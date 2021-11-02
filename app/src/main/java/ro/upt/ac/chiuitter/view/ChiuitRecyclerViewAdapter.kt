package ro.upt.ac.chiuitter.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_chiuit.view.*
import ro.upt.ac.chiuitter.R
import ro.upt.ac.chiuitter.domain.Chiuit


class ChiuitRecyclerViewAdapter(
        private val chiuitList: List<Chiuit>,
        private val onShareClick: (Chiuit) -> (Unit)

// TODO("Add a new callback triggered when delete button was pressed")

) : RecyclerView.Adapter<ChiuitRecyclerViewAdapter.ChiuitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChiuitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chiuit, parent, false)
        return ChiuitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chiuitList.size
    }

    override fun onBindViewHolder(holder: ChiuitViewHolder, position: Int) {
        holder.bind(chiuitList[position])
    }

    inner class ChiuitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.ibt_share.setOnClickListener { onShareClick(chiuitList[adapterPosition]) }
            TODO("Trigger delete callback same as for share")
        }

        fun bind(chiuit: Chiuit) {
            itemView.txv_content.text = chiuit.description
        }

    }

}