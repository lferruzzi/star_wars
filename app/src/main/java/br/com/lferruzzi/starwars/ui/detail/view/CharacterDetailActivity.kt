package br.com.lferruzzi.starwars.ui.detail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lferruzzi.starwars.R

class CharacterDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
    }

    companion object {
        private const val TAG = "CharacterDetailActivity"
    }
}
