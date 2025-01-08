package xcom.nitesh.apps.pokedex.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xcom.nitesh.apps.pokedex.data.Model.Pokemon
import xcom.nitesh.apps.pokedex.data.repository.PokemonRepository
import javax.inject.Inject

class PokemonViewModel @Inject constructor(val repository: PokemonRepository) : ViewModel() {

    val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> get() = _pokemonList

    val _loadingdata = MutableLiveData<Boolean>()
    val loadingdata : LiveData<Boolean> get() = _loadingdata

    fun loadPokemonData() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingdata.postValue(true)
            val data = repository.loaddata()
            _pokemonList.postValue(data)
            _loadingdata.postValue(false)
        }
    }
}