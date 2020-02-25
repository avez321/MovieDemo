package com.rtr.moviesdemo.di

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.rtr.moviesdemo.model.MoviesClient
import com.rtr.moviesdemo.model.MoviesClient.getOkHttpClient
import com.rtr.moviesdemo.model.MoviesClient.makeMovieApi
import com.rtr.moviesdemo.network.MovieApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

val networkModule = module {
    val BASE_URL = "https://api.themoviedb.org/3/"

    single<MovieApi> {
        makeMovieApi()
    }

    fun makeMovieApi(): MovieApi {
        val jacksonMapper: ObjectMapper =
            ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        return Retrofit.Builder()
            .baseUrl(MoviesClient.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create(jacksonMapper))
            .client(getOkHttpClient())
            .build().create(MovieApi::class.java)
    }

    fun getOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }
}