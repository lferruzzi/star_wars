package br.com.lferruzzi.starwars.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.lferruzzi.starwars.model.Character
import br.com.lferruzzi.starwars.model.CharacterList
import br.com.lferruzzi.starwars.rest.StarWarsWebClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Class containing the current [Character]s.
 */
class CharacterListRepository(private val characterWebClient: StarWarsWebClient) {

    /**
     * The current [Character] collection.
     */
    private val _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> = _characterList

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

    init {
        getFullCharacterList()
    }

    private fun getFullCharacterList() {
        Log.d(TAG, "getFullCharacterList")

        _isRequesting.value = true

        characterWebClient
            .characterEndpoint()
            .getFullCharacterList()
            .enqueue(object : Callback<CharacterList?> {

                override fun onResponse(call: Call<CharacterList?>, response: Response<CharacterList?>) {
                    _isRequesting.value = false
                    _wasLastRequestSuccessful.value = true
                    response.body()?.let {
                        _characterList.value = it.characters
                    }
                    Log.d(TAG, "onResponse $response")
                }

                override fun onFailure(call: Call<CharacterList?>?, t: Throwable?) {
                    _isRequesting.value = false
                    _wasLastRequestSuccessful.value = false
                    _characterList.value = listOf()
                    Log.d(TAG, "onFailure Throwable: $t , call: $call")
                }
            })
    }

    /**
     * Requests a new collection of [characters] based on the [searchString].
     */
    fun searchCharacters(searchString: String) {
        Log.d(TAG, "requestCharactersByName name: $searchString")

        _isRequesting.value = true

        characterWebClient
            .characterEndpoint()
            .searchCharacterList(searchString)
            .enqueue(object : Callback<CharacterList?> {
                override fun onResponse(call: Call<CharacterList?>, response: Response<CharacterList?>) {
                    _isRequesting.value = false
                    response.body()?.let {
                        _characterList.value = it.characters
                    }
                    Log.d(TAG, "onResponse $response")
                }

                override fun onFailure(call: Call<CharacterList?>?, t: Throwable?) {
                    _isRequesting.value = false
                    _wasLastRequestSuccessful.value = false
                    _characterList.value = listOf()
                    Log.d(TAG, "onFailure Throwable: $t , call: $call")
                }
            })
    }

    companion object {
        private const val TAG = "CharacterRepository"
    }
}
