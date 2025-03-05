CREATE TABLE cargo(
   id   SERIAL  PRIMARY KEY,
   nome VARCHAR NOT NULL
);

CREATE TABLE cargoDosUsuarios(
   id_usuario INTEGER,
   id_cargo INTEGER,
   PRIMARY KEY (id_usuario, id_cargo),
   CONSTRAINT fk_cargoDosUsuarios_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id),
   CONSTRAINT fk_cargoDosUsuarios_id_cargo FOREIGN KEY(id_cargo) REFERENCES cargo(id)
);