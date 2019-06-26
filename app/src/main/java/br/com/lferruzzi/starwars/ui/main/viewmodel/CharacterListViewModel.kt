package br.com.lferruzzi.starwars.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.repository.CharacterListRepository

class CharacterListViewModel(characterListRepository: CharacterListRepository) : ViewModel() {

    val characters = characterListRepository.characterList
    val wasLastRequestSuccessful = characterListRepository.wasLastRequestSuccessful
    val isRequesting = characterListRepository.isRequesting

    companion object {
        private const val TAG = "CharacterListViewModel"
    }
}
