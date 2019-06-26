package br.com.lferruzzi.starwars.injection

import br.com.lferruzzi.starwars.repository.CharacterListRepository
import br.com.lferruzzi.starwars.repository.CharacterRepository
import br.com.lferruzzi.starwars.rest.StarWarsWebClient
import br.com.lferruzzi.starwars.ui.detail.viewmodel.CharacterDetailViewModel
import br.com.lferruzzi.starwars.ui.main.viewmodel.CharacterListViewModel
import br.com.lferruzzi.starwars.ui.main.viewmodel.MainActivityViewModel
import br.com.lferruzzi.starwars.ui.main.viewmodel.SearchCharacterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Application Koin module.
 */
object ApplicationModule {
    val appModule = module {
        single { CharacterRepository() }
        single { CharacterListRepository(characterWebClient = get()) }
        single { StarWarsWebClient() }

        viewModel { CharacterListViewModel(characterListRepository = get()) }
        viewModel { MainActivityViewModel(characterRepository = get(), characterListRepository = get()) }
        viewModel { SearchCharacterViewModel(characterListRepository = get()) }
        viewModel { CharacterDetailViewModel(characterRepository = get()) }
    }
}
