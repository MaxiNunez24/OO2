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
   No es necesario modificar los tests para que el código refactorizado funcione, ya que el getter sigue siendo cost() y el rename field es sólo para implementaciones internas a la clase.
   
3) Se quiere aplicar el refactoring Pull Up Method para subir los métodos startDate() y endDate() a la superclase Product. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.
   No, no es posible directamente. Las precondiciones del refactoring Pull Up Method (Fowler) establecen: Los métodos deben ser idénticos o sus diferencias deben poder eliminarse previamente. Además, todos los campos y métodos que referencian deben existir (o poder subirse) a la superclase. El problema es que startDate() y endDate() en ambas clases referencian this.timePeriod, el cual es un campo privado de cada subclase, no existe en Product. Si intentáramos subir los métodos directamente, Product no sabría qué es timePeriod y el código no compilaría.

4) Mencione y aplique los refactorings necesarios para poder hacer Pull Up Method.
   Se deben aplicar dos refactorings previos:
      1. Pull Up Field sobre timePeriod
         El campo private TimePeriod timePeriod aparece idéntico en ambas subclases (mismo tipo, mismo nombre). Esto es un Duplicate Code que se resuelve subiéndolo a la superclase.
         Pasos:
         1. Declarar protected TimePeriod timePeriod en Product.
         2. Eliminar la declaración del campo en HotelStay y CarRental. 
         3. Verificar que los constructores de ambas subclases ya asignan correctamente this.timePeriod = timePeriod (siguen funcionando sin cambios). 
         4. Compilar y correr los tests.
      
      2. Encapsulate Field sobre timePeriod (opcional pero recomendable)
         Si se prefiere mantener el campo private en Product en lugar de protected, se puede agregar un getter getTimePeriod() en la superclase. Los métodos en las subclases usarían this.getTimePeriod().start() en lugar de this.timePeriod.start(). Esto respeta mejor el encapsulamiento antes de subir los métodos.

5) Aplique Pull Up Method para subir los métodos a la superclase Product. Verifique que los tests provistos sigan funcionando.
   Una vez que timePeriod vive en Product, los métodos son idénticos en ambas subclases y todas sus referencias están resueltas. Se procede:
   Pasos:
   1. Copiar startDate() y endDate() a Product (como métodos public).
   2. Compilar para verificar que Product compila correctamente con this.timePeriod.
   3. Eliminar startDate() y endDate() de HotelStay y CarRental.
   4. Compilar y correr los tests.

6) Observe los métodos price() en CarRental.java (línea 21) y en HotelStay.java (línea 25). Identifique los Code Smell presentes. Luego aplique los refactoring correspondientes para eliminarlos. Verifique que los tests provistos sigan funcionando.
   Ambos métodos presentan el smell Feature Envy: un método está más interesado en los datos de otro objeto que en los del objeto al que pertenece. En HotelStay, la lógica para calcular el precio efectivo por noche (nightPrice * discountRate) es responsabilidad de Hotel, no de HotelStay. Lo mismo con company.price() * company.promotionRate().
   Adicionalmente, el patrón objeto.valor() * objeto.tasa() se repite en ambos casos, lo que también sugiere Duplicate Code estructural.
   Refactoring a aplicar: Move Method (o Extract Method + Move Method)
   En Hotel: mover la lógica nightPrice() * discountRate() como un nuevo método effectiveNightPrice().
   En Company: mover la lógica price() * promotionRate() como un nuevo método effectivePrice().
