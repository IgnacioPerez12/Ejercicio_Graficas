package modelo.datos;

import modelo.beans.Grafica;
import java.io.*;
import java.util.*;
import modelo.excepciones.*;

public class GraficaDatosImpl implements IntGraficaDatos{

    static double total = 0.0;
    static int maxCant = 0;
    
    @Override
    public boolean Existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);      
        return archivo.exists();
    }

    @Override
    public List<Grafica> Listar(String nombreArchivo) throws LecturaEx{
        File archivo = new File(nombreArchivo);
        List<Grafica> lista = new ArrayList<Grafica>();
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            //String[] cadenaGrafica = lectura.split(";");
            while (lectura != null) {
                String[] cadenaGrafica = lectura.split(";");
                Grafica newGrafica = new Grafica(cadenaGrafica[0], cadenaGrafica[1], Integer.parseInt(cadenaGrafica[2]), Double.parseDouble(cadenaGrafica[3]));
                lista.add(newGrafica);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                throw new LecturaEx("Error de lectura listando las peliculas");
            } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    @Override
    public void Escribir(Grafica grafica, String nombreArchivo, boolean anexar) throws EscrituraEx{
        File archivo = new File(nombreArchivo);
        String cadena = grafica.getMarca() + ";" + grafica.getModelo() + ";" + grafica.getCantidad() + ";" + grafica.getPrecio();
        
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            
            salida.println(cadena);
            salida.close();
            System.out.println("Modificado el contenido con exito\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String Buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        String mensaje = "";
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            while (lectura != null) {
                String[] cadenaGrafica = lectura.split(";");
                linea = linea + 1;
                if(cadenaGrafica[1].equalsIgnoreCase(buscar)){
                    mensaje = "Nombre del archivo : " + nombreArchivo + "\n" + "Grafica : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }
                
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                System.out.println("La Grafica no esta en stock");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
        
        return mensaje;
    }

    @Override
    public void Crear(String nombreArchivo) throws EscrituraEx{
        File archivo = new File(nombreArchivo);
        
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado con exito el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            //throw new ExcepcionEscrituraEx("No se ha podido crear el archivo");
        }
    }

    @Override
    public void Borrar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            
            //Creamos el archivo
            PrintWriter salida = new PrintWriter(archivo);
            System.out.println("Se ha creado con exito el archivo");
            
            while (lectura != null) {
                String[] cadenaGrafica = lectura.split(";");
                
                if(cadenaGrafica[1].equalsIgnoreCase(buscar)){
                    lectura = entrada.readLine();
                    continue;
                }
                
                //Escribimos las lineas que no queremos eliminar
                salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(lectura);
                salida.close();
                
                //Pasamos a la siguiente linea
                lectura = entrada.readLine();
            }
            
            if(lectura == null) {
                if(archivo.exists() == true){
                    archivo.delete();
                    System.out.println("El archivo a sido eliminado");
                } else {
                    System.out.println("El archivo que quieres eliminar no existe");
                }
                System.out.println("Se han eliminado las lineas");
            }
            
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                System.out.println("Error al leerlo");
            } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("No se ha encontrado el archivo");
        }
    }

/*    
    @Override
    public double precioTotal(String nombreArchivo) throws LecturaEx{
        File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            while (lectura != null) {
                String[] cadenaGrafica = lectura.split(";");
                total = total + Double.parseDouble(cadenaGrafica[3]);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                throw new LecturaEx("Error de lectura listando las peliculas");
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        return total;
    }

    @Override
    public int maxCantidad(String nombreArchivo) throws LecturaEx{
        File archivo = new File(nombreArchivo);
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            var lectura = entrada.readLine();
            while (lectura != null) {
                String[] cadenaGrafica = lectura.split(";");
                maxCant = maxCant + Integer.parseInt(cadenaGrafica[2]);
                lectura = entrada.readLine();
            }
            entrada.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
                throw new LecturaEx("Error de lectura listando las peliculas");
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        return maxCant;
    }
*/
}
