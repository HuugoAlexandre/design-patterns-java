# Factory Method (Sistema de Notificações)

## Descrição do Problema e Solução

A empresa precisava de um sistema para **enviar notificações por múltiplos canais** — e-mail, SMS e push notification — cada um com comportamentos distintos, mas seguindo a mesma estrutura geral: **destinatário, assunto e conteúdo**.

Para evitar que o código do controlador (`NotificationController`) precisasse conhecer diretamente as classes concretas de cada tipo de notificação, foi aplicado o **padrão Factory Method**.  
Esse padrão centraliza a criação dos objetos em uma única classe (`NotificationFactory`), tornando o sistema **flexível e extensível**.

A aplicação permite adicionar novos canais (como WhatsApp ou Telegram) apenas criando uma nova implementação de `NotificationService`, sem alterar código existente.

---

## Padrão Aplicado e Justificativa

**Padrão:** Factory Method  
**Categoria:** Criacional  

### Explicação
O **Factory Method** fornece uma interface para criar objetos em uma superclasse, permitindo que subclasses (ou uma fábrica dedicada) decidam **qual classe concreta instanciar**.  

Aqui, a classe `NotificationFactory` decide qual implementação de `NotificationService` será usada com base no tipo informado (`email`, `sms` ou `push`).

### Benefícios
- **Desacoplamento:** o controller não precisa conhecer classes concretas.  
- **Extensibilidade:** novos tipos podem ser adicionados sem alterar código existente.  
- **Manutenibilidade:** mudanças em um tipo de notificação não afetam os demais.  
- **Organização:** cada responsabilidade está bem separada (controller, factory, serviços).  

---

## Instruções para Executar o Projeto

### 1️. Executar a aplicação
Na raiz do projeto, execute (ou só clique em executar no Spring):

```bash
mvn spring-boot:run
```
O servidor iniciará em:
```
http://localhost:8080
``` 
### 2️. Testar os Endpoints
#### Obs: execute esses comandos no CMD, os comandos via bash são diferentes.

Enviar notificação por e-mail
```
curl -X POST "http://localhost:8080/notifications" -H "Content-Type: application/json" -d "{\"type\":\"email\",\"recipient\":\"user@email.com\",\"subject\":\"Boas-vindas\",\"content\":\"Seja bem-vindo!\"}"
```
Enviar notificação por SMS
```
curl -X POST "http://localhost:8080/notifications" -H "Content-Type: application/json" -d "{\"type\":\"sms\",\"recipient\":\"+5511999999999\",\"subject\":\"Código de verificação\",\"content\":\"Seu código é 1234\"}"
```
Enviar notificação push
```
curl -X POST "http://localhost:8080/notifications" -H "Content-Type: application/json" -d "{\"type\":\"push\",\"recipient\":\"device_token_123\",\"subject\":\"Alerta\",\"content\":\"Notificação push de teste\"}"
```
### Saída esperada (no console):

[EMAIL] Enviando para: teste@empresa.com | Assunto: Boas Vindas | Conteúdo: Olá, seja bem-vindo!
[SMS] Enviando SMS para: 5511999999999 | Assunto: Promoção | Conteúdo: Desconto especial para você!
[PUSH] Enviando push para: usuario123 | Assunto: Alerta | Conteúdo: Sua conta foi atualizada!

### Conclusão
O projeto aplica com sucesso o padrão Factory Method, encapsulando a lógica de criação dos serviços de notificação dentro de uma fábrica dedicada.
Essa abordagem promove baixo acoplamento, facilidade de manutenção e aderência aos princípios SOLID, especialmente:

OCP (Aberto para extensão, fechado para modificação)

DIP (Inversão de dependência)

O resultado é uma aplicação modular, extensível e pronta para integrar novos canais de comunicação com mínima alteração de código.