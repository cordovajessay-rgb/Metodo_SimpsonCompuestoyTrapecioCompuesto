public class SimpsonCompuesto {
    private static double calcularSimpson(double a, double b, int n) {
        //reutilizamos el metodo calcularH de la clase TrapecioCompuesto
        double h = TrapecioCompuesto.calcularH(a, b, n);
        double sumaImpares = 0.0;
        double sumaPares = 0.0;

        //Recorremos los puntos intermedios desde k = 1 hasta n-1
        for (int k = 1; k < n; k++) {
            double xk = a + k * h;

            //Si k es impar lleva coeficiente 4; si k es par, lleva coeficiente 2
            if (k % 2 != 0) {
                //Reutilizamos la función f(x) de la clase TrapecioCompuesto
                sumaImpares += TrapecioCompuesto.funcion(xk);
            } else {
                sumaPares += TrapecioCompuesto.funcion(xk);
            }
        }

        //Aplicación de la fórmula general de Simpson Compuesto usando TrapecioCompuesto.función
        double sumaTotal = TrapecioCompuesto.funcion(a) + 4 * sumaImpares + 2 * sumaPares + TrapecioCompuesto.funcion(b);

        return (h/3) * sumaTotal;
    }

    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2; // Debe iniciar en un número par para Simpson 1/3
        double integralAnterior = calcularSimpson(a, b, n);
        double errorAbsoluto = 999.0;

        System.out.println("\n---ITERACIONES (SIMPSON COMPUESTO) ---");
        System.out.println("n = " + n + " | Integral = " + integralAnterior);

        while (errorAbsoluto > tolerancia) {
            n *= 2; // Duplicamos subintervalos manteniendo la paridad
            double integralNueva = calcularSimpson(a, b, n);

            errorAbsoluto = Math.abs(integralNueva - integralAnterior);

            System.out.println("n = " + n + " | Integral = " + integralNueva + " | Error absoluto: " + errorAbsoluto);

            integralAnterior = integralNueva;
        }

        return integralAnterior;
    }
}