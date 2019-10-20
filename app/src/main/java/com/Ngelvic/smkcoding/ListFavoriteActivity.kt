package com.Ngelvic.smkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.Ngelvic.smkcoding.database.DatabaseContract
import com.Ngelvic.smkcoding.database.database
import com.Ngelvic.smkcoding.model.ResultsItem
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class ListFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_favorite)

        selectFavoriteListFromSqlite()
    }

    private fun selectFavoriteListFromSqlite() {
        database.use{
            val selectData = select(ResultsItem.TABLE_FAVORITE)
            val list : MutableList<DatabaseContract> = selectData.parseList(classParser<DatabaseContract>()) as MutableList
            val arrayListMovie = list as ArrayList<DatabaseContract>
            Log.d("LISTFAVORITE",arrayListMovie.toString())
        }
    }


}
