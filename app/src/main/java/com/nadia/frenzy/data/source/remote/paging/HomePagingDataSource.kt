package com.nadia.frenzy.data.source.remote.paging

//PagingSource: generic abstract class that is responsible for loading the paging data from the network

//pagination library: uses Flow or LiveData for the communication between the layers.

/* PagingState: It holds the information related to the recently accessed index in the list
 and some information related to the pages which have been loaded earlier. */

/* Retrofit: REST Client. network library that used for network transactions.
By using this library we can seamlessly capture JSON response from web service/web API */

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nadia.frenzy.data.Feed
import com.nadia.frenzy.data.source.FeedDataSource
import retrofit2.HttpException
import java.io.IOException

class HomePagingDataSource(
    private val feedDataSource: FeedDataSource,
    private val userId: String,
) : PagingSource<Int, Feed>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Feed> {
        val position = params.key ?: 1
        return try {
            val response = feedDataSource.getHomeFeed(userId, position)
            val feed = response.getOrDefault(listOf())
            val nextKey = if (feed.isEmpty()) null else position + 1
            val prevKey = if (position == 0) null else position - 1
            LoadResult.Page(feed, prevKey, nextKey)
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Feed>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

/*When PagingDataAdapter.refresh() is called, the anchorPosition is the first visible
position in the displayed list, so we will need to load the page that contains that specific item.*/