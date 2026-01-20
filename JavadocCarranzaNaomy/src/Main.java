import java.util.Scanner;

public class Main {
    public static double VALOR_DE_PI=3.1416;
    public static void main (String[] args) {
        Scanner scanner=new Scanner(System.in);
        int opcion=0;
        do {
            System.out.println("menu: ");
            System.out.println("1. calcular imc");
            System.out.println("2. calcular el area de un rectangulo");
            System.out.println("3. convertir c a f");
            System.out.println("4. calcular area de un circulo");
            System.out.println("salir");
            opcion=scanner.nextInt();

            if (opcion==1){
                double pesoKG=obtenerDato(scanner, "introduce el peso en kilogramos: ");
                double alturaMetros=obtenerDato(scanner, "introduce la altura en metros: ");
                double imc=calcularIMC(pesoKG, alturaMetros);
                System.out.println("tu imc es de: "+imc);

            } else if (opcion==2) {
                double base=obtenerDato(scanner, "introdue la base del rectangulo :");
                double altura=obtenerDato(scanner, "intrduce la altura del rectangulo: ");
                double area=areaRectangulo(base, altura);
                System.out.println("el area del rectangulo es: "+area);


            } else if (opcion==3) {
                System.out.println("este es el caso 3");
                double centigrados=obtenerDato(scanner, "introduce el grado en Celsius: ");
                double Fahrenheit=conversionDeGrados(centigrados);
                System.out.println("el resultado de la conversion es: "+Fahrenheit);


            } else if (opcion==4) {
                System.out.println("este es el caso 4");
                double radio=obtenerDato(scanner, "introduce el radio del circulo: ");
                double areaCirculo=areaCirculo(radio);
                System.out.println("el area del circulo es :"+areaCirculo);

            }else{
                System.out.println("no se encontro la opcion");
            }
        }while (opcion>0 && opcion<5);

        System.out.println("menu: ");
        System.out.println("1. calcular imc");
        System.out.println("2. calcular el area de un rectangulo");
        System.out.println("3. convertir c a f");
        System.out.println("4. calcular area de un circulo");
        System.out.println("salir");
        opcion=scanner.nextInt();

        if (opcion==1){
            double pesoKG=obtenerDato(scanner, "introduce el peso en kilogramos: ");
            double alturaMetros=obtenerDato(scanner, "introduce la altura en metros: ");
            double imc=calcularIMC(pesoKG, alturaMetros);
            System.out.println("tu imc es de: "+imc);

        } else if (opcion==2) {
            double base=obtenerDato(scanner, "introdue la base del rectangulo :");
            double altura=obtenerDato(scanner, "intrduce la altura del rectangulo: ");
            double area=areaRectangulo(base, altura);
            System.out.println("el area del rectangulo es: "+area);


        } else if (opcion==3) {
            System.out.println("este es el caso 3");
            double centigrados=obtenerDato(scanner, "introduce el grado en Celsius: ");
            double Fahrenheit=conversionDeGrados(centigrados);
            System.out.println("el resultado de la conversion es: "+Fahrenheit);


        } else if (opcion==4) {
            System.out.println("este es el caso 4");
            double radio=obtenerDato(scanner, "introduce el radio del circulo: ");
            double areaCirculo=areaCirculo(radio);
            System.out.println("el area del circulo es :"+areaCirculo);

        }else{
            System.out.println("no se encontro la opcion");
        }
    }

    /**
     * manda un mensaje y recibe un dato
     * @param scanner
     * @param mensaje
     * @return
     */
    public static double obtenerDato(Scanner scanner, String mensaje){
        System.out.println(mensaje);
        return scanner.nextDouble();
    }

    /**
     * calcular imc
     * @param pesoKG -> el usuario introduce el peso
     * @param alturaMetros -> el usuario introduce la altura
     * @return
     */
    public static double calcularIMC(double pesoKG, double alturaMetros){
        return pesoKG/(alturaMetros*alturaMetros);
    }

    /**
     * calcular area de rectangulo
     * @param base -> el usuario introduce la base
     * @param altura ->el usuario introduce la altura
     * @return
     */
    public static double areaRectangulo(double base, double altura){
        return base*altura;
    }

    /**
     * calcular la conversion de C a F
     * @param centigrados -> el usuario introduce los centigrados
     * @return
     */
    public static double conversionDeGrados(double centigrados){
        return (centigrados * 1.8)+32;
    }

    /**
     * calcular area de circulo
     * @param radio -> el usuario introduce el radio
     * @return
     */
    public static double areaCirculo(double radio){
        return VALOR_DE_PI*(radio*radio);
    }
}
