CREATE OR REPLACE FUNCTION pessoa_set_criado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.criado_em := NOW();
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER pessoa_set_criado_em_trigger
BEFORE INSERT ON pessoa
FOR EACH ROW EXECUTE FUNCTION pessoa_set_criado_em();

CREATE OR REPLACE FUNCTION pessoa_set_atualizado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER pessoa_set_atualizado_em_trigger
BEFORE UPDATE ON pessoa
FOR EACH ROW EXECUTE FUNCTION pessoa_set_atualizado_em();


CREATE OR REPLACE FUNCTION usuario_set_criado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.criado_em := NOW();
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER usuario_set_criado_em_trigger
BEFORE INSERT ON usuario
FOR EACH ROW EXECUTE FUNCTION usuario_set_criado_em();

CREATE OR REPLACE FUNCTION usuario_set_atualizado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER usuario_set_atualizado_em_trigger
BEFORE UPDATE ON usuario
FOR EACH ROW EXECUTE FUNCTION usuario_set_atualizado_em();

CREATE OR REPLACE FUNCTION parametro_set_criado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.criado_em := NOW();
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER parametro_set_criado_em_trigger
BEFORE INSERT ON parametro
FOR EACH ROW EXECUTE FUNCTION parametro_set_criado_em();

CREATE OR REPLACE FUNCTION parametro_set_atualizado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER parametro_set_atualizado_em_trigger
BEFORE UPDATE ON parametro
FOR EACH ROW EXECUTE FUNCTION parametro_set_atualizado_em();

CREATE OR REPLACE FUNCTION categoria_set_criado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.criado_em := NOW();
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER categoria_set_criado_em_trigger
BEFORE INSERT ON categoria
FOR EACH ROW EXECUTE FUNCTION categoria_set_criado_em();

CREATE OR REPLACE FUNCTION categoria_set_atualizado_em()
RETURNS TRIGGER AS $$
BEGIN
   NEW.atualizado_em := NOW();
   RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER categoria_set_atualizado_em_trigger
BEFORE UPDATE ON categoria
FOR EACH ROW EXECUTE FUNCTION categoria_set_atualizado_em();