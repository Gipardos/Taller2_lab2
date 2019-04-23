
package DAO;

import modelo.Conexion;
import Modelo.Vendedor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorDAO {
    Conexion con;

    public VendedorDAO() {
        this.con = new Conexion();
    }
    
    public ArrayList<Vendedor> getVendedor(){
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        Connection taller2 = con.getConexion();
        
        try{
            String sql = "SELECT * FROM vendedor";
            Statement st = taller2.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
            while(resultados.next()){
                int id_vendedor = Integer.parseInt(resultados.getString("id_vendedor"));
                String nombre = resultados.getString("nombre");
                String apellido = resultados.getString("apellido");
                String rut = resultados.getString("rut");
                vendedores.add(new Vendedor(id_vendedor, nombre, apellido, rut));
            }
            taller2.close();
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

