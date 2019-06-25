package br.com.lferruzzi.starwars.main.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.repository.CharacterRepository

class CharacterListViewModel(characterRepository: CharacterRepository) : ViewModel() {

    val characters = characterRepository.characters
    val wasLastRequestSuccessful = characterRepository.wasLastRequestSuccessful
    val isRequesting = characterRepository.isRequesting

    companion object {
        private const val TAG = "CharacterListViewModel"
    }
}
