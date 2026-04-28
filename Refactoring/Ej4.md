# Ejercicio 4: Alcance en Redes Sociales 

Una nueva red social está desarrollando un sistema para modelar perfiles y publicaciones, y medir su alcance como parte del algoritmo de relevancia. Cada publicación acumula reacciones de los usuarios, y cada perfil consolida el alcance de sus publicaciones amplificándolo según si está verificado o no. El código es el siguiente:


```java
package redesocial;
public class Publicacion{
    private String texto;
    private int likes;
    public Publicacion(String texto){  
        this.texto = texto;
        this.likes = 0;
    }
    public void darLike(){ likes ++ ; }
    public void darDislike(){ likes -- ;}
    private int procesar(){ // Línea 11
        return likes * 3;
    }
    public int calcular(){ // Línea 14
        return procesar() * 10;
    }
}
```

```java
package redesocial;
import java.util.ArrayList;
public class Perfil{
    private boolean verificado;
    private ArrayList<Publicacion> publicaciones;
    public Perfil(boolean verificado){
        this.verificado = verificado;
        this.publicaciones = new ArrayList<>();
    }
    public void agregarPublicacion(Publicacion p){publicaciones.add(p);} // Línea 10
    private int bonus(){return verificado ? 2:1;}
    private int alcanceDePublicaciones(){
        return publicaciones.stream().mapToInt(p-> p.calcular()).sum(); // Línea 13
    }
    public int calcular(){ // Línea 15
        return alcanceDePublicaciones() * bonus();
    }
}
```

## Ejercicios:
Liste cada uno de los cambios necesarios, indicando archivo y línea afectados, para cada uno de los siguientes refactorings:
1) Rename method: procesar (referenciado en línea 11 de Publicacion.java) por impacto
   1. Verificar si el método es utilizado por alguna superclase o subclase
   2. Como no es referenciado por superclases o subclases, sino que solo por un método local, entonces -> 
   3. Renombrar el método procesar de la clase Publicación en línea 11 por impacto
   4. Actualizar el llamado a procesar en la línea 15 de la clase Publicación por impacto 
   5. Compilar y Testear

2) Rename method: calcular (referenciado en línea 14 de Publicacion.java) por alcance
   1. Verificar si el método es utilizado por alguna superclase o subclase
   2. Como es referenciado por la clase Perfil en línea 13, entonces ->
   3. Declarar un nuevo método con el nombre nuevo "alcance"
   4. Copiar el cuerpo del viejo método "calcular" al nuevo "alcance" y aplicar los cambios correspondientes si hacen falta
   5. Compilar
   6. Como solamente tiene una única referencia, no hace falta cambiar el cuerpo del viejo método para que ejecute el nuevo
   7. Renombrar la llamada al método "calcular" de la clase Perfil en línea 13 por "alcance", como no hay más referencias ->
   8. Remover el método viejo "calcular"
   9. Compilar y Testear

3) Rename method: calcular (referenciado en línea 15 de Perfil.java) por alcance
   1. Verificar si el método es utilizado por alguna superclase o subclase
   2. Como no es referenciado por ningún otro método o clase, entonces ->
   3. Renombrar el método "calcular" de la clase Perfil línea 15 por "alcance"
   4. Compilar y Testear

4) Rename parameter: el parámetro “p” del método agregarPublicacion (línea 10 de Perfil.java) por “publicacion”
   1. Encontrar todas las referencias al parámetro "p" dentro del método agregarPublicacion de la clase Perfil
   2. Como solamente tiene una única referencia ->
   3. Renombrar el parámetro "p" a "publicacion"
   4. Renombrar la referencia al parámetro "p" a "publicacion"
   5. Compilar y Testear


