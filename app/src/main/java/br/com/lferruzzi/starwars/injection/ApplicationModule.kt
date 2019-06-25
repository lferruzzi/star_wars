package br.com.lferruzzi.starwars.injection

import br.com.lferruzzi.starwars.repository.CharacterRepository
import br.com.lferruzzi.starwars.rest.CharacterWebClient
import br.com.lferruzzi.starwars.main.viewmodel.CharacterListViewModel
import br.com.lferruzzi.starwars.main.viewmodel.MainActivityViewModel
import br.com.lferruzzi.starwars.main.viewmodel.SearchCharacterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Application Koin module.
 */
object ApplicationModule {
    val appModule = module {
        single { CharacterRepository(characterWebClient = get()) }
        single { CharacterWebClient() }
        viewModel { CharacterListViewModel(characterRepository = get()) }
        viewModel { MainActivityViewModel(characterRepository = get()) }
        viewModel { SearchCharacterViewModel(characterRepository = get()) }
    }

    const val MAIN_ACTIVITY_SCOPE = "MAIN_ACTIVITY_SCOPE"
}
