package br.com.lferruzzi.starwars.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import br.com.lferruzzi.starwars.R
import br.com.lferruzzi.starwars.ui.main.viewmodel.SearchCharacterViewModel
import kotlinx.android.synthetic.main.fragment_character_search.characterSearchView
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterSearchFragment : Fragment() {

    private val viewModel: SearchCharacterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_character_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.run {
                    viewModel.searchString = this
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}
