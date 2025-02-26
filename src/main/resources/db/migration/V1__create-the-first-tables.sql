CREATE TABLE usuario(
   id                   SERIAL  PRIMARY KEY,
   email                VARCHAR NOT NULL UNIQUE,
   senha                VARCHAR NOT NULL,
   status               CHAR(1) NOT NULL,
   criado_em            TIMESTAMP,
   atualizado_em        TIMESTAMP,
   atualizado_por       INTEGER REFERENCES usuario(id)
);

CREATE TABLE pessoa (
   id                SERIAL PRIMARY KEY,
   nome              VARCHAR NOT NULL,
   cpf               VARCHAR NOT NULL UNIQUE,
   data_nascimento   DATE NOT NULL,
   criado_em         TIMESTAMP,
   atualizado_em     TIMESTAMP,
   usuario_id        INTEGER,
   atualizado_por    INTEGER,
   CONSTRAINT fk_pessoa_atualizado_por FOREIGN KEY (atualizado_por) REFERENCES usuario(id),
   CONSTRAINT fk_pessoa_usuario_id     FOREIGN KEY (usuario_id)     REFERENCES usuario(id)
);

CREATE TABLE parametro (
   id                SERIAL PRIMARY KEY,
   nome              VARCHAR NOT NULL,
   valor             VARCHAR NOT NULL,
   descricao         VARCHAR NOT NULL,
   status            CHAR(1) NOT NULL,
   criado_em         TIMESTAMP,
   atualizado_em     TIMESTAMP,
   usuario_id        INTEGER,
   atualizado_por    INTEGER,
   CONSTRAINT fk_parametro_atualizado_por FOREIGN KEY (atualizado_por) REFERENCES usuario(id),
   CONSTRAINT fk_parametro_usuario_id     FOREIGN KEY (usuario_id)     REFERENCES usuario(id)
);

CREATE TABLE categoria (
   id                SERIAL PRIMARY KEY,
   nome              VARCHAR NOT NULL,
   criado_em         TIMESTAMP,
   atualizado_em     TIMESTAMP,
   usuario_id        INTEGER,
   atualizado_por    INTEGER,
   CONSTRAINT fk_categoria_atualizado_por FOREIGN KEY (atualizado_por) REFERENCES usuario(id),
   CONSTRAINT fk_categoria_usuario_id     FOREIGN KEY (usuario_id)     REFERENCES usuario(id)
);