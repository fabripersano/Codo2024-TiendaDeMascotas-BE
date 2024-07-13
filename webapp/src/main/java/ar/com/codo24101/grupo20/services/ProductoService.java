package ar.com.codo24101.grupo20.services;

import java.util.List;

import ar.com.codo24101.grupo20.dao.ProductoDAO;
import ar.com.codo24101.grupo20.dao.ProductoJDBCMysqlImpl;
import ar.com.codo24101.grupo20.domain.Producto;
import ar.com.codo24101.grupo20.dto.ProductoDTO;

public class ProductoService {

    private ProductoDAO dao;

    public ProductoService() {
        this.dao = new ProductoJDBCMysqlImpl();
    }

    public Producto obtener(Long id) {
        return this.dao.getById(id);
    }

    public List<ProductoDTO> obtenerTodos() {
        return this.dao.getAllElements();
    }

    public void guardar(ProductoDTO dto) throws Exception {
        this.dao.createElement(dto);
    }

    public void actualizar(ProductoDTO dto) throws Exception {
        this.dao.updateElement(dto);
    }

}
