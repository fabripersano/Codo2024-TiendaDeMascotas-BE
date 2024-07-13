package ar.com.codo24101.grupo20.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.codo24101.grupo20.dto.ProductoDTO;
import ar.com.codo24101.grupo20.services.ProductoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/productos")
public class ProductosController extends HttpServlet {

    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //     Long idProducto = 1L;
    //     ProductoService service = new ProductoService();
    //     // System.out.println(service.obtener(idProducto).toString());

    //     ObjectMapper mapper = new ObjectMapper();
    //     // convierto objeto java a json string  
    //     String jsonResult = mapper.writeValueAsString(service.obtener(idProducto));

    //     resp.getWriter().println(jsonResult);

    //     // TODO Auto-generated method stub
    //     // super.doGet(req, resp);
    // }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoService();
        // System.out.println(service.obtener(idProducto).toString());

        ObjectMapper mapper = new ObjectMapper();
        // convierto objeto java a json string  
        String jsonResult = mapper.writeValueAsString(service.obtenerTodos());

        resp.getWriter().println(jsonResult);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean success = false;
        // el json que viene se atrapa asi
        String json = req.getReader()
            .lines()
            .collect(Collectors.joining(System.lineSeparator()));

        ObjectMapper mapper = new ObjectMapper();
        ProductoDTO dto = mapper.readValue(json, ProductoDTO.class);
        ProductoService service = new ProductoService();
        try {
            service.guardar(dto);
            success = true;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

        resp.getWriter().println("{ success: "+ success +" }");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean success = false;
        // el json que viene se atrapa asi
        String json = req.getReader()
            .lines()
            .collect(Collectors.joining(System.lineSeparator()));

        ObjectMapper mapper = new ObjectMapper();
        ProductoDTO dto = mapper.readValue(json, ProductoDTO.class);
        ProductoService service = new ProductoService();
        try {
            service.actualizar(dto);
            success = true;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

        resp.getWriter().println("{ 'success': "+ success +" }");
    }


}
