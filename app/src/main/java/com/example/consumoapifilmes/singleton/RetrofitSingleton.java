package com.example.consumoapifilmes.singleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    public static Retrofit retrofit;

    public static  Retrofit getRetrofitInstance(){
        //se n existir instancia no projeto
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.omdbapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
