package com.example.demo.company;

import com.example.demo.car.CarService;
import com.example.demo.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    CarService carService;

    //GET COMPANY
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getCompany/{companyId}")
    public Company getCompany(@PathVariable long companyId){
        return companyService.getCompany(companyId);
    }

    //GET COMPANIES
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    //Search Company
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/searchCompanies")
    public List<Company> searchCompanies(@RequestBody Search search){
        return companyService.searchCompanies(search);
    }

    //ADD COMPANY
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    //ADD CAR TO COMPANY
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addCarToCompany")
    public Company addCarToCompany(@RequestBody Company company){
        return companyService.addCarToCompany(company);
    }

    //ADD STATIC COMPANY
    @GetMapping("/testCompany")
    public void testCompany(){
        companyService.testCompany();
    }
}
