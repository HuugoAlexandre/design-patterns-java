# Adapter — Integração de Sistemas de Pagamento

## Descrição do problema e solução

A empresa estava migrando de um **sistema legado de pagamentos** para um **novo sistema moderno** com interface incompatível.  
O desafio era permitir que o código antigo continuasse funcionando sem precisar ser reescrito.

A solução foi implementar um **Adapter**, que atua como um tradutor entre a interface antiga (`LegacyPaymentProcessor`) e a nova interface (`NewPaymentSystem`).  
Assim, o código legado pode continuar chamando métodos antigos enquanto internamente o adapter converte as chamadas para o novo sistema.

---

## Explicação dos padrões aplicados e justificativa

**Padrão aplicado:** Adapter (Estrutural)

- **O que faz:** Permite que classes com interfaces incompatíveis trabalhem juntas, sem modificar o código existente.  
- **Justificativa para o uso:**  
  - Mantém compatibilidade com o sistema antigo.  
  - Reduz acoplamento entre o código legado e o novo sistema.  
  - Facilita a migração gradual, garantindo que o novo sistema possa ser usado sem alterar a lógica existente.

---

## Instruções para executar o projeto

#### Subir o projeto Spring Boot (ou execute a classe principal no Spring):

```bash
mvn spring-boot:run
```
#### Testar o endpoint de pagamento via terminal:
```
curl "http://localhost:8080/pay?orderId=123&amount=150.75"
```

#### Resultado esperado:
```
Pagamento processado com sucesso no novo sistema: Pedido 123 | Valor: R$ 150.75
```