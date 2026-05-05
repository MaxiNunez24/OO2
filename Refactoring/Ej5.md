# Ejercicio 5: Productos 

```java
package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class HotelStay extends Product {
    public double cost;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.cost / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }
}
```

```java
package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class CarRental extends Product {
    public double cost;
    private TimePeriod timePeriod;
    private Company company;

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.company = company;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double cost() {
        return this.cost;
    }
}
```

## Tareas:
1) La variable “cost” está declarada como pública, lo que rompe el encapsulamiento de la clase. Utilice el refactoring Encapsulate Field y describa brevemente los pasos llevados a cabo.
   1. Crear método get para el atributo "cost"
   2. Encontrar todas las referencias al atributo
   3. Como el atributo solo es referenciado por las clases de Test ->
   4. Se reemplazan las referencias por el llamado al método get
   5. Se encapsula la variable cambiandola a private
   6. Se compila y se vuelve a correr los tests
Verifique que los tests provistos sigan funcionando. Discuta con un ayudante: 
   1. ¿Es correcto modificar alguno de los tests para que el código refactorizado funcione?
      En la mayoría de los casos no es correcto, pero en este caso está justificado debido a que el test está mal hecho ya que falla y no testea la funcionalidad propia solamente.
   2.  En caso de qué el test falle, ¿qué situación está representando este test?
      El primer test que falla está representando la situación de que costo sea null, cosa que no puede pasar ya que es un parámetro del constructor.
2) Utilice el refactoring Rename Field en el método priceFactor(), para que la variable “cost” se pase a llamar “quote”. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante: ¿en este caso, es necesario modificar alguno de los tests para que el código refactorizado funcione?
   
3) Se quiere aplicar el refactoring Pull Up Method para subir los métodos startDate() y endDate() a la superclase Product. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.
4) Mencione y aplique los refactorings necesarios para poder hacer Pull Up Method.
5) Aplique Pull Up Method para subir los métodos a la superclase Product. Verifique que los tests provistos sigan funcionando.
6) Observe los métodos price() en CarRental.java (línea 21) y en HotelStay.java (línea 25). Identifique los Code Smell presentes. Luego aplique los refactoring correspondientes para eliminarlos. Verifique que los tests provistos sigan funcionando.
