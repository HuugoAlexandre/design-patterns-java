# Sistema de Pagamento - Padrão Strategy

## Descrição do Problema e Solução
O sistema de pagamento precisa aplicar diferentes estratégias de desconto dependendo de promoções, campanhas sazonais ou tipo de cliente.  
O desafio era permitir que múltiplas estratégias fossem intercambiáveis sem alterar o código principal de cálculo de preços.  

**Solução:**  
Foi implementado o padrão Strategy. Cada estratégia de desconto (percentual, valor fixo, compre 2 leve 3, etc.) é encapsulada em uma classe concreta que implementa a interface `DiscountStrategy`.  
O `PriceService` atua como Context, selecionando dinamicamente a estratégia desejada e calculando o preço final.  
O controller REST permite escolher a estratégia e testar o cálculo de preço.

---

## Explicação dos Padrões Aplicados e Justificativa
**Padrão aplicado:** Strategy (Comportamental)  

**Justificativa:**  
- Permite definir múltiplos algoritmos (formas de calcular desconto) e trocá-los dinamicamente.  
- Evita condicionais complexas (if/else ou switch espalhados pelo código).  
- Facilita a adição de novas estratégias sem modificar o código existente (OCP).  
- Promove desacoplamento entre o cálculo de preço e as regras de desconto.

No Spring:  
- Cada estratégia é um bean nomeado (`@Component("id")`).  
- Spring injeta todas as implementações em um `Map<String, DiscountStrategy>`.  
- O `PriceService` seleciona a estratégia com base no nome fornecido na requisição.

---

## Instruções para Executar o Projeto
#### Subir o projeto Spring Boot:
```bash
mvn spring-boot:run
```

#### Listar estratégias disponíveis:
```
curl http://localhost:8080/discount/strategies
```

### Calcular preço com uma estratégia:
#### Desconto percentual:
```
curl "http://localhost:8080/discount/calculate?amount=200&strategy=percentage"
```
#### Saída:
```
Saída:
Preço original: R$200.0
Preço final (percentage): R$180.0
```
#### Desconto fixo:
```
curl "http://localhost:8080/discount/calculate?amount=200&strategy=fixed"
```
#### Saída:
```
Preço original: R$200.0
Preço final (fixed): R$180.0
```
##### Compre 2 leve 3:
```
curl "http://localhost:8080/discount/calculate?amount=300&strategy=buyxgety"
```

##### Saída:
```
Preço original: R$300.0
Preço final (buyxgety): R$200.0
```