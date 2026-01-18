import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int numero=PedirEntero("ingresar un numero entero :)");
        int suma=SumarHastaN(numero);
        System.out.println("la suma del numero 1 al "+numero+"es:"+suma);
    }
    // metodo para obteber un numero entero :)
    public static int PedirEntero(String mensaje) {
        Scanner sc=new Scanner(System.in);
        System.out.print(mensaje);
        int valor=sc.nextInt();
        sc.close();
        return valor;
    }
    // metodo para sumar :)
    public static int SumarHastaN(int n) {
        int suma=0;
        for (int i=1; i <=n; i++) {
            suma +=i;
        }
        return suma;
    }
}
