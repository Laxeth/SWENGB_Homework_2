package at.fh.swengb.he01.solution

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class Movie(
    val id: String,
    val title: String,
    val posterImagePath: String,
    val backdropImagePath: String,
    val release: String,
    val reviews: MutableList<Review>

) {

    fun reviewAverage(): Double {
        return reviews
            .map{ it.reviewValue }
            .average()
            .run { if(isNaN()) 0.0 else this }
    }

}

@JsonClass(generateAdapter = true)
class MovieDetail(
    id: String,
    title: String,
    posterImagePath: String,
    backdropImagePath: String,
    release: String,
    val plot: String,
    var actors: List<Person>,
    val director: Person,
    val genres: List<String>,
    reviews: MutableList<Review>
): Movie(id, title, posterImagePath, backdropImagePath, release, reviews)
