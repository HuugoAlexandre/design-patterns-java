# Projeto Integrador — E-commerce com Múltiplos Padrões

## 1) Descrição do problema e solução

**Problema:**  
Construir um sistema de e-commerce completo que seja flexível, escalável e de fácil manutenção. O sistema precisa atender várias responsabilidades transversais (catálogo de produtos, carrinho, cálculo de frete, descontos, processamento de pedidos, pagamentos e integrações externas) de forma modular, permitindo evolução e substituição gradual de componentes sem grandes reescritas.

**Solução (resumo):**  
Implementou-se uma aplicação Spring Boot que resolve cada subproblema aplicando o padrão de projeto mais adequado — por exemplo: Factory/Builder para criação de produtos; Observer para notificações de estoque; Composite para representar itens e bundles; Strategy para cálculo de frete e regras de desconto; Decorator para combinar transformações de exportação e múltiplos descontos; Chain of Responsibility e Template Method para validação e fluxo de pagamento; Adapter e Facade para integrar e simplificar comunicações com gateways externos. A combinação dos padrões torna o sistema coeso, testável e extensível.

---

## 2) Padrões aplicados e justificativa (apenas o essencial)

> A aplicação aplica vários padrões — abaixo, cada um com uma linha de justificativa prática.

- **Factory + Builder (Catálogo de Produtos)**  
  *Por que:* criar diferentes tipos de produto configuráveis de maneira clara e desacoplada; Builder facilita composição de variações; Factory centraliza a decisão de qual implementação criar.

- **Observer (Notificações de estoque)**  
  *Por que:* notificar múltiplos consumidores (SMS, email, dashboard) quando o estoque muda, sem acoplar o produtor aos consumidores; facilita adicionar novos listeners.

- **Composite (Carrinho / Itens e Bundles)**  
  *Por que:* representar itens simples e bundles de forma uniforme, permitindo operações recursivas (ex.: cálculo de preço, total de itens) sem condicional espalhado.

- **Strategy (Cálculo de frete e regras de desconto)**  
  *Por que:* permitir trocar dinamicamente algoritmos de cálculo (flat, freeOver, percentual, fixo, compreXleveY) sem alterar o código do serviço que os usa; facilita A/B testing e promoções.

- **Decorator (Combinar descontos / Transformações de exportação)**  
  *Por que:* aplicar funcionalidades adicionais (compressão, criptografia, múltiplos descontos) de forma dinâmica e composable, mantendo os componentes base inalterados (respeita OCP).

- **Chain of Responsibility (Pipeline de processamento de pedidos)**  
  *Por que:* modelar um fluxo de validações e transformações (estoque → fraude → preço → desconto → persistência) onde cada etapa pode interromper o processamento, mantendo handlers independentes e testáveis.

- **Template Method (Fluxo de pagamento)**  
  *Por que:* definir o fluxo estável (validar → executar → notificar) para métodos de pagamento, permitindo que cada método (cartão, PayPal, transferência) implemente suas variações sem duplicar o fluxo principal.

- **Adapter (Integração com gateways externos)**  
  *Por que:* adaptar a interface do sistema legado/externo (ex.: SDKs de pagamento) para o contrato usado internamente, permitindo troca de provedores sem alterar o cliente.

- **Facade (API única para integrações externas)**  
  *Por que:* oferecer uma interface simplificada que orquestra múltiplos serviços externos (pagamento, anticorrupção, logística), reduzindo a complexidade do cliente que consome o sistema.

**Justificativa geral:**  
Cada padrão foi escolhido para resolver um problema específico de modularidade, extensibilidade ou desacoplamento. Juntos, eles mantêm o código limpo, testável e alinhado aos princípios SOLID (especialmente OCP e DIP), e facilitam migração/escala incremental.

---

## 3) Instruções para executar o projeto

### Pré-requisitos
- Java 17+
- Maven 3+
- (Opcional) Postman ou outro cliente HTTP para testes

### Subir a aplicação
Na raiz do projeto (ou executar diretamente no Spring):
```bash
mvn clean package
mvn spring-boot:run
```

### Testes rápidos (endpoints principais)
#### Use bash ou os comandos adaptados para Windows CMD / PowerShell conforme seu terminal.

#### Catálogo — listar produtos
```
curl http://localhost:8080/api/catalog/products
```

#### Saída (formatada):
```
[
  {
    "id": "p1",
    "name": "Mouse",
    "price": 120,
    "stock": 0,
    "attributes": {
    }
  }
]
```

#### Repor estoque (dispara Observer)
```
curl -X POST "http://localhost:8080/api/catalog/products/{productId}/restock?qty=5"
```

#### Saída:
```
restocked
```

#### Calcular frete (Strategy: flat / freeOver)
```
curl -X POST "http://localhost:8080/api/cart/shipping?strategy=flat" ^
  -H "Content-Type: application/json" ^
  -d "{\"items\":[{\"name\":\"item1\",\"quantity\":1,\"unitPrice\":100.0}]}"
```

#### Saída: 
```
15.0
```

#### Aplicar desconto (Strategy/Decorator)
```
curl -X POST "http://localhost:8080/api/discount/apply?strategies=percentage" ^
  -H "Content-Type: application/json" ^
  -d "{\"id\":\"001\",\"items\":[\"a\",\"b\"],\"total\":500}"
```

#### Saída: 
```
450.0
```

#### Processar pedido (Chain + Template + persistência simulada)

```
curl -X POST "http://localhost:8080/api/orders" ^
  -H "Content-Type: application/json" ^
  -d "{\"id\":\"o1\",\"items\":[\"a\",\"b\",\"c\"],\"paymentInfo\":{\"method\":\"card\",\"account\":\"user\",\"amount\":300}}"
```

#### Saída: 
```
{"id":"o1","items":["a","b","c"],"total":270.0,"valid":true,"status":"Order persisted. Total: 270.0","paymentInfo":{"method":"card","account":"user","amount":300.0}}
```

#### Processar pagamento via integração (Facade + Adapter)
```
curl -X POST "http://localhost:8080/api/integration/pay?gateway=stripe" ^
  -H "Content-Type: application/json" ^
  -d "{\"method\":\"card\",\"account\":\"tok_abc\",\"amount\":100}"
```

#### Saída: 
```
Ok via stripe
```

### OBSERVAÇÃO: alguns endpoints retornam resultado em JSON, já outros escrevem logs no console (simulações de serviços externos). É bom olhar os logs do Spring Boot para ver as mensagens dos padrões (Observer, Chain, Adapter, etc.).

#### Exemplo de como a mensagem será impressa no terminal do Spring: 
```
[Chain] Inventory ok
[Chain] Fraud check ok
[Chain] Pricing calculated: 300.0
[Chain] Discount applied: 270.0
[Payment] Validate card for user
[Payment] Charging card user amount 300.0
[Payment] Notify card payment to user
[Chain] Payment processed by card
[Chain] Order persisted
[StripeSDK] Charging tok_abc amount 100.0
[Adapter] Stripe mapped txn: stripe_txn_123
```

