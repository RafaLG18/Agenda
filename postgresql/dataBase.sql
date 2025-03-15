-- Tabela usuario
CREATE TABLE "usuario"(
    "id" SERIAL NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "senha" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "usuario" ADD PRIMARY KEY("id");

-- Tabela endereco
CREATE TABLE "endereco"(
    "id" SERIAL NOT NULL,
    "cep" VARCHAR(8) NOT NULL,
    "rua" VARCHAR(255) NOT NULL,
    "numero" INTEGER NOT NULL,
    "complemento" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "endereco" ADD PRIMARY KEY("id");

-- Tabela telefones
CREATE TABLE "telefones"(
    "id" SERIAL NOT NULL,
    "telefone-1" VARCHAR(255) NOT NULL DEFAULT '-',
    "telefone-2" VARCHAR(255) NOT NULL DEFAULT '-',
    "telefone-3" VARCHAR(255) NOT NULL DEFAULT '-'
);
ALTER TABLE
    "telefones" ADD PRIMARY KEY("id");

-- Tabela contato
CREATE TABLE "contato"(
    "id" SERIAL NOT NULL,
    "nome_contato" VARCHAR(255) NOT NULL,
    "usuario_id" INTEGER NOT NULL,
    "telefone_id" INTEGER NOT NULL,
    "endereco_id" INTEGER NOT NULL
);
ALTER TABLE
    "contato" ADD PRIMARY KEY("id");

ALTER TABLE
    "contato" ADD CONSTRAINT "contato_telefone_id_foreign" FOREIGN KEY("telefone_id") REFERENCES "telefones"("id");
ALTER TABLE
    "contato" ADD CONSTRAINT "contato_usuario_id_foreign" FOREIGN KEY("usuario_id") REFERENCES "usuario"("id");
ALTER TABLE
    "contato" ADD CONSTRAINT "contato_endereco_id_foreign" FOREIGN KEY("endereco_id") REFERENCES "endereco"("id");