# Observer (Notificações de Mercado de Ações)

## 1) Descrição do problema e solução

**Problema:**  
O sistema deve simular um mercado de ações onde, ao alterar o preço de uma ação, vários investidores (ou sistemas externos) devem ser notificados automaticamente.  
A atualização deve ocorrer de forma desacoplada, sem que o emissor (mercado) precise conhecer detalhes sobre os inscritos (investidores).

**Solução:**  
Aplicou-se o padrão **Observer**, onde o objeto `StockMarket` atua como o **sujeito (Subject)**, mantendo uma lista de observadores.  
Cada observador (por exemplo, `InvestorObserver`) é notificado automaticamente quando ocorre uma atualização de preço.  
Essa abordagem desacopla o produtor do evento (mercado) dos consumidores (investidores), tornando o sistema extensível e modular.

---

## 2) Explicação do padrão e justificativa

**Padrão Aplicado:** *Observer (Comportamental)*

**Ideia principal:**  
Permite que múltiplos objetos sejam notificados automaticamente quando o estado de outro objeto muda, sem dependência direta entre eles.

**Aplicação no projeto:**
- `StockMarket` → Sujeito observado.  
- `InvestorObserver` → Observadores inscritos.  
- Quando o preço de uma ação é atualizado, todos os observadores são notificados via método `update(symbol, price)`.

**Justificativa:**  
O padrão **Observer** foi escolhido porque resolve exatamente o problema de notificações reativas entre objetos sem acoplamento.  
Adicionando novos observadores (ex.: envio de e-mail, log, integração externa) não é necessário alterar o código do `StockMarket`, apenas registrar novos observers.

---

## 3) Instruções para executar o projeto

### 3.1. Subir a aplicação
Na raiz do projeto:
```bash
mvn spring-boot:run
```

#### Testar o comportamento:
```
curl -X POST "http://localhost:8080/stock/update?symbol=PETR4&price=37.50"
```

#### Saída esperada no console do Spring: 
```
[Dashboard] Atualização de PETR4 -> R$37.5
[Email] Notificação: PETR4 alterada para R$37.5
[SMS] Ação PETR4 atualizada para R$37.5
Atualização de preço publicada: PETR4 -> R$37.5
```

#### Saída via terminal (sem ser no Spring):
```
Evento de atualização enviado para a ação: PETR4
```

### Explicação do fluxo:

#### O controlador (StockController) recebe a requisição HTTP.

#### Ele chama o serviço StockMarket.updateStockPrice(symbol, price).

#### O StockMarket atualiza o valor e notifica automaticamente todos os observadores registrados.

#### Cada InvestorObserver imprime no console (ou executa uma ação específica).