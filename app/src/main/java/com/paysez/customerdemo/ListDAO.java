package com.paysez.customerdemo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ListDAO {
    @Query("select * from LocalData")
    List<LocalData> getAll();
    @Insert
    void insertAll(LocalData... users);
    @Delete
    void delete(LocalData user);
    @Query("delete from localdata")
    void deleteAll();


    @Query("select * from localdata order by link_creation_date")
    List<LocalData> sortByDate();


    @Query("select * from localdata order by amount")
    List<LocalData> sortByDateAmount();


    @Query("select * from localdata order by link_creation_date DESC")
    List<LocalData> sortByDateDescending();
}
