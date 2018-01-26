package org.esiea.cam_gidon.pokedex;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.Callback;
import org.esiea.cam_gidon.pokedex.model.PokemonHeader;
import org.esiea.cam_gidon.pokedex.Pokemon.PokemonDetails;


/**
 * Created by dgidon on 26/01/2018.
 */

public interface ApiService {
    @GET("/api/v2/")
    void getPokemonList(Callback<PokemonHeader> pokedexList);

    @GET("/api/v2/{id}")
    void getPokemonById(@Path("id") int pokemonId, Callback<PokemonDetails> PokemonDetails);
}
