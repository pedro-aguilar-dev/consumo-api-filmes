package com.example.consumoapifilmes.api;

import com.example.consumoapifilmes.model.FilmeModel;
import com.example.consumoapifilmes.model.FilmeSerializable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OmdbApi{


    @GET("?apikey=4369d39a&t=matrix")
    Call<FilmeModel> getFilme();


    @GET("?apikey=4369d39a&s=matrix")
    Call<FilmeSerializable> getFilmes();




}
