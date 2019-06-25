package br.com.lferruzzi.starwars.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lferruzzi.starwars.R
import br.com.lferruzzi.starwars.main.view.CharacterListFragment.OnListFragmentInteractionListener
import br.com.lferruzzi.starwars.model.Character
import kotlinx.android.synthetic.main.fragment_character_list_item.view.*
import kotlin.properties.Delegates

class CharacterListAdapter(
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    private val itemOnClickListener: View.OnClickListener

    var characters: List<Character> by Delegates.observable(listOf(), { _, _, _ -> notifyDataSetChanged() })

    init {
        itemOnClickListener = View.OnClickListener { view ->
            val item = view.tag as Character
            listener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_character_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = characters[position]
        holder.nameTextView.text = item.name
        holder.birthYearTextView.text = item.birthYear

        with(holder.view) {
            tag = item
            setOnClickListener(itemOnClickListener)
        }
    }

    override fun getItemCount() = characters.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.characterItemNameTextView
        val birthYearTextView: TextView = view.characterItemBirthYearTextView
    }
}
