# Ejercicio 6.1: Empleados

```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido; 
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    public double sueldo() {
        return this.sueldoBasico
                + (this.horasTrabajadas * 500)
                + (this.cantidadHijos * 1000) 
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......

    public double sueldo() {
        return this.sueldoBasico
                + (this.cantidadHijos * 2000)
                - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......

    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

Los Code Smell que encuentro son Duplicated Code (campos) Duplicated Code (Descuento), Public Fields y Magic Numbers que se podrían solucionar con Pull Up Field, Pull Up Method y Extract Method para los primeros, Encapsulate Field para los segundos y Replace Magic Numbers with Symbolic Constant para el último:

```java
public class Empleado{
    private String nombre; 
    private String apellido;
    private double sueldoBasico = 0;

    private static final double TASA_DESCUENTO = 0.13;
    
    public String getNombre() { return this.nombre; }
    public String getApellido() { return this.apellido; }
    
    public double sueldo(){
        return this.sueldoBasico - calcularDescuento();
    }
    
    public double calcularDescuento(){ return this.sueldoBasico * TASA_DESCUENTO; }
}

public class EmpleadoTemporario extends Empleado {
    private int cantidadHijos = 0;
    private double horasTrabajadas = 0;
    // ......

    private static final double VALOR_HORA = 500;
    private static final double ASIGNACION_HIJO = 1000;
    
    @Override
    public double sueldo() {
        return super.sueldo() 
                + (this.horasTrabajadas * VALOR_HORA)
                + (this.cantidadHijos * ASIGNACION_HIJO); 
    }
}

public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos = 0;
    // ......

    private static final double ASIGNACION_HIJO = 2000;
    
    @Override
    public double sueldo() {
        return super.sueldo()
                + (this.cantidadHijos * ASIGNACION_HIJO);
    }
}

public class EmpleadoPasante extends Empleado {
    // ......
    // Hereda sueldo() directamente
}
```


