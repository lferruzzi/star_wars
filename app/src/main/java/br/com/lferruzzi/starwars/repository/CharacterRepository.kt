package br.com.lferruzzi.starwars.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.lferruzzi.starwars.model.Character

/**
 * Class containing the current [Character]s.
 */
class CharacterRepository {
    /**
     * The current selected [Character].
     */
    private val _character = MutableLiveData<Character>()
    val character: LiveData<Character> = _character

    /**
     * The last server request status.
     */
    private val _wasLastRequestSuccessful = MutableLiveData<Boolean>()
    val wasLastRequestSuccessful: LiveData<Boolean> = _wasLastRequestSuccessful

    /**
     * True if a new server request is ongoing, false otherwise.
     */
    private val _isRequesting = MutableLiveData<Boolean>()
    val isRequesting: LiveData<Boolean> = _isRequesting

    fun onCharacterSelected(character: Character) {
        _character.value = character
    }

    companion object {
        private const val TAG = "CharacterRepository"
    }
}
