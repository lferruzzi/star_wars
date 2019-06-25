package br.com.lferruzzi.starwars.main.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import br.com.lferruzzi.starwars.R
import br.com.lferruzzi.starwars.main.viewmodel.CharacterListViewModel
import br.com.lferruzzi.starwars.model.Character
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null

    private val viewModel: CharacterListViewModel by viewModel()

    private val characterListAdapter by lazy { CharacterListAdapter(listener) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                adapter = characterListAdapter
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
    }

    private fun initializeViewModel() {
        viewModel.characters.observe(this, Observer<List<Character>> {
            Log.d(TAG, "character list: $it")
            characterListAdapter.characters = it
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw UnsupportedOperationException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Character)
    }

    companion object {
        private const val TAG = "CharacterListFragment"
    }
}
