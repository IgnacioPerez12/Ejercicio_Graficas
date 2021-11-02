package modelo.beans;

import java.util.Objects;

public class Grafica {
    private String marca;
    private String modelo;
    private int cantidad;
    private double precio;
    
    //Contructor
    public Grafica() {
    }

    public Grafica(String marca, String modelo, int cantidad, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    //Getter and Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //ToString
    @Override
    public String toString() {
        return "Grafica{" + "marca=" + marca + ", modelo=" + modelo + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }    
    
}
