/*
 * Clase que implementa el metodo de Integración Numerica por Trapecio compuesto
 * con un criterio de para basado en el error absoluto y duplicación de subintervalos.
 */
public class TrapecioCompuesto {
    /**
     * Define la función matematica f(x) que se desea integrar.
     * @param x valor de la variable independiente.
     * @return El valor evaluando de la funcion f(x).
     */
    public static double funcion(double x){
        return Math.pow(x, 2); //Ejemplo: f(x) = x2
    }
    /**
     * Calcula el tamaño del paso h
     * Se declara public static para que la clase SimpsonCompuesto pueda reutlizarlo directamente
     * @param a Limite inferior.
     * @param b Limite superior.
     * @param n Numero de subintervalos.
     * @return El ancho de cada rebanada h
     */
    public static double calcularH(double a, double b, int n){ return (b-a)/n; }

    /**
     * Método base que calcula la aproximación de la integral mediante la
     * regla del Trapecio Compuesta para un numero fijo de subintervalos (n).
     *
     * Fórmula: I = (h/2) * [f(a) * 2*sum(f(x_k)) * f(b) ]
     */
    private static double calcularTrapecio(double a, double b, int n ){
        //Reutilizamos el método calcularH que definimos arriba
        double h = calcularH(a, b,n);
        double suma = funcion(a) + funcion(b); //Suma inicial con los extremos

        //Ciclo para sumar los puntos interiores
        for(int k = 1; k < n; k++){
            double xk = a + k * h;
            suma += 2 * funcion(xk);
        }

        return (h/2) * suma;
    }

    /**
     * Método iteración que aplica el criterio de paro por error absoluto
     * Duplica el numero de subintervalos (n -> 2n) en cada iteración del ciclo while
     * Hasta que la diferencia entre dos aproximaciones susecivas con menor a la tolerancia1
     */
    public static double integrarConTolerancia(double a, double b, double tolerancia){
        int n = 2; //Numero incial de subintervlos
        double integrarAnterior = calcularTrapecio(a, b, n);
        double errorAbsoluto = 999.0; //Inicializamos con un valor grande para entar al subintervalo

        System.out.println("---ITERACIONES (TRAPECIO COMPUESTO) ---");
        System.out.println("n = " + n + " | Integral = " + integrarAnterior);

        //Ciclo while para ecaluar la convergencia iterativa
        while (errorAbsoluto > tolerancia){
            n *= 2; //Duplicamos los subintervalos (el paso h se reduce a la mitad)
            double integralNueva = calcularTrapecio(a, b, n);

            //Calculo de error absoluto entre la iteracion nueva y la anterior
            errorAbsoluto = Math.abs(integralNueva - integrarAnterior);

            System.out.println("n = " + n + " | Integral = " + integralNueva + " | Error absoluto: " + errorAbsoluto);

            //Actualizamos el valor anterior para la siguiente compración
            integrarAnterior = integralNueva;
        }

        return integrarAnterior;
    }
}