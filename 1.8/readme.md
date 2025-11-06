# Sistema de Pagamentos - Padrão Template Method

## Descrição do Problema e Solução
O sistema de pagamentos deve suportar múltiplos métodos — cartão de crédito, PayPal e transferência bancária — que compartilham um mesmo fluxo geral: validar dados, processar pagamento e notificar o usuário.  
Antes, cada método repetia a mesma estrutura, gerando duplicação e inconsistência.  

**Solução:**  
Aplicou-se o padrão **Template Method**, definindo uma classe abstrata `PaymentProcessor` que contém o fluxo fixo `processPayment()` e delega as etapas variáveis (`validate`, `executePayment`, `sendNotification`) para subclasses específicas (`CreditCardPaymentProcessor`, `PaypalPaymentProcessor`, `BankTransferPaymentProcessor`).  
Assim, cada tipo de pagamento personaliza seu comportamento mantendo a consistência do processo.

---

## Explicação dos Padrões Aplicados e Justificativa
**Padrão aplicado:** Template Method (Comportamental)  

**Justificativa:**  
- Define um **fluxo padronizado** de operações que se repetem com variações.  
- **Evita duplicação** de lógica comum entre diferentes métodos de pagamento.  
- **Facilita extensões futuras**, permitindo adicionar novos tipos sem alterar o fluxo principal.  
- **Reduz acoplamento**, mantendo as etapas específicas isoladas em subclasses.  
- Garante **consistência** e **reutilização** de código entre os métodos de pagamento.

---

## Instruções para Executar o Projeto

### 3 Subir o projeto Spring Boot:
```bash
mvn spring-boot:run
```

### Testar os diferentes métodos de pagamento:

#### Cartão de Crédito
```
curl -X POST http://localhost:8080/payments ^
     -H "Content-Type: application/json" ^
     -d "{\"method\":\"card\", \"account\":\"cliente@email.com\", \"amount\":200.0}"
```

#### Paypal
```
curl -X POST http://localhost:8080/payments ^
     -H "Content-Type: application/json" ^
     -d "{\"method\":\"paypal\", \"account\":\"cliente@paypal.com\", \"amount\":350.0}"
```

#### Transferência Bancária
```
curl -X POST http://localhost:8080/payments ^
     -H "Content-Type: application/json" ^
     -d "{\"method\":\"bank\", \"account\":\"ag123-cc456\", \"amount\":1000.0}"
```

#### Saída esperada no console:
```
Validando dados...
Processando pagamento...
Enviando notificação para o cliente...
```

#### Resposta esperada da API:
```
Pagamento processado com sucesso via <método>
```

| Aspecto                | Descrição                                                      |
| ---------------------- | -------------------------------------------------------------- |
| **Padrão**             | Template Method                                                |
| **Tipo**               | Comportamental                                                 |
| **Problema Resolvido** | Evitar duplicação e inconsistência em fluxos semelhantes       |
| **Solução**            | Definir um template com etapas fixas e variações em subclasses |
| **Exemplo Real**       | Processamento de múltiplos métodos de pagamento                |
