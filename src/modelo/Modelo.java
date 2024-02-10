/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Aprendiz Compras
 */
public class Modelo {
    
    private String c1B,c2B,c3B,c4B,c5B,c1P,c2P,c3P,c4P,c5P,box;
    private int sumaB, sumaP,winsB,winsP;

    public Modelo() {
    }   

    public Modelo(String c1B, String c2B, String c3B, String c4B, String c5B, String c1P, String c2P, String c3P, String c4P,String c5P, String box, int sumaB, int sumaP, int winsB, int winsP) {
        this.c1B = c1B;
        this.c2B = c2B;
        this.c3B = c3B;
        this.c4B = c4B;
        this.c5B = c5B;
        this.c1P = c1P;
        this.c2P = c2P;
        this.c3P = c3P;
        this.c4P = c4P; 
        this.c5P = c5P;
        this.box = box;
        this.sumaB = sumaB;
        this.sumaP = sumaP;
        this.winsB = winsB;
        this.winsP = winsP;
    }

    public String getC1B() {
        return c1B;
    }

    public void setC1B(String c1B) {
        this.c1B = c1B;
    }

    public String getC2B() {
        return c2B;
    }

    public void setC2B(String c2B) {
        this.c2B = c2B;
    }

    public String getC3B() {
        return c3B;
    }

    public void setC3B(String c3B) {
        this.c3B = c3B;
    }

    public String getC4B() {
        return c4B;
    }

    public void setC4B(String c4B) {
        this.c4B = c4B;
    }

    public String getC5B() {
        return c5B;
    }

    public void setC5B(String c5B) {
        this.c5B = c5B;
    }

    public String getC1P() {
        return c1P;
    }

    public void setC1P(String c1P) {
        this.c1P = c1P;
    }

    public String getC2P() {
        return c2P;
    }

    public void setC2P(String c2P) {
        this.c2P = c2P;
    }

    public String getC3P() {
        return c3P;
    }

    public void setC3P(String c3P) {
        this.c3P = c3P;
    }

    public String getC4P() {
        return c4P;
    }

    public void setC4P(String c4P) {
        this.c4P = c4P;
    }
    
    public String getC5P() {
        return c5P;
    }

    public void setC5P(String c5P) {
        this.c5P = c5P;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public int getSumaB() {
        return sumaB;
    }

    public void setSumaB(int sumaB) {
        this.sumaB = sumaB;
    }

    public int getSumaP() {
        return sumaP;
    }

    public void setSumaP(int sumaP) {
        this.sumaP = sumaP;
    }

    public int getWinsB() {
        return winsB;
    }

    public void setWinsB(int winsB) {
        this.winsB = winsB;
    }

    public int getWinsP() {
        return winsP;
    }

    public void setWinsP(int winsP) {
        this.winsP = winsP;
    }
    
    //Se inicializa una ArrayList temporal para seleccionar los datos y eliminarlos
    ArrayList<String> cartasTemp = new ArrayList<>();
            
    private static String seleccionarYEliminarDatoAlAzar(ArrayList<String> cartasTemp) {
        // Crear una instancia de Random
        Random random = new Random();
        
        // Generar un índice aleatorio
        int indiceAleatorio = random.nextInt(cartasTemp.size());

        // Obtener el dato correspondiente al índice aleatorio
        String datoSeleccionado = cartasTemp.get(indiceAleatorio);

        // Eliminar el dato seleccionado del ArrayList
        cartasTemp.remove(indiceAleatorio);

        return datoSeleccionado;        
    }
    
    public void iniciarJuego(){ 
        cartasTemp = Cartas.cartas; // No cambies esta línea
        
        //Se crea un objeto de la clase ValorCarta para guardar el respectivo valor de cada carta
        ValorCarta vc = new ValorCarta();
        //Se barajan las cartas, se reparten y se elimina la carta repartida
        this.c1B = seleccionarYEliminarDatoAlAzar(cartasTemp);
        this.c2B = seleccionarYEliminarDatoAlAzar(cartasTemp);
        this.c1P = seleccionarYEliminarDatoAlAzar(cartasTemp);
        this.c2P = seleccionarYEliminarDatoAlAzar(cartasTemp);        
    }
    
    public String pedirCarta(){
        String carta = seleccionarYEliminarDatoAlAzar(cartasTemp);
        return carta;        
    }
    
       
}
