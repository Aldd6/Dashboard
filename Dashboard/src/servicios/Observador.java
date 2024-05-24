package servicios;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Daniel Aldana(DaS6T)
 */

import javax.swing.JInternalFrame;

public class Observador {
    private static JInternalFrame observador;
    
    public static void initObservador(JInternalFrame frame) {
        observador = frame;
    }
    
    public static void closeObservador() {
        if(observador != null) {
            observador.dispose();
        }
    }
}
