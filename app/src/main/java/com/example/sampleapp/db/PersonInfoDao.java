package com.example.sampleapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface PersonInfoDao {
    @Query("SELECT * FROM personData")
    List<PersonInfo> getAll();
   // @Query("SELECT * FROM personData WHERE uid IN (:uid)")
  //  List<PersonInfo> loadAllByIds(int[] uid);

    @Query("SELECT * FROM personData WHERE email LIKE :email AND " +
            "password LIKE :password LIMIT 1")
    PersonInfo findByEmail(String email, String password);

    @Insert
    void insert(PersonInfo personInfo);

    @Delete
    void delete(PersonInfo personInfo);

}
