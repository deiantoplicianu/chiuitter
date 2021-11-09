package ro.upt.ac.chiuitter.data.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ro.upt.ac.chiuitter.data.ChiuitRepository
import ro.upt.ac.chiuitter.domain.Chiuit
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseChiuitStore : ChiuitRepository {

    private val database = FirebaseDatabase.getInstance().reference.child("chiuits")

    override suspend fun getAll(): List<Chiuit> = suspendCoroutine { continuation ->
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                database.removeEventListener(this)
                continuation.resumeWithException(p0.toException())
            }

            override fun onDataChange(p0: DataSnapshot) {
                val values = mutableListOf<ChiuitNode>()

                val children = p0.children

                //TODO ("Iterate through the children and get the node value")

                children.forEach {
                    values.add(it.getValue(ChiuitNode::class.java)!!)
                }

                database.removeEventListener(this)

                continuation.resume(values.map { chiuitNode -> chiuitNode.toDomainModel() })
            }

        })
    }

    override suspend fun addChiuit(chiuit: Chiuit): Unit = suspendCoroutine { continuation ->
        //TODO ("Insert the object into database - don't forget to use the right model")
        database.push().setValue(chiuit.toFirebaseModel())

        //TODO ("Make sure the continuation is called")
        continuation.resumeWith(Result.success(Unit))
    }

    override suspend fun removeChiuit(chiuit: Chiuit) : Unit = suspendCoroutine { continuation ->
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                database.removeEventListener(this)
                continuation.resumeWithException(p0.toException())
            }

            override fun onDataChange(p0: DataSnapshot) {
                val children = p0.children


               // TODO ("Iterate through the children and find the matching node, then perform removal.")
                for (child in children) {

                    val node = child.getValue(ChiuitNode::class.java)
                    node?.let {
                        if(it.timestamp == chiuit.timestamp && it.description == chiuit.description) {
                            child.ref.removeValue()
                        }
                    }

                }

                database.removeEventListener(this)

                //TODO ("Make sure the continuation is called")

                continuation.resumeWith(Result.success(Unit))
            }

        })
    }

    fun Chiuit.toFirebaseModel(): ChiuitNode {
        return ChiuitNode(timestamp, description)
    }

    fun ChiuitNode.toDomainModel(): Chiuit {
        return Chiuit(timestamp, description)
    }

}