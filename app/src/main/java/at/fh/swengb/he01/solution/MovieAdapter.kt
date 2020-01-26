package at.fh.swengb.he01.solution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.item_movie.view.*
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.view.*


class MovieAdapter(val clickListener: (movie: Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {

    private var movieList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieItemView = inflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.count()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(movieList[position])
    }


    fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View, val clickListener: (movie: Movie) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(movie: Movie) {
        itemView.item_movie_title.text = movie.title
        Glide.with(itemView.mainPoster).load(movie.posterImagePath).into(itemView.mainPoster)
        //itemView.item_movie_release.text = movie.release
        //itemView.item_movie_actors.text = movie.actors.take(2).joinToString(", ") { it.name }
        //itemView.item_movie_director.text = movie.director.name
        //itemView.item_movie_avg_review_bar.rating = movie.reviewAverage().toFloat()
        //itemView.item_movie_avg_review_value.text = movie.reviewAverage().toString()
        //itemView.item_movie_review_count.text = movie.reviews.count().toString()

        itemView.setOnClickListener{
            clickListener(movie)
        }
    }
}