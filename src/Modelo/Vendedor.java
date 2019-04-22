
package Modelo;

public class Vendedor {
    private int idVendedor;
    private String nombre;
    private String apellido;
    private String rut;

    public Vendedor(int idVendedor, String nombre, String apellido, String rut) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

   
    
}
