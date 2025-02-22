# Projeto Ada Commerce - E-Commerce

Projeto final do módulo Programação Orientada a Objetos II

## Grupo 3: 
- Bruno Madureira
- Claudia Bispo
- Igor Eloi

# Sistema de E-Commerce 

## Descrição
A **Ada Tech** pretende realizar a venda de produtos através de um **E-Commerce** e, para isso, nos contratou para desenvolver todo o fluxo necessário. O sistema permitirá a gestão de clientes, produtos e vendas seguindo regras de negócio bem definidas.

## Funcionalidades

- **Gestão de Clientes**:
  - Cadastrar clientes
  - Listar clientes
  - Atualizar informações dos clientes (sem possibilidade de exclusão)

- **Gestão de Produtos**:
  - Cadastrar produtos
  - Listar produtos
  - Atualizar informações dos produtos (sem possibilidade de exclusão)

- **Gestão de Vendas**:
  - Criar uma venda para um cliente
  - Adicionar, remover e alterar quantidade de itens no pedido
  - Informar preço de venda do produto no pedido
  - Finalizar pedido (somente se houver ao menos um item e valor maior que zero)
  - Realizar pagamento
  - Notificar cliente sobre status do pedido
  - Registrar e alterar status do pedido: **Aberto** -> **Aguardando pagamento** -> **Pago** -> **Finalizado**

## Regras de Negócio

- Todo cliente deve possuir um documento de identificação.
- Um pedido sempre deve ter uma data de criação.
- Um pedido inicia com o status **Aberto** e pode receber itens, alterar quantidades e remover itens.
- O valor do produto na venda pode ser diferente do valor padrão do produto.
- Para finalizar um pedido:
  - Deve ter ao menos um item.
  - O valor total deve ser maior que zero.
  - O status do pagamento passa para **Aguardando pagamento** e o cliente é notificado por e-mail.
- O pagamento só pode ocorrer quando o status for **Aguardando pagamento**.
- Quando o pagamento for realizado com sucesso:
  - O status do pagamento é alterado para **Pago**.
  - O cliente é notificado.
- O pedido pode ser entregue ao cliente após o pagamento, alterando o status para **Finalizado** e notificando o cliente.

## Tecnologias Utilizadas
- Linguagem de programação: [JAVA]
- Base de dados em memória
- Paradigma: Programado orientado a objetos (com princípios SOLID)
