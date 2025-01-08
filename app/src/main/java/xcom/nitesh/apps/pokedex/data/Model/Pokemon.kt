package xcom.nitesh.apps.pokedex.data.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val abilities: List<String>,
    val attack: Int,
    val defense: Int,
    val description: String,
    val height: String,
    val hp: Int,
    val id: Int,
    val image_url: String,
    val name: String,
    val special_attack: Int,
    val special_defense: Int,
    val speed: Int,
    val type: List<String>,
    val weight: String
) : Parcelable