-- Tabela usuario
CREATE TABLE "usuario"(
    "id" SERIAL PRIMARY KEY,
    "nome" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "senha" BIGINT NOT NULL
);

-- Tabela endereco
CREATE TABLE "endereco"(
    "id" SERIAL PRIMARY KEY,
    "CEP" VARCHAR(8) NOT NULL,
    "rua" VARCHAR(255) NOT NULL,
    "numero" INTEGER NOT NULL,
    "complemento" VARCHAR(255) NOT NULL
);

-- Tabela telefones
CREATE TABLE "telefones"(
    "id" SERIAL PRIMARY KEY,
    "telefone-1" VARCHAR(255) NOT NULL,
    "telefone-2" VARCHAR(255) NOT NULL DEFAULT '-',
    "telefone-3" VARCHAR(255) NOT NULL DEFAULT '-'
);

-- Tabela contato
CREATE TABLE "contato"(
    "id" SERIAL PRIMARY KEY,
    "nome_contato" VARCHAR(255) NOT NULL,
    "usuario_id" INTEGER NOT NULL,
    "telefone_id" INTEGER NOT NULL,
    "endereco_id" INTEGER NOT NULL,
    CONSTRAINT "contato_usuario_id_foreign" FOREIGN KEY("usuario_id") REFERENCES "usuario"("id"),
    CONSTRAINT "contato_telefone_id_foreign" FOREIGN KEY("telefone_id") REFERENCES "telefones"("id"),
    CONSTRAINT "contato_endereco_id_foreign" FOREIGN KEY("endereco_id") REFERENCES "endereco"("id")
);