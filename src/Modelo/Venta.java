
package Modelo;

public class Venta {
    private int idVenta;
    private String sucursal;
    private int monto;
    private String fecha;
    private int idVendedor;
    

    public Venta(int idVenta, String sucursal, int monto, String fecha, int idVendedor) {
        this.idVenta = idVenta;
        this.sucursal = sucursal;
        this.monto = monto;
        this.fecha = fecha;
        this.idVendedor = idVendedor;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public int getMonto() {
        return monto;
    }

    public String getFecha() {
        return fecha;
    }

    public int getIdVendedor() {
        return idVendedor;
    }
    
    
    
}
