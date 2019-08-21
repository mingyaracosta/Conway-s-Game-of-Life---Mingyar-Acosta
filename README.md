# El juego de la vida de Conway - Wilton Mingyar Acosta Choclo

El presente repositorio es la solución al ejercicio práctico del Juego de la vida,
la misma está escrita en JAVA y fue realizada aplicando [TDD](https://es.wikipedia.org/wiki/Desarrollo_guiado_por_pruebas)
y haciendo uso de [JUnit](https://junit.org/junit4/) para la implementacion de las
pruebas unitarias.

### El juego

Se trata de un juego de cero jugadores, lo que quiere decir que su evolución está 
determinada por el estado inicial y no necesita ninguna entrada de datos posterior.
El "tablero de juego" es una malla plana formada por cuadrados (las "células") que
se extiende por el infinito en todas las direcciones. Por tanto, cada célula tiene
8 células "vecinas", que son las que están próximas a ella, incluidas las diagonales.
Las células tienen dos estados: están "vivas" o "muertas" (o "encendidas" y 
"apagadas"). El estado de las células evoluciona a lo largo de unidades de tiempo
discretas (se podría decir que por turnos). El estado de todas las células se tiene
en cuenta para calcular el estado de las mismas al turno siguiente. Todas las 
células se actualizan simultáneamente en cada turno, siguiendo estas reglas:

- Una célula muerta con exactamente 3 células vecinas vivas "nace" (es decir, al 
turno siguiente estará viva).
- Una célula viva con 2 o 3 células vecinas vivas sigue viva, en otro caso muere 
(por "soledad" o "superpoblación").Una célula muerta con exactamente 3 células
vecinas vivas "nace" (es decir, al turno siguiente estará viva).

Para mayor informacióm se puede ver la [descripción en wikipedia](https://es.wikipedia.org/wiki/Juego_de_la_vida)

### La solución

En la solución se distinguen los siguientes elementos:

- Las celulas: Que son la unidad base en el juego, unicamente tienen un estado que
puede ser VIVA o MUERTA
- El universo: Es el conjunto de celulas, tanto vivas o muertas
- Las reglas: Que son quienes determinan el estado de una celula en la siguiente 
generación a partir del estado actual de la celula y los vecinos de la misma
- El motor de juego: Es quien, a partir de un universo y un conjunto de reglas,
calcula el estado del universo en la siguiente generacion.

### Cómo ejecutar el proyecto

1. Clonar el proyecto desde el repositorio
2. Abrir en el IDE de su preferencia como un proyecto Maven (generalmente
indicando el archivo XML)
3. Actualizar su repositorio Maven local las dependencias para que contenga las
dependencias del proyecto.
4. Puede ejecutar las pruebas una a una (por métodos) o por grupos de pruebas
(por clase), las pruebas se encuentran en la carpeta [Test](src/test/java/com/mingyaracosta)
5. Si se desea ver pruebas en una aplicacion de consola, ejecutar el metodo main
en la clase [Main](src/main/java/com/mingyaracosta/Main.java) 
