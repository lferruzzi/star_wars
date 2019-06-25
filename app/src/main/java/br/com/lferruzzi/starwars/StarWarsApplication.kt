package br.com.lferruzzi.starwars

import android.app.Application
import br.com.lferruzzi.starwars.injection.ApplicationModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * First class to be executed when the application starts.
 */
class StarWarsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    /**
     * Initialize Koin's application module.
     */
    private fun initializeKoin() {
        startKoin {
            androidContext(this@StarWarsApplication)
            modules(appModule)
        }
    }
}
