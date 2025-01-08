package xcom.nitesh.apps.pokedex.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import xcom.nitesh.apps.pokedex.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val pokemon = args.pokemon

        binding.pokemonName.text = pokemon.name
        binding.pokemonDescription.text = pokemon.description
        binding.pokemonType.text = "Type: ${pokemon.type.joinToString(", ")}"
        binding.pokemonAbilities.text = "Abilities: ${pokemon.abilities.joinToString(", ")}"
        binding.pokemonHeightWeight.text = "Height: ${pokemon.height}, Weight: ${pokemon.weight}"

        Glide.with(requireContext())
            .load(pokemon.image_url)
            .into(binding.pokemonImage)

        binding.hpProgress.progress = pokemon.hp
        binding.hpValue.text = pokemon.hp.toString()
        binding.attackProgress.progress = pokemon.attack
        binding.attackValue.text = pokemon.attack.toString()
        binding.defenseProgress.progress = pokemon.defense
        binding.defenseValue.text = pokemon.defense.toString()
        binding.specialAttackProgress.progress = pokemon.special_attack
        binding.specialAttackValue.text = pokemon.special_attack.toString()
        binding.specialDefenseProgress.progress = pokemon.special_defense
        binding.specialDefenseValue.text = pokemon.special_defense.toString()
        binding.speedProgress.progress = pokemon.speed
        binding.speedValue.text = pokemon.speed.toString()

    }

}