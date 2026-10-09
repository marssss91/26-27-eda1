# A día de hoy deberíamos saber

> *Entiéndase "deberíamos saber" como una combinación de "nos debería sonar", "no nos debería sorprender", "deberíamos conocer", "deberíamos saber manejar", en función del tema abordado. En cualquier caso, lo mínimo es "no nos debería sorprender" y deberíamos poder tener una mínima conversación o lectura sobre estos temas.*

- Un repaso de lo visto en PRG1 & PRG2 ([Intro](https://github.com/mmasias/eda1/blob/main/temario/001-intro/README.md))
  - Primitivas, matrices, clases y objetos: qué resuelve cada uno.
  - Por qué una matriz se queda corta cuando la colección crece, decrece o se modifica por el medio.

- Los límites de lo que ya sabíamos, sobre un escenario concreto ([Reto 001 - laFila](/evaluaciones/retos/reto001.md))
  - Salidas desde cualquier posición, incorporaciones detrás de alguien, tamaño máximo: qué cuesta cada una cuando la fila es una matriz.

- Agregar la capacidad de "situarse" espacialmente a un elemento y lo que eso implica
  - Un elemento que conoce a su siguiente: el nodo.
  - De "posición en una matriz" a "referencia al siguiente": qué se gana (insertar y eliminar sin desplazar elementos) y qué se pierde (acceso directo por índice).
  - La [lista enlazada](https://github.com/mmasias/eda1/blob/main/temario/002-00-listas/README.md) simple: solo conoce su cabeza; el último nodo apunta a `null`.
  - Recorrer una lista con un puntero auxiliar.

- [Nodo dummy](https://github.com/mmasias/eda1/blob/main/temario/999-otrosTemas/nodoDummy.md)
  - Por qué la cabeza es un caso especial al insertar o eliminar, y qué errores provoca tratarla por separado.
  - El nodo dummy como predecesor ficticio de la cabeza: un único camino de ejecución para todas las posiciones.
  - El patrón: instanciación, anclaje, recorrido, modificación y redirección (`cabeza = dummy.siguiente`).
  - Inserción en posición y eliminación por valor, con y sin dummy.
