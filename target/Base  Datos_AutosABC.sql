
create table usuario(
	usuario_id int not null,
	name varchar(50) not null,
	contrasena int not null,
	telefono int not null,
	correo varchar(30) not null,
	sueldo int not null,
	cargo varchar(20) not null,
	estado varchar(10) not null,
	fecha_registro varchar(20) not null,
    PRIMARY KEY (usuario_id)
);


create table sede(
    sede_id int not null,
	usuario_id int not null,
	nombre varchar(30) not null,
	ciudad varchar(30) not null,
    PRIMARY KEY (sede_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);


create table gerente(
	gerente_id int not null,
	sede_id int not null,
    PRIMARY KEY (gerente_id),
	FOREIGN KEY (gerente_id) REFERENCES usuario(usuario_id),
	FOREIGN KEY (sede_id) REFERENCES sede(sede_id)
);


create table vendedor(
	vendedor_id int not null,
	gerente_id int not null,
	numero_ventas integer not null,
    PRIMARY KEY (vendedor_id),
	FOREIGN KEY (vendedor_id) REFERENCES usuario(usuario_id),
	FOREIGN KEY (gerente_id) REFERENCES gerente(gerente_id)
);


create table jefe_taller(
	jefe_taller_id int not null,
	gerente_id int not null,
	numero_autos_reparados integer not null,
    PRIMARY KEY (jefe_taller_id),
	FOREIGN KEY (jefe_taller_id) REFERENCES usuario(usuario_id),
	FOREIGN KEY (gerente_id) REFERENCES gerente(gerente_id)
);



create table cliente(
    cliente_id int not null,
	name varchar(30) not null,
	telefono integer not null,
	direccion varchar(30) not null,
	entidad varchar(20),
    PRIMARY KEY (cliente_id) 
);

create table auto(
    auto_id int not null,
	color varchar(30) not null,
	marca varchar(30) not null,
	año integer not null,
	modelo varchar(30) not null,
    PRIMARY KEY (auto_id) 
);

create table cliente_auto_reparar(
	cliente_id int not null,
	auto_id int not null,
    PRIMARY KEY (cliente_id, auto_id),
	FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id),
	FOREIGN KEY (auto_id) REFERENCES auto(auto_id)
);


create table auto_venta(
    auto_id int not null,
	sede_id int not null,
	translado_id int not null,
	precio integer not null,
    PRIMARY KEY (auto_id),
	FOREIGN KEY (auto_id) REFERENCES auto(auto_id)

);


create table auto_reparar(
    auto_id int not null,
	placa varchar(30) not null,
	estimacion_daño varchar not null,
    PRIMARY KEY (auto_id),
	FOREIGN KEY (auto_id) REFERENCES auto(auto_id)
);


create table Venta(
    Venta_id int not null,
	auto_id int not null,
	usuario_id int not null,
	cliente_id  int not null,
	comision_vendedor  int not null,
	fecha_venta varchar(30) not null,
    PRIMARY KEY (Venta_id), 
	FOREIGN KEY (auto_id) REFERENCES auto(auto_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id),
	FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id)
);



create table orden_trabajo(
    orden_id int not null,
	cliente_id int not null,
	auto_id int not null,
	jefe_taller_id int not null,
	descripcion varchar not null,
	precio_reparacion integer not null,
	fecha_reparacion integer not null,
	comision_jefe_taller integer not null,
    PRIMARY KEY (orden_id),
	FOREIGN KEY (auto_id) REFERENCES auto(auto_id),
	FOREIGN KEY (cliente_id) REFERENCES cliente(cliente_id),
	FOREIGN KEY (jefe_taller_id) REFERENCES jefe_taller(jefe_taller_id)
);



create table repuesto(
	repuesto_id int not null,
	sede_id int not null,
	precio integer not null,
	nombre varchar(30) not null,
    PRIMARY KEY (repuesto_id),
	FOREIGN KEY (sede_id) REFERENCES sede(sede_id)
);


create table repuesto_inventario(
	repuesto_inventario_id int not null,
	repuesto_id int not null,
	jefe_taller_id int not null,
	fecha_registro varchar(30) not null,
	cantidad_disponible integer not null,
    PRIMARY KEY (repuesto_inventario_id),
	FOREIGN KEY (repuesto_id) REFERENCES repuesto(repuesto_id),
	FOREIGN KEY (jefe_taller_id) REFERENCES jefe_taller(jefe_taller_id)
);


create table repuesto_orden(
	repuesto_inventario_id int not null,
	orden_id int not null,
	cantidad integer not null,
    PRIMARY KEY (repuesto_inventario_id, orden_id ),
	FOREIGN KEY (orden_id) REFERENCES orden(orden_id),
	FOREIGN KEY (repuesto_inventario_id) REFERENCES repuesto_inventario(repuesto_inventario_id)
);




create table tramite_translado(
    translado_id int not null,
	auto_id  int not null,
	vendedor_id int not null,
	gerente_id int not null,
	sede_id  int not null,
	estado varchar(30) not null,
	fecha_translado varchar(30) not null,
    PRIMARY KEY (translado_id),
	FOREIGN KEY (vendedor_id) REFERENCES vendedor(vendedor_id),
	FOREIGN KEY (gerente_id) REFERENCES gerente(gerente_id),
	FOREIGN KEY (auto_id) REFERENCES auto(auto_id),
	FOREIGN KEY (sede_id) REFERENCES sede(sede_id)
);
