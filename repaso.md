# OO2 - Integración de contenidos

## Bloque 1 — Refactoring

**1.1 (conceptual)** ¿Por qué "que compile y pase los tests" NO alcanza para afirmar que hiciste un buen refactoring? ¿Qué aporta mirar los smells? *(esta te quedó sin responder en el micro)*

**1.2 (conceptual)** Explicá la diferencia entre las **precondiciones** y el **mecanismo** de un refactoring. ¿Para qué sirve cada uno?

**1.3 (aplicado)** Tenés este código:

```java
public double calcularPrecio(Pedido pedido) {
    double precioBase = pedido.getCantidad() * pedido.getPrecioUnitario();
    double descuento = 0;
    if (pedido.getCantidad() > 100) {
        descuento = precioBase * 0.1;
    }
    return precioBase - descuento;
}
```

Nombrá el/los smell(s) que detectás y en qué líneas, y decí qué refactoring aplicarías. (No hace falta que lo apliques entero — solo diagnóstico + nombre del refactoring.)

---

## Bloque 2 — Patrones

**2.1 (conceptual)** Cuando estudiás un patrón, ¿qué cosas son importantes recordar de él? *(lo viste el lunes — a ver si te quedó)*

**2.2 (conceptual)** Diferencia entre **Strategy** y **State**. No me des solo "uno es para algoritmos y otro para estados" — quiero el matiz fino: ¿qué pasa con el *conocimiento entre las clases* concretas en cada uno, y qué sabe el objeto cliente/contexto en cada caso?

**2.3 (aplicado)** Una clase `Reporte` tiene un método `exportar(String formato)` con un `if/else` largo: si es "PDF" hace una cosa, si es "CSV" otra, si es "HTML" otra. Cada vez que agregás un formato, tocás ese método. ¿Qué smell es? ¿Qué patrón aplicarías y por qué? ¿Qué rol cumpliría cada clase?

---

## Bloque 3 — Frameworks

**3.1 (conceptual)** Definí **hot spot** y **frozen spot**. Dame un ejemplo de cada uno (puede ser del `SingleThreadTCPServer` que vieron, o inventado).

**3.2 (conceptual)** ¿Qué es la **inversión de control** en un framework? ¿Por qué se la asocia con el "Principio de Hollywood"? ¿Qué la diferencia de una biblioteca (library) común?

**3.3 (conceptual/aplicado)** Un framework se puede extender por **herencia** (white box) o por **composición**. Mencioná una ventaja y una desventaja de cada forma. ¿Cuál requiere que el desarrollador conozca más la estructura interna del framework?

___

1.1 Que compile y pase los tests NO alcanza para afirmar que se hizo un buen refactoring porque no se tiene en cuenta los code smells restantes. Estos son uno de los motivos principales del refactoring, el poder mejorar el código quitandolos es en parte la razón de los refactorings.

1.2 Las precondiciones son el contexto que se necesita tener antes de aplicar los pasos de un refactoring para asegurarnos de que funcione igual en todas las situaciones, mientras que el mecanismo son los pasos a seguir para cada situación posible.

1.3 
Code Smells: 
- L2, L4 Feature Envy
    
Refactoring: 
- Extract Method: crear los métodos públicos en Pedido llamados getPrecioBase() y getDescuento(). El resultado final quedaría: calcularPrecio(){ return pedido.getPrecioBase() - pedido.getDescuento() }


2.1 Cuando se estudia un patrón lo importante a recordar de él son:
    - Su intención
    - Los roles de su implementación
    - Su diagrama si se quiere tener una pista visual

2.2 La diferencia clave entre Strategy y State está en que, por más que ambos tengan el mismo diagrama, los Strategies no se conocen entre sí mientras que los States sí. Además de que los States pueden cambiar de forma dinámica, como luego de ejecutar algún método de un State u otra clase, mientras que los Strategies se pueden cambiar pero lo suele hacer el cliente / contexto explícitamente. Para el contexto no debería ni de enterarse que existen States, mientras que el contexto conoce los Strategies y selecciona cuál utilizar en cada caso.

2.3 Los code smell del método exportar son: Primitive Obsession que de seguro contiene además Duplicated Code y Switch Statements. 
Aplicaría el patrón Strategy porque cada formato es independiente y el contexto va a decidir cuál desea. En caso de tener código repetido también se podría aplicar Template Method. La clase Reporte cumpliría el rol de Strategy mientras que cada formato cumpliría el rol de ConcreteStrategy.

3.1 Un hot spot es una expresión, bloque, o parte del código dejada a implementación de cada uno (flexible) por el propio framework, que se puede y suele modificar, a menudo en base a las necesidades del problema que resuelva el desarrollador (que está utilizando el framework para realizar una implementación de su familia de aplicaciones). Por ejemplo los cuerpos o la creación de los hooks de React.

Mientras que un Frozen spot es lo contrario, la parte inflexible, "hardcodeada", que no se puede modificar al utilizar el framework. Por ejemplo los errores de algún servidor sencillo que no permita declarar propios, como la condición de cierre que no se permita cambiar de una comparación por "".

3.2 La inversión de control de un framework es cuando se le cede el control del flujo a la implementación del desarrollador, por ej: se llama a un método que el desarrollador definió en el hot spot. Se lo asocia con el "Principio de Hollywood" ya que cada implementación del framework va a ser conocida como parte de una familia de aplicaciones, siendo estas todas las implementaciones del framwork. Una biblioteca es una serie de clases ya implementadas y que no se pueden adaptar a las necesidades de cada solución, mientras que la inversión de control hace posible el framework pueda ser utilizado en múltiples casos o soluciones distintas gracias a tener a disposición hot spots que permitan que suceda.

3.3 La ventaja de extender un framework por herencia es que se puede llegar a tener más control sobre la implementación del mismo, la desventaja es que el framework va a funcionar hasta que no completemos los hot spots necesarios. Mientras que por composición la ventaja es que el framework ya funciona por si solo, pero la desventaja es que vamos a estar más limitados a las herramientas que provee el framework. Un framework que se extiende por herencia además requiere que el desarrollador conozca más su estructura interna para poder hacerlo funcionar.