# Consultas - Clase teoría lunes

## Régimen de promoción
- Las preguntas extra se corrigen solo si apruebo los 3 temas. Si dejo un
  tema para 2da fecha: ¿los temas aprobados en 1ra se arrastran y cuento
  los 3 en 2da, o necesito los 3 aprobados en la MISMA fecha en que
  respondo las preguntas extra?

## Refactoring - nivel de detalle en el parcial (papel)
- En el paso 2 del algoritmo ("indicar el refactoring y los pasos"),
  ¿esperan los pasos genéricos del mecanismo (con todas las ramas posibles)
  o los pasos aplicados a mi caso concreto?
- ¿Cuánto hay que justificar el manejo de variables (parámetros / retorno /
  variable de salida)?
- Sin compilador ni tests: ¿cómo esperan que demuestre la preservación de
  comportamiento en la hoja?

## Refactoring - bug en medio de un ejercicio
- Si me cruzo un bug preexistente mientras refactorizo (ej. en el Ej 6.3 el
  `while` no incrementa `index`, así que ignora `cantidad`), ¿cómo lo
  documento? ¿Refactorizo preservando el comportamiento buggeado y dejo el
  arreglo como cambio aparte?

## Refactoring - granularidad de las iteraciones
- ¿Una iteración por cada Extract Method, o si detecto varios Extract Method
  independientes puedo aplicarlos juntos en una iteración?


# Preguntas para repasar en el micro (lunes)

## Ya en mi lista para la cátedra (las importantes, no perderlas)
- Promoción: ¿los temas aprobados en 1ra fecha se arrastran a 2da, o
  necesito los 3 en la misma fecha en que respondo las preguntas extra?
- Parcial en papel: ¿pasos genéricos del mecanismo o aplicados a mi caso?
- ¿Cómo demostrar preservación de comportamiento sin compilador ni tests?
- Bug en medio de un refactoring: ¿cómo se documenta?
- Granularidad: ¿una iteración por refactoring, o puedo agrupar los
  independientes?

## Para pensar yo (conceptuales / estilo promoción) - NO resolver hoy
- Extract Method: ¿qué pasa si el bloque a extraer produce MÁS de una
  variable de salida? ¿Por qué no se puede hacer directo y qué hago antes?
- ¿Por qué "que compile y pase los tests" NO alcanza para decir que algo
  es un buen refactoring? ¿Qué agrega mirar los smells?
- Comments como smell: ¿siempre es malo un comentario? ¿Cuándo un
  comentario es síntoma y cuándo es legítimo (ej. el Javadoc del método)?
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