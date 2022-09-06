package com.nichi.miniProject.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nichi.miniProject.model.Farmer;


@Repository
public interface FarmerRepositry_V2 extends JpaRepository<Farmer, Integer> {

    @Query(value="SELECT farmer_Id,fname,age FROM Farmer f where f.fname=:fname", nativeQuery = true)
    public List<Farmer> searchByfname(String fname);

}