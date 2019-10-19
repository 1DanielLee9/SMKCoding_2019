package com.Ngelvic.smkcoding


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.Ngelvic.smkcoding.connection.ConfigRetrofit
import com.Ngelvic.smkcoding.connection.MovieInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movie.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)

        getListMovie()

//        val list = Movie.listMovie as ArrayList<MovieModel>
//
//        val layoutmanager = LinearLayoutManager(activity)
//
//        val adapter = MovieAdapter(list,activity!!.applicationContext)
//
//        rootView.rv_movie.apply {
//            layoutManager = layoutmanager
//            setAdapter(adapter)
//        }

        return rootView
    }

    private fun getListMovie(){
        val movieNowPlaying =  ConfigRetrofit.retrofitConfig()
            .create(MovieInterface::class.java)
            .getListMovieNowPlaying("6d6c98438bb15404918c7530bc0b8eae")

        movieNowPlaying
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                //Success
                val list = response.results
                val layoutmanager = LinearLayoutManager(activity)
                val adapter = MovieAdapter(list,activity!!.applicationContext)

                rootView.rv_movie.apply {
                    layoutManager = layoutmanager
                    setAdapter(adapter)
                }


            },{
                //Failure
                toast("Fail")
            })

    }


}
