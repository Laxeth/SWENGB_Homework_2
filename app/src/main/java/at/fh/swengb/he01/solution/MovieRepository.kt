package at.fh.swengb.he01.solution

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MovieRepository {
    //private val movies: List<Movie>

    init{
        val diCaprio = Person("Leonardo DiCaprio", "11.11.1974")
        val page = Person("Ellen Page", "21.02.1987")
        val levitt = Person("Joseph Gordon-Levitt", "17.02.1981")
        val thurman = Person("Uma Thurman", "29.04.1970")
        val lu = Person("Lucy Liu", "02.12.1968")
        val caradine = Person("David Carradine", "08.12.1936")
        val pitt = Person("Brad Pitt", "18.12.1963")
        val kruger = Person("Diane Kruger", "15.07.1976")
        val russel = Person("Kurt Russel", "17.03.1951")
        val norton = Person("Edward Norton", "18.08.1969")
        val bale = Person("Christian Bale", "30.01.1974")
        val ledger = Person("Heath Ledger", "04.04.1979")
        val deNiro = Person("Robert De Niro","17.08.1943")
        val pesci = Person("Joe Pesci","09.02.1943")
        val keitel = Person("Harvey Keitel","13.05.1939")
        val pacino = Person("Al Pacino","25.04.1940")
        val brando = Person("Marlon Brando","03.04.1924")
        val travolta = Person("John Travolta","18.02.1954")
        val jackson = Person("Samuel L. Jackson","21.12.1948")
        val buscemi = Person("Steve Buscemi", "13.12.1957")
        val gyllenhaal = Person("Jake Gyllenhaal", "19.12.1980")
        val hopkins = Person("Anthony Hopkins", "31.12.1937")
        val foster = Person("Jodie Foster", "19.11.1962")
        val nicholson = Person("Jack Nicholson", "22.04.1937")
        val pearce = Person("Guy Pearce", "05.10.1967")

        val scorsese = Person("Martin Scorsese", "17.11.1942")
        val coppola = Person("Francis Ford Coppola", "07.04.1939")
        val tarantino = Person("Quentin Tarantino", "27.03.1963")
        val kubrick = Person("Stanley Kubrick", "26.07.1928")
        val kelly = Person("Richard Kelly", "28.03.1975")
        val demme = Person("Jonathan Demme", "22.02.1944")
        val nolan = Person("Christopher Nolan", "30.07.1970")
        val fincher = Person("David Fincher", "28.08.1962")


        /*
        movies = listOf(
            Movie("1",
                "Inception",
                "2010",
                nolan,
                MovieGenre.ACTION,
                listOf(diCaprio, levitt, page),
                mutableListOf(),
                "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable."
            ),
            Movie("2",
                "Pulp Fiction",
                "1994",
                tarantino,
                MovieGenre.DRAMA,
                listOf(travolta, jackson),
                mutableListOf(),
                "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."
            ),
            Movie("3",
                "Reservoir Dogs",
                "1992",
                tarantino,
                MovieGenre.DRAMA,
                listOf(buscemi, keitel),
                mutableListOf(),
                "When a simple jewelry heist goes horribly wrong, the surviving criminals begin to suspect that one of them is a police informant."
            ),
            Movie("4",
                "Kill Bill: Vol. 1",
                "2003",
                tarantino,
                MovieGenre.ACTION,
                listOf(thurman, lu),
                mutableListOf(),
                "The lead character, called 'The Bride,' was a member of the Deadly Viper Assassination Squad, led by her lover 'Bill.' Upon realizing she was pregnant with Bill's child, 'The Bride' decided to escape her life as a killer."
            ),
            Movie("5",
                "Kill Bill: Vol. 2",
                "2004",
                tarantino,
                MovieGenre.ACTION,
                listOf(thurman, caradine),
                mutableListOf(),
                "The murderous Bride is back and she is still continuing her vengeance quest against her ex-boss, Bill, and taking aim at Bill's younger brother Budd and Elle Driver, the only survivors from the squad of assassins who betrayed her four years earlier."
            ),
            Movie("6",
                "Inglourious Basterds",
                "2009",
                tarantino,
                MovieGenre.ACTION,
                listOf(pitt, kruger),
                mutableListOf(),
                "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same."
            ),
            Movie("7",
                "The Hateful Eight",
                "2015",
                tarantino,
                MovieGenre.ACTION,
                listOf(jackson, russel),
                mutableListOf(),
                "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same."
            ),
            Movie("8",
                "Goodfellas",
                "1990",
                scorsese,
                MovieGenre.DRAMA,
                listOf(deNiro, pesci),
                mutableListOf(),
                "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate."
            ),
            Movie("9",
                "The Godfather",
                "1972",
                coppola,
                MovieGenre.DRAMA,
                listOf(pacino, brando),
                mutableListOf(),
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."
            ),
            Movie("10",
                "Fight Club",
                "1999",
                fincher,
                MovieGenre.DRAMA,
                listOf(pitt, norton),
                mutableListOf(),
                "In the future, a sadistic gang leader is imprisoned and volunteers for a conduct-aversion experiment, but it doesn't go as planned."
            ),
            Movie("11",
                "Donnie Darko",
                "2001",
                kelly,
                MovieGenre.DRAMA,
                listOf(gyllenhaal),
                mutableListOf(),
                "A troubled teenager is plagued by visions of a man in a large rabbit suit who manipulates him to commit a series of crimes, after he narrowly escapes a bizarre accident."
            ),
            Movie("12",
                "The Silence of the Lambs",
                "1991",
                demme,
                MovieGenre.DRAMA,
                listOf(hopkins, foster),
                mutableListOf(),
                "A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims."
            ),
            Movie("13",
                "The Shining",
                "1980",
                kubrick,
                MovieGenre.HORROR,
                listOf(nicholson),
                mutableListOf(),
                "A family heads to an isolated hotel for the winter where a sinister presence influences the father into violence, while his psychic son sees horrific forebodings from both past and future."
            ),
            Movie("14",
                "Memento",
                "2000",
                nolan,
                MovieGenre.ACTION,
                listOf(pearce),
                mutableListOf(),
                "A man with short-term memory loss attempts to track down his wife's murderer."
            ),
            Movie("15",
                "The Dark Knight",
                "2008",
                nolan,
                MovieGenre.ACTION,
                listOf(bale, ledger),
                mutableListOf(),
                "A man with short-term memory loss attempts to track down his wife's murderer."
            )
        )

         */
    }


    fun movieList(success: (movieList: List<Movie>) -> Unit, error: (errorMessage: String) -> Unit) {
        MovieApi.retrofitService.movieList().enqueue(object: Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                error("movieList call failed")
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }

        })
    }

    fun movieById(id: String, success: (movieDetail: MovieDetail) -> Unit, error: (errorMessage: String) -> Unit) {
        MovieApi.retrofitService.movieById(id).enqueue(object: Callback<MovieDetail>{
            override fun onFailure(call: Call<MovieDetail>, t: Throwable) {
                error("movieById call failed")
            }

            override fun onResponse(call: Call<MovieDetail>, response: Response<MovieDetail>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    success(responseBody)
                } else {
                    error("Something went wrong")
                }
            }

        })
    }

    fun reviewMovie(id: String, rating: Review, success: () -> Unit, error: (errorMessage: String) -> Unit) {
        MovieApi.retrofitService.reviewMovie(id, rating).enqueue(object: Callback<Unit> {
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                error("reviewMovie call failed")
            }

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    success()
                } else {
                    error("Something went wrong")
                }
            }
        })
    }
}