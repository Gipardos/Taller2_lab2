package Controlador;

import DAO.VentaDAO;
import Modelo.Vendedor;
import Modelo.Venta;
import Vista.RegistrarVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class VentaController implements ActionListener {

    private javax.swing.JComboBox<String> SucursalBox;
    private javax.swing.JComboBox<String> VendedorBox;
    private RegistrarVenta rv;

    public VentaController(RegistrarVenta rv) {        
        this.rv = rv;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("registrar")) {
            String sucursal = (String) rv.getSucursalBox().getSelectedItem();
            int monto = Integer.parseInt(rv.getjTextField2().getText());
            Date fecha = this.formatoFecha(rv.getjTextField1().getText());
            Vendedor v = (Vendedor) rv.getVendedorBox().getSelectedItem();
            VentaDAO vd = new VentaDAO();
            if (vd.añadirVenta(new Venta(0, sucursal, monto, fecha, v.getIdVendedor()))) {
                JOptionPane.showMessageDialog(null, "Venta ingresada con éxito", "Nueva Venta", JOptionPane.INFORMATION_MESSAGE);
                rv.dispose();
            }

        }
    }

    public Date formatoFecha(String strFecha) {
        Date fecha = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        try {
            fecha = formato.parse(strFecha);
        } catch (Exception e) {
            System.out.println(e);
        }
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
        return fechaSQL;

    }

}
