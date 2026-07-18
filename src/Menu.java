    import java.util.Scanner;
    public class Menu {

        public static void mostrarMenu(){
            System.out.println();
            System.out.println("=== MARTA PELUQUERIA ===");
            System.out.println("1. Agendar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Reporte");
            System.out.println("5. Salir");
        }

        public static int leerOpcion(Scanner sc){
            return Validador.leerEntero(sc, "Elije una opcion");
        }

        
}
