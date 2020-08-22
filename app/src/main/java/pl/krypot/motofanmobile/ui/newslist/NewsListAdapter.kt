package pl.krypot.motofanmobile.ui.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.krypot.motofanmobile.data.News

class NewsListAdapter(private var list: ArrayList<News>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(
            inflater,
            parent,
            parent.context
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val comic: News = list[position]
        holder.bind(comic)
    }

    fun setItems(newsList : ArrayList<News>) {
        list.clear()
        list = newsList
        notifyDataSetChanged()
    }

}
