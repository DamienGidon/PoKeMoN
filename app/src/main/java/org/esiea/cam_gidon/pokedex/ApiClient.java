package org.esiea.cam_gidon.pokedex;

import retrofit.RestAdapter;

/**
 * Created by dgidon on 26/01/2018.
 */

public class ApiClient {
    private static  final String POKEMON_BASE_URL = "http://pokeapi.co";
    private ApiService apiservice;

    private static ApiClient instance = null;

    public static ApiClient getInstance() {
        if(instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    protected ApiClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(POKEMON_BASE_URL)
                .build();

        apiservice = restAdapter.create(ApiService.class);
    }

    public ApiService getApiservice() {
        return apiservice;
    }
}
