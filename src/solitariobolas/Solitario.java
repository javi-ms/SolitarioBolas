/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariobolas;

/**
 *
 * @author Javier
 */
public class Solitario {

    private final int COL = 7;
    private final int FIL = 7;
    public String tablero = "";
    int numero = 0;
//   String[][] solitario;
    //solo puede crearse dentro de un metodo
//   solitario = new String[fila][col];

    String[][] solitario = new String[FIL][COL];

//         * * *
//         * * *
//     * * * * * * * 
//     * * *   * * * 
//     * * * * * * * 
//         * * * 
//         * * *
//    public int moverFicha(int posicionColumna, int posicionFila){
//    hay que recoger la informacion que haya en una posicion y moverla 
//    a dos posiciones de distancia, excepto cuando haya dos posiciones seguidas ocupadas
//    solo lo moveremos cuando la posicion adyacente este ocupada y la siguiente vacia
//        if (posicionColumna &&posicionFila ==isEmpty) {
//            
//        }
//    }
    public void crearTablero() {

        for (int fila = 0; fila < 7; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                solitario[fila][columna] = " ";
            }
        }
        for (int columna = 2; columna < 5; columna++) {
            for (int fila = 0; fila < 7; fila++) {
                solitario[fila][columna] = "*";
            }
        }
        for (int fila = 2; fila < 5; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                solitario[fila][columna] = "*";
            }
        }
        solitario[3][3] = " ";
        //hay que poner un salto de linea cuando llegue a siete  
    }

    public String mostrarTablero() {
        tablero = "";
        for (int i = 0; i < FIL; i++) {
            for (int j = 0; j < COL; j++) {
                //se usa el += para que se añada a lo que ya halla 
                //sin el + te borra el tablero y pinta uno nuevo
                tablero += solitario[i][j];
            }
            tablero += "\n";
        }
        return tablero;
    }

    public String getMovimientos(int posicionColumna, int posicionFila, int posColumnaFinal, int posFilaFinal) {

        String posInicial = solitario[posicionColumna][posicionFila];

        //Mostrar en pantalla
        System.out.println(posInicial);
        System.out.println("posicion columna : " + posicionColumna);
        System.out.println("posicion fila : " + posicionFila);
        System.out.println("posicion columna final: " + posColumnaFinal);
        System.out.println("posicion fila final: " + posFilaFinal);

        solitario[posColumnaFinal][posFilaFinal] = posInicial;
        posInicial = " ";

        
        if (posicionFila < posFilaFinal) {
            solitario[posColumnaFinal][posFilaFinal - 1] = " ";
        } else {
            solitario[posColumnaFinal][posFilaFinal + 1] = " ";
        }

        if (posicionColumna < posColumnaFinal) {
            solitario[posColumnaFinal - 1][posFilaFinal] = " ";
        } else {
            solitario[posColumnaFinal + 1][posFilaFinal] = " ";
        }
        return posInicial;
    }
}
