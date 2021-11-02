package modelo.daos;

public interface IntGraficasDao {
    
    void AgragarGrafica(String nombreArchivo, String marca, String modelo, int cantidad, double precio);
    void Listar (String nombreArchivo);
    void Buscar(String nombreArchivo, String buscar);
    void IniciarArchivo(String nombreArchivo);
    void Borrar(String nombreArchivo, String buscar);
    void PrecioTotal(String nombreArchivo);
    void MaxCantidad(String nombreArchivo);
    
}
