# SimulacaoLojaOnline

## Sobre o Projeto:
->Esta é uma atividade que representa o funcionamento de uma loja online (um pequeno e-commerce), o projeto foi realizado em JAVA com paradigma em Orientação a Objetos e com arquitetura moniítica (não sendo o modelo mais ideal para a criação de e-commerces, mas esse projeto é apenas uma simulação da ideia), o objetivo foi implementar o fluxo de compras de um e-commerce

->Todo o projeto roda em uma API via terminal sem interface gráfica,

->Funcionalidades: <br> 
  &nbsp;&nbsp;&nbsp;&nbsp;1.Identificação de Clientes dentro do sistema <br>
  &nbsp;&nbsp;&nbsp;&nbsp;2.Listagem de Produtos <br>
  &nbsp;&nbsp;&nbsp;&nbsp;3.Fluxo de carrinho de compras(pedido) como criação e adição de itens ao carrinho <br>
  &nbsp;&nbsp;&nbsp;&nbsp;4. Processo de finalizar a compra com gateway de pagamento externo e retorno de status(aprovado ou nao) <br>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;->A integração com o sistema externo de pagamento foi implementada utilizando o **Padrão de Projeto Singleton**<br>
  
->**O por quê do uso do Singleton**: Serviços de gateway de pagamento externo são um grande custo em termo de conexão o Singleton garante que exista apenas uma instância responsável por essa comunicação no código todo, evitando sobrecargas e centralizando o controle em um único ponto da arquitetura.

-> Segue abaixo o **Mapa de Atividades e Diagrama Entidade Relacionamento**:

## Mapa de Atividades
<img width="804" height="714" alt="Diagrama de atividades - LOJINHA drawio" src="https://github.com/user-attachments/assets/cb82cc30-3115-4442-a29e-2892bd5906de" />


## Diagrama Entidade Relacionamento(MER)
![LojaOnlineMER](https://github.com/user-attachments/assets/53d59ca2-8cce-407a-8c5f-0ca0228aa1a7)
