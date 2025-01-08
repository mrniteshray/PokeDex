package xcom.nitesh.apps.pokedex.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import xcom.nitesh.apps.pokedex.data.Model.Pokemon
import xcom.nitesh.apps.pokedex.data.repository.PokemonRepository
import xcom.nitesh.apps.pokedex.R
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PokemonAdapter

    @Inject
    lateinit var pokemonViewModel: PokemonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)


        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)


        adapter = PokemonAdapter{ pokemon ->
            onPokemonClick(pokemon)
        }
        recyclerView.adapter = adapter

        pokemonViewModel.loadPokemonData()
        pokemonViewModel.pokemonList.observe(viewLifecycleOwner){ pokemon->
            adapter.submitList(pokemon)
        }

        pokemonViewModel.loadingdata.observe(viewLifecycleOwner){
            if (it){
                progressBar.visibility = View.VISIBLE
            }else{
                progressBar.visibility = View.GONE
            }
        }
    }

    private fun  onPokemonClick(pokemon: Pokemon){
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(pokemon)
        findNavController().navigate(action)
    }
}
