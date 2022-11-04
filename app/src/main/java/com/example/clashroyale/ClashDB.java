package com.example.clashroyale;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Cards.class}, version = 1)
public abstract class ClashDB extends RoomDatabase {
    private static ClashDB INSTANCE;

    public static ClashDB getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            ClashDB.class, "db"
                    ).build();
        }
        return INSTANCE;
    }

    public abstract  ClashDao getCardsDao();
}
