package pl.krypot.motofanmobile.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import pl.krypot.motofanmobile.R
import pl.krypot.motofanmobile.ui.newslist.NewsListFragment
//import pl.krypot.motofanmobile.ui.placeslist.PlacesListFragment
//import pl.krypot.motofanmobile.ui.eventslist.EventsListFragment

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1//,
        //R.string.tab_text_2,
        //R.string.tab_text_3
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        //if(position == 1){
        //    return EventsListFragment.newInstance()
        //}
        return NewsListFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}