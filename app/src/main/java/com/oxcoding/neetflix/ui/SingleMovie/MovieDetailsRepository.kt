package com.oxcoding.neetflix.ui.SingleMovie

import androidx.lifecycle.LiveData
import com.oxcoding.neetflix.data.api.TheMovieDBInterface
import com.oxcoding.neetflix.data.repository.MovieDetailsNetworkDataSource
import com.oxcoding.neetflix.data.repository.NetworkState
import com.oxcoding.neetflix.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository  (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}
