package com.nichi.miniProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.nichi.miniProject.services.FarmerService_V2;

@Controller
public class HomeController {
    

    
    @Autowired
    FarmerService_V2 farmerService;

  //  List<Farmer> farmerList=farmerService.getAllFarmers();
    
    @GetMapping("/")
    public String IndexPage(Model model)
    {
        //model.addAttribute("farmerList", farmerService.getAllFarmers());
        return "resultSearchFarmerDetails.html";
    }

    


    /*
    @GetMapping("/farmers/getData")
public String getFarmers(Model model,@Param("keyword") String keyword)
{
  List<Farmer> farmers=farmerService.findAllFarmers(keyword);
  model.addAttribute("farmers",farmers);
  model.addAttribute("keyword",keyword);
  return "farmers";
}

 */


}
