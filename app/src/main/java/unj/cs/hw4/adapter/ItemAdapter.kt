package unj.cs.hw4.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import unj.cs.hw4.R
import unj.cs.hw4.model.Coffee
import unj.cs.hw4.ui.home.HomeFragment

class ItemAdapter(private val context: Context, private val dataset: List<Coffee>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val descView: TextView = view.findViewById(R.id.item_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.titleResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
        holder.descView.text = context.resources.getString(item.descResourceId)
    }

    override fun getItemCount()= dataset.size
}