package com.nichi.miniProject.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.nichi.miniProject.model.Farmer;
import com.nichi.miniProject.services.FarmerService_V2;

@Controller
@RequestMapping("jpa")
public class FarmerController
{

        @Autowired
        FarmerService_V2 farmerService;


        @GetMapping("/farmers/list")
        @ResponseBody
        public List<Farmer> allFarmers()
        {
            return farmerService.getAllFarmers();
        }

     

    @PostMapping("/farmers/addnewfarmer")
    @ResponseBody
    public RedirectView addFarmer(@Valid Farmer farmer)
    {   
        // Save the farmer in the DB
        
        farmerService.addFarmer(farmer);

        RedirectView redirectView = new RedirectView("/"); 
        return redirectView;
    }

    
    @RequestMapping(value="/farmers/SearchfarmersByName",method ={RequestMethod.GET,RequestMethod.POST} )
	public String searchFarmerByName(@RequestParam String fname,HttpServletRequest httpServletRequest,Model model) 
    {
        System.out.println("inside search method ");

        /*
        if(httpServletRequest.getMethod()=="GET")
        {
            model.addAttribute("farmerList",new ArrayList<>());
                
        } */

       // else if(httpServletRequest.getMethod()=="POST")
              {
                List<Farmer> ListOfFarmers= farmerService.searchFarmerByName(fname);
                model.addAttribute("farmerList",ListOfFarmers);
                model.addAttribute("farmer_name",fname);

                System.out.println("size of list ="+ListOfFarmers.size());
              }
              
              return "resultSearchFarmerDetails.html";
    }


    
    @RequestMapping(value="/farmers/delete/{farmerId}",method ={RequestMethod.GET} )
       @ResponseBody
       public RedirectView deleteFarmerByName(@PathVariable int farmerId) 
   {

    System.out.println(""+farmerId);
   
        farmerService.deleteFarmerById(farmerId);
    
		RedirectView redirectView = new RedirectView("/");
		return redirectView;

}










}