public class MainTrap {
    public static void main(String[] args) {
        double a = 0.0;
        double b = 2.0;
        double tolerancia = 0.0001;

        // Mandamos a llamar al metodo encapsulado de Trapecio
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.println("\nResultado final Trapecio obtenido: " + resultadoTrapecio);

        // Mandamos a llamar al metodo encapsulado de Simpson
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(a, b, tolerancia);
        System.out.println("\nResultado final Simpson obtenido: " + resultadoSimpson);
    }
}