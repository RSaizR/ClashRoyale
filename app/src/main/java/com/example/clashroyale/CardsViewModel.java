package com.example.clashroyale;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;

public class CardsViewModel extends AndroidViewModel {

    private final Application app;
    private final ClashDB db;
    private final ClashDao clashDao;
    private MutableLiveData<List<Cards>> cards;

    public CardsViewModel(@NonNull Application application) {

        super(application);
        this.app = application;
        this.db = ClashDB.getDatabase(this.app);
        this.clashDao = this.db.getCardsDao();
    }

    public LiveData<List<Cards>> getCards() {
        return clashDao.getCards();
    }

    public void refresh() {

       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            CardsAPI api = new CardsAPI();
            ArrayList<Cards> pokemons = api.getCards();

            this.clashDao.deletePokemons();
            this.clashDao.addPokemons(pokemons);
        });
    }
}
