-- Inserindo dados na tabela usuario
INSERT INTO "usuario" (id, nome, email, senha) VALUES
(1, 'João Silva', 'joao.silva@email.com', 123456),
(2, 'Maria Oliveira', 'maria.oliveira@email.com', 654321),
(3, 'Carlos Souza', 'carlos.souza@email.com', 987654);

-- Inserindo dados na tabela endereco
INSERT INTO "endereco" (id, cep, rua, numero, complemento) VALUES
(1, '01001000', 'Praça da Sé', 100, 'Apto 12'),
(2, '02020000', 'Av. Paulista', 2000, 'Sala 304'),
(3, '03030000', 'Rua das Flores', 45, 'Casa B');

-- Inserindo dados na tabela telefones
INSERT INTO "telefones" (id, "telefone-1", "telefone-2", "telefone-3") VALUES
(1, '11987654321', '11876543210', '-'),
(2, '11912345678', '-', '-'),
(3, '11911112222', '11933334444', '11955556666');

-- Inserindo dados na tabela agenda
INSERT INTO "agenda" (id, usuario, telefone, endereco) VALUES
(1, 1, 1, 1),
(2, 2, 2, 2),
(3, 3, 3, 3);