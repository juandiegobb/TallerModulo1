import java.util.Scanner;

public class Operaciones {
    
    static final int MAX_RESERVAS = 10;
    static int contadorReservas = 0;

    static String[] nombresClientes = new String[MAX_RESERVAS];
    static int[] horas = new int[MAX_RESERVAS];
    static int[] tipoServicio = new int[MAX_RESERVAS];

    
    public static void agendar(Scanner sc){
        if(contadorReservas >= MAX_RESERVAS){
            System.out.println("Lo sentimos, no hay mas cupos :(");
            return;
        }
        String nombre = "";

        while(!Validador.nombreValido(nombre)){
            System.out.println("Ingrese nombre del cliente");
            nombre = sc.nextLine();


            if(!Validador.nombreValido(nombre)){
                System.out.println("Error: nombre Invalido");
            }
        }


        int hora = 0;
        boolean horaConfirmada = false;
        while(!horaConfirmada){
            hora = Validador.leerEntero(sc, "Ingrese la hora de la cita (8 a 17):");

            if(!Validador.horaValida(hora)){
                System.out.println("Error: El horario de atención es de 8:00 a 17:00." );
                continue;
            }

            boolean horaOcupada = false;
            for(int i=0; i < contadorReservas; i++){
                if (horas[i] == hora){
                    horaOcupada = true;
                    break;
                }
            }

            if(horaOcupada){
                System.out.println("Error: El horario " + hora + ":00 ya se encuentra reservado por otro cliente.");
            }else{
                horaConfirmada = true;
            }
        }
            int servicioInput;
            System.out.println();
            System.out.println("===MENU SERVICIOS===");
            System.out.println("1. Corte de cabello => $25.000");
            System.out.println("2. Tinte => $60.000");
            System.out.println("3. Manicure => $30.000");

            System.out.println("ingrese el servicio requerido 1, 2 o 3");
            servicioInput = sc.nextInt();
            sc.nextLine();

            while(!Validador.servicioValido(servicioInput)){
                 System.out.println("❌ Error: Selección inválida. Debe elegir 1, 2 o 3."); 
                servicioInput = Validador.leerEntero(sc, "Seleccione un código válido (1-3):");
            }

            nombresClientes[contadorReservas] = nombre;
            horas[contadorReservas] = hora;
            tipoServicio[contadorReservas] = servicioInput;

            contadorReservas++;

             System.out.println("\n ¡Reserva agendada con éxito para las " + hora + ":00!");
    }

    public static void listar(){

        System.out.println("===LISTA DE RESERVAS DEL DIA===");

        if(contadorReservas == 0){
            System.out.println("Aún no hay reservas registradas en el sistema.");
            return;
        }

        for(int i=0; i < contadorReservas; i++){

            String nombreServicio = "";

            switch(tipoServicio[i]){
                case 1 -> nombreServicio = "Corte de cabello";
                case 2 -> nombreServicio = "Tinte";
                case 3 -> nombreServicio = "Manicure";
                default -> nombreServicio = "Desconocido";
            }

            System.out.println((i+1)+". "+nombresClientes[i] +
                "| Hora: "+ horas[i]+":00"+
                "| Servicio: " + nombreServicio);
            System.out.println();
        }
    }

    public static void cancelar(Scanner sc){
        System.out.println("===CANCELAR RESERVAS===");

        if(contadorReservas == 0){
             System.out.println("Aún no hay reservas registradas para cancelar.");
            return;
        }

        listar();

        int cancelarInput;
        cancelarInput = Validador.leerEntero(sc, "Ingrese la opcion que desea cancelar");

        if(cancelarInput < 1 || cancelarInput > contadorReservas){
             System.out.println("Error: El número de reserva no existe."); 
            return;
        }   

        int indiceBorrar = cancelarInput - 1;
        
        // Algoritmo para "tapar el hueco" desplazando los elementos hacia atrás
        for (int i = indiceBorrar; i < contadorReservas - 1; i++) { 
            nombresClientes[i] = nombresClientes[i + 1];  
            horas[i] = horas[i + 1]; // 
            tipoServicio[i] = tipoServicio[i + 1]; 
        }

        contadorReservas--; 
        System.out.println("¡La reserva ha sido cancelada exitosamente!");

    }

    public static void reporte(){
        

        if(contadorReservas == 0){
            System.out.println("Aún no hay reservas registradas en el sistema.");
            return;
        }

        int totalCitas = contadorReservas;
        int totalIngresos = 0;

        for(int i=0; i < contadorReservas; i++){
            switch(tipoServicio[i]){
                case 1 -> totalIngresos += 25000;
                case 2 -> totalIngresos += 60000;
                case 3 -> totalIngresos += 30000;
            }
        }

        System.out.println("===REPORTE DEL DIA===");
        System.out.println("Total de citas: " + totalCitas);
        System.out.println("Total de ingresos: $" + totalIngresos);

    }

}
