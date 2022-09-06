package com.nichi.miniProject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nichi.miniProject.model.Farmer;
import com.nichi.miniProject.repositries.FarmerRepositry_V2;


@Service
public class FarmerService_V2 {

    @Autowired
    FarmerRepositry_V2 farmerRepositry;


    public List<Farmer> getAllFarmers() 
    {
        List<Farmer> farmersList = new ArrayList<Farmer>();

        farmerRepositry.findAll().forEach(farmer -> farmersList.add(farmer));

        return farmersList;
    }



    public Farmer addFarmer(Farmer farmer){
        return farmerRepositry.save(farmer);
   }


 
    public List<Farmer> searchFarmerByName(String fname) {
       
       // List<Farmer> FarmerList=farmerRepositry.searchByfname(fname);
        //return FarmerList;
          //farmerRepositry.findAll().forEach(farmer -> farmersList.add(farmer));


        List<Farmer> farmersList = getAllFarmers();

        List<Farmer> farmerList1=farmersList
        .stream()
        .filter(fty -> (fty.getFname().contains(fname)))
        .collect(Collectors.toList());

        return farmerList1;

    }

        @Transactional
        public void deleteFarmerById(int fId) 
        {
            farmerRepositry.deleteById(fId);
        }

    

}
