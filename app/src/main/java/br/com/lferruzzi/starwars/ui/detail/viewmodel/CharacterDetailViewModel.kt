package br.com.lferruzzi.starwars.ui.detail.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.repository.CharacterRepository

class CharacterDetailViewModel(characterRepository: CharacterRepository) : ViewModel() {

    val wasLastRequestSuccessful = characterRepository.wasLastRequestSuccessful
    val isRequesting = characterRepository.isRequesting
    val character = characterRepository.character
}
