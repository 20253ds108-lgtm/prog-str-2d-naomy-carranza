public class ShippingCalculator {

    private final double IVA = 0.16;
    private final double PRECIO_ESTANDAR = 50;
    private final double PRECIO_EXPRESS = 90;
    private final double PRECIO_ZONA_REMOTA = 0.10;

    double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota){
        double subtotal=0;
        if (tipoServicio==1){
            subtotal+=PRECIO_ESTANDAR;
            subtotal+=12*pesoKg;
        }else {
            subtotal += PRECIO_EXPRESS;
            subtotal = subtotal+(12*pesoKg);
        }
        if (distanciaKm<=50){
            subtotal+=20;
        } else if (distanciaKm<=200) {
            subtotal+=60;
        } else{
            subtotal+=120;
        }
        if (esZonaRemota){
            subtotal=subtotal+(subtotal*PRECIO_ZONA_REMOTA);
        }
        return subtotal;
    }

    double calcularIVA(double subtotal){
        return subtotal * IVA;
    }
    double calcularTotal(double subtotal){
        return subtotal+calcularIVA(subtotal);
    }

    String esUnaZonaRemota(boolean esZonaRemota){
        if (esZonaRemota){
            return "es una zona remota";
        }else {
            return "no en una zona remota";
        }
    }
}
