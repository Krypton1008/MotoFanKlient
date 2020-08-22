package pl.krypot.motofanmobile.ui.newslist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.krypot.motofanmobile.data.NewsResponse
import pl.krypot.motofanmobile.utils.ShortBoxApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageViewModel : ViewModel() {

    private val failureMessage = "Failure to connect in fetchDataMethod()"
    private val emptyResponseMessage = "Empty response in fetchDataMethod()"
    private val nullResponseContentMessage = "Null response in fetchDataMethod()"
    private var sportsNewsList = MutableLiveData<NewsResponse>()

    fun getList(): MutableLiveData<NewsResponse> {
        return sportsNewsList
    }

    private fun fetchData() {
        val shortBoxApiService = ShortBoxApiService.Factory.create()
        val call = shortBoxApiService.getNew()
        call.enqueue(object : Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e(javaClass.name, failureMessage, t.cause)
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.body() == null) {
                    Log.e(javaClass.name, emptyResponseMessage)
                } else if (response.body()!!.newsList.isNullOrEmpty()) {
                    Log.e(javaClass.name, nullResponseContentMessage)
                } else {
                    Log.d(javaClass.name, response.body().toString())
                    sportsNewsList.value = response.body()!!
                }
            }

        })
    }

    fun callApi() {
        this.fetchData()
    }

}