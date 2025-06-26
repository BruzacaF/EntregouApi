-- SCRIPT DE CRIAÇÃO DE TABELAS

CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha_hash TEXT NOT NULL,
	role VARCHAR(50) NOT NULL CHECK(ROLE IN ('ADMIN', 'CLIENTE', 'MOTORISTA'))
);

CREATE TABLE telefone_usuario (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id),
    numero VARCHAR(20) NOT NULL
);

CREATE TABLE log_alteracoes_usuario (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id),
    campo_alterado VARCHAR(100),
    valor_antigo TEXT,
    valor_novo TEXT,
    data_alteracao TIMESTAMP DEFAULT NOW()
);

CREATE TABLE cliente (
    id_usuario INT PRIMARY KEY REFERENCES usuario(id),
    tipo_pessoa CHAR(1) , -- F ou J
    cpf_cnpj VARCHAR(20)
);

CREATE TABLE empresa (
    id_cliente INT PRIMARY KEY REFERENCES cliente(id_usuario),
    razao_social VARCHAR(100),
    nome_fantasia VARCHAR(100),
    inscricao_estadual VARCHAR(20),
    cnpj VARCHAR(20)
);

CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES cliente(id_usuario),
    rua VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    cep VARCHAR(10),
    ponto_referencia VARCHAR(100),
    principal BOOLEAN DEFAULT FALSE
);

CREATE TABLE motorista (
    id_usuario INT PRIMARY KEY REFERENCES usuario(id),
    cnh VARCHAR(20),
    categoria_cnh VARCHAR(5) NOT NULL CHECK(categoria_cnh in('A','B', 'C', 'D', 'E')),
    validade_cnh DATE,
    avaliacao_media NUMERIC(3,2),
    ultima_entrega_id INT
);

CREATE TABLE veiculo (
    id SERIAL PRIMARY KEY,
    id_motorista INT REFERENCES motorista(id_usuario),
    placa VARCHAR(10) UNIQUE NOT NULL,
    tipo VARCHAR(20),
    ano INT,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    capacidade DECIMAL
);

CREATE TABLE administrador (
    id_usuario INT PRIMARY KEY REFERENCES usuario(id),
    ultimo_login TIMESTAMP
);

CREATE TABLE armazem (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    tipo VARCHAR(20),
    cidade VARCHAR(50),
    estado VARCHAR(2),
    capacidade_maxima INT,
    latitude DECIMAL(10, 6),
    longitude DECIMAL(10, 6)
);

CREATE TABLE pacote (
    id SERIAL PRIMARY KEY,
    id_cliente_remetente INT REFERENCES cliente(id_usuario),
    id_cliente_destinatario INT REFERENCES cliente(id_usuario),
    tipo_pacote VARCHAR(50),
    dimensoes VARCHAR(50),
    peso DECIMAL(10, 2),
    valor_declarado DECIMAL(10, 2),
    codigo_rastreio VARCHAR(50),
    descricao_conteudo TEXT,
    tipo_embalagem VARCHAR(50),
    prioridade BOOLEAN DEFAULT FALSE
);

CREATE TABLE entrega (
    id SERIAL PRIMARY KEY,
    id_motorista INT REFERENCES motorista(id_usuario),
    id_veiculo INT REFERENCES veiculo(id),
    data_coleta TIMESTAMP,
    data_entrega_prevista TIMESTAMP,
    data_entrega_real TIMESTAMP,
    status_entrega VARCHAR(50),
    motivo_atraso TEXT,
    geolocalizacao_eventos TEXT,
    recusado BOOLEAN DEFAULT FALSE
);

CREATE TABLE entrega_pacote (
    id_entrega INT REFERENCES entrega(id),
    id_pacote INT REFERENCES pacote(id),
    PRIMARY KEY (id_entrega, id_pacote)
);

CREATE TABLE historico_entrega (
    id SERIAL PRIMARY KEY,
    id_entrega INT REFERENCES entrega(id),
    status VARCHAR(50),
    timestamp TIMESTAMP DEFAULT NOW(),
    observacao TEXT
);



CREATE OR REPLACE FUNCTION criar_cliente_motorista_admin_automaticamente()
RETURNS TRIGGER AS $$
BEGIN
    -- Se for CLIENTE, insere na tabela cliente
    IF NEW.role = 'CLIENTE' THEN
        INSERT INTO cliente (id_usuario, tipo_pessoa, cpf_cnpj)
        VALUES (NEW.id, 'F', '000.000.000-00');
END IF;

    -- Se for MOTORISTA, insere na tabela motorista
    IF NEW.role = 'MOTORISTA' THEN
        INSERT INTO motorista (id_usuario, categoria_cnh)
        VALUES (NEW.id, 'B'); -- valores default
END IF;

    -- Se for ADMIN, insere na tabela administrador
    IF NEW.role = 'ADMIN' THEN
        INSERT INTO administrador (id_usuario, ultimo_login)
        VALUES (NEW.id, NOW());
END IF;

RETURN NEW;
END;
$$ LANGUAGE plpgsql;



CREATE TRIGGER trigger_criar_cliente_motorista_admin
    AFTER INSERT ON usuario
    FOR EACH ROW
    EXECUTE FUNCTION criar_cliente_motorista_admin_automaticamente();




