package ar.com.codo24101.grupo20.domain;

public class Producto {

    private Long Id;
    private Integer ProductoId;
    private String Nombre;
    private String ImageUrl;
    private String Descripcion;
    private String Marca;
    private float Precio;
    private float Descuento;
    private String Promocion;

    

    public Producto(Long id, Integer productoId, String nombre, String imageUrl, String descripcion, String marca,
            float precio, float descuento, String promocion) {
        this.Id = id;
        this.ProductoId = productoId;
        this.Nombre = nombre;
        this.ImageUrl = imageUrl;
        this.Descripcion = descripcion;
        this.Marca = marca;
        this.Precio = precio;
        this.Descuento = descuento;
        this.Promocion = promocion;
    }

    public Producto(Integer productoId, String nombre, String imageUrl, String descripcion, String marca, float precio,
            float descuento, String promocion) {
        this.ProductoId = productoId;
        this.Nombre = nombre;
        this.ImageUrl = imageUrl;
        this.Descripcion = descripcion;
        this.Marca = marca;
        this.Precio = precio;
        this.Descuento = descuento;
        this.Promocion = promocion;
    }




    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public Integer getProductoId() {
        return ProductoId;
    }
    public void setProductoId(Integer productoId) {
        ProductoId = productoId;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getImageUrl() {
        return ImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public float getPrecio() {
        return Precio;
    }
    public void setPrecio(float precio) {
        Precio = precio;
    }
    public float getDescuento() {
        return Descuento;
    }
    public void setDescuento(float descuento) {
        Descuento = descuento;
    }
    public String getPromocion() {
        return Promocion;
    }
    public void setPromocion(String promocion) {
        Promocion = promocion;
    }

    @Override
    public String toString() {
        return "Producto [Id=" + Id + ", ProductoId=" + ProductoId + ", Nombre=" + Nombre + ", ImageUrl=" + ImageUrl
                + ", Descripcion=" + Descripcion + ", Marca=" + Marca + ", Precio=" + Precio + ", Descuento="
                + Descuento + ", Promocion=" + Promocion + "]";
    }

    

}
