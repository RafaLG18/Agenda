CREATE TABLE "usuario"(
    "id" INTEGER NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "senha" BIGINT NOT NULL
);
ALTER TABLE
    "usuario" ADD PRIMARY KEY("id");
CREATE TABLE "endereco"(
    "id" BIGINT NOT NULL,
    "cep" VARCHAR(8) NOT NULL,
    "rua" VARCHAR(255) NOT NULL,
    "numero" BIGINT NOT NULL,
    "complemento" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "endereco" ADD PRIMARY KEY("id");
CREATE TABLE "agenda"(
    "id" INTEGER NOT NULL,
    "usuario" INTEGER NOT NULL,
    "telefone" INTEGER NOT NULL,
    "endereco" BIGINT NOT NULL
);
ALTER TABLE
    "agenda" ADD PRIMARY KEY("id");
CREATE TABLE "telefones"(
    "id" BIGINT NOT NULL,
    "telefone-1" VARCHAR(255) NOT NULL,
    "telefone-2" VARCHAR(255) NOT NULL DEFAULT '-',
    "telefone-3" VARCHAR(255) NOT NULL DEFAULT '-'
);
ALTER TABLE
    "telefones" ADD PRIMARY KEY("id");
ALTER TABLE
    "agenda" ADD CONSTRAINT "agenda_telefone_foreign" FOREIGN KEY("telefone") REFERENCES "telefones"("id");
ALTER TABLE
    "agenda" ADD CONSTRAINT "agenda_usuario_foreign" FOREIGN KEY("usuario") REFERENCES "usuario"("id");
ALTER TABLE
    "agenda" ADD CONSTRAINT "agenda_endereco_foreign" FOREIGN KEY("endereco") REFERENCES "endereco"("id");