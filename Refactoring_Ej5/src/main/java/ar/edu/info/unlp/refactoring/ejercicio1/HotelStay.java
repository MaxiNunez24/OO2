package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class HotelStay extends Product {
    private double quote;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.quote = cost;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double cost(){
        return this.quote;
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.effectiveNightPrice();
    }
}
