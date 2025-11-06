# Processamento de Pedidos - Padrão Chain of Responsibility

## Descrição do Problema e Solução
O sistema de e-commerce precisa processar pedidos passando por várias etapas: verificação de estoque, detecção de fraude, cálculo de preço, aplicação de desconto e persistência.  
Cada etapa deve ser modular e capaz de interromper o processamento caso algo esteja errado.  

**Solução:**  
Foi implementado o padrão Chain of Responsibility. Cada etapa do processamento é um `Handler` independente (InventoryValidator, FraudDetector, PricingCalculator, DiscountApplier, OrderPersister) que decide se processa a requisição ou passa para o próximo.  
O `OrderService` orquestra a cadeia, garantindo que as etapas sejam executadas na ordem correta. O controller REST expõe uma API para submeter pedidos e receber o resultado final.

---

## Explicação dos Padrões Aplicados e Justificativa
**Padrão aplicado:** Chain of Responsibility (Comportamental)  

**Justificativa:**  
- Permite encadear múltiplas etapas de processamento de forma flexível e desacoplada.  
- Cada handler é responsável por uma tarefa específica, podendo interromper o fluxo se necessário.  
- Facilita manutenção e testes isolados de cada etapa.  
- Reduz acoplamento entre o remetente da requisição (controller) e os processadores individuais.

---

## Instruções para Executar o Projeto
#### Subir o projeto Spring Boot:
```bash
mvn spring-boot:run
```

#### Submeter um pedido via API REST:
```
curl -X POST http://localhost:8080/orders ^
     -H "Content-Type: application/json" ^
     -d "{\"id\":\"001\",\"items\":[\"item1\",\"item2\",\"item3\"],\"total\":0}"
```

#### ou essa forma no bash: 
```
curl -X POST http://localhost:8080/orders \
     -H "Content-Type: application/json" \
     -d '{"id":"001","items":["item1","item2","item3"],"total":0}'
```

#### Saída esperada no console: 
```
Estoque verificado
Nenhuma fraude detectada
Preço calculado: R$300.0
Desconto aplicado: novo total R$270.0
Pedido salvo com sucesso: 001
```

#### Resposta JSON da API:
```
{
  "id": "001",
  "items": ["item1","item2","item3"],
  "total": 270.0,
  "valid": true,
  "message": "Pedido processado com sucesso!"
}
```