package com.example.pokemon2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemon2.data.Pokemon
import com.example.pokemon2.data.PokemonModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    suspend fun fetchPokemon(pokemonName: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(PokeApiService::class.java)
        val call = apiService.getPokemonByName(pokemonName)

        call.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.isSuccessful) {
                    val pokemon = response.body()
                    // Procesar el objeto Pokémon recibido
                } else {
                    // Manejar el caso de respuesta no exitosa
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                // Manejar errores de red o errores en la respuesta
            }
        })
}

}