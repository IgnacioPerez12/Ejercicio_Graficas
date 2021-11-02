package modelo.daos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.beans.Grafica;
import modelo.datos.GraficaDatosImpl;
import modelo.datos.IntGraficaDatos;
import modelo.excepciones.*;

public class GraficasDaoImpl implements IntGraficasDao{

    private final IntGraficaDatos datos;
    private double total = 0;
    private int cantidad = 0;
    List<Grafica> lista;
    
    //Constructor
    public GraficasDaoImpl() {
        this.datos = new GraficaDatosImpl();
    }
    
    
    @Override
    public void AgragarGrafica(String nombreArchivo, String marca, String modelo, int cantidad, double precio) {
        try {
            Grafica newGrafica = new Grafica(marca, modelo, cantidad, precio);
            if(datos.Existe(nombreArchivo) == true){
                datos.Escribir(newGrafica, nombreArchivo, true);
            } else {
                System.out.println("El archivo no existe");
            }
            
        } catch (EscrituraEx ex) {
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void Listar(String nombreArchivo) {
        //List<Grafica> lista;
        try {
            lista = datos.Listar(nombreArchivo);
            lista.forEach(grafica -> {
                System.out.println("Grafica: " + grafica.getMarca() +" | "+ grafica.getModelo() +" | Cantidad: "+ grafica.getCantidad() +" | Precio: "+ grafica.getPrecio());
            });
            
        } catch (LecturaEx e) {
            System.out.println("Error leyendo el catalogo");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void Buscar(String nombreArchivo, String buscar) {
        try {
            System.out.println(datos.Buscar(nombreArchivo, buscar));
        } catch (LecturaEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void IniciarArchivo(String nombreArchivo) {
        try {
            if(datos.Existe(nombreArchivo) == false){
                datos.Crear(nombreArchivo);
            } else {
                System.out.println("El archivo ya existe");
            }
            
        } catch (AccesoDatosEx e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void Borrar(String nombreArchivo,String buscar) {
        datos.Borrar(nombreArchivo, buscar);
        System.out.println("Catalogo eliminado con exito");
    }


    @Override
    public void PrecioTotal(String nombreArchivo) {
        try {
            lista = datos.Listar(nombreArchivo);
            total = 0;
            lista.forEach(grafica -> {
                var precio = grafica.getPrecio();
                total = total + precio;
            });
            System.out.println("Precio total de las graficas: " + total+"€");
            //System.out.println("Precio total de las graficas: " + datos.precioTotal(nombreArchivo)+"€");
        } catch (LecturaEx ex) {
            Logger.getLogger(GraficasDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void MaxCantidad(String nombreArchivo) {
        try {
            lista = datos.Listar(nombreArchivo);
            cantidad = 0;
            lista.forEach(grafica -> {
                var cant = grafica.getCantidad();
                cantidad = cantidad + cant;
            });
            System.out.println("Cantidad de graficas: " + cantidad);
            //System.out.println("Cantidad de graficas: " + datos.maxCantidad(nombreArchivo));
        } catch (LecturaEx ex) {
            Logger.getLogger(GraficasDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
