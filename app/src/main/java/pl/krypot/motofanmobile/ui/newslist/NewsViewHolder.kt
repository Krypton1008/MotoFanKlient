package pl.krypot.motofanmobile.ui.newslist

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.krypot.motofanmobile.MainActivity
import pl.krypot.motofanmobile.R
import pl.krypot.motofanmobile.data.News
import java.util.regex.Pattern

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup, context: Context) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.news_list_item, parent, false)) {
    private var title: TextView? = null
    private var date: TextView? = null
    private var fragmentContext: Context
    private val imageServer = ""

    init {
        title = itemView.findViewById(R.id.list_title)
        date = itemView.findViewById(R.id.list_release_date)
        fragmentContext = context
    }

    fun bind(news: News) {
        title?.text = news.title.capitalize()
        date?.text = news.date
    }

}
