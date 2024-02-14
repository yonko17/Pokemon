package com.example.pokemon2

import com.example.pokemon2.data.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{pokemonName}")
    fun getPokemonByName(@Path("pokemonName") pokemonName: String): Call<Pokemon>
}

