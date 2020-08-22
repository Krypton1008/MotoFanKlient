package pl.krypot.motofanmobile.ui.newslist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import pl.krypot.motofanmobile.R
import pl.krypot.motofanmobile.data.News
import pl.krypot.motofanmobile.data.NewsResponse


/**
 * A placeholder fragment containing a simple view.
 */
class NewsListFragment : Fragment() {

    private lateinit var viewModel: PageViewModel
    private lateinit var newsAdapter: NewsListAdapter
    private var newsList = ArrayList<News>()
    private val dataChangedMessage= "Data Changed"
    private val nullMessage = "Null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PageViewModel::class.java)
        defineObserver(viewModel)
    }

    private fun defineObserver(viewModel: PageViewModel) {
        viewModel.getList().observe(this, Observer<NewsResponse> {
            if (!it.newsList.isNullOrEmpty()) {
                Log.d(javaClass.name, dataChangedMessage)
                newsList = it.newsList
                newsAdapter.setItems(newsList)
            } else {
                Log.e(javaClass.name, nullMessage)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsAdapter =
            NewsListAdapter(
                newsList
            )
        premiere_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = newsAdapter
        }
        viewModel.callApi()
    }

    public override fun getContext(): Context? {
        return super.getContext()
    }

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): NewsListFragment {
            return NewsListFragment()
                .apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}