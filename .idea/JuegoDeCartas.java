import java.util.Scanner;

public JuegoDeCartas() {
    matrizCartas = new Carta[1][3]; // Solo 3 cartas
    numCartas = 0;
}

public void crearMatrizCartas() {
    for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 3; j++) {
            matrizCartas[i][j] = null;
        }
    }
}

public void agregarCartas(String tipo, String valor, int puntos) {
    Carta carta = new Carta(tipo, valor, puntos);
    for (int i = 0; i < 1; i++) {
        for (int j = 0; j < 3; j++) {
            if (matrizCartas[i][j] == null) {
                matrizCartas[i][j] = carta;
                numCartas++;
                return;
            }
        }
    }
}

public void inicializarCartasJuego() {
    agregarCartas("Corazones", "1", 1);
    agregarCartas("Diamantes", "2", 2);
    agregarCartas("Treboles", "3", 3);
}

public Carta[] obtenerCartas() {
    Carta[] cartas = new Carta[numCartas];
    int indice = 0;
    for (int i = 0; i < matrizCartas.length; i++) {
        for (int j = 0; j < matrizCartas[i].length; j++) {
            if (matrizCartas[i][j] != null) {
                cartas[indice] = matrizCartas[i][j];
                indice++;
            }
        }
    }
    return cartas;
}
public void jugar() {
    Carta[] cartas = obtenerCartas();
    int puntos = 0;
    for (Carta carta : cartas) {
        puntos += carta.getPuntos();
    }
    System.out.println("Puntos: " + puntos);
    if (puntos == 2.0) {
        System.out.println("¡Has ganado!");
    } else if (puntos > 2.0) {
        System.out.println("¡Has perdido! Tu puntaje es mayor a 20.");
    } else {
        System.out.println("¡Has perdido! Tu puntaje es menor a 20.");
    }
}
public void salir (){
    System.out.println("Saliendo");
    System.exit(1);
}
public void menu (){
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("Menu de opciones:");
        System.out.println("1) Jugar.");
        System.out.println("2) Salir");
        System.out.println("Solo hay dos opciones: ");
        opcion = scanner.nextInt();
        switch (opcion){
            case 1:
                jugar();
                salir();
            case 2:
                salir();
                System.out.println("Adios");
            default:
                System.out.println("tu opcion no es valida");
        }
    }while(opcion != 2);
}

public static void main(String[] args) {
    JuegoDeCartas juego = new JuegoDeCartas();
    juego.crearMatrizCartas();
    juego.inicializarCartasJuego();
    juego.menu();
}

class Carta{
    private String tipo;
    private String valor;
    private int puntos;

    public Carta(String tipo, String valor, int puntos) {
        this.tipo = tipo;
        this.valor = valor;
        this.puntos = puntos;
    }

    public String getPalo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getPuntos() {
        return puntos;
    }
}
