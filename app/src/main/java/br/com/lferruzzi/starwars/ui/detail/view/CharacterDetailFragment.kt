package br.com.lferruzzi.starwars.ui.detail.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.lferruzzi.starwars.R
import org.koin.android.viewmodel.ext.android.viewModel
import br.com.lferruzzi.starwars.model.Character
import br.com.lferruzzi.starwars.ui.detail.viewmodel.CharacterDetailViewModel
import kotlinx.android.synthetic.main.fragment_character_detail.message

class CharacterDetailFragment : Fragment() {
    private val viewModel: CharacterDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_character_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.character.observe(this, Observer<Character> {
            Log.d(TAG, "character: $it")
            message.text = it.name
        })
    }

    companion object {
        private const val TAG = "CharacterDetailFragment"
    }
}
