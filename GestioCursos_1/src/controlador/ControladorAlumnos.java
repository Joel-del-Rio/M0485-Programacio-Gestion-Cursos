/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import modelo.Alumno;
import vista.VentanaCurso;

/**
 *
 * @author joeli
 */
public class ControladorAlumnos {

    private VentanaCurso vista;
    private String curso;

    public ControladorAlumnos(VentanaCurso vista, String curso) {
        this.vista = vista;
        this.curso = curso;
    }

    public void anadirAlumno() {
        String nombre = vista.getNombre();
        String apellido = vista.getApellido();
        String edadTexto = vista.getEdad();
        String dni = vista.getDni();

        if (nombre.isEmpty() || apellido.isEmpty() || edadTexto.isEmpty() || dni.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios");
        } else {
            if (modelo.GestorAlumnos.checkAlumno(curso, dni)) {
                int edad = Integer.parseInt(edadTexto);
                Alumno alumno = new Alumno(nombre, apellido, edad, dni);
                modelo.GestorAlumnos.anadirAlumno(curso, alumno);
                cargarAlumnos();
                limpiarCampos();
            } else {
                System.out.println("El DNI ya existe.");
            }
        }
    }

    public void eliminarAlumno() {
        String dni = vista.getDni();

        if (dni.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Introduce un DNI para eliminar el alumno");
        } else {
            Alumno alumno = modelo.GestorAlumnos.buscarAlumno(curso, dni);
            if (alumno == null) {
                javax.swing.JOptionPane.showMessageDialog(vista, "No existe ningun alumno con ese DNI");
            } else {
                int opc = javax.swing.JOptionPane.showConfirmDialog(vista,
                        "¿Seguro que deseas eliminar el alumno " + alumno.getNombre() + " " + alumno.getApellido() + "?",
                        "Confirma eliminacion",
                        javax.swing.JOptionPane.YES_NO_OPTION
                );

                if (opc == javax.swing.JOptionPane.YES_NO_OPTION) {
                    modelo.GestorAlumnos.eliminarAlumno(curso, alumno);
                    cargarAlumnos();
                    limpiarCampos();
                }
            }
        }
    }

    public void buscarAlumno() {
        String dni = vista.getDni();

        if (dni.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Introduce el DNI del alumno que busques");
        } else {
            Alumno alumno = modelo.GestorAlumnos.buscarAlumno(curso, dni);
            if (alumno == null) {
                javax.swing.JOptionPane.showMessageDialog(vista, "No existe ningun alumno con ese DNI");
            } else {
                String mensaje = "Nombre: " + alumno.getNombre() + "\n"
                        + "Apellido: " + alumno.getApellido() + "\n"
                        + "Edad: " + alumno.getEdad() + "\n"
                        + "DNI: " + alumno.getDni();
                javax.swing.JOptionPane.showMessageDialog(vista, 
                        mensaje,
                        "Datos del alumno",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }
    
    public void back(){
        vista.getPrincipal().setVisible(true);
        vista.getPrincipal().actualizarNumeroAlumnos();
        vista.setVisible(false);
    }

    public void cargarAlumnos() {
        vista.getModeloLista().clear();

        for (Alumno alumno : modelo.GestorAlumnos.leerAlumnos(curso)) {
            vista.getModeloLista().addElement(alumno.toString());
        }
    }

    public void limpiarCampos() {
        vista.getNombreField().setText("");
        vista.getApellidoField().setText("");
        vista.getEdadField().setText("");
        vista.getDniField().setText("");
    }

}