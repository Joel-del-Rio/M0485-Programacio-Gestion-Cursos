/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joeli
 */
public class Alumno {

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;

    public Alumno(String nombre, String apellido, int edad, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String toFile() {
        return nombre + ";" + apellido + ";" + edad + ";" + dni;
    }
    
    public static Alumno fromLine(String linea){
        String[] partes = linea.split(";");
        
        String nombre = partes[0];
        String apellido = partes[1];
        int edad = Integer.parseInt(partes[2]);
        String dni = partes[3];
        
        return new Alumno(nombre, apellido, edad, dni);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + dni + ")";
    }
}