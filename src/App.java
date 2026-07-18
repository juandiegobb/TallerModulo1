
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 5) { 
            Menu.mostrarMenu();

            opcion = Menu.leerOpcion(sc);

            switch(opcion) {
                case 1:
                    Operaciones.agendar(sc);
                    
                    //System.out.println("Aqui agendamos");
                    break;
                case 2:
                    Operaciones.listar();
                    //System.out.println("Aqui listamos");
                    break;
                case 3:
                    Operaciones.cancelar(sc);  
                //System.out.println("Aqui cancelamos reserva");
                    break;
                case 4:
                    Operaciones.reporte();
                    break;
                case 5:
                    System.out.println("Salida");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

    }
}
