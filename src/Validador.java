
import java.util.Scanner;

public class Validador {
    public static int leerEntero(Scanner sc, String mensaje){
        while (true) { 
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            }else{
                 System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                 sc.nextLine();
            }
        }
    }

    public static boolean horaValida(int hora){
        return hora >= 8 && hora <= 17;
    }

    public static boolean nombreValido(String nombre){
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean servicioValido(int servicio){
        return servicio == 1 || servicio == 2 || servicio == 3;
    }

}

