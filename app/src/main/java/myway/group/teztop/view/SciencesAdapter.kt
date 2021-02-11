package myway.group.teztop.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.science_item_layout.view.*
import myway.group.teztop.R
import myway.group.teztop.models.ScienceModel

interface SciencesAdapterCallback{
    fun onClick(items: ScienceModel)
}
class SciencesAdapter(val items:List<ScienceModel>, val  callback: SciencesAdapterCallback):RecyclerView.Adapter<SciencesAdapter.ItemHolder>(){
    inner class ItemHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.science_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            callback.onClick(item)
        }
        holder.itemView.tvTitle.text = item.title

    }
}