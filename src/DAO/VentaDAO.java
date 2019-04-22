
package DAO;

import Modelo.Conexion;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VentaDAO {
    Conexion con;

    public VentaDAO(Conexion con) {
        this.con = con;
    }
    
    public ArrayList<Venta> getVenta(String mes){
        ArrayList<Venta> ventas = new ArrayList<>();
        Connection accesoBD = con.getConexion();
        
        try{
            String sql = "SELECT * FROM venta WHERE fecha BETWEEN '2019-" + mes + "-01' and '2019-" + mes + "-31'";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while(resultados.next()){
                int id_venta = Integer.parseInt(resultados.getString("id venta"));
                String sucursal = resultados.getString("sucursal");
                int monto = Integer.parseInt(resultados.getString("monto"));
                String fecha = resultados.getString("fecha");
                int id_vendedor = Integer.parseInt(resultados.getString("id vendedor"));
                ventas.add(new Venta(id_venta, sucursal, monto, fecha, id_vendedor));
            }
            accesoBD.close();
            return ventas;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean añadirVenta(Venta v) {
        boolean respuesta = false;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "INSERT INTO venta VALUES ( NULL ,'" + v.getSucursal() + "', '" + v.getMonto() + "', '" + v.getFecha() + "','" + v.getIdVendedor() + "')";
            Statement st = accesoBD.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
        }
        return respuesta;
    }
    
    public ArrayList<Integer> getVentasMejorVendedor(String mes) {
        ArrayList<Integer> ventasMejorVendedor = new ArrayList<>();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT id_vendedor, SUM(monto) AS total FROM venta WHERE fecha BETWEEN '2019-" + mes + "-01' and '2019-" + mes + "-31' Group By id_vendedor order BY total DESC";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                int idMejorVendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                int totalMejorVendedor = Integer.parseInt(resultados.getString("total"));
                ventasMejorVendedor.add(idMejorVendedor);
                ventasMejorVendedor.add(totalMejorVendedor);
            }            
            return ventasMejorVendedor;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }

    }
}
