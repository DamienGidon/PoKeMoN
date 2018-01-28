package org.esiea.cam_gidon.pokedex.Api.Service;
import org.esiea.cam_gidon.pokedex.models.Pokedex.PokedexHeader;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Damien on 28/01/2018.
 */

public interface PokedexService {

    @GET("/api/v2/pokedex/")
    void getPokedex(Callback<PokedexHeader> pokedexList);



    //@GET("/api/v2/pokemon/{id}")
    //void getPokemonDetails(@Path("id") int pokedexId, Callback<PokemonDetails> pokemonDetails);

}
