package org.esiea.cam_gidon.pokedex.Api;

import org.esiea.cam_gidon.pokedex.Api.Service.PokedexService;
import retrofit.RestAdapter;


/**
 * Created by Damien on 28/01/2018.
 */

public class PokedexClient {

    private static final String POKEDEX_BASE_URL = "http://pokeapi.co";
    private PokedexService pokedexService;

    private static PokedexClient instance = null;

    public static PokedexClient getInstance() {
        if(instance == null) {
            instance = new PokedexClient();
        }
        return instance;
    }

    protected PokedexClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(POKEDEX_BASE_URL)
                .build();

        pokedexService = restAdapter.create(PokedexService.class);
    }

    public PokedexService getApiService() {
        return pokedexService;
    }
}
