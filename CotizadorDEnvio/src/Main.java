import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);
        ComprobarRango comprobarRango=new ComprobarRango();
        ShippingCalculator shippingCalculator=new ShippingCalculator();

        double pesoEnKg=comprobarRango.leerDoubleEnRango(scanner, "ingresa el peso en kg: : ", 0.1, 50);
        int distanciaEnKm=comprobarRango.leerIntEnRango(scanner, "ingresa la distancia en km: ", 1, 2000);
        int tipoDeServicio=comprobarRango.leerIntEnRango(scanner, "ingesa el tipo de servicio: 1) estandar  2) express", 1, 2);
        boolean esZonaRemota=comprobarRango.leerBoolean(scanner, "¿Es zona remota? (true/false): ");
        double subtotal=shippingCalculator.calcularSubtotal(pesoEnKg,distanciaEnKm, tipoDeServicio, esZonaRemota);
        System.out.println("el peso en kg es de: "+pesoEnKg);
        System.out.println("la distancia en km es de: "+distanciaEnKm);
        System.out.println("el tipo de servicio es de: "+tipoDeServicio);
        System.out.println(shippingCalculator.esUnaZonaRemota(esZonaRemota));
        System.out.println("el calculo del subtotal es de: "+subtotal);
        System.out.println("el calculo de iva es de: "+shippingCalculator.calcularIVA(subtotal));
        System.out.println("el calculo del precio final es de: "+shippingCalculator.calcularTotal(subtotal));

    }
}
