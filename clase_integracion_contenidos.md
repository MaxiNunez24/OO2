# Material de apuntes de teorías

## Primera clase OO2
La cursada consta de un parcial que se aprueba por temas
Si se aprueba en la 1ra y/o 2da fecha en la 3ra fecha se rinde la promoción (examen final simplificado) el cual se aprueba con 6 o más.

Se puede aprobar los 3 temas en primera fecha y venir a la segunda fecha a rendir las preguntas de promoción.

### Hay que estudiar de los libros además de las transparencias:
- Design Patterns. Elements of REusable Objects Oriented Software. Gamma, Helm, Johnson. Vlissides, Addison-Wesley.
- Refactoring: Improving the Design of Existing Code. Fowler, Martin, Addison-Wesley (1ra EdicióN Java)
- Refactoring to Patterns. Joshua Kerievsky
- Implementing Aplication Frameworks


### Refactoring
Reconocer y hacer más prolijo el código spaghetti para que siga pasando los test pero sea más legible y mantenible
### Patrones de diseño
Construir diseños reusables, más sensibles a la evolución
Reconocer las consecuencias positivas y negativas
### Frameworks
Aprender a entender y crear arquitecturas reusables.
 
### Importancia del Testing
Tipos de test
TDD


## Refactoring
Son transformaciones que preservan el comportamiento para hacer el código más reusable, más legible y mejorar su calidad.

(Sustantivo): Es una transformación que se realiza en la estructura interna del software para hacerlo fácil de entender y más barato de modificar, y que preserva el comportamiento observable
- Con un nombre específico con el que está catalogada y una secuencia de pasos ordenados ("mechanics")
### Leyes de Lehman
#### Continuing Change (1974):
Los sistemas deben adaptarse continuamente o se vuelven progresivamente menos satisfactorios.
#### Continuing Growth (1991)
La funcionalidad de un sistema debe ser incrementada continuamente para mantener la satisfacción del cliente
#### Increasing Complexity (1974)
A medida que un sistema evoluciona su complejidad incrementa a menos que se trabaje para evitarlo.
#### Declining Quality (1996)
La calidad de un sistema va a ir declinando a menos que se haga un manteniemienot riguroso

### Costo del mantenimiento
Correctivo, evolutivo, adaptativo, perfectivo, preventivo
Entender el código existente lleva el 50% del tiempo del mantenimiento

- Lidiando con el código spaghetti
- Lidiando con el código de IA
### Big Balls of Mud
Brain Foote & Joe Yoder: 2000: http://www.laputan.org/mud/

### Diseñar es difícil
- Los elementos distintivos de la arquitectura de un sistema no surgen hasta después de tener código que funciona
- No se trata sólo de agregar, sino de adaptar, transformar, mejorar
### La iteración es fundamental
"Reusable Software is the result of many design iterations. Some of this iterations..." (Creador del Refactoring)

### Refactoring como proceso
Es el proceso a través del cual se cambia un sistema de software

### Precondiciones y mecanismo
- Si el comportamiento cambia (no compila, no pasa los tests), entonces el cambio no fue un refactoring
- Debemos tener cuidado de no introducir un bug
- Los refactorings tienen:
    - Precondiciones
      Que chequean que se pueda aplicar
    - Mecanismo de aplicación
      Pasos que se *cuidan* la preservación del comportamiento
      *(cuidan porque no asegura, al no estar teniendo en cuenta todos los casos posibles)*


### Pull Up Field
### Pull Up Method


### Características del refactoring
Implica
- Eliminar duplicaciones
- Simplificar lógicas complejas

### ¿Cómo ayuda el refactoring?

## Resumen
### Pasos de un Refactoring
- Verificar precondiciones
- Ejecutar transformaciones
- Compilar y Testear
### Refactoring presentados
- Encapsulate Field (p. 206)
- Pull Up Field (p. 320)
- Pull Up Method (p. 322)




## Tipo de preguntas Parcial

Vamos a encontrar enunciados con diagramas de clases:
Este diagrama es un framework de caja blanca o caja negra?
Este bloque de código es una instanciación o extensión del framework?
Etc.

Va a haber 5 o 4 preguntas de V o F
Una va a ser
**Un patrón de diseño es una solución a un problema recurrente**
- Consecuencia positiva relacionada con un tipo de cambio

Ejemplo de preguntas Patrones:
- Marque el rol que cumple esta clase
- Esta clase cumple el rol de cliente?
- Qué clase cumple el rol de State?

Ejemplo de preguntas Refactoring:
- "Aplique Extract Method en las líneas 3-7"
- Existe Feature Envy en la línea 6?

Ejemplo de preguntas Framework:
- En la implementación del server, dónde hay hook methods, qué partes es frozen
- Qué parte es frozen, hot
- Implementación o extensión
- Dónde está la inversión de control
- Cómo usar Java Logging



## Repaso Patrones

Un patrón es un diseño probado que dado un par problema-solución se pueden aplicar para poder resolverlo de una forma eficiente, sustentable y escalable.
### Patrones

#### Composite
Tengo objetos compuestos y simples y quiero tratarlos por igual, hay una estructura recursiva en forma de árbol.
#### Adapter
Traduce una interfaz ya implementada no mutable a una interfaz que el cliente sepa utilizar  **(Wrapper).**
#### Decorator
Agrego comportamiento dinámicamente, puedo poner anidación **(Wrapper)**.
#### Proxy
Intermediario para carga diferida o seguridad u objetos distribuidos **(Wrapper)**.
#### Builder
Creación de objetos con una misma estructura pero cambios muy sutiles en sus partes **(Creacionales).**
#### Factory Method
Creación de objetos con distintas estructuras **(Creacionales).**
#### State
El comportamiento depende del estado, hay transiciones entre esos estados que se manejan entre sí, los estados se conocen unos a otros. El contexto no conoce a los estados. Si hay transiciones explícitas es State **(Misma estructura que Strategy).**
#### Strategy
Distintos algoritmos misma tarea. El contexto permite cambiar la estrategia, esta última es visible desde afuera. Si no hay transiciones, es Strategy **(Misma estructura que State).**
#### Template Method
Receta de pasos en la superclase que cada subclase debe seguir y/o modificar


### Relación entre patrones y refactoring

"Patterns are where you want to be; refactorings are ways to get there from somewhere else" (Fowler, 2000).

#### Form Template Method
#### Extract Adapter
#### Replace Implicit Tree with Composite
#### Replace Conditional Logic with Strategy
#### Replace State-Altering Conditionals with State
#### Move Embellishment to Decorator


### Technical Doubt (TD)
SonarQube sistema más utilizado actualmente para calcular la deuda técnica


### Para investigar
#### Type Object
Es un patrón utilizado para representar un comportamiento común a varias instancias de un objeto, ejemplo de libros prestados en la biblioteca.

