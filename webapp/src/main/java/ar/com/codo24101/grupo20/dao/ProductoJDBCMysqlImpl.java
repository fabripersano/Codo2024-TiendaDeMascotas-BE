package ar.com.codo24101.grupo20.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ar.com.codo24101.grupo20.domain.Producto;
import ar.com.codo24101.grupo20.dto.ProductoDTO;

public class ProductoJDBCMysqlImpl implements ProductoDAO {

    @Override
    public Producto getById(Long id) {
        String sql = "SELECT * FROM PRODUCTOS WHERE ID = " + id;

        Producto prod = null;
        Connection connection = null;

        try {
            connection = AdministradorDeConexiones.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                Long newId = result.getLong("ID");
                Integer productoId = result.getInt("ProductoId");
                String nombre = result.getString("Nombre");
                String imageUrl = result.getString("ImageUrl");
                String descripcion = result.getString("Descripcion");
                String marca = result.getString("Marca");
                float precio = result.getFloat("Precio");
                float descuento = result.getFloat("Descuento");
                String promocion = result.getString("Promocion");
                prod = new Producto(newId, productoId, nombre, imageUrl, descripcion, marca, precio, descuento, promocion);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        finally {
            AdministradorDeConexiones.desconectar(connection);
        }

        return prod;
    }

    private boolean isProductIdRepeated(Integer productId, Long id) {
        String sql = "SELECT * FROM PRODUCTOS WHERE ProductoId = " + productId + " AND ID <> " + id;
        System.err.println(sql);

        Connection connection = null;
        Integer totalResults = 0;

        try {
            connection = AdministradorDeConexiones.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                totalResults++;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        finally {
            AdministradorDeConexiones.desconectar(connection);
        }

        return totalResults >= 1;
    }

    private void validarActualizarProducto(ProductoDTO input) throws Exception{
        if(Objects.isNull(input) || Objects.isNull(input.getId()) || input.getId() < 0 ) {
            throw new Exception("El id del producto no puede faltar para actualizar un producto");
        }
        if(isProductIdRepeated(input.getProductoId(), input.getId())) {
            throw new Exception("Ya existe otro producto con el producto ID = " + input.getProductoId());
        }
    }

    private void validarCrearProducto(ProductoDTO input) throws Exception{
        if(Objects.isNull(input) || input.getNombre().isBlank() || Objects.isNull(input.getPrecio()) 
            || input.getImageUrl().isBlank()) {
            throw new Exception("Los siguientes datos son mandatorios: nombre, precio, imagen URL");
        }
        if(input.getPrecio() <= 0.009) {
            throw new Exception("El precio debe ser mayor a $0.00");
        }
    }

    @Override
    public void createElement(ProductoDTO element) throws Exception {
        validarCrearProducto(element);
        String sql = "INSERT INTO PRODUCTOS (ProductoId, Nombre, ImageUrl, Descripcion, Marca, Precio, Descuento, Promocion) "+
        "VALUES(?,?,?,?,?,?,?,?)";


        Connection connection = null;

        try {
            connection = AdministradorDeConexiones.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, element.getProductoId());
            statement.setString(2, element.getNombre());
            statement.setString(3, element.getImageUrl());
            statement.setString(4, element.getDescripcion());
            statement.setString(5, element.getMarca());
            statement.setFloat(6, element.getPrecio());
            statement.setFloat(7, element.getDescuento());
            statement.setString(8, element.getPromocion());
            statement.executeUpdate();

            if(statement.getUpdateCount() > 0 ) {
                System.out.println("insert ok");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

    @Override
    public List<ProductoDTO> getAllElements() {
        List<ProductoDTO> dtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTOS";
        Connection connection = null;

        try {
            connection = AdministradorDeConexiones.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while(result.next()) {
                Integer productoId = result.getInt("ProductoId");
                String nombre = result.getString("Nombre");
                String imageUrl = result.getString("ImageUrl");
                String descripcion = result.getString("Descripcion");
                String marca = result.getString("Marca");
                float precio = result.getFloat("Precio");
                float descuento = result.getFloat("Descuento");
                String promocion = result.getString("Promocion");

                ProductoDTO dto = new ProductoDTO();
                dto.setId(result.getLong("ID"));
                dto.setProductoId(productoId);
                dto.setNombre(nombre);
                dto.setImageUrl(imageUrl);
                dto.setDescripcion(descripcion);
                dto.setMarca(marca);
                dto.setPrecio(precio);
                dto.setDescuento(descuento);
                dto.setPromocion(promocion);
                dtos.add(dto);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        finally {
            AdministradorDeConexiones.desconectar(connection);
        }

        return dtos;
    }

    @Override
    public void updateElement(ProductoDTO element) throws Exception {
        validarCrearProducto(element);
        validarActualizarProducto(element);
        String sql = "UPDATE PRODUCTOS" + 
            " SET ProductoId = ?, Nombre = ?, ImageUrl = ?, Descripcion = ?, Marca = ?, Precio = ?, Descuento = ?, Promocion = ? "+
        "WHERE ID = ?";


        Connection connection = null;

        try {
            connection = AdministradorDeConexiones.conectar();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, element.getProductoId());
            statement.setString(2, element.getNombre());
            statement.setString(3, element.getImageUrl());
            statement.setString(4, element.getDescripcion());
            statement.setString(5, element.getMarca());
            statement.setFloat(6, element.getPrecio());
            statement.setFloat(7, element.getDescuento());
            statement.setString(8, element.getPromocion());
            statement.setLong(9, element.getId());
            statement.executeUpdate();

            if(statement.getUpdateCount() > 0 ) {
                System.out.println("update ok");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }
        finally {
            AdministradorDeConexiones.desconectar(connection);
        }
    }

}
