package com.example.pokemon2.data

data class Pokemon (
    val name: String,
    val id: Int,
    val types: List<PokemonType>,
    val abilities: List<PokemonAbility>
    )

data class PokemonType(
    val slot: Int,
    val type: TypeInfo
    )

    data class PokemonAbility(
        val ability: AbilityInfo,
        val isHidden: Boolean,
        val slot: Int
    )

    data class TypeInfo(
        val name: String,
        val url: String
    )
