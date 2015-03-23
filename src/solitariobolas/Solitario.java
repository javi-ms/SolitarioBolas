/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solitariobolas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public String[][] getSolitario() {
        return solitario;
    }

    public void setSolitario(String[][] solitario) {
        this.solitario = solitario;
    }

//         * * *
//         * * *
//     * * * * * * * 
//     * * *   * * * 
//     * * * * * * * 
//         * * * 
//         * * *
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

//        if (solitario[posColumnaOrigen][posFilaOrigen].equals("*") && solitario[posColumnaFinal][posFilaFinal - 1].equals("*") 
//                && solitario[posColumnaFinal][posFilaFinal].equals("*")) {
//            if (solitario[posColumnaOrigen][posFilaOrigen].equals("*") && solitario[posColumnaFinal][posFilaFinal + 1].equals("*")
//                    && solitario[posColumnaFinal][posFilaFinal].equals(" ")) {
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
        } else {
            System.out.println("error");
        }
//        }
//        if (solitario[posColumnaOrigen][posFilaOrigen].equals("*") && solitario[posColumnaFinal - 1][posFilaFinal].equals("*")
//                && solitario[posColumnaFinal][posFilaFinal].equals(" ")) {
//            System.out.println("esta es la de la filas de izquierda a derecha");
//            if (solitario[posColumnaOrigen][posFilaOrigen].equals("*")&& solitario[posColumnaFinal + 1][posFilaFinal].equals("*")
//                    && solitario[posColumnaFinal][posFilaFinal].equals(" ")) {
//                System.out.println("esta es la de las filas de derecha a izquierda");
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
//            }
//        }

        //Contenido Posicion Final
//        String posAMover = solitario[posColumnaFinal][posFilaFinal];
        return fichaOrigen;
    }

    public void mostrarNiveles(String ruta_archivo) {

        BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(ruta_archivo)));

        try {
            String texto = br.readLine();
            while (texto != null) {
                for (int i = 0; i < FIL; i++) {
                    for (int j = 0; j < COL; j++) {
                        solitario[i][j] = String.valueOf(texto.charAt(j));
                    }
                    texto = br.readLine();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Solitario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

//        String nombreFichero = "Levels/2.txt";
//        //Declarar una variable BufferedReader
//        BufferedReader br = null;
//        String datosFichero = "";
//        try {
//            //Crear un objeto BufferedReader al que se le pasa 
//            //   un objeto FileReader con el nombre del fichero
//            br = new BufferedReader(new FileReader(nombreFichero));
//            //Leer la primera línea, guardando en un String
//            String texto = br.readLine();
//            //Repetir mientras no se llegue al final del fichero
//            while (texto != null) {
//                //Hacer lo que sea con la línea leída
//                //Bucle doble que recorre la matriz
//               datosFichero = texto;
//                //Leer la siguiente línea
//                  texto = br.readLine();
//            }
//             for (int i = 0; i < FIL; i++) {
//                    for (int j = 0; j < COL; j++) {
//
//                        solitario[i][j] = datosFichero;
//                        System.out.println(solitario[i][j]);
//                    }
//                }
//        } catch (FileNotFoundException e) {
//            System.out.println("Error: Fichero no encontrado");
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Error de lectura del fichero");
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (br != null) {
//                    br.close();
//                }
//            } catch (Exception e) {
//                System.out.println("Error al cerrar el fichero");
//                System.out.println(e.getMessage());
//            }
//        }
//
//        return tablero;
//    }
//    
//     * Hay que evitar los movimientos menores de la columna 2 y mayores que 5 y
//     * menor que la fila 2 y mayores que 5 /
//     *
//     * }
    
    
}
