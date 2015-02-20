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
    public int moverFicha(int columna, int fila){
    
    
    }
    public void crearTablero() {
        for (int columna=0; columna < 7; columna++) {
            for (int fila = 0; fila < 7; fila++) {
                solitario[fila][columna] = " ";
            }
        }
        
        for (int columna=2; columna < 5; columna++) {
            for (int fila = 0; fila < 7; fila++) {
                solitario[fila][columna] = "*";
            }
        }
        
        for (int fila = 2; fila <5; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                solitario[fila][columna]="*";
            }
        }
        solitario[3][3]=" ";
        //hay que poner un salto de linea cuando llegue a siete  
    }

    public String mostrarTablero() {

        for (int i = 0; i < FIL; i++) {
            for (int j = 0; j < COL; j++) {
                //se usa el += para que se añada a lo que ya halla 
                tablero += solitario[i][j];
            }
            tablero += "\n";
        }
        return tablero;
    }
}
