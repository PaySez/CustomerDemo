package com.paysez.customerdemo;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@androidx.room.Database(entities = LocalData.class,version = 1)
public abstract class  Database extends RoomDatabase {

    public abstract ListDAO getListDao();

}
