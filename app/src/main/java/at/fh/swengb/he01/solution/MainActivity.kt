package at.fh.swengb.he01.solution

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager



class MainActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val VIEW_DETAIL_OR_ADD_REVIEW_REQUEST = 1
    }

    val movieAdapter = MovieAdapter {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(EXTRA_MOVIE_ID, it.id)
        startActivityForResult(intent, VIEW_DETAIL_OR_ADD_REVIEW_REQUEST)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moshi = Moshi.Builder().build()
        val jsonAdapterMovDetail = moshi.adapter<MovieDetail>(Movie::class.java)
        val jsonAdapterMov = moshi.adapter<Movie>(Movie::class.java)
        val jsonMov = """
        {
              "id" : "278",
              "title" : "The Shawshank Redemption",
              "posterImagePath" : "https://image.tmdb.org/t/p/w200/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg",
              "backdropImagePath" : "https://image.tmdb.org/t/p/w500/j9XKiZrVeViAixVRzCta7h1VU9W.jpg",
              "release" : "1994-09-23",
              "reviews" : [ {
                "reviewValue" : 5.0,
                "reviewText" : "👍"
              }, {
                "reviewValue" : 4.5,
                "reviewText" : ""
              }, {
                "reviewValue" : 3.5,
                "reviewText" : ""
              }, {
                "reviewValue" : 4.5,
                "reviewText" : "H h "
              }, {
                "reviewValue" : 2.5,
                "reviewText" : "seas"
              }, {
                "reviewValue" : 3.5,
                "reviewText" : ""
              }, {
                "reviewValue" : 4.0,
                "reviewText" : "Banken und ykdbdldnyoy sksndbykdsoododcnbfkdodododkdbbdkdodoowsodofkfkdkldldkfngkrkfnfkdkdkfnfkdkdbfbfkkfbfbfkfkfkdkdkdndkfkdkxkbxkxkfkfnfbfkdndkflcllclcldkdkdbxnxnndkdkdkdkdkdlldlxlfllfldldldldlflfldldldlfllglflflflflflflfkfkfkfkff f f f f  Fr  f f f f\n"
              }, {
                "reviewValue" : 4.0,
                "reviewText" : ""
              } ]
            }
        """
        val jsonMovDetail = """
            {
              "id" : "2",
              "title" : "Ariel",
              "posterImagePath" : "https://image.tmdb.org/t/p/w200/gZCJZOn4l0Zj5hAxsMbxoS6CL0u.jpg",
              "backdropImagePath" : "https://image.tmdb.org/t/p/w500/z2QUexmccqrvw1kDMw3R8TxAh5E.jpg",
              "release" : "1988-10-21",
              "plot" : "Taisto Kasurinen is a Finnish coal miner whose father has just committed suicide and who is framed for a crime he did not commit. In jail, he starts to dream about leaving the country and starting a new life. He escapes from prison but things don't go as planned...",
              "actors" : [ {
                "name" : "Turo Pajala",
                "profileImagePath" : ""
              }, {
                "name" : "Susanna Haavisto",
                "profileImagePath" : ""
              }, {
                "name" : "Matti Pellonpää",
                "profileImagePath" : "https://image.tmdb.org/t/p/w200/7WuLvkuWphUAtW6QQwtF3WrwUKE.jpg"
              }, {
                "name" : "Eetu Hilkamo",
                "profileImagePath" : ""
              }, {
                "name" : "Erkki Pajala",
                "profileImagePath" : "https://image.tmdb.org/t/p/w200/rCTSh1Z2RdqCFqRTZULXXylI36o.jpg"
              } ],
              "director" : {
                "name" : "Aki Kaurismäki",
                "profileImagePath" : "https://image.tmdb.org/t/p/w200/kiJErWEOv4Ew7aHOGKg4ljsmppZ.jpg"
              },
              "genres" : [ "Drama", "Crime", "Comedy" ],
              "reviews" : [ ]
            }
        """

        val movie = jsonAdapterMov.fromJson(jsonMov)
        Log.e("MyActivity", "Movietitle from JSON: ${movie?.title ?: "no movie found"}")
        //val movieDetail = jsonAdapterMovDetail.fromJson(jsonMovDetail)
        //Log.e("MyActivity", "MovieDetailtitle from JSON: ${movieDetail?.title ?: "no movie found"}")

        loadMovies()

        movie_recycler_view.layoutManager = GridLayoutManager(this, 3)
        //movie_recycler_view.layoutManager = LinearLayoutManager(this)
        movie_recycler_view.adapter = movieAdapter
        //movieAdapter.updateList(MovieRepository.movieList())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == VIEW_DETAIL_OR_ADD_REVIEW_REQUEST && resultCode == Activity.RESULT_OK){
            //movieAdapter.updateList(MovieRepository.movieList())
            loadMovies()
        }
    }

    private fun loadMovies() {
        MovieRepository.movieList(
            success = {
                movieAdapter.updateList(it)
            },
            error = {
                Log.e("REPOSITORY_ERROR", it)
            }
        )
    }
}
