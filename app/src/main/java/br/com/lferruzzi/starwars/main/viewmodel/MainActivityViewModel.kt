package br.com.lferruzzi.starwars.main.viewmodel

import androidx.lifecycle.ViewModel
import br.com.lferruzzi.starwars.repository.CharacterRepository

class MainActivityViewModel(characterRepository: CharacterRepository) : ViewModel() {
    val wasLastRequestSuccessful = characterRepository.wasLastRequestSuccessful
    val isRequesting = characterRepository.isRequesting
}
