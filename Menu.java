import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<ObjBanco> colaPreferencial = new LinkedList<>();
        Queue<ObjBanco> colaNormal = new LinkedList<>();

        Metodos m = new Metodos();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Bienvenido al Banco Vid");
            System.out.println("1) Registrar Cliente ");
            System.out.println("2) LLamar Siguiente Cliente");
            System.out.println("3)Atender al cliente ");
            System.out.println("4)Cambiar cliente a atencion preferencial ");
            System.out.println("5)Cancelar turno del cliente ");
            System.out.println("6)Buscar cliente por su ID ");
            System.out.println("7)Mostar personas en espera ");
            System.out.println("8)Mostar cuantos hay en la fila de preferencial y fila normal ");
            System.out.println("9)Salir ");
            System.out.println("10)Escoge una opcion del 1 a 9 ");

            int opt = m.ValidarEnteros(colaNormal, colaNormal, sc);

            switch (opt) {

                case 1:
                m.LlenarCola(colaPreferencial, colaNormal, m, sc);
                System.out.println("-----------------------------------------");
                    break;

                case 2:
                    m.MostrarClientes(colaPreferencial, colaNormal);
                    System.out.println("-----------------------------------------");
                    break;


                case 3 :
                    m.LlamarSiguiente(colaPreferencial, colaNormal);
                    System.out.println("-----------------------------------------");
                    break;

                case 4:
                    m.AtenderCliente(colaPreferencial, colaNormal);
                    System.out.println("-----------------------------------------");
                    break;
                    
                case 5:
                     m.CambiarPreferencial(colaPreferencial,colaNormal,sc);
                     System.out.println("-----------------------------------------");
                    break;
                
                case 6:
                    m.CancelarTurno(colaPreferencial,colaNormal,sc);
                    System.out.println("-----------------------------------------");
                    break;
                    
                case 7:
                    m.MostrarEspera(colaPreferencial, colaNormal);
                    System.out.println("-----------------------------------------");
                    break; 

                case 8:
                    m.ContarPorTipo(colaPreferencial,colaNormal);
                    System.out.println("-----------------------------------------");
                    break; 

                case 9:
                    System.out.println("Gracias por utlizar el banco Vid");
                    break; 

                default:
                    System.out.println("Opcion no valida");
                    break;
                
            }



        }
    }
}
