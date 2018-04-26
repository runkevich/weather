//package com.gmail.runkevich8.data.database;
//
//import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Insert;
//import android.arch.persistence.room.OnConflictStrategy;
//import android.arch.persistence.room.Query;
//
//import com.gmail.runkevich8.data.entity.Weather;
//
//import java.util.List;
//
//import io.reactivex.Flowable;
//
//
//
//
//@Dao
//public interface WeatherDAO {
//
//    @Query("SELECT  cityName FROM Weather")
//    Flowable<List<String>> loadCityList();
//
//    @Query("SELECT * FROM Weather WHERE cityName = :cityName LIMIT 1")
//    Flowable<Weather> load(String cityName);
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    void save(Weather weather);
//}
