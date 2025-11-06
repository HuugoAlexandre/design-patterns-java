# Facade Pattern — Processamento de Pedidos

## Descrição do problema e solução

A empresa possui múltiplos microsserviços responsáveis por clientes, produtos, pedidos e pagamentos.  
Realizar uma compra exigia chamadas complexas e repetitivas a todos esses serviços, tornando o processo difícil de manter.

A solução foi aplicar o **padrão Facade**, criando a classe `OrderFacade`, que oferece uma **interface única e simplificada** para validar clientes, verificar produtos, criar pedidos e processar pagamentos, **ocultando a complexidade interna**.

---

## Explicação dos padrões aplicados e justificativa

**Padrão aplicado:** Facade (Estrutural)

- **O que faz:** Fornece uma interface simplificada para um conjunto de interfaces de um subsistema complexo.  
- **Justificativa para o uso:**  
  - Reduz o acoplamento entre o cliente e os serviços internos.  
  - Simplifica o consumo do sistema de pedidos, expondo apenas métodos essenciais.  
  - Facilita manutenção, testes e futuras integrações de microsserviços.

---

## Instruções para executar o projeto

#### Subir o projeto Spring Boot (ou executa no programa principal no Spring):

```bash
mvn spring-boot:run
```

#### Testar o endpoint de criação de pedido via terminal:
```
curl "http://localhost:8080/place-order"
```

#### Resultado esperado:

```
Pedido realizado com sucesso! ID: ORDER-1730747500000 | Valor total: R$ 320.0
```