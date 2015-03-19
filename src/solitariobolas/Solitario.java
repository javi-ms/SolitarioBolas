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
        //crear tablero en blanco
        for (int fila = 0; fila < 7; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                solitario[columna][fila] = " ";
            }
        }
        //crear columnas 
        for (int columna = 2; columna < 5; columna++) {
            for (int fila = 0; fila < 7; fila++) {
                solitario[columna][fila] = "*";
            }
        }
        //crear filas
        for (int fila = 2; fila < 5; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                solitario[columna][fila] = "*";
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
                tablero += solitario[j][i];
            }
            tablero += "\n";
        }
        return tablero;
    }

    public String getMovimientos(int posColumnaOrigen, int posFilaOrigen, int posColumnaFinal, int posFilaFinal) {

        /*queremos que nos recoga la informacion de la posicion inicial
         y que nos la mueva a la posicion final*/
        //Contenido posicion Inicial
        //Mostrar en pantalla
        String fichaOrigen = solitario[posColumnaOrigen][posFilaOrigen];

        //solitario[posColumnaFinal][posFilaFinal]=fichaOrigen;
        solitario[posColumnaFinal][posFilaFinal] = "*";
        solitario[posColumnaOrigen][posFilaOrigen] = " ";
        System.out.println(solitario[posColumnaOrigen][posFilaOrigen] + "origen");
        System.out.println(solitario[posColumnaFinal][posFilaFinal - 1] + "final -1");
        System.out.println(solitario[posColumnaFinal][posFilaFinal] + "final");
        System.out.println(solitario[posColumnaFinal][posFilaFinal + 1]  + "final +1");
        
        if (solitario[posColumnaOrigen][posFilaOrigen] == "*" && solitario[posColumnaFinal][posFilaFinal - 1] == "*" && solitario[posColumnaFinal][posFilaFinal] == " ") {
            if (solitario[posColumnaOrigen][posFilaOrigen] == "*" && solitario[posColumnaFinal][posFilaFinal + 1] == "*" && solitario[posColumnaFinal][posFilaFinal] == " ") {
                //movimiento vertical
                if (posColumnaOrigen == posColumnaFinal) {
                    if (posFilaOrigen < posFilaFinal) {
                        //para abajo
                        solitario[posColumnaFinal][posFilaFinal - 1] = " ";
                        System.out.println("prueba fila -1");
                    } else {
                        //para arriba
                        solitario[posColumnaFinal][posFilaFinal + 1] = " ";
                        System.out.println("prueba fila +1");
                    }
                }
            } else {
                System.out.println("error");
            }
        }
        if (solitario[posColumnaOrigen][posFilaOrigen] == "*" && solitario[posColumnaFinal - 1][posFilaFinal] == "*"
                && solitario[posColumnaFinal][posFilaFinal] == " ") {
            if (solitario[posColumnaOrigen][posFilaOrigen] == "*" && solitario[posColumnaFinal + 1][posFilaFinal] == "*"
                    && solitario[posColumnaFinal][posFilaFinal] == " ") {
                //movimiento horizontal
                if (posFilaOrigen == posFilaFinal) {
                    //para la derecha
                    if (posColumnaOrigen < posColumnaFinal) {
                        solitario[posColumnaFinal - 1][posFilaFinal] = " ";
                        System.out.println("prueba Columna -1");

                    } else {
                        //para la izquierda
                        solitario[posColumnaFinal + 1][posFilaFinal] = " ";
                        System.out.println("prueba Columna +1");
                    }
                }
            }
        }

        //Contenido Posicion Final
//        String posAMover = solitario[posColumnaFinal][posFilaFinal];
        return fichaOrigen;
    }
//    public String colision(int posicionColumnaFinal, int posicionFilaFinal ){
//        
//        //Si en la posicion Adyacente hay un "*" y la siguiente esta vacio que se mueva
//        
//        String posFinal=solitario[posicionColumnaFinal][posicionFilaFinal];
//        if (solitario[posColumnaFinal]<solitario[2]&&solitario[posColumnaFinal]>solitario[5])) {
//            System.out.println("Error");
//        }
// 
//       
//            
//        }
//        return "pon otro movimiento";
//    }
//    

//     * Hay que evitar los movimientos menores de la columna 2 y mayores que 5 y
//     * menor que la fila 2 y mayores que 5 /
//     *
//     * }
}
