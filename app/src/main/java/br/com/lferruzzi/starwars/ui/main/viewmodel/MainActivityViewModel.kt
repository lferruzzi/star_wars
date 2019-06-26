package br.com.lferruzzi.starwars.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.model.Character
import br.com.lferruzzi.starwars.repository.CharacterListRepository
import br.com.lferruzzi.starwars.repository.CharacterRepository

class MainActivityViewModel(
    private val characterRepository: CharacterRepository,
    characterListRepository: CharacterListRepository
) : ViewModel() {
    val wasLastRequestSuccessful = characterListRepository.wasLastRequestSuccessful
    val isRequesting = characterListRepository.isRequesting

    fun onCharacterSelected(character: Character) {
        characterRepository.onCharacterSelected(character)
    }
}
