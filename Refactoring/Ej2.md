# Ejercicio 2: Iteradores circulares 

Dada la siguiente implementación:

CharRing.java
```java
public class CharRing extends Object {
    char[] source;
    int idx;

    public CharRing(String srcString) {
        char result;
        source = new char[srcString.length()];
        srcString.getChars(0, srcString.length(), source, 0);
        result = 0;
        idx = result;
    }

    public char next() {
        int result;
        if (idx >= source.length) idx = 0;
        result = idx++;
        return source[result]; // Línea 18 
    }
}
```

## Tareas:
1) Se quiere aplicar el refactoring Rename Variable sobre la variable **result** que se usa en la línea 18 con el nuevo nombre **currentPosition**.
2) ¿Cómo queda el código final y qué inconveniente se podría encontrar?

## Soluciones
1) Para aplicar el refactoring Rename Variable sobre la línea 18 cambiando result por currentPosition se debe contemplar que también se deberá cambiar las líneas 17 y 15 ya que contienen a la variable result.
2) El código final queda:
```java
    public class CharRing extends Object {
    char[] source;
    int idx;

    public CharRing(String srcString) {
        char result;
        source = new char[srcString.length()];
        srcString.getChars(0, srcString.length(), source, 0);
        result = 0;
        idx = result;
    }

    public char next() {i
        int currentPosition;
        if (idx >= source.length) idx = 0;
        currentPosition = idx++;
        return source[currentPosition]; // Línea 18
    }
}
```
El inconveniente que se podría encontrar es que si se utiliza el replace del IDE se puede modificar incorrectamente el result que está en el constructor en lugar de sólo la variable local necesaria.