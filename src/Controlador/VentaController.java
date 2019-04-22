/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.RegistrarVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class VentaController implements ActionListener{
    private javax.swing.JComboBox<String> SucursalBox;
    private javax.swing.JComboBox<String> VendedorBox;
    private RegistrarVenta rv;

    public VentaController(JComboBox<String> SucursalBox, JComboBox<String> VendedorBox, RegistrarVenta rv) {
        this.SucursalBox = SucursalBox;
        this.VendedorBox = VendedorBox;
        this.rv = rv;
        SucursalBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro", "Portal", "Lider", "Jumbo" }));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       
}
