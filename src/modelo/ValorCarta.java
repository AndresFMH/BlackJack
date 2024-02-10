/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Aprendiz Compras
 */
public class ValorCarta {
    
    public int valorCarta (String c){
        String carta = c;
        
        switch (carta) {
            
            case "/image/c01.jpg":
            case "/image/d01.jpg":
            case "/image/p01.jpg":
            case "/image/t01.jpg":
                return 1;
            case "/image/c02.jpg":
            case "/image/d02.jpg":
            case "/image/p02.jpg":
            case "/image/t02.jpg":
                return 2;
            case "/image/c03.jpg":
            case "/image/d03.jpg":
            case "/image/p03.jpg":
            case "/image/t03.jpg":
                return 3;
            case "/image/c04.jpg":
            case "/image/d04.jpg":
            case "/image/p04.jpg":
            case "/image/t04.jpg":
                return 4;
            case "/image/c05.jpg":
            case "/image/d05.jpg":
            case "/image/p05.jpg":
            case "/image/t05.jpg":
                return 5;
            case "/image/c06.jpg":
            case "/image/d06.jpg":
            case "/image/p06.jpg":
            case "/image/t06.jpg":
                return 6;
            case "/image/c07.jpg":
            case "/image/d07.jpg":
            case "/image/p07.jpg":
            case "/image/t07.jpg":
                return 7;
            case "/image/c08.jpg":
            case "/image/d08.jpg":
            case "/image/p08.jpg":
            case "/image/t08.jpg":
                return 8;
            case "/image/c09.jpg":
            case "/image/d09.jpg":
            case "/image/p09.jpg":
            case "/image/t09.jpg":
                return 9;
            case "/image/c10.jpg":
            case "/image/d10.jpg":
            case "/image/p10.jpg":
            case "/image/t10.jpg":
                return 10;
            case "/image/cJ.jpg":
            case "/image/dJ.jpg":
            case "/image/pJ.jpg":
            case "/image/tJ.jpg":
            
            case "/image/cK.jpg":
            case "/image/dK.jpg":
            case "/image/pK.jpg":
            case "/image/tK.jpg":
                
            case "/image/cQ.jpg":
            case "/image/dQ.jpg":
            case "/image/pQ.jpg":
            case "/image/tQ.jpg":
                return 10;
                
            
            default:
                return 0;
        }                
    }    
}
