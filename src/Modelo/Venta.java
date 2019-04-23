
package Modelo;

import java.util.Date;

public class Venta {
    private int idVenta;
    private String sucursal;
    private int monto;
    private Date fecha;
    private int idVendedor; 
    

    public Venta(int idVenta, String sucursal, int monto, Date fecha, int idVendedor) {
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

    public Date getFecha() {
        return fecha;
    }

    public int getIdVendedor() {
        return idVendedor;
    }
    
    
    
}
