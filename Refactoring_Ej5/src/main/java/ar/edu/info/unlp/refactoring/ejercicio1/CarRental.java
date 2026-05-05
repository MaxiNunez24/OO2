package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class CarRental extends Product {
    private double cost;
    private Company company;

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.company = company;
    }

    public double price() {
        return this.company.effectivePrice();
    }

    public double cost() {
        return this.cost;
    }
}
