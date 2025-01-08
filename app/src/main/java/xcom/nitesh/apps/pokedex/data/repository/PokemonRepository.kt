package xcom.nitesh.apps.pokedex.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import xcom.nitesh.apps.pokedex.data.Model.Pokemon
import java.io.InputStreamReader
import javax.inject.Inject

class PokemonRepository @Inject constructor(@ApplicationContext private val context : Context) {
    fun loaddata() : List<Pokemon>{
        val inputStream = context.assets.open("pokemon.json")
        val reader = InputStreamReader(inputStream)
        val type = object : TypeToken<List<Pokemon>>() {}.type
        return Gson().fromJson(reader, type)
    }
}