
import java.util.Queue;
import java.util.Scanner;

/**
 * Metodos
 */
public class Metodos {


    public void LlenarCola(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal,
            Metodos m, Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            ObjBanco o = new ObjBanco();
            System.out.println("Ingrese el numero de documento");
            o.setId(sc.nextInt());
            System.out.println("Ingrese el nombre");
            o.setNombre(sc.next());
            System.out.println("Ingrese su edad");
            o.setEdad(sc.nextInt());
            System.out.println("Ingrese el tramite a realizar");
            o.setTipoTramite(m.MenuTramite(sc));
            o.setEspecial(m.Condicion(sc, o.getEdad()));
            o.setTurno(m.ValidarTurno(colaPreferencial, colaNormal));
            o.setEstado(1);

            if (o.getEspecial() == 1) {
                colaPreferencial.offer(o);
                System.out.println("Cliente agregado a la cola preferencial");
            } else {
                colaNormal.offer(o);
                System.out.println("Cliente agregado a la cola normal");
            }

            System.out.println("Desea agregar mas clientes 1) Si, 2) No");
            int opt = m.ValidarEnteros(colaPreferencial, colaNormal, sc);

            if (opt == 2) {
                System.out.println("Registro terminado");
                continuar = false;
            }
        }
    }

     public  int ValidarEnteros(Queue<ObjBanco> colaPreferencial, Queue<ObjBanco> colaNormal, Scanner sc) {
        while (!sc.hasNext()) {
        System.out.println("Ingrese un valor numerico ");
        sc.next();            
        }
        return sc.nextInt();
    }

    

    private String MenuTramite(Scanner sc) {
        System.out.println("Bienvenido al Banco Vid");
        System.out.println("Ingrese Tramite");
        System.out.println("1) Depositar y retirar");
        System.out.println("2) Pagos y giros");
        System.out.println("3) Apertura de cuentas");
        System.out.println("4) Solicitud de trajetas");
        System.out.println("5) Credito y prestamos ");
        System.out.println("6) otros");
        
        int opt = ValidarEnteros(null, null, sc);

        String tramite = "";
        switch (opt) {
            case 1: tramite = "Depositar y retirar"; 
                break; 
            case 2: tramite = "Pagos y giros"; 
                break; 
            case 3: tramite = "Apertura de cuentas"; 
                break;

            case 4: tramite = "Solicitud de tarjetas";
                break; 
                
            case 5: tramite = "Creditos y prestamos"; 
                break;
        
            default:
                tramite = "Otros";
                break;
        }

        return tramite;
    }




    public int Condicion(Scanner sc, int edad) {

        int condicion;

        System.out.println("Seleccione la condicion especial del cliente");
        System.out.println("1) Adulto mayor");
        System.out.println("2) Persona en situacion de discapacidad");
        System.out.println("3) Mujer gestante");
        System.out.println("4) Persona con niño en brazos");
        System.out.println("5) No tiene condicion especial");

        condicion = ValidarEnteros(null, null, sc);

        if (condicion == 1) {

            if (edad >= 60) {
                System.out.println("Cliente con atencion preferencial");
                return 1;
            } else {
                System.out.println("La edad no cumple la condicion de adulto mayor");
                return 2;
            }

        } else if (condicion == 2) {

            System.out.println("Cliente con atencion preferencial");
            return 1;

        } else if (condicion == 3) {

            System.out.println("Cliente con atencion preferencial");
            return 1;

        } else if (condicion == 4) {

            System.out.println("Cliente con atencion preferencial");
            return 1;

        } else {

            System.out.println("Cliente con atencion normal");
            return 2;
        }
    }

    public int ValidarTurno(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal) {

        int turno;

        int cantidad = colaPreferencial.size() + colaNormal.size();

        if (cantidad == 0) {
            turno = 1;
        } else {
            turno = cantidad + 1;
        }

        return turno;
    }


    public void MostrarClientes(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal) {

        System.out.println("\n========== CLIENTES PREFERENCIALES ==========");

        for (ObjBanco o : colaPreferencial) {

            if (o.getEstado() == 1) {

                System.out.println("ID: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Tramite: " + o.getTipoTramite());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Estado: Pendiente");
                System.out.println("-----------------------------------------");
            }
        }

        System.out.println("\n========== CLIENTES NORMALES ==========");

        for (ObjBanco o : colaNormal) {

            if (o.getEstado() == 1) {

                System.out.println("ID: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Tramite: " + o.getTipoTramite());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Estado: Pendiente");
                System.out.println("-----------------------------------------");
            }
        }
    }


    public ObjBanco LlamarSiguiente(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal) {

        ObjBanco cliente = null;

        if (!colaPreferencial.isEmpty()) {

            cliente = colaPreferencial.peek();

            System.out.println("El siguiente cliente es:");
            System.out.println("Turno: " + cliente.getTurno());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("ID: " + cliente.getId());
            System.out.println("Atencion: Preferencial");

        } else if (!colaNormal.isEmpty()) {

            cliente = colaNormal.peek();

            System.out.println("El siguiente cliente es:");
            System.out.println("Turno: " + cliente.getTurno());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("ID: " + cliente.getId());
            System.out.println("Atencion: Normal");

        } else {

            System.out.println("No hay clientes esperando");
        }

        return cliente;
    }

    public void AtenderCliente(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal) {

        ObjBanco cliente = null;

        if (!colaPreferencial.isEmpty()) {

            cliente = colaPreferencial.poll();

            cliente.setEstado(2);

            System.out.println("Cliente atendido correctamente");
            System.out.println("Turno atendido: " + cliente.getTurno());
            System.out.println("Nombre: " + cliente.getNombre());

        } else if (!colaNormal.isEmpty()) {

            cliente = colaNormal.poll();

            cliente.setEstado(2);

            System.out.println("Cliente atendido correctamente");
            System.out.println("Turno atendido: " + cliente.getTurno());
            System.out.println("Nombre: " + cliente.getNombre());

        } else {

            System.out.println("No hay clientes para atender");
        }
    }


    public void CambiarPreferencial(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal,
            Scanner sc) {

        System.out.println("Ingrese el ID del cliente que desea cambiar");
        int id = sc.nextInt();

        ObjBanco encontrado = null;

        for (ObjBanco o : colaNormal) {

            if (o.getId() == id && o.getEstado() == 1) {
                encontrado = o;
                break;
            }
        }

        if (encontrado != null) {

            colaNormal.remove(encontrado);

            encontrado.setEspecial(1);

            colaPreferencial.offer(encontrado);

            System.out.println("Cliente cambiado a atencion preferencial");
            System.out.println("Turno: " + encontrado.getTurno());
            System.out.println("Nombre: " + encontrado.getNombre());

        } else {

            System.out.println("Cliente no encontrado en la cola normal");
        }
    }


    public void CancelarTurno(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal,
            Scanner sc) {

        System.out.println("Ingrese el ID del cliente que desea cancelar");
       int  id = sc.nextInt();

        ObjBanco encontrado = null;

        
        for (ObjBanco o : colaPreferencial) {

            if (o.getId() == id) {
                encontrado = o;
                break;
            }
        }

        if (encontrado != null) {

            if (encontrado.getEstado() == 1) {

                encontrado.setEstado(3);
                colaPreferencial.remove(encontrado);

                System.out.println("Turno cancelado correctamente");

            } else if (encontrado.getEstado() == 2) {

                System.out.println("No se puede cancelar");
                System.out.println("El cliente ya fue atendido");

            } else {

                System.out.println("El turno ya estaba cancelado");
            }

            return;
        }

        for (ObjBanco o : colaNormal) {

            if (o.getId() == id) {
                encontrado = o;
                break;
            }
        }

        if (encontrado != null) {

            if (encontrado.getEstado() == 1) {

                encontrado.setEstado(3);
                colaNormal.remove(encontrado);

                System.out.println("Turno cancelado correctamente");

            } else if (encontrado.getEstado() == 2) {

                System.out.println("No se puede cancelar");
                System.out.println("El cliente ya fue atendido");

            } else {

                System.out.println("El turno ya estaba cancelado");
            }

        } else {

            System.out.println("Cliente no encontrado");
        }
    }

    public ObjBanco BuscarCliente(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal,
            Scanner sc) {

        System.out.println("Ingrese el ID del cliente");
        int id = sc.nextInt();

        for (ObjBanco o : colaPreferencial){
            if (o.getId() == id) {

                System.out.println("Cliente encontrado");
                System.out.println("ID: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Tramite: " + o.getTipoTramite());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Turno: " + o.getTurno());

                if (o.getEspecial() == 1) {
                    System.out.println("Atencion: Preferencial");
                } else {
                    System.out.println("Atencion: Normal");
                }

                if (o.getEstado() == 1) {
                    System.out.println("Estado: Pendiente");
                } else if (o.getEstado() == 2) {
                    System.out.println("Estado: Atendido");
                } else {
                    System.out.println("Estado: Cancelado");
                }

                return o;
            }
        }

        for (ObjBanco o : colaNormal) {

            if (o.getId() == id) {

                System.out.println("Cliente encontrado");
                System.out.println("ID: " + o.getId());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Tramite: " + o.getTipoTramite());
                System.out.println("Edad: " + o.getEdad());
                System.out.println("Turno: " + o.getTurno());

                if (o.getEspecial() == 1) {
                    System.out.println("Atencion: Preferencial");
                } else {
                    System.out.println("Atencion: Normal");
                }

                if (o.getEstado() == 1) {
                    System.out.println("Estado: Pendiente");
                } else if (o.getEstado() == 2) {
                    System.out.println("Estado: Atendido");
                } else {
                    System.out.println("Estado: Cancelado");
                }

                return o;
            }
        }

        System.out.println("Cliente no encontrado");
        return null;
    }


    public int ContarEsperando(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal) {

        int cont = 0;

        for (ObjBanco o : colaPreferencial) {

            if (o.getEstado() == 1) {
                cont++;
            }
        }

        for (ObjBanco o : colaNormal) {

            if (o.getEstado() == 1) {
                cont++;
            }
        }

        System.out.println("Personas esperando: " + cont);

        return cont;
    }



    public void ContarPorTipo(Queue<ObjBanco> colaPreferencial,
            Queue<ObjBanco> colaNormal) {

        int preferenciales = 0;
        int normales = 0;

        for (ObjBanco o : colaPreferencial) {

            if (o.getEstado() == 1) {
                preferenciales++;
            }
        }

        for (ObjBanco o : colaNormal) {

            if (o.getEstado() == 1) {
                normales++;
            }
        }

        System.out.println("Clientes preferenciales pendientes: " + preferenciales);
        System.out.println("Clientes normales pendientes: " + normales);
    }

}



