package com.example.demo.companytest;

import com.example.demo.car.Car;
import com.example.demo.car.CarRepository;
import com.example.demo.company.Company;
import com.example.demo.company.CompanyController;
import com.example.demo.company.CompanyRepository;
import com.example.demo.company.CompanyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@TestPropertySource(locations= "classpath:application-dev.properties")
public class UnitTesting {

        @Autowired
        private CompanyRepository companyRepository;

        @Autowired
        private CarRepository carRepository;

        @Test
        public void test(){
            Assert.assertTrue("Hej".contains("Hej"));
        }

        @Test
        public void saveCompanyThenCheckIfSaved(){
                List<Car> list = new ArrayList<>();
                Company company = new Company("Wolverine", "X-MEN Mansion", list);

                companyRepository.save(company);
                List<Company> companyList = companyRepository.findAll();
                Assert.assertTrue(companyList.toString().contains("Wolverine"));
        }

        @Test
        public void saveCarThenCheckifSaved(){
                Car car = new Car("ABC123", "VIN1234567890", true);

                carRepository.save(car);
                List<Car> carList = carRepository.findAll();
                Assert.assertTrue(car.toString().contains("ABC123"));
        }
}
