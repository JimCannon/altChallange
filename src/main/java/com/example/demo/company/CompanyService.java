package com.example.demo.company;

import com.example.demo.car.Car;
import com.example.demo.car.CarRepository;
import com.example.demo.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

//@RestController
@Service
public class CompanyService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CarRepository carRepository;

    public Company getCompany(long companyId){
        return companyRepository.findById(companyId);
    }

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }


    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company addCarToCompany(Company company){
        Company companyList = companyRepository.findById(company.getId());
        Car car = carRepository.findById(company.getCarList().get(0).getId());

        companyList.getCarList().add(car);
        return companyRepository.save(companyList);
    }

    public List<Company> searchCompanies(@RequestBody Search search){
        StringBuilder sb = new StringBuilder();
        sb.append("Select * from Company where id > 0");

        if(search.getCompanyName() != null){
            sb.append(" and company_name = \'" + search.getCompanyName() +"\'");
        }
        System.out.println(sb.toString());
        return entityManager.createNativeQuery(sb.toString(), Company.class).getResultList();
    }


    public void testCompany(){
        List<Company> companyList = CompanyStatic.getStaticCompanies();
        for(Company c : companyList){
            companyRepository.save(c);
        }
    }
}
