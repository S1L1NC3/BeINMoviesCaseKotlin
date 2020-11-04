package com.dmd.beinmoviescasekotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmd.beinmoviescasekotlin.view.MainFragment

class MainActivity : AppCompatActivity() {
    //Companion object yapmamın sebebi instance alınamasın ama
    // ViewHolder içerisinden erişilebilir olsun istedim
    companion object ImagePath {
        private var imagePathForReturn = "http://image.tmdb.org/t/p/w185/"

        fun returnImagePath():String{
            return imagePathForReturn
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}