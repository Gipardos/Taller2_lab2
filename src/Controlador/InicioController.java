/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; 
import Modelo.Vendedor;
import DAO.VendedorDAO;
import vista.VentanaInicio; 
import Vista.RegistrarVenta;
import Vista.VentanaReportes;


public class InicioController implements ActionListener {

    public InicioController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VendedorDAO vd = new VendedorDAO();        
        ArrayList<Vendedor> vendedores = new ArrayList();
        vendedores = vd.getVendedor();
        if (e.getActionCommand().equals("registrar")) {
            RegistrarVenta registrarVenta = new RegistrarVenta();
            DefaultComboBoxModel model = new DefaultComboBoxModel();

            for (int i = 0; i < vendedores.size(); i++) {
                model.addElement(vendedores.get(i));
            }

            registrarVenta.getVendedorBox().setModel(model);
            registrarVenta.setVisible(true);
        }

        if (e.getActionCommand().equals("reporte")) {
            VentanaReportes reporte = new VentanaReportes(); 
            reporte.setVisible(true);
        }

    }
}
