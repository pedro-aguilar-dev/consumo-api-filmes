package com.example.consumoapifilmes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consumoapifilmes.R;
import com.example.consumoapifilmes.adapter.FilmeAdapter;
import com.example.consumoapifilmes.api.OmdbApi;
import com.example.consumoapifilmes.model.FilmeModel;
import com.example.consumoapifilmes.model.FilmeSerializable;
import com.example.consumoapifilmes.singleton.RetrofitSingleton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
      RecyclerView recyclerView;
      EditText editTextFilme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewFilmes);
         editTextFilme = findViewById(R.id.editTextFilme);

         //define o numero  de colunas na lista
        final int NCOL= 2;
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, NCOL ));

        //acessa o serviço da api

        //pegando a instancia
        OmdbApi omdbApi = RetrofitSingleton.getRetrofitInstance().create(OmdbApi.class);


        Call<FilmeSerializable> call = omdbApi.getFilmes();

        //enquueue empilhar
        //variados chamadas de requisicão
        call.enqueue(new Callback<FilmeSerializable>() {
            @Override
            public void onResponse(Call<FilmeSerializable> call, Response<FilmeSerializable> response) {

                  if(response.isSuccessful()){
                      ArrayList<FilmeModel> filmeModelArrayLis = response.body().filmeSerializableArrayList;
                      RecyclerView.Adapter adapter =  new FilmeAdapter(filmeModelArrayLis);
                      recyclerView.setAdapter(adapter);

                  }
                  else{
                      Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                  }
            }

            @Override
            public void onFailure(Call<FilmeSerializable> call, Throwable t) {

            }
        });
    }
}