package ar.com.codo24101.grupo20.dao;

import java.util.List;

import ar.com.codo24101.grupo20.domain.Producto;
import ar.com.codo24101.grupo20.dto.ProductoDTO;

public interface ProductoDAO {

    Producto getById(Long id);

    void createElement(ProductoDTO element) throws Exception;

    // void deleteById(Integer id);

    void updateElement(ProductoDTO element) throws Exception;

    List<ProductoDTO> getAllElements();

}
