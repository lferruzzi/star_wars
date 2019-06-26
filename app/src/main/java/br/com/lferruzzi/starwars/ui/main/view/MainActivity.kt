package br.com.lferruzzi.starwars.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.lferruzzi.starwars.R
import br.com.lferruzzi.starwars.ui.main.view.CharacterListFragment.OnListFragmentInteractionListener
import br.com.lferruzzi.starwars.ui.main.viewmodel.MainActivityViewModel
import br.com.lferruzzi.starwars.model.Character
import br.com.lferruzzi.starwars.ui.detail.view.CharacterDetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {
    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViewModel()
    }

    private fun initializeViewModel() {
        viewModel.isRequesting.observe(this, Observer<Boolean> {
            Log.d(TAG, "isRequesting: $it")
        })
    }

    override fun onListFragmentInteraction(item: Character) {
        Log.d(TAG, "clicked on $item")
        viewModel.onCharacterSelected(item)
        val intent = Intent(this, CharacterDetailActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
