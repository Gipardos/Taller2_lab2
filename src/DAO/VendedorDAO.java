
package DAO;

import Modelo.Conexion;
import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorDAO {
    Conexion con;

    public VendedorDAO(Conexion con) {
        this.con = con;
    }
    
    public ArrayList<Vendedor> getVendedor(){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        Connection accesoBD = con.getConexion();
        
        try{
            String sql = "SELECT * FROM vendedor";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while(resultados.next()){
                int id_vendedor = Integer.parseInt(resultados.getString("id cuenta"));
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String rut = resultados.getString("rut");
                vendedores.add(new Vendedor(id_vendedor, nombre, apellido, rut));
            }
            accesoBD.close();
            return vendedores;
        }catch (Exception e){
            System.out.println();
            System.out.println("Error al obtener");
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean añadirVendedor(Vendedor v) {
        boolean respuesta = false;
        Connection accesoBD = con.getConexion();

        try {
            String sql = "INSERT INTO vendedor VALUES ( NULL ,'" + v.getNombre() + "', '" + v.getApellido() + "', '" + v.getRut() + "')";
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
}
