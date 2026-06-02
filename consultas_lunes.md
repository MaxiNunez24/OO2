# Consultas - Clase teoría lunes

## Régimen de promoción
- Las preguntas extra se corrigen solo si apruebo los 3 temas. Si dejo un
  tema para 2da fecha: ¿los temas aprobados en 1ra se arrastran y cuento
  los 3 en 2da, o necesito los 3 aprobados en la MISMA fecha en que
  respondo las preguntas extra?

  Hay que responder las 3 preguntas extra en ambas fechas, ya que las corrigen cuando se aprueben los 3 temas. Por ende si se deja algún tema para la segunda fecha se debe de volver a responder las preguntas. O en el caso de que se apruebe en primera fecha pero no se completen las preguntas, se puede ir a la segunda fecha para sólo responder las preguntas extra de promoción. (Las 3 preguntas son a desarrollo)

  El examen va a durar 3:30hs (media hora para las preguntas extra) y va a comenzar a las 13:00hs

## Refactoring - nivel de detalle en el parcial (papel)
- En el paso 2 del algoritmo ("indicar el refactoring y los pasos"),
  ¿esperan los pasos genéricos del mecanismo (con todas las ramas posibles)
  o los pasos aplicados a mi caso concreto?
  
  Se esperan los pasos aplicados a mi caso concreto, no hay necesidad de mencionar cosas que no voy a implementar en ese caso.

- ¿Cuánto hay que justificar el manejo de variables (parámetros / retorno /
  variable de salida)?

  

- Sin compilador ni tests: ¿cómo esperan que demuestre la preservación de
  comportamiento en la hoja?

  No hace falta que se demuestre la preservación de comportamiento.

## Refactoring - bug en medio de un ejercicio
- Si me cruzo un bug preexistente mientras refactorizo (ej. en el Ej 6.3 el
  `while` no incrementa `index`, así que ignora `cantidad`), ¿cómo lo
  documento? ¿Refactorizo preservando el comportamiento buggeado y dejo el
  arreglo como cambio aparte?
  
  Es probable que no nos den un código con bugs, pero en caso de que lo hagan se debe de dejar tal cual está ya que no corresponde a la etapa de refactoring.
  

## Refactoring - granularidad de las iteraciones
- ¿Una iteración por cada Extract Method, o si detecto varios Extract Method
  independientes puedo aplicarlos juntos en una iteración?

  Si se detectan varios Extract Methods sencillos e independientes se pueden aplicar juntos en una iteración, la idea es no perder tanto tiempo en el parcial.

# Preguntas para repasar en el micro (lunes)

## Para pensar yo (conceptuales / estilo promoción) - NO resolver hoy
- Extract Method: ¿qué pasa si el bloque a extraer produce MÁS de una
  variable de salida? ¿Por qué no se puede hacer directo y qué hago antes?
  
  No se puede hacer un Extract Method si el bloque a extraer produce más de una variable de salida.
  

- ¿Por qué "que compile y pase los tests" NO alcanza para decir que algo
  es un buen refactoring? ¿Qué agrega mirar los smells?

  

- Comments como smell: ¿siempre es malo un comentario? ¿Cuándo un
  comentario es síntoma y cuándo es legítimo (ej. el Javadoc del método)?
  No siempre, depende mucho si el comentario es utilizado para describir el código o simplemente aclara algo puntual, en determinados casos pueden dejarse, ej: javadoc.

- Replace Loop with Pipeline: ¿hay casos donde un loop imperativo sea
  preferible a un stream? (pista: efectos colaterales, performance, salir
  temprano de un bucle)
  
    

- Si refactorizar preserva el comportamiento... ¿para qué sirve, si el
  programa hace exactamente lo mismo antes y después? (la respuesta es la
  clave de todo el tema)

- Relación patrones ↔ refactorings: "los patrones son a dónde querés
  llegar, los refactorings el camino" — ¿qué significa esto en concreto?

- Selection sort a mano vs. sorted: además de ser más corto, ¿qué otro
  problema de diseño tiene reimplementar algo que la librería ya da?


## Preguntas hechas en la clase

- Cómo nos ayuda OO2:
  - Desarrollar criterio para distinguir calidad en el diseño de software
  - Adquirir buenas prácticas en el proceso de mejora de la calidad del software
  - Desarrollar la capacidad de cambiar el software de manera rápida y sustentable
    - Consciente, evitando el desperdicio de recursos, reconociendo oportunidades, responsable, con calidad, buscando la mejora continua
  
- Qué aprendimos en OO2
  - Reconocer las fuerzas que llevan al deterioro de la arquitectura (SMELLS) y aprender a reconocer oportunidades para mejorarla (REFACTORINGS)
  - Con el objetivo de lograr código legible y extensible (MEJORAR CALIDAD INTERNA)
  - En cada iteración (RESOLVIENDO LA DEUDA TÉCNICA)
  - REFACTORING.
  - Una solución a la deuda técnica es el refactoring

- Qué cosa es importante recordar de patrones?
  - Propósito
  - Estructura
    - Clases que componen el patrón (roles)
    - Cómo se relacionan (jerarquías, clases abstractas / interfaces, métodos abstractos - protocolo de interfaces, conocimiento / composición)
  - Variantes de implementación
  - Consecuencias positivas y negativas
  - Relación con otros patrones (RECORDEMOS LAS RELACIONES QUE FUIMOS VIENDO ENTRE LOS PATRONES)

- Template method repaso con refactoring
  - Se necesita una super-clase
  - Ej: 
    - BankAccount con 
      - deposit(m)
        - this.incSaldo(m)
        - this.aplicarDif(m)
        - this.crearTransaccion(n,,)
      - incSaldo(m)
      - aplicarDif(m)
      - crearTransaccion(nombre,monto,balance)
    
  - Pasos Form Template Method
    1. Encontrar el método que es similar en todas las subclases y extraer sus partes en: métodos idénticos (misma signatura y cuerpo en las subclases) o métodos únicos (distinta signatura y cuerpo).
    2. Aplicar "Pull Up Method" para los métodos idénticos.
    3. Aplicar "Rename Method" sobre los métodos únicos hasta que el método similar quede con cuerpo idéntico en las subclases.
    4. Compilar y testear después de cada "rename".
    5. Aplicar "Rename Method" sobre los métodos similares de las subclases (esqueleto).
    6. Aplicar "Pull Up Method" sobre los métodos similares.
    7. Definir métodos abstractos en la superclase por cada método único de las subclases.
    8. Compilar y Testear.

  - Para el caso del ejemplo no contamos con métodos idénticos, por lo que antes habría que hacer un Extract Method como paso intermedio (según la profe de teoría no hace falta explayar los pasos o indicar cuáles otros refactorings se realizan como pasos intermedios de otros a menos que el enunciado lo indique).
  
  - Lo mismo para el paso de Rename Method que no tenemos, por ende no hay que definir los pasos genéricos que no utilicemos en nuestro caso. 
  
- Fotos de un enunciado antiguo de examen final.
  - Un diagrama de clases y un código en Smalltalk (porque es antiguo a que cambiara la materia)
  - Decir qué patrón quiso aplicar el desarrollador
  - Luego se quiere agregar una nueva forma de pago, cómo se implementaría este nuevo requerimiento?
  - Al añadir una forma de pago nueva que utiliza una interfaz diferente el desarrollador vuelve a implementar un if para discernir entre clases dándole null a la nueva interfaz, cómo lo hubieramos resuelto nosotros? (adapter)


- Factory Method vs Builder
  - Factory
    - En general cuando tengo factory tengo jerarquías paralelas (cosa que no se da en builder)
      - 
  
  - Builder
    - Separa la construcción de un objeto complejo de su representación (implementación) de tal manera que el mismo proceso puede construir diferentes representaciones (implementaciones)

## Preguntas Explicación práctica 2/6

- No nos van a pedir armar un framework, de seguro nos den uno y tengamos que modificarlo o analizarlo

- Ej: 27 de patrones:
  - Los States se conocen entre sí y el ejemplo de la opción A no se implementa de forma correcta
  - Además el Strategy tampoco se implementa adecuadamente, ya que conceptualmente el Strategy implementa algoritmos totalmente independientes y por separados sin que se conozcan entre sí. Mientras que un State debería de ser como una inner class, el obj usuario debería de abstraerse de que existe por debajo un State.
  - Ejercicio calculadora va con State 