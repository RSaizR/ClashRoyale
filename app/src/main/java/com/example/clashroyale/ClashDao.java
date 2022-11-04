package com.example.clashroyale;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ClashDao {

    //PREGUNTA A LA BASE DE DATOS SI HA HABIDO ALGUN CAMBIO
    @Query("select * from cards")
    LiveData<List<Cards>> getCards();

    @Insert
    void addPokemon(Cards card);

    @Insert
    void addPokemons(List<Cards> card);

    @Delete
    void deletePokemon(Cards card);

    @Query("DELETE FROM cards")
    void deletePokemons();

}
