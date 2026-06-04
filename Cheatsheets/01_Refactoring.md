# Machete — Refactoring (OO2, cátedra Garrido)

> **Definición clave:** Refactoring = cambio en la estructura **interna** del código
> que **preserva el comportamiento observable externo**, para mejorar la calidad
> interna (legibilidad, mantenibilidad, extensibilidad).
> No arregla bugs ni agrega features: eso son cambios **aparte**.

---

## 0. El algoritmo iterativo de la cátedra (cómo documentar)

Por cada smell, **una iteración**:

1. **Nombrar el mal olor** y en qué líneas está.
2. **Nombrar el refactoring** que lo corrige + los pasos **aplicados a tu caso**.
3. **Aplicarlo** y mostrar el resultado.
4. Si aparece un **nuevo** smell → volver a 1.

**Confirmado por la cátedra (parcial en papel):**
- Pasos **aplicados a tu caso**, NO la receta genérica con todas las ramas.
- NO hace falta demostrar la preservación de comportamiento.
- Refactorings intermedios (ej. un Extract Method dentro de un Form Template
  Method) NO hace falta explayarlos salvo que el enunciado lo pida.
- Varios Extract Method sencillos e independientes → se pueden **agrupar** en una
  iteración (para no perder tiempo).
- Si el enunciado trae un **bug**: dejarlo tal cual, NO es etapa de refactoring.

---

## 1. Catálogo Smell → Refactoring (los que más caen)

| Mal olor | Qué es (en una línea) | Refactoring(s) |
|---|---|---|
| **Long Method** | Método que hace demasiado / muy largo | **Extract Method**, Decompose Conditional, Replace Temp with Query, Replace Method with Method Object |
| **Large Class / God Class** | **Clase** con demasiadas responsabilidades | **Extract Class**, Extract Subclass, Extract Interface |
| **Duplicated Code** | Mismo código repetido | **Extract Method**, Pull Up Method, **Form Template Method**, Substitute Algorithm |
| **Feature Envy** | **Método** más interesado en datos de OTRA clase que en los suyos | **Move Method**, Move Field, Extract Method |
| **Data Class** | Clase con solo datos (getters/setters), sin comportamiento | **Move Method** (mover hacia ella la lógica que la usa), Encapsulate Field/Collection |
| **Switch Statements** | `if/else` o `switch` sobre tipo, repetido al extender | **Replace Conditional with Polymorphism**, Replace Type Code with State/Strategy |
| **Long Parameter List** | Demasiados parámetros | Introduce Parameter Object, Preserve Whole Object, Replace Parameter with Method |
| **Data Clumps** | Mismos grupos de datos juntos en muchos lados | **Extract Class**, Introduce Parameter Object, Preserve Whole Object |
| **Primitive Obsession** | Usar primitivos para conceptos del dominio | Replace Data Value with Object, Replace Type Code with Class/Subclasses/State-Strategy |
| **Divergent Change** | Una clase cambia por muchos motivos distintos | **Extract Class** |
| **Shotgun Surgery** | Un cambio obliga a tocar muchas clases | **Move Method/Field**, Inline Class |
| **Comments** | Comentario que explica QUÉ hace un bloque (síntoma) | **Extract Method** (el nombre reemplaza al comentario), Rename Method |
| **Refused Bequest** | Subclase que no usa lo que hereda | Push Down Method/Field, Replace Inheritance with Delegation |
| **Lazy Class** | Clase que no hace lo suficiente | Inline Class, Collapse Hierarchy |
| **Speculative Generality** | Generalidad "por las dudas" sin uso real | Collapse Hierarchy, Inline Class, Remove Parameter |
| **Message Chains** | `a.getB().getC().getD()` | Hide Delegate, Extract Method, Move Method |
| **Middle Man** | Clase que solo delega | Remove Middle Man |
| **Imperative Loops** | Bucle manual donde va un pipeline | **Replace Loop with Pipeline** (.filter/.map/.sorted/.limit...) |

---

## 2. ⚠️ Distinciones que SE TOMAN (no las confundas)

### Feature Envy vs God/Large Class
| | **Feature Envy** | **God / Large Class** |
|---|---|---|
| Alcance | un **método** mal ubicado | una **clase** entera sobrecargada |
| Síntoma | usa más datos de OTRA clase que de la propia | clase enorme, muchas responsabilidades |
| Refactoring | **Move Method** | **Extract Class** |

> Si ves un método de 5 líneas que hurga en otra clase → **Feature Envy → Move Method**.
> No es God Class: God Class es de tamaño/responsabilidad de **clase**.

### Extract Method vs Move Method
- **Extract Method:** saco un fragmento a un método nuevo **en la MISMA clase**.
- **Move Method:** muevo un método **a OTRA clase** (donde viven los datos que usa).

### Strategy vs State como solución a Switch Statements
- Switch sobre "tipo de algoritmo" elegido desde afuera → **Replace Conditional with Polymorphism** / Strategy.
- Switch sobre "estado" que transiciona solo → **State**.

---

## 3. Mecanismos (los 4 que más se piden)

### Extract Method
1. Crear método con nombre que describe **el QUÉ** (no el cómo).
2. Analizar variables:
    - leídas y definidas afuera → **parámetros**
    - locales al fragmento → se van con el método
    - **modificadas y usadas después** → si es **una** se devuelve con `return`;
      si son **varias** NO se puede directo (antes: Split Temp, Replace Temp with
      Query, o devolver un objeto).
3. Mover el fragmento al cuerpo del método.
4. Reemplazar el fragmento original por la **llamada** (guardando el retorno si hace falta).
5. (Real) Compilar y testear.

### Move Method
1. El método usa muchos servicios de **otra** clase.
2. Moverlo a esa clase.
3. En la clase original: convertirlo en **delegación** o eliminarlo.

### Replace Conditional with Polymorphism
1. Crear la jerarquía de clases necesaria.
2. Si el condicional está en un método largo → Extract Method primero.
3. Por cada subclase: sobreescribir el método, copiar el branch correspondiente, ajustar, compilar/testear.
4. Borrar ese branch de la superclase. Compilar/testear.
5. Hacer abstracto el método en la superclase.

### Form Template Method (Refactoring to Patterns)
1. Encontrar el método similar en subclases; separar partes **idénticas** vs **únicas**.
2. **Pull Up Method** para las idénticas.
3. **Rename Method** sobre las únicas hasta que el método similar quede idéntico en las subclases.
4. Pull Up del método similar (el esqueleto / template method).
5. Declarar **abstractos** en la superclase los métodos únicos (que las subclases definen).

---

### Más mecanismos (set enfocado)

**Extract Class** (Large/God Class, Data Clumps, Divergent Change)
1. Decidir cómo partir responsabilidades.
2. Crear la clase nueva.
3. Move Field + Move Method de lo que corresponde a la nueva clase.
4. La clase vieja queda con una referencia a la nueva; ajustar accesos.

**Pull Up Method / Pull Up Field** (Duplicated Code en subclases)
1. Verificar que el método/campo sea idéntico en las subclases (si no, antes
   ajustar con Rename / Extract para que queden iguales).
2. Mover el método/campo a la superclase.
3. Borrarlo de las subclases. Compilar y testear.

**Replace Temp with Query** (Long Method; temp que guarda un cálculo)
1. Extraer el cálculo de la variable temporal a un método (query).
2. Reemplazar los usos de la temp por la llamada al query.
3. Borrar la temp. (Habilita Extract Method porque desaparece una variable local.)

**Decompose Conditional** (Long Method; condicional complejo)
1. Extract Method de la condición → método con nombre que explica el *qué*.
2. Extract Method de cada rama (then / else).
3. Queda `if (esVerano(fecha)) cargo = tarifaVerano(...) else ...`.

**Replace Type Code with State/Strategy** (Switch sobre un "código de tipo")
- Reemplazar el atributo "tipo" (int/String) por una jerarquía State/Strategy,
  y mover el comportamiento que dependía del tipo a las subclases.
- Es el **puente** entre refactoring y patrones.

---

## 5. Refactoring to Patterns (ejercicios 10-12)

> Idea clave: un RtP **no es un paso atómico** — se construye **aplicando otros
> refactorings** (Move Method, Extract Parameter, Replace Conditional with
> Polymorphism, etc.). En el parcial NO hace falta explayar esos sub-refactorings
> salvo que lo pidan.

| RtP | Smell que ataca | Llega a |
|---|---|---|
| Form Template Method | Duplicated Code en subclases | Template Method |
| Extract Adapter | Alternative Classes w/ Diff Interfaces | Adapter |
| Replace Implicit Tree with Composite | estructura de árbol "a mano" | Composite |
| Replace Conditional Logic with Strategy | condicional que elige variante | Strategy |
| Replace State-Altering Conditionals with State | condicionales que cambian estado | State |
| Move Embellishment to Decorator | subclases que "adornan" comportamiento | Decorator |

### Replace Conditional Logic with Strategy — mecánica (cátedra)
1. Crear una clase **Strategy**.
2. **Move Method**: mover el cálculo con los condicionales del contexto al Strategy.
    - v.i. en el contexto que referencia al strategy + setter (normalmente el constructor).
    - dejar un método en el contexto que **delegue**.
    - elegir qué parámetros pasarle al strategy (¿el contexto entero? ¿solo algunas variables?).
    - compilar y testear.
3. **Extract Parameter** donde el contexto inicializa un strategy concreto (para que los clientes lo seteen).
4. **Replace Conditional with Polymorphism** en el método del Strategy.
5. Compilar y testear con distintas combinaciones.

### Move Embellishment to Decorator — mecánica (cátedra)
1. Identificar la superclase/interfaz del objeto a decorar (= **Component**). Si no existe, crearla.
2. **Replace Conditional with Polymorphism** (crea el decorator como subclase del decorado). ¿Alcanza? Si no, seguir.
3. **Replace Inheritance with Delegation** (el decorator delega en el decorado como clase "hermana").
4. **Extract Parameter** en el decorator para asignarle el decorado.

---

## 6. Conceptos para promoción (preguntas a desarrollo)

- **¿Para qué refactorizar si el comportamiento es el mismo?** Es una **inversión**:
  mejora la calidad interna para poder **agregar features o corregir bugs** que el
  diseño actual hace difíciles/riesgosos. Se preserva el comportamiento **observable
  externo**; la estructura interna cambia deliberadamente.


- **¿Por qué "compila y pasa los tests" no alcanza?** Eso verifica el
  **comportamiento**; el refactoring es sobre la **calidad interna** (diseño), que se
  diagnostica con los **smells**. Un código correcto puede tener pésimo diseño.


- **Precondiciones vs mecanismo:** las **precondiciones** son lo que debe cumplirse
  para aplicar el refactoring de forma **segura** (ej. que el fragmento no tenga
  return/break que salten afuera). El **mecanismo** son los pasos concretos.


- **¿Comentario = siempre malo?** No. Es smell cuando **explica qué hace** un bloque
  (síntoma de Extract Method). Es legítimo cuando aclara un **porqué** no obvio, o el
  Javadoc del método.