# 💸 Simulador de Pagamento Digital (Java + POO)

Este é um projeto didático desenvolvido para aplicar e demonstrar os principais conceitos da Programação Orientada a Objetos (POO) em Java, simulando um sistema básico de transferências entre clientes e lojistas via diferentes formas de pagamento.

---

## 🎯 Objetivo

Simular um ambiente onde **clientes podem realizar pagamentos** para **lojistas** utilizando **Pix**, **cartão de crédito** ou **saldo interno**, com comportamentos específicos para cada tipo de pagamento.

---

## 🚀 Tecnologias e Conceitos

- **Java 17**
- **Programação Orientada a Objetos (POO)**
  - Classes e Objetos
  - Encapsulamento
  - Herança
  - Polimorfismo
  - Abstração
- Boas práticas de organização em camadas

---

## 🧩 Estrutura do Projeto

### 👤 `Usuario` *(abstract)*
Classe base para todos os usuários do sistema.
- Atributos: `nome`, `email`, `senha`, `saldo`
- Métodos: `getSaldo()`, `alterarSaldo()`, `autenticar()`

### 🧑‍💼 `Cliente` (herda de `Usuario`)
- Pode realizar transferências.
- Atributos: `cpf`, `telefone`, `ativo`
- Método principal: `transferir(Lojista, valor, formaPagamento, senha)`

### 🏬 `Lojista` (herda de `Usuario`)
- Apenas recebe pagamentos.
- Atributos: `cnpj`, `razaoSocial`, `saldoBloqueado`
- Métodos: `receberPagamento()`, `receberValorBloqueado()`, `liberarSaldoBloqueado()`

### 🔐 `Autenticavel` *(interface)*
Contrato para autenticação de usuários.

### 💳 `Pagamento` *(interface)*
Define o método `realizar(valor, origem, destino)` que é implementado por:

- `PagamentoPix`: pagamento imediato sem taxas
- `PagamentoCartao`: aplica taxa e bloqueia valor no lojista
- `PagamentoSaldo`: usa crédito interno do cliente

---

## ✅ Funcionalidades Simuladas

- Autenticação por senha
- Validação de saldo
- Lógica de pagamento específica por tipo
- Liberação de valores bloqueados (cartão)
- Simulações de sucesso e falha de pagamento

---

## 📌 Exemplo de Uso

```java
Cliente kaweny = new Cliente("Kaweny", "email", "1234", 100.0, "111.111.111-11", "9999-9999");
Lojista loja = new Lojista("Loja Kaw", "loja@email.com", "loj@123", 0.0, "00.000.000/0001-00", "Loja da Kaweny");

Pagamento pagamento = new PagamentoPix();
kaweny.transferir(loja, 50.0, pagamento, "1234");



