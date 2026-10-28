# Metodo_SimpsonCompuestoyTrapecioCompuesto
#EJECUCIÓN DE CADA UNO: 
---ITERACIONES (TRAPECIO COMPUESTO) --- 
n = 2 | Integral = 3.0 
n = 4 | Integral = 2.75 | Error absoluto: 0.25 
n = 8 | Integral = 2.6875 | Error absoluto: 0.0625 
n = 16 | Integral = 2.671875 | Error absoluto: 0.015625 
n = 32 | Integral = 2.66796875 | Error absoluto: 0.00390625 
n = 64 | Integral = 2.6669921875 | Error absoluto: 9.765625E-4 
n = 128 | Integral = 2.666748046875 | Error absoluto: 2.44140625E-4 
n = 256 | Integral = 2.66668701171875 | Error absoluto: 6.103515625E-5

Resultado final Trapecio obtenido: 2.66668701171875

---ITERACIONES (SIMPSON COMPUESTO) --- 
n = 2 | Integral = 2.6666666666666665 
n = 4 | Integral = 2.6666666666666665 | Error absoluto: 0.0

Resultado final Simpson obtenido: 2.6666666666666665

Como se puede obervar el método trapecio compuesto requiere de más iteraciones para poder llegar a la aproxionamción requerida que en este caso se usaron 7 con aproximadamente 128 subintervalos y dandonos un valor de: 2.6666646728515625 el cual el valor analítico exacto es 8/3= 2.6666667.
Por otro lado el método Simpson Compuesto útilizo 1 iteración, 4 subintervalos para poder alcanzar la convergencia de forma exacta casi sin ningún inconveniente esto gracias a que "la regla de Simpson 1/3" integra de manera "exacta" los polinomios de hasta grado 3 usando parábolas y todo esto dando como valor de la integral aproximada: 2.6666666666666665
Se concluye que el metodo Simpson es el más apto debido a que muestra cierta superioridad, una drástica velocidad y una precisión para resolver funciones polinimicas ya que solo requirio 4 subintervalos mientras que el otro uso 128 subintervalos para poder cumplir lo requerido.

#PREGUNTAS:
*1. ¿Por qué la Regla de Simpson 1/3 Compuesta exige geométricamente que el número total de subinintervalos (n) sea estrictamente par?*
R-. Esto se debe a la diferencia del método del trapecio el cual aproxima el área bajo la curva conectando puntos adyacentes mediante lineas rectas individuales mientras que la regla de Simpson 1/3 construye arcos de parábolas para poder ajustar la curva, ademas para poder definir de manera única una parábola ( Ax2 + Bx + C ), se necesitan exactamente 3 puntos no colineales (punto inicial, punto medio y punto final) lo que significa que cada bloque o aplicación elemental de la regla de Simpson abarca 2 subintervalos consecutivos de ancho h en otras palabras abarca desde xi-2 hasta xi pasando por el punto medio que en este caso seria xi-1.

*2. ¿A qué se debe el patrón alternado de coeficientes en Simpson (1,4,2,4, ... ,1) en comparación con el Trapecio Compuesto (1,2,2, ... , 1)?, considerando cómo se comparten los puntos entre las figuras geométricas (parábolas vs. trapecios)*
R-.Este patrón surge directamente de cómo se conectan y comparten los puntos extremos e intermedios (nodos) entre las figuras geométricas adyacentes al aplicar la regla de Simpson de forma sucesiva (compuesta):
-Cada trapecio individual comparte su vertice derecho con el vertice izquierdo del siguiente trapecio, al sumas las areas de todos los trapecios contiguos los puntos interiores se suman dos veces.
Fórmula: I=h/2[f(a)+2Σf(xk)+f(b)].
Simpson 1/3 dice que al unir muchas parábolas contiguas, los nodos interiores se comparten de dos formas alternadas segun la fórmula de Simpson para 3 puntos(se divide en 2 partes más):
Nodos impares: Estos actuán siempre como el punto central de la parábola en curso, multiplicandose por el coeficiente 4 exigido por la deducción matemática.
Nodos pares: Actuan como un enlace el cual termina en una parabola y comienza lo siguiente, por ende estos puntos se comparten y son extremos comunes para dos parábolas vécinas.

## ESTRUCTURA DEL PROYECTO.

- `TrapecioCompuesto.java`: Contiene la función matemática a integrar, el cálculo de pasos "h", el método base del trapecio y la iteración con tolerancia.
- `SimpsonCompuesto.java`: Contiene la implementación de la regla de Simpson 1/3 compuesta y su respectiva iteración con tolerancia.
- `MainTrap.java`: Clase principal (`main`) para ejecutar y comparar ambos métodos.
