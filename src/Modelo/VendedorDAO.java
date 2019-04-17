
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class VendedorDAO {
    
    Conexion con;

    public VendedorDAO(Conexion con) {
        this.con = con;
    }
   
    
     public ArrayList<Vendedor>Vendedores; 
     
     Connection accesoBD = con.getConexion();
     try{
            String sql="SELECT * FROM credencial ";
            
            //System.out.println(sql);
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);
            
               while ( resultados.next() ) {
                String  = resultados.getString("usuario");
                String pass = resultados.getString("pass");
                int idCuenta = Integer.parseInt(resultados.getString("idcuenta"));
                credenciales.add(new Credencial(user, pass,idCuenta));
            }
    
     
}
