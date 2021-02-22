package com.kevicsalazar.globant.devtest.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevicsalazar.globant.devtest.R
import com.kevicsalazar.globant.devtest.domain.entities.NewsItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    private var onItemClick: (String) -> Unit = {}
    private val items = mutableListOf<NewsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setOnClickListener(action: (String) -> Unit) {
        this.onItemClick = action
    }

    fun updateList(items: List<NewsItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: NewsItem) {
            itemView.tvTitle.text = item.title
            itemView.setOnClickListener { onItemClick.invoke(item.id) }
        }
    }

}