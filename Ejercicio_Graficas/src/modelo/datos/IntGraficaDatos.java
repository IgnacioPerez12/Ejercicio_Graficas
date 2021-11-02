package modelo.datos;

import java.util.*;
import modelo.beans.Grafica;
import modelo.excepciones.*;

public interface IntGraficaDatos {
    
    boolean Existe(String nombreArchivo) throws AccesoDatosEx;
    List <Grafica> Listar (String nombreArchivo) throws LecturaEx;
    void Escribir (Grafica grafica, String nombreArchivo, boolean anexar) throws EscrituraEx;
    String Buscar (String nombreArchivo, String buscar) throws LecturaEx;
    void Crear (String nombreArchivo) throws AccesoDatosEx;
    void Borrar (String nombreArchivo, String buscar);
    //double precioTotal (String nombreArchivo) throws LecturaEx;
    //int maxCantidad (String nombreArchivo) throws LecturaEx;
    
}