package com.batdemir.themovie.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.batdemir.themovie.data.entities.db.toDto
import com.batdemir.themovie.data.entities.dto.MovieResultDto
import com.batdemir.themovie.data.remote.datasource.TheMovieRemoteDataSource
import com.batdemir.themovie.other.Constant
import com.batdemir.themovie.other.Resource
import com.google.gson.Gson
import retrofit2.HttpException

class TheMoviePagingRemoteDatasource(
    private val remoteDataSource: TheMovieRemoteDataSource,
    private val movieType: MovieType
) : PagingSource<Long, MovieResultDto>() {
    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, MovieResultDto> {
        return try {
            val key = params.key ?: Constant.START_PAGE_INDEX
            val response = when (movieType) {
                MovieType.UP_COMING ->
                    remoteDataSource.getMovieUpComings(
                        page = key,
                    )
                MovieType.NOW_PLAYING ->
                    remoteDataSource.getMovieNowPlayings(
                        page = key
                    )
            }
            if (response.status == Resource.Status.ERROR) {
                throw Exception(response.throwable)
            }
            val prevKey = when (key) {
                Constant.START_PAGE_INDEX -> null
                else -> key.minus(1)
            }
            val nextKey = when (response.data?.totalPages) {
                key -> null
                else -> key.plus(1)
            }
            LoadResult.Page(
                data = response.data?.results?.map { x -> x.toDto() } ?: listOf(),
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: HttpException) {
            LoadResult.Error(
                Throwable(
                    Gson().fromJson(
                        e.response()?.errorBody()?.charStream(),
                        Error::class.java
                    )
                )
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Long, MovieResultDto>): Long? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

enum class MovieType {
    UP_COMING,
    NOW_PLAYING
}