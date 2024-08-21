import java.util.Scanner;

public class JuegoDeCartas {
    private Carta[][] matrizCartas;
    private int numCartas;

    public JuegoDeCartas() {
        matrizCartas = new Carta[5][10];
        numCartas = 0;
    }

    public void crearMatrizCartas() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                matrizCartas[i][j] = null;
            }
        }
    }

    public void agregarCartas(String palo, String valor, int puntos) {
        Carta carta = new Carta(palo, valor, puntos);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrizCartas[i][j] == null) {
                    matrizCartas[i][j] = carta;
                    numCartas++;
                    return;
                }
            }
        }
    }

    public void inicializarCartasJuego() {
        agregarCartas("Corazones", "As", 1);
        agregarCartas("Diamantes", "2", 2);
        agregarCartas("Treboles", "3", 3);
        agregarCartas("Picas", "4", 4);
        agregarCartas("Corazones", "5", 5);
        agregarCartas("Diamantes", "6", 6);
        agregarCartas("Treboles", "7", 7);
        agregarCartas("Picas", "8", 8);
        agregarCartas("Corazones", "9", 9);
        agregarCartas("Diamantes", "10", 10);
        agregarCartas("Treboles", "J", 10);
        agregarCartas("Picas", "Q", 10);
        agregarCartas("Corazones", "K", 10);
    }
    public
}