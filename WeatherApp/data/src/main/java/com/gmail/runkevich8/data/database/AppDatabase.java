package com.gmail.runkevich8.data.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.gmail.runkevich8.data.entity.Weather;

@Database(entities = {Weather.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WeatherDAO weatherDao();
}
