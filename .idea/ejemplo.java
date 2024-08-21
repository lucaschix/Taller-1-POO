import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ColeccionVinilosConMenu {

    public static void main(String[] args) {
        List<Vinilo> vinilos = new ArrayList<>();
        ejecutarMenu(vinilos);
    }

    public static void ejecutarMenu(List<Vinilo> vinilos) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, vinilos);
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú de Colección de Vinilos:");
        System.out.println("1. Agregar vinilo");
        System.out.println("2. Mostrar total de vinilos");
        System.out.println("3. Mostrar espacios disponibles");
        System.out.println("4. Borrar un vinilo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }

    public static String leerCadena(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        String cadena = scanner.nextLine();
        return cadena;
    }

    public static void ejecutarOpcion(int opcion, List<Vinilo> vinilos) {
        switch (opcion) {
            case 1:
                agregarViniloMenu(vinilos);
                break;
            case 2:
                mostrarTotal(vinilos);
                break;
            case 3:
                mostrarDisponibles(vinilos);
                break;
            case 4:
                borrarViniloMenu(vinilos);
                break;
            case 5:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void agregarViniloMenu(List<Vinilo> vinilos) {
        String artista = leerCadena("Ingrese el nombre del artista: ");
        String disco = leerCadena("Ingrese el nombre del disco: ");
        String año = leerCadena("Ingrese el año de lanzamiento: ");

        Vinilo vinilo = new Vinilo(artista, disco, año);
        vinilos.add(vinilo);
        System.out.println("Vinilo agregado exitosamente.");
    }

    public static void borrarViniloMenu(List<Vinilo> vinilos) {
        String artista = leerCadena("Ingrese el nombre del artista del vinilo a borrar: ");
        String disco = leerCadena("Ingrese el nombre del disco del vinilo a borrar: ");

        Vinilo viniloABorrar = buscarVinilo(vinilos, artista, disco);
        if (viniloABorrar != null) {
            vinilos.remove(viniloABorrar);
            System.out.println("Vinilo borrado exitosamente.");
        } else {
            System.out.println("Vinilo no encontrado en la colección.");
        }
    }

    public static Vinilo buscarVinilo(List<Vinilo> vinilos, String artista, String disco) {
        for (Vinilo vinilo : vinilos) {
            if (vinilo.getArtista().equals(artista) && vinilo.getDisco().equals(disco)) {
                return vinilo;
            }
        }
        return null;
    }

    public static void mostrarTotal(List<Vinilo> vinilos) {
        System.out.println("Hay un total de: " + vinilos.size() + " vinilos en la colección.");
    }

    public static void mostrarDisponibles(List<Vinilo> vinilos) {
        System.out.println("Hay un total de: " + (100 - vinilos.size()) + " espacios disponibles en la colección.");
    }
}

class Vinilo {
    private String artista;
    private String disco;
    private String año;

    public Vinilo(String artista, String disco, String año) {
        this.artista = artista;
        this.disco = disco;
        this.año = año;
    }

    public String getArtista() {
        return artista;
    }

    public String getDisco() {