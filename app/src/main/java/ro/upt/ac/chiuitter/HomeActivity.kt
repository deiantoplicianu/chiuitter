package ro.upt.ac.chiuitter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.item_chiuit.*
import kotlinx.android.synthetic.main.view_home.*

class HomeActivity : AppCompatActivity() {

    private val dummyChiuitStore = DummyChiuitStore()

    private lateinit var listAdapter: ChiuitRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_home)

        initList()
    }

    private fun initList() {
        val chiuitList = dummyChiuitStore.getAllData()

        TODO("7. Instantiate the adapter, then setup the recycler view list")

        listAdapter = ChiuitRecyclerViewAdapter(chiuitList.toMutableList()) {
            shareChiuit(it.description)
        }

        rv_chiuit_list.adapter = listAdapter
        rv_chiuit_list.layoutManager = LinearLayoutManager(this)
    }

    /*
    Defines text sharing/sending *implicit* intent, opens the application chooser menu,
    and starts a new activity which supports sharing/sending text.
     */
    private fun shareChiuit(text: String) {
        val sendIntent = Intent().apply {
            // TODO 1: Configure to support text sending/sharing and then attach the text as intent's extra.

            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain";

        }

        val intentChooser = Intent.createChooser(sendIntent, "")

        startActivity(intentChooser)
    }

    /*
    Defines an *explicit* intent which will be used to start ComposeActivity.
     */
    private fun composeChiuit() {
        // TODO 2: Create an explicit intent which points to ComposeActivity.

        val intent = Intent(this, ComposeActivity::class.java).apply {

        }


        // TODO 3: Start a new activity with the previously defined intent.
        // We start a new activity that we expect to return the acquired text as the result.

        startActivityForResult(intent, COMPOSE_REQUEST_CODE);

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            COMPOSE_REQUEST_CODE -> if (resultCode == Activity.RESULT_OK) extractText(data)
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun extractText(data: Intent?) {
        data?.let {
            // TODO 5: Extract the text from result intent.

            val text = data.getStringExtra(ComposeActivity.EXTRA_TEXT)

            // TODO 6: Check if text is not null or empty, then set the new "chiuit" content.

            if(text.isNullOrEmpty()) {
                return;
            } else {
                txv_content.text = text;
            }


            TODO("13. Instantiate a new chiuit object that add it to the adapter")
            val chiuitNou = Chiuit(text)
            listAdapter.addItem(chiuitNou)
        }
    }

    companion object {
        const val COMPOSE_REQUEST_CODE = 1213
    }

}
