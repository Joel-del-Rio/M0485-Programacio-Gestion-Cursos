/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author joeli
 */
public class GestorAlumnos {

    private static String separador = File.separator;
    private static final String rutaBase = System.getProperty("user.dir") + separador + "src" + separador + "datos";

    public static ArrayList<Alumno> leerAlumnos(String curso) {
        ArrayList<Alumno> lista = new ArrayList<Alumno>();

        try {
            File archivo = new File(rutaBase + separador + curso + separador + "alumnos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                lista.add(Alumno.fromLine(linea));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

        return lista;
    }

    public static void anadirAlumno(String curso, Alumno alumno) {
        try {
            File archivo = new File(rutaBase + separador + curso + separador + "alumnos.txt");
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(alumno.toFile());
            bw.write(System.getProperty("line.separator"));
            bw.flush();
            bw.close();
            System.out.println("Alumno registrado correctamente");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void eliminarAlumno(String curso, Alumno alumno) {
        try {
            File archivo = new File(rutaBase + separador + curso + separador + "alumnos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            String contenido = "";
            
            while((linea = br.readLine()) != null){
                if(!linea.contains(alumno.getDni())){
                    contenido += linea + System.getProperty("line.separator");
                }
            }
            
            br.close();
            
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(contenido);
            bw.flush();
            bw.close();
            
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    
    public static Alumno buscarAlumno(String curso, String dni){
        try{
            File archivo = new File(rutaBase + separador + curso + separador + "alumnos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            
            while((linea = br.readLine()) != null){
                if(linea.contains(dni)){
                    br.close();
                    return Alumno.fromLine(linea);
                }
            }
            br.close();
        } catch (IOException e){
            System.out.println("Error");
        }
        return null;
    }
    
    public static boolean checkAlumno(String curso, String dni){
        try{
            File archivo = new File(rutaBase + separador + curso + separador + "alumnos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine()) != null){
                if(linea.contains(dni)){
                    br.close();
                    return false;
                }
            }
        } catch (IOException e){
            System.out.println("Error");
        }
        return true;
    }
    
    public static int contarAlumnosTotales(){
        int total = 0;
        
        for(String curso : GestorCursos.listarCursos()){
            total += leerAlumnos(curso).size();
        }
        return total;
    }
}