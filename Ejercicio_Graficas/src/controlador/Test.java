package controlador;

import java.util.*;
import modelo.daos.GraficasDaoImpl;
import modelo.daos.IntGraficasDao;

public class Test {

    public static void main(String[] args) {
        
        System.out.println("----------------------------------\n" + "     LISTA DE GRAFICAS" + "\n----------------------------------");
        System.out.println("\nIntroduzca una opcion entre el 0 y 7");
        System.out.println("\n0. Salir\n" + "1. Crear Archivo\n" + "2. Agregar Grafica\n" + "3. Listar Graficas\n" + "4. Buscar Grafica\n" + "5. Total Precio\n" + "6. Total Cantidad Graficas\n"+ "7. Eliminar una Grafica en una linea\n");
        
        
        IntGraficasDao metodosGraficas = new GraficasDaoImpl();
        int entradaCaso;
        
        do {
            Scanner entrada = new Scanner(System.in);
            entradaCaso = entrada.nextInt();
            switch(entradaCaso){
           
                //SALIR
                case 0 :
                    System.out.println("FIN DEL PROGRAMA");
                   break;

                //CREAR ARCHIVO
                case 1 :
                    metodosGraficas.IniciarArchivo("Lote_Graficas_1.txt");
                    metodosGraficas.IniciarArchivo("Lote_Graficas_2.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;

                //AGREGAR GRAFICA
                case 2 :
                    metodosGraficas.AgragarGrafica("Lote_Graficas_1.txt", "NVIDEA", "Zotac gaming 1660", 2, 335.50);
                    metodosGraficas.AgragarGrafica("Lote_Graficas_1.txt", "GIGABYTE", "Giga gaming 3060", 1, 600.50);
                    metodosGraficas.AgragarGrafica("Lote_Graficas_1.txt", "ASUS", "TFG Titan 55x", 5, 740.202);
                    System.out.println("\n¿Que más quieres hacer?");

                   break;

                //LISTAR GRAFICAS
                case 3:
                    metodosGraficas.Listar("Lote_Graficas_1.txt");
                    System.out.println("\n¿Que más quieres hacer?");

                   break;

                //BUSCAR GRAFICAS
                case 4:
                    metodosGraficas.Buscar("Lote_Graficas_1.txt", "TFG Titan 55x");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;   
                
                //TOTAL PRECIO
                case 5:
                    metodosGraficas.PrecioTotal("Lote_Graficas_1.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;
                   
                //TOTAL CANTIDAD
                case 6:
                    metodosGraficas.MaxCantidad("Lote_Graficas_1.txt");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;
                   
                //ELIMINAR ARCHIVO
                case 7:
                    metodosGraficas.Borrar("Lote_Graficas_1.txt", "Giga gaming 3060");
                    System.out.println("\n¿Que más quieres hacer?");
                   break;

                default : 
                        System.out.println("Valor erroneo");
            }
            
        } while (entradaCaso != 0);
        
    }
    
}
