package com.example.demo.company;

import com.example.demo.car.Car;

import java.util.ArrayList;
import java.util.List;

public final class CompanyStatic {
    protected static List<Company> getStaticCompanies() {
        List<Car> carTestList1 = new ArrayList<>();
        List<Car> carTestList2 = new ArrayList<>();
        List<Car> carTestList3 = new ArrayList<>();

        carTestList1.add(new Car("YS2R4X20005399401", "ABC123", true));
        carTestList1.add(new Car("VLUR4X20009093588", "DEF456", true));
        carTestList1.add(new Car("VLUR4X20009048066", "GHI789", true));

        carTestList2.add(new Car("YS2R4X20005388011", "JKL012", true));
        carTestList2.add(new Car("YS2R4X20005387949", "MNO345", true));

        carTestList3.add(new Car("YS2R4X20005387765", "PQR678", true));
        carTestList3.add(new Car("YS2R4X20005387055", "STU901", true));

        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Kalles Grustransporter AB", "Cementvägen 8, 111 11 Södertälje", carTestList1));
        companies.add(new Company("Johans Bulk AB", "Balkvägen 12, 222 22 Stockholm", carTestList2));
        companies.add(new Company("Haralds Värdetransporter AB", "Budgetvägen 1, 333 33 Uppsala", carTestList3));

        return companies;
    }
}
