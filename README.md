# Projeto — Padrões de Projeto com Spring Boot

## Descrição Geral

Este repositório reúne uma coleção de **atividades práticas** desenvolvidas durante a disciplina de **Padrões de Projeto e Arquitetura de Software**, aplicando os principais **Design Patterns (GoF)** em projetos **Java com Spring Boot**.

Cada atividade representa a implementação de **um padrão específico** — explorando sua motivação, estrutura e aplicação em cenários reais.  
Ao final, o conjunto culmina em um **projeto completo de e-commerce**, que integra vários desses padrões em uma arquitetura modular e extensível.

---

## Estrutura do Repositório


Cada pasta contém:
- Código-fonte da implementação.
- Um `README.md` explicando o problema, o padrão aplicado e como executar.
- Exemplos de chamadas **cURL** e saídas esperadas no terminal.

---

## Padrões Implementados

| Atividade | Padrão de Projeto | Tipo | Descrição |
|------------|------------------|------|------------|
| **1.1** | **Singleton** | Criacional | Garante que uma classe possua apenas uma instância global. |
| **1.2** | **Factory Method** | Criacional | Cria objetos sem expor a lógica de instância ao cliente. |
| **1.3** | **Adapter** | Estrutural | Converte interfaces incompatíveis para trabalharem juntas. |
| **1.4** | **Decorator** | Estrutural | Adiciona responsabilidades a objetos dinamicamente. |
| **1.5** | **Observer** | Comportamental | Permite que múltiplos objetos sejam notificados de mudanças. |
| **1.6** | **Strategy** | Comportamental | Define uma família de algoritmos intercambiáveis em tempo de execução. |
| **1.7** | **Chain of Responsibility** | Comportamental | Encadeia objetos para processar solicitações de forma sequencial. |
| **1.8** | **Template Method** | Comportamental | Define o esqueleto de um algoritmo, delegando etapas para subclasses. |
| **1.9** | **Facade** | Estrutural | Fornece uma interface unificada para um conjunto complexo de classes. |
| **E-commerce** | **Projeto Final** | Arquitetural | Integra múltiplos padrões em um sistema completo de e-commerce. |

---

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3+**
- **Maven**
- **API REST / JSON**
- **cURL / Postman** para testes

---

## Objetivo de Aprendizado

- Compreender o propósito e uso prático dos principais **padrões de projeto GoF**.  
- Aplicar **boas práticas de design** em aplicações Spring Boot.  
- Desenvolver **código reutilizável, extensível e de baixo acoplamento**.  
- Consolidar o aprendizado teórico com **implementações reais e testáveis**.

---

## Projeto Final — E-commerce

A pasta **`ecommerce/`** contém o **projeto integrador**, simulando um sistema de **vendas online**.  
Ele aplica diversos padrões em conjunto para organizar responsabilidades e fluxos, como:

- **Factory + Strategy**: criação e seleção de estratégias de pagamento e frete.  
- **Observer**: eventos de reabastecimento de produtos.  
- **Decorator**: aplicação de múltiplos descontos.  
- **Adapter + Facade**: integração com gateways externos de pagamento.  
- **Chain of Responsibility**: validações e processamento de pedidos.  

Exemplo de saída esperada no console:
```
[Chain] Inventory ok
[Chain] Fraud check ok
[Chain] Pricing calculated: 300.0
[Chain] Discount applied: 270.0
[Payment] Charging card user amount 300.0
[Chain] Payment processed by card
[Chain] Order persisted
```


---

## Informações sobre o desenvolvimento das atividades

Estas atividades foram desenvolvidas para fins **educacionais**, como parte das atividades da disciplina de **APSI**.

---

**Autor:** Hugo Alexandre  
**Disciplina:** APSI  
**Atividades — Implementações com Spring Boot**


