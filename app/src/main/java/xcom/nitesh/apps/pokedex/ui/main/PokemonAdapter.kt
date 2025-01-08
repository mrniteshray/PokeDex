package xcom.nitesh.apps.pokedex.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import xcom.nitesh.apps.pokedex.data.Model.Pokemon
import xcom.nitesh.apps.pokedex.R

class PokemonAdapter(private val onPokemonclick : (Pokemon) -> Unit) : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(
    PokemonDiffCallback()
) {

    class PokemonViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val pokemonimg : ImageView = itemView.findViewById(R.id.pokemon_img)
        val pokenamename : TextView = itemView.findViewById(R.id.pokemon_name)
        fun bind(pokemon: Pokemon){
            pokenamename.text = pokemon.name
            Glide.with(itemView.context)
                .load(pokemon.image_url)
                .error(R.drawable.pikachu)
                .into(pokemonimg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_itemview,parent,false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
        holder.pokemonimg.setOnClickListener {
            onPokemonclick(current)
        }
    }

    class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}