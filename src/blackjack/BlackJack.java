/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

import javax.swing.ImageIcon;
import vista.Vista;

/**
 *
 * @author Aprendiz Compras
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista v = new Vista();
        v.setVisible(true);
        v.setTitle("BLACKJACK");
        v.setIconImage(new ImageIcon(BlackJack.class.getResource("/icono.png")).getImage());
        v.setLocationRelativeTo(null);
    }
    
}
