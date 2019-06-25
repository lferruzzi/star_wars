package br.com.lferruzzi.starwars.main.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.repository.CharacterRepository
import kotlin.properties.Delegates

class SearchCharacterViewModel(characterRepository: CharacterRepository) : ViewModel() {
    var searchString by Delegates.observable(initialValue = "",
        onChange = { _, _, newSearch -> characterRepository.searchCharacters(newSearch) })
}
