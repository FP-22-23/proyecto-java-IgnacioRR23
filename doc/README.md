## Clase ContenedorLimonada

La clase `ContenedorLimonada` implementa la interfaz `Limonadas` y proporciona funcionalidades relacionadas con la gestión de puestos de limonada.

### Atributos

- `puesto`: Lista estática de objetos `Limonada` que representa los puestos de limonada y naranjada.

### Constructores

- `ContenedorLimonada()`: Constructor por defecto que inicializa la lista `puesto` como una lista vacía.
- `ContenedorLimonada(Collection<Limonada> puesto)`: Constructor que recibe una colección de objetos `Limonada` y la asigna a la lista `puesto`.
- `ContenedorLimonada(Stream<Limonada> puesto)`: Constructor que recibe un flujo de objetos `Limonada` y los recopila en la lista `puesto`.

### Métodos

- `añadirPuesto(Limonada l)`: Permite añadir un objeto `Limonada` a la lista `puesto`.
    - Parámetros:
        - `l`: Objeto `Limonada` a añadir al puesto.
    - Valor de retorno: Ninguno.
    - Objetivo: Añadir un puesto de limonada a la lista.

- `eliminarCap(Limonada l)`: Permite eliminar un objeto `Limonada` de la lista `puesto`.
    - Parámetros:
        - `l`: Objeto `Limonada` a eliminar del puesto.
    - Valor de retorno: Ninguno.
    - Objetivo: Eliminar un puesto de limonada de la lista.

- `calcularNumPuestos()`: Permite calcular el número de puestos de limonada en la lista `puesto`.
    - Parámetros: Ninguno.
    - Valor de retorno: Entero que representa el número de puestos de limonada.
    - Objetivo: Obtener el número de puestos de limonada.

- `existePuesto(Limonada l)`: Verifica si un objeto `Limonada` existe en la lista `puesto`.
    - Parámetros:
        - `l`: Objeto `Limonada` a buscar en el puesto.
    - Valor de retorno: Booleano que indica si el puesto existe (`true`) o no (`false`).
    - Objetivo: Verificar la existencia de un puesto de limonada en la lista.

- `existePuesto2(Limonada l)`: Verifica si un objeto `Limonada` existe en la lista `puesto` utilizando el método `anyMatch()` de Java 8 Streams.
    - Parámetros:
        - `l`: Objeto `Limonada` a buscar en el puesto.
    - Valor de retorno: Booleano que indica si el puesto existe (`true`) o no (`false`).
    - Objetivo: Verificar la existencia de un puesto de limonada en la lista utilizando Java 8 Streams.

- `contarCiudades()`: Cuenta la cantidad de puestos de limonada por ciudad y devuelve un mapa que asocia cada ciudad con el número de puestos.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<String, Integer>` que asocia cada ciudad con el número

 de puestos de limonada.
    - Objetivo: Contar la cantidad de puestos de limonada por ciudad.

- `contarCiudades2()`: Cuenta la cantidad de puestos de limonada por ciudad utilizando Java 8 Streams y devuelve un mapa que asocia cada ciudad con el número de puestos.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<String, Integer>` que asocia cada ciudad con el número de puestos de limonada.
    - Objetivo: Contar la cantidad de puestos de limonada por ciudad utilizando Java 8 Streams.

- `getCiudadPorTemperatura()`: Obtiene un mapa que asocia cada temperatura con la ciudad correspondiente.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<Double, String>` que asocia cada temperatura con la ciudad correspondiente.
    - Objetivo: Obtener un mapa que asocia cada temperatura con la ciudad correspondiente.

- `getCiudadPorTemperatura2()`: Obtiene un mapa que asocia cada temperatura con la ciudad correspondiente utilizando Java 8 Streams.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<Double, String>` que asocia cada temperatura con la ciudad correspondiente.
    - Objetivo: Obtener un mapa que asocia cada temperatura con la ciudad correspondiente utilizando Java 8 Streams.

- `getPuestoSegunLugar()`: Agrupa los puestos de limonada según el tipo de lugar y devuelve un mapa que asocia cada tipo de lugar con la lista de puestos correspondiente.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<TipoLugar, List<Limonada>>` que asocia cada tipo de lugar con la lista de puestos de limonada correspondiente.
    - Objetivo: Agrupar los puestos de limonada según el tipo de lugar.

- `getPuestoSegunLugar2()`: Agrupa los puestos de limonada según el tipo de lugar y devuelve un mapa que asocia cada tipo de lugar con la lista de puestos correspondiente utilizando Java 8 Streams.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<TipoLugar, List<Limonada>>` que asocia cada tipo de lugar con la lista de puestos de limonada correspondiente.
    - Objetivo: Agrupar los puestos de limonada según el tipo de lugar utilizando Java 8 Streams.

- `obtenerCiudadMayorTemperatura()`: Obtiene la limonada con la mayor temperatura, entre las que tienen más de 90 limonadas vendidas.
    - Parámetros: Ninguno.
    - Valor de retorno: Objeto `Limonada` que representa la limonada con la mayor temperatura.
    - Objetivo: Obtener la limonada con la mayor temperatura.

- `seleccionarLimondas()`: Filtra y selecciona las limonadas que tienen más de 90 limonadas vendidas y una temperatura superior a 75.0, las ordena en orden descendente según el número de limonadas vendidas y las devuelve en una lista.
    - Parámetros: Ninguno.
    - Valor de retorno: Lista de objetos `Limonada` que representan las limonadas seleccionadas.
    - Objetivo: Se

leccionar las limonadas que cumplen ciertas condiciones y ordenarlas según el número de limonadas vendidas.

- `obtenerPreciosLimonadas()`: Obtiene una lista de los precios de las limonadas en la lista `puesto`, calcula el promedio de los precios y devuelve una nueva lista con los precios incrementados por el promedio.
    - Parámetros: Ninguno.
    - Valor de retorno: Lista de tipo `List<Double>` que representa los precios de las limonadas incrementados por el promedio.
    - Objetivo: Obtener una lista de precios de limonadas incrementados por el promedio de los precios.

- `obtenerMaximosMinimosLimonadasVendidas()`: Obtiene la limonada con el máximo número de limonadas vendidas y la limonada con el mínimo número de limonadas vendidas, y las devuelve en un mapa.
    - Parámetros: Ninguno.
    - Valor de retorno: Mapa de tipo `Map<String, Limonada>` que asocia las claves "maximo" y "minimo" con las limonadas de máximo y mínimo número de limonadas vendidas, respectivamente.
    - Objetivo: Obtener las limonadas con el máximo y mínimo número de limonadas vendidas.

- `obtenerNLimonadasMasVendidas(int n)`: Obtiene un mapa ordenado de las `n` limonadas más vendidas, donde la clave es el número de limonadas vendidas y el valor es la lista de limonadas correspondientes.
    - Parámetros:
        - `n`: Entero que representa el número de limonadas más vendidas a obtener.
    - Valor de retorno: Mapa ordenado de tipo `SortedMap<Integer, List<Limonada>>` que representa las `n` limonadas más vendidas.
    - Objetivo: Obtener las `n` limonadas más vendidas en un mapa ordenado según el número de limonadas vendidas.

- `obtenerFechaMayorTemperatura()`: Obtiene la fecha en la que se registró la mayor temperatura en las limonadas de la lista `puesto`.
    - Parámetros: Ninguno.
    - Valor de retorno: Objeto `LocalDate` que representa la fecha en la que se registró la mayor temperatura.
    - Objetivo: Obtener la fecha en la que se registró la mayor temperatura.

### Sobrescritura de métodos

- `toString()`: Sobrescribe el método `toString()` para proporcionar una representación en forma de cadena de la clase `ContenedorLimonada`.
    - Parámetros: Ninguno.
    - Valor de retorno: Cadena que representa la clase `ContenedorLimonada`.
    - Objetivo: Obtener una representación en forma de cadena de la clase `ContenedorLimonada`.

- `hashCode()`: Sobrescribe el método `hashCode()` para proporcionar un código hash basado en el atributo `puesto`.
    - Parámetros: Ninguno.
    - Valor de retorno: Entero que representa el código hash de la clase `ContenedorLimonada`.
    - Objetivo: Obtener un código hash para la clase `ContenedorLimonada` basado en el atributo `puesto`.

- `equals(Object obj)`: Sobrescribe el método `equals()` para comparar dos objetos de tipo `ContenedorLimonada` y determinar si son iguales.
    - Parámetros:
        - `

obj`: Objeto a comparar con la instancia actual.
    - Valor de retorno: Booleano que indica si los dos objetos son iguales (`true`) o no (`false`).
    - Objetivo: Comparar dos objetos de tipo `ContenedorLimonada` y determinar si son iguales.
