DROP DATABASE IF EXISTS TiendaMascotas;

CREATE DATABASE IF NOT EXISTS TiendaMascotas;

CREATE TABLE PRODUCTOS (
	ID int NOT NULL AUTO_INCREMENT,
    ProductoId int NOT NULL,
    Nombre varchar(100) NOT NULL,
    ImageUrl varchar(500),
    Descripcion varchar(500),
    Marca varchar(100),
    Precio float NOT NULL,
    Descuento float,
    Promocion varchar(100),
    PRIMARY KEY(ID)
);

INSERT INTO PRODUCTOS(ProductoId, Nombre, ImageUrl, Descripcion, Marca, Precio, Descuento, Promocion)
VALUES (3631, 'Royal Canin Fit 7.5 Kg', 'https://puppis.vteximg.com.br/arquivos/ids/196469-600-600/100138.jpg?v=638511567536070000',
	'Descripcion - Royal Canin Fit 7.5 Kg', 'Royal Canin', 6615000, null, null),
(3126, 'Alimento Excellent Urinary Arroz y Pollo para Gato', 'https://puppis.vteximg.com.br/arquivos/ids/196214-600-600/150029.jpg?v=638482808155070000',
	'Descripcion - Alimento Excellent Urinary Arroz y Pollo para Gato', 'DESCONOCIDA', 4909000, null, null),
(3088, 'Alimento Excellent Pollo Y Arroz para Gato', 'https://puppis.vteximg.com.br/arquivos/ids/196206-600-600/150019.jpg?v=638482805682400000',
	'Descripcion - Alimento Excellent Pollo Y Arroz para Gato', 'DESCONOCIDA', 2054000, null, null),
(62, 'Alimento Eukanuba Para Perro Adulto Raza Grande 15 Kg', 'https://puppis.vteximg.com.br/arquivos/ids/194767-600-600/138003-138002-8.jpg?v=638314170691530000',
	'Descripcion - Alimento Eukanuba Para Perro Adulto Raza Grande 15 Kg', 'DESCONOCIDA', 5370000, null, null),
(7120, 'Alimento Excellent Skin Care Cordero para Perro Adulto', 'https://puppis.vteximg.com.br/arquivos/ids/196576-600-600/150057-150056.jpg?v=638525039001270000',
	'Descripcion - Alimento Excellent Skin Care Cordero para Perro Adulto', 'DESCONOCIDA', 5269000, null, null),
(631, 'Alimento Maintenance Criadores Adulto', 'https://puppis.vteximg.com.br/arquivos/ids/158003-600-600/150002.png?v=635894318957130000',
	'Descripcion - Alimento Maintenance Criadores Adulto', 'DESCONOCIDA', 3005000, null, null),
(7832, 'Adorno Marina Cool Dibujo Estrella de Mar', 'https://puppis.vteximg.com.br/arquivos/ids/183646-600-600/228498.jpg?v=637710847870070000',
	'Descripcion - Adorno Marina Cool Dibujo Estrella de Mar', 'DESCONOCIDA', 380000, null, null),
(7687, 'Planta Pennplax Plástica Base Extra', 'https://puppis.vteximg.com.br/arquivos/ids/189599-600-600/251163.jpg?v=638005817318470000',
	'Descripcion - Planta Pennplax Plástica Base Extra', 'DESCONOCIDA', 1121000, null, null),
(7684, 'Aqua Plants Pennplax x6', 'https://puppis.vteximg.com.br/arquivos/ids/183250-600-600/251150.jpg?v=637698190610870000',
	'Descripcion - Aqua Plants Pennplax x6', 'DESCONOCIDA', 1308000, null, null),
(6089, 'Planta Pennplax Aqua', 'https://puppis.vteximg.com.br/arquivos/ids/176315-600-600/251146.jpg?v=637534369624330000',
	'Descripcion - Planta Pennplax Aqua', 'DESCONOCIDA', 3112000, null, null),
(3007, 'Stick Para Perico De Vegetales', 'https://puppis.vteximg.com.br/arquivos/ids/166846-600-600/242096.jpg?v=636957681272700000',
	'Descripcion - Stick Para Perico De Vegetales', 'DESCONOCIDA', 335000, null, null),
(9104, 'Tunel Para Aves', 'https://puppis.vteximg.com.br/arquivos/ids/166856-600-600/242107.jpg?v=636957681305730000',
	'Descripcion - Tunel Para Aves', 'DESCONOCIDA', 859000, null, null),
(3000, 'Stick De Vegetales Para Canario', 'https://puppis.vteximg.com.br/arquivos/ids/166839-600-600/242095.jpg?v=636957681246770000',
	'Descripcion - Stick De Vegetales Para Canario', 'DESCONOCIDA', 335000, null, null);
    
    
SELECT * FROM PRODUCTOS;