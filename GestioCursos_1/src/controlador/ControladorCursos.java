/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JOptionPane;
import modelo.GestorCursos;
import vista.VentanaCurso;
import vista.VentanaPrincipal;

/**
 *
 * @author joeli
 */
public class ControladorCursos {

    private VentanaPrincipal vista;

    public ControladorCursos(VentanaPrincipal vista) {
        this.vista = vista;
    }

    public void crearCurso() {
        String nombre = JOptionPane.showInputDialog("Nombre del curso");

        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Nombre invalido");
        } else if (modelo.GestorCursos.listarCursos().contains(nombre)) {
            JOptionPane.showMessageDialog(vista, "El curso ya existe");
        } else {
            GestorCursos.crearCurso(nombre);
            vista.cargarCursos();
        }
    }

    public void eliminarCurso() {
        String nombre = vista.getCursoSeleccionado();

        if (nombre == null) {
            JOptionPane.showMessageDialog(vista, "Selecciona un curso");
        } else {
            GestorCursos.eliminarCurso(nombre);
            vista.cargarCursos();
        }
    }

    public void abrirCurso() {
        String curso = vista.getCursoSeleccionado();

        if (curso == null) {
            JOptionPane.showMessageDialog(vista, "Selecciona un curso");
        } else {
            VentanaCurso dialog = new VentanaCurso(curso, vista);
            vista.setVisible(false);
            dialog.setLocationRelativeTo(vista);
            dialog.setVisible(true);
        }
    }
}