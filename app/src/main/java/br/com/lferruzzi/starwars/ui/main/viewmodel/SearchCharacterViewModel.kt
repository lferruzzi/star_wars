package br.com.lferruzzi.starwars.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.repository.CharacterListRepository
import kotlin.properties.Delegates

class SearchCharacterViewModel(characterListRepository: CharacterListRepository) : ViewModel() {
    var searchString by Delegates.observable(initialValue = "",
        onChange = { _, _, newSearch -> characterListRepository.searchCharacters(newSearch) })
}
