/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.io.File;
import java.io.IOException;
import vista.VentanaPrincipal;

/**
 *
 * @author joeli
 */
public class Main {

    final static String rutaAbsoluta = System.getProperty("user.dir");
    final static String separador = File.separator;
    final static String src = rutaAbsoluta + separador + "src";
    final static String carpeta = src + separador + "datos";
    final static File carpetaNueva = new File(carpeta);
    final static String carpetaDAM = carpeta + separador + "dam";
    final static String carpetaDAW = carpeta + separador + "daw";
    final static File dam = new File(carpetaDAM);
    final static File daw = new File(carpetaDAW);
    final static File alumnosDAM = new File(carpetaDAM + separador + "alumnos.txt");
    final static File alumnosDAW = new File(carpetaDAW + separador + "alumnos.txt");

    public static void start() {
        try {
            

            if (!carpetaNueva.exists()) {
                carpetaNueva.mkdir();
            }

            if (!dam.exists()) {
                dam.mkdir();
            }

            if (!daw.exists()) {
                daw.mkdir();
            }

            if (!alumnosDAM.exists()) {
                alumnosDAM.createNewFile();
            }

            if (!alumnosDAW.exists()) {
                alumnosDAW.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] agrs) {
        start();
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
        
    }
}