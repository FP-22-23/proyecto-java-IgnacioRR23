# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 22/23)
Autor: Ignacio David Rodríguez Rabal uvus: ignrodrab@alum.us.es (JQG0381)

El dataset del proyecto trata sobre datos de puestos estadounidenses de limonadas y naranjadas que se recopilan en los atributos:

## Atributos:
* **fecha**: de tipo LocalDateTime, representa el día y la hora en la que se recogen los siguientes datos sobre la jornada diaria.
* **ciudad**: de tipo String, representa el nombre de la ciudad en la que se localiza el puesto de ventas.
* **lugar**: de tipo TipoLugar, representa la zona en la que se sitúa el puesto (parque o playa).
* **temperaturaF**: de tipo Double, representa la temperatura del día en grados Fahrenheit.
* **temperaturaC**: de tipo Double, representa la temperatura del día en grados Celsius.
* **folletosRepartidos**: de tipo Integer, representa el número total de folletos repartidos en la jornada.
* **precio**: de tipo Double, representa el precio de la limonada/naranjada en ese puesto.
* **ventasLN**: de tipo List<Ventas>, representa una lista que proporciona el número de limonadas y naranjadas (por separado) vendidas hasta el momento en la jornada.

De manera consecutiva tenemos una propiedad derivada de tipo Boolean que afirma o niega el logro de haber repartido los suficientes folletos requeridos (100 unidades) en la jornada diaria. Para ello trabaja sobre el método *getfolletosSuficientes()* y el atributo *folletosRepartidos*. 

## Estructura de las carpetas del proyecto
* **common**:
  * **Ventas.java**: Es un record que recibe los valores enteros "Limonadas vendidas" y "Naranjadas vendidas" y crea una representación como cadena que devuelve esos dos valores.
* **src**:
  * **Limonada.java**: Es la base principal donde se guardan los atributos, los constructores, la representación en cadena, los métodos Getters y Setters, el criterio de igualdad y el criterio de orden natural entre otros.
  * **TipoLugar.java**: Se trata de un enum al que se le atribuye "PARK" y "BEACH" que son propiedades del mismo TipoLugar en Limonada.java.
  * **TestLimonada.java**: Se usa para experimentar con los objetos de la clase limonada, el enum de TipoLugar y el record de Ventas y comprobar su correcto funcionamiento.
* **utiles**:
  * **Checkers.java**: Se trata de una clase que implementa checkers que facilitan la creación de restricciones en las demás clases a través del método check.
  
## Métodos implementados
  * **Primer constructor**: recibe la fecha, ciudad, temperatura en grados Fahrenheit, los folletos repartidos y el precio y calcula la temperatura en grados Celsius a través de la temperatura dada.
  * **Segundo constructor**: recibe la ciudad, temperatura en grados Fahrenheit y los folletos repartidos y, al igual que el anterio, calcula la temperatura en grados Celsius a través de la temperatura dada.
  * **HashCode**: enumera los objetos según la ciudad, lugar, precio, temperatura en Celsius y temperatura en Fahrenheit.
  * **Equals**: booleano que calcula el criterio de igualdad definido por la ciudad, el lugar, el precio y la temperatura, devuelve "True" si ambos objetos son iguales, de lo contrario, devolverá "False".
  * **CompareTo**: devuleve un entero según el criterio de orden natural definido por el lugar en primera opción y el precio en caso de que el lugar sea el mismo. Se devuelve un "0" si ambos objetos comparados son iguales según este criterio, un número negativo si el primer objeto es menor que el segundo y un número positivo si el primer objeto es mayor que el segundo.
  * **Métodos Getters y Setters**: se han implementado a algunos atributos.
  * **Incorpora**: añade las ventas registradas por el record "ventas" al atributo "ventasLN".
  * **toString**: se trata de la representación como cadena del objeto Limonada", esta devuelve los atributos fecha, ciudad, temperaturaF, temperaturaC y precio y los métodos *getLugar()*, *getVentasLN()* y *getfolletosSuficientes()* acompañados de un texto String.
