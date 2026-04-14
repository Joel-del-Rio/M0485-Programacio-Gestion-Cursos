/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import app.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joeli
 */
public class GestorCursos {

    final static String rutaAbsoluta = System.getProperty("user.dir");
    final static String separador = File.separator;
    final static String src = rutaAbsoluta + separador + "src";
    final static String carpeta = src + separador + "datos";
    final static File carpetaNueva = new File(carpeta);

    public static ArrayList<String> listarCursos() {
        String[] nombres = carpetaNueva.list();
        ArrayList<String> cursos = new ArrayList<String>();

        if (nombres != null) {
            for (String n : nombres) {
                File f = new File(carpetaNueva, n);
                if (f.isDirectory()) {
                    cursos.add(n);
                }
            }
        }
        return cursos;
    }

    public static void crearCurso(String nombre) {
        try {
            String cursos = carpeta + separador + nombre;
            File curso = new File(cursos);
            String alumno = cursos + separador + "alumnos.txt";
            File alumnos = new File(alumno);

            if (!curso.exists()) {
                curso.mkdir();
                alumnos.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void eliminarCurso(String nombre) {
        String cursos = carpeta + separador + nombre;
        File curso = new File(cursos);
        if (curso.exists()) {
            String alumno = cursos + separador + "alumnos.txt";
            File alumnos = new File(alumno);
            alumnos.delete();
            curso.delete();
        } else {
            System.out.println("La carpeta no existe");
        }

    }
}