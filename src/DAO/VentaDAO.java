
package DAO;

import modelo.Conexion;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VentaDAO {
    Conexion con;

    public VentaDAO() {
        this.con = new Conexion();
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
                Date fecha = resultados.getDate("fecha");
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
        Connection taller2 = con.getConexion();

        try {
            String sql = "INSERT INTO venta VALUES ( NULL ,'" + v.getSucursal() + "', '" + v.getMonto() + "', '" + v.getFecha() + "','" + v.getIdVendedor() + "')";
            Statement st = taller2.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
        }
        return respuesta;
    }
}
