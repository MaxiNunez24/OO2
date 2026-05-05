# Ejercicio 6.2: Juego

```java
public class Juego {
    //........
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }

    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
```

Los Code Smells que encuentro son Feature Envy, Magic Numbers y Public Fields. Se solucionan con Move Method, Collapse Hierarchy, Replace Magic Numbers with Symbolic Constant y Encapsulate Fields:

```java
public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    private static final int INCREMENTO = 100;
    private static final int DECREMENTO = 50;

    public void incrementar() { this.puntuacion += INCREMENTO; }
    public void decrementar() { this.puntuacion -= DECREMENTO; }
}
```

