package ar.com.codo24101.grupo20;

import ar.com.codo24101.grupo20.services.ProductoService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Long idProducto = 1L;

        ProductoService service = new ProductoService();

        System.out.println(service.obtener(idProducto).toString());
    }
}
