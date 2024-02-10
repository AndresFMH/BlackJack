/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.Modelo;
import modelo.ValorCarta;
import vista.Vista;

/**
 *
 * @author Aprendiz Compras
 */
public class Controlador {
    
    Vista v;
    Modelo m = new Modelo();
    ValorCarta vc = new ValorCarta();
    
    //Se crea un constructor vacio de la clase Controlador
    
    public Controlador(){
        
    }
    
    //Se crea un metodo para comunicarse con la vista, se pide como argumento la clase vista
    
    public void SetVista(Vista v){
        this.v = v;
    }
    
    int cartasMesaPlayer = 2;
    int cartasMesaBanca = 2;  
    
    public void Jugar(){                   
        
        activarBoton();
        desactivarBtnJugar();
        limpiarMesa();
        //Se reparten las cartas                
        m.iniciarJuego();
        v.Setc1b(m.getC1B());
        v.Setc2b("/image/carta.jpg");
        v.Setc1p(m.getC1P());
        v.Setc2p(m.getC2P());
        m.setSumaB(vc.valorCarta(m.getC1B()));
        m.setSumaP(vc.valorCarta(m.getC1P())+vc.valorCarta(m.getC2P()));
        v.setSumaBanca(String.valueOf( m.getSumaB()));
        v.setSumaPlayer(String.valueOf( m.getSumaP()));
        
        // Si el jugador tiene un blackjack al inicio, muestra el 21 en el tablero
        if ((vc.valorCarta(m.getC1P()) == 1 && vc.valorCarta(m.getC2P()) == 10) || (vc.valorCarta(m.getC1P()) == 10 && vc.valorCarta(m.getC2P()) == 1)) {
            v.setSumaPlayer("21");
        }
        
        //Si el Player saca 21 gana el Juego sin importar el resultado de la banca.
        if ((vc.valorCarta(m.getC1P())==1&&vc.valorCarta(m.getC2P())==10)||(vc.valorCarta(m.getC1P())==10&&vc.valorCarta(m.getC2P())==1)){
            JOptionPane.showMessageDialog(null, "Blackjack,GANASTE!!!");
            v.Setc2b(m.getC2B());
            m.setSumaB(vc.valorCarta(m.getC1B())+ vc.valorCarta(m.getC2B()));
            v.setSumaBanca(String.valueOf( m.getSumaB()));
            int varWinsP = m.getWinsP();
            varWinsP = varWinsP + 1;
            m.setWinsP(varWinsP);
            v.setWinsPlayer(String.valueOf(m.getWinsP())); 
            nuevoJuego();
        }
        else{
            JOptionPane.showMessageDialog(null, "Pedir carta o plantarse");
        }
    }
    
    boolean s1 = true;
    boolean s2 = true;
    boolean s3 = true;
    boolean s4 = true;
    
    public boolean cambiarValorDeAs(String carta, boolean suicheAs) {                
    if (esAs(carta)) {
        int valorCambio = suicheAs ? 10 : -10;
        int nuevoValor = m.getSumaP() + valorCambio;

        m.setSumaP(nuevoValor);
        v.setSumaPlayer(String.valueOf(m.getSumaP()));

        // Verificar si el jugador se pasa de 21 después del cambio
        if (nuevoValor > 21) {
            // Si se pasa de 21, muestra el mensaje y la Banca gana
            GanaBanca();
            v.Setc2b(m.getC2B());
            int valorCarta2B = vc.valorCarta(m.getC2B());
            m.setSumaB(m.getSumaB() + valorCarta2B);
            v.setSumaBanca(String.valueOf(m.getSumaB()));
            nuevoJuego();
        }

        // Verificar si el jugador alcanza 21 después del cambio y la Banca no tiene blackjack
        if (nuevoValor == 21 && !(vc.valorCarta(m.getC1B()) == 1 && (vc.valorCarta(m.getC2B()) == 10 || vc.valorCarta(m.getC2B()) == 1))) {
            GanaPlayer();
            v.Setc2b(m.getC2B());
            int valorCarta2B = vc.valorCarta(m.getC2B());
            m.setSumaB(m.getSumaB() + valorCarta2B);
            v.setSumaBanca(String.valueOf(m.getSumaB()));
            nuevoJuego();
        }

        return !suicheAs;
    } else {
        JOptionPane.showMessageDialog(null, "La carta seleccionada no es un As");
        return suicheAs;
    }        
}

    private boolean esAs(String carta) {
        return carta.equals("/image/c01.jpg") ||
               carta.equals("/image/d01.jpg") ||
               carta.equals("/image/p01.jpg") ||
               carta.equals("/image/t01.jpg");
    }

    public void cambiarValor() {
        int indiceCambio = v.GetBox();        
        switch (indiceCambio) {
            case 1:                
                s1 = cambiarValorDeAs(m.getC1P(), s1);
                break;
            case 2:                
                s2 = cambiarValorDeAs(m.getC2P(), s2);               
                break;                
            case 3:                
                s3 = cambiarValorDeAs(m.getC3P(), s3);   
                break;
            case 4:                
                s4 = cambiarValorDeAs(m.getC4P(), s4);               
                break;
            default:
                throw new IllegalArgumentException("Índice de cambio no válido: " + indiceCambio);
        }
    }
    
    
    public void pedirCartaPlayer() {
    cartasMesaPlayer++;

    switch (cartasMesaPlayer) {
        case 3:
            m.setC3P(m.pedirCarta());
            int valorCarta3P = vc.valorCarta(m.getC3P());
            m.setSumaP(m.getSumaP() + valorCarta3P);
            v.Setc3p(m.getC3P());
            v.setSumaPlayer(String.valueOf(m.getSumaP()));
            break;
        case 4:
            m.setC4P(m.pedirCarta());
            int valorCarta4P = vc.valorCarta(m.getC4P());
            m.setSumaP(m.getSumaP() + valorCarta4P);
            v.Setc4p(m.getC4P());
            v.setSumaPlayer(String.valueOf(m.getSumaP()));
            break;
        case 5:
            m.setC5P(m.pedirCarta());
            int valorCarta5P = vc.valorCarta(m.getC5P());
            m.setSumaP(m.getSumaP() + valorCarta5P);
            v.Setc5p(m.getC5P());
            v.setSumaPlayer(String.valueOf(m.getSumaP()));
            break;
        default:
            throw new AssertionError();
    }

    // Verificar si el jugador se pasa de 21
    if (m.getSumaP() > 21) {
        GanaBanca();
        v.Setc2b(m.getC2B());
        int valorCarta2B = vc.valorCarta(m.getC2B());
        m.setSumaB(m.getSumaB() + valorCarta2B);
        v.setSumaBanca(String.valueOf(m.getSumaB()));
        nuevoJuego();
    } else if (m.getSumaP() == 21) {
        GanaPlayer();
        v.Setc2b(m.getC2B());
        int valorCarta2B = vc.valorCarta(m.getC2B());
        m.setSumaB(m.getSumaB() + valorCarta2B);
        v.setSumaBanca(String.valueOf(m.getSumaB()));
        
        // Si la banca también tiene blackjack, determinar el ganador
        if (vc.valorCarta(m.getC1B()) == 1 && (vc.valorCarta(m.getC2B()) == 10 || vc.valorCarta(m.getC2B()) == 1)) {
            determinarGanador();
        } else {
            nuevoJuego();
        }
    }
}

        
    public void GanaPlayer(){
        JOptionPane.showMessageDialog(null, "Gana PLAYER");
        m.setWinsP(m.getWinsP() + 1);
        v.setWinsPlayer(String.valueOf(m.getWinsP()));        
    }
    
    public void GanaBanca(){
        JOptionPane.showMessageDialog(null, "Gana la BANCA!!!");
        m.setWinsB(m.getWinsB() + 1);
        v.setWinsBanca(String.valueOf(m.getWinsB()));         
    }
    
    public void Plantarse() {
        int SumPlayer = m.getSumaP();

        if (SumPlayer > 21) {
            // El jugador se pasó, gana la Banca
            GanaBanca();
            v.Setc2b(m.getC2B());
            m.setSumaB(m.getSumaB() + vc.valorCarta(m.getC2P()));
            v.setSumaBanca(String.valueOf(m.getSumaB())); 
            nuevoJuego();
        } else {
            // El jugador se planta y no se pasa de 21, la Banca juega
            juegaBanca();
        }
    }
    
    public void juegaBanca() {
    v.Setc2b(m.getC2B());
    int valorCarta2B = vc.valorCarta(m.getC2B());
    m.setSumaB(m.getSumaB() + valorCarta2B);
    v.setSumaBanca(String.valueOf(m.getSumaB()));

    while (m.getSumaB() < 16) {
        pedirCartaBanca();
    }

    // Verificar si la banca tiene un As y su mano supera 21
    if (m.getSumaB() > 21 && m.getC5B() != null && m.getC5B().contains("01")) {
        m.setSumaB(m.getSumaB() - 10); // Restar 10 solo si el As está presente
        v.setSumaBanca(String.valueOf(m.getSumaB()));
    }

    determinarGanador();
}
    

    public void pedirCartaBanca() {
        cartasMesaBanca++;
        
        switch (cartasMesaBanca) {
            case 3:
                m.setC3B(m.pedirCarta());                
                v.Setc3b(m.getC3B());
                m.setSumaB(m.getSumaB() + vc.valorCarta(m.getC3B()));
                v.setSumaBanca(String.valueOf(m.getSumaB()));
                
                break;
            case 4:
                m.setC4B(m.pedirCarta());
                v.Setc4b(m.getC4B());
                m.setSumaB(m.getSumaB() + vc.valorCarta(m.getC4B()));
                v.setSumaBanca(String.valueOf(m.getSumaB()));
                
                break;
            case 5:
                m.setC5B(m.pedirCarta());
                v.Setc5b(m.getC5B());
                m.setSumaB(m.getSumaB() + vc.valorCarta(m.getC5B()));
                v.setSumaBanca(String.valueOf(m.getSumaB()));
                
                break;
            default:
                throw new AssertionError();
        }
    }

    public void determinarGanador() {
        int diferenciaBanca = 21 - m.getSumaB();
        int diferenciaPlayer = 21 - m.getSumaP();

        if (m.getSumaB() == m.getSumaP()) {
            JOptionPane.showMessageDialog(null, "EMPATE!!!");

        } else if (m.getSumaB() > 21 || (diferenciaPlayer < diferenciaBanca && diferenciaPlayer >= 0)) {
            // La Banca se pasa de 21 o el jugador está más cerca de 21, gana el jugador
            GanaPlayer();

        } else {
            // En cualquier otro caso, gana la Banca
            GanaBanca();
        }

        // Preguntar si desea jugar nuevamente
        nuevoJuego();
        
    }
    
    public void nuevoJuego(){
        int option = JOptionPane.showConfirmDialog(null, "¿Deseas jugar nuevamente?", "Nueva partida", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {            
            desactivarBoton();
            activarBtnJugar();            
        } 
        else {
            JOptionPane.showMessageDialog(null, "¡Gracias por jugar! Hasta luego.");
            //Cerrar aplicacion
            System.exit(0);
        }        
    }
        
    public void limpiarMesa() {
        v.Setc3p("");
        v.Setc4p("");
        v.Setc5p("");
        v.Setc3b("");
        v.Setc4b("");
        v.Setc5b("");

        // Se reinician las variables relacionadas con las cartas       
        cartasMesaPlayer = 2;
        cartasMesaBanca = 2;
    }
    
    public void activarBoton() {
        v.getBtnPedir().setEnabled(true);
        v.getBtnPlantarse().setEnabled(true);
    }
    
    public void desactivarBoton() {
        v.getBtnPedir().setEnabled(false);
        v.getBtnPlantarse().setEnabled(false);
    }
    
    public void activarBtnJugar() {        
        v.getBtnJugar().setEnabled(true);
    }
    
    public void desactivarBtnJugar() {
        v.getBtnJugar().setEnabled(false);        
    } 
}
