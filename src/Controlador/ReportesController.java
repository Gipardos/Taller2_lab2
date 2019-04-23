/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VentanaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author Nicole
 */
public class ReportesController implements ActionListener {

    private javax.swing.JComboBox<String> MesBox;
    private VentanaReportes vr;

    public ReportesController(JComboBox<String> MesBox, VentanaReportes vr) {
        this.MesBox = MesBox;
        this.vr = vr;
        MesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("imprimir")) {
            this.imprimir();
        }

        if (ae.getActionCommand().equals("cerrar")) {
            this.cerrar();
        }
    }
    
    private void imprimir() {
        System.out.println("Se está imprimiendo");
    }
    
    private void cerrar(){
        vr.setVisible(false);
    }


}
