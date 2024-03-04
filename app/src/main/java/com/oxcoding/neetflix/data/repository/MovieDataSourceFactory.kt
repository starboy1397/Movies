package com.oxcoding.neetflix.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.oxcoding.neetflix.data.api.TheMovieDBInterface
import com.oxcoding.neetflix.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable


class MovieDataSourceFactory(private val apiService : TheMovieDBInterface, private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, Movie>() {

    val moviesLiveDataSource =  MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = MovieDataSource(apiService,compositeDisposable)
        moviesLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }

//    fun getItemLiveDataSource(): MutableLiveData<MovieDataSource> {
//        return moviesLiveDataSource
//    }
}