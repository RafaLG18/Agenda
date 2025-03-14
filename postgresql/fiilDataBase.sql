-- Inserindo dados na tabela "usuario"
INSERT INTO "usuario" ("nome", "email", "senha") VALUES
('João Silva', 'joao.silva@example.com', 1234567890),
('Maria Oliveira', 'maria.oliveira@example.com', 0987654321),
('Carlos Souza', 'carlos.souza@example.com', 1122334455);

-- Inserindo dados na tabela "endereco"
INSERT INTO "endereco" ("CEP", "rua", "numero", "complemento") VALUES
('12345678', 'Rua das Flores', 100, 'Apartamento 101'),
('87654321', 'Avenida Brasil', 200, 'Casa 2'),
('45678901', 'Rua dos Coqueiros', 300, 'Bloco B, Apt 302'),
('98765432', 'Rua das Palmeiras', 400, 'Casa 5'),
('54321098', 'Avenida Paulista', 500, 'Sala 10');

-- Inserindo dados na tabela "telefones"
INSERT INTO "telefones" ("telefone-1", "telefone-2", "telefone-3") VALUES
('(11) 98765-4321', '(11) 91234-5678', '-'),
('(21) 99876-5432', '-', '-'),
('(31) 98765-1234', '(31) 91234-8765', '(31) 92345-6789'),
('(41) 98765-0000', '(41) 91234-1111', '-'), 
('(51) 98765-2222', '-', '-');               

-- Inserindo dados na tabela "contato"
-- Usuário João Silva (id 1) tem três contatos com nomes diferentes
INSERT INTO "contato" ("nome_contato", "usuario_id", "telefone_id", "endereco_id") VALUES
('Roberto', 1, 1, 1),
('Ana', 1, 4, 4),
('Leticia', 1, 5, 5),
('Rafael', 2, 2, 2),
('Vinicius', 2, 3, 3),
('Caique', 3, 3, 3),
('Thainá', 3, 5, 5);
