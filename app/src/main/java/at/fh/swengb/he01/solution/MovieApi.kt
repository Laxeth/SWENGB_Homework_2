package at.fh.swengb.he01.solution

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

object MovieApi {
    const val accessToken = "e14a412a-c12e-4f8b-a549-acb44feccdd5"
    val retrofit: Retrofit
    val retrofitService: MovieApiService

    init {
        val moshi = Moshi.Builder().build()
        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://movies.bloder.xyz")
            .build()

        retrofitService = retrofit.create(
            MovieApiService::class.java)
    }
}

interface MovieApiService {

    @GET("/${MovieApi.accessToken}/movies")
    fun movieList(): Call<List<Movie>>

    @GET("/${MovieApi.accessToken}/movies/{movieId}")
    fun movieById(@Path("movieId") movieId: String): Call<MovieDetail>

    @POST("/${MovieApi.accessToken}/movies/{movieId}/rate")
    fun reviewMovie(@Path("movieId") movieId: String, @Body rating: Review): Call<Unit>

}