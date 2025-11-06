# Decorator — Sistema de Exportação de Dados

## Descrição do problema e solução

A empresa precisava de um **sistema de exportação de dados** que suportasse múltiplos formatos (JSON, XML, CSV) e permitisse aplicar **funcionalidades adicionais** como compressão, criptografia e validação, sem modificar os exportadores originais.

A solução foi aplicar o **padrão Decorator**, permitindo que essas responsabilidades fossem adicionadas **dinamicamente** aos objetos de exportação, mantendo o sistema **aberto para extensão e fechado para modificação**.

---

## Explicação dos padrões aplicados e justificativa

**Padrão aplicado:** Decorator (Estrutural)

- **O que faz:** Permite adicionar responsabilidades a objetos de forma dinâmica, sem alterar suas classes.  
- **Justificativa para o uso:**  
  - Suporta múltiplos formatos de exportação de forma consistente.  
  - Permite adicionar funcionalidades adicionais (compressão, criptografia, validação) sem modificar o código original.  
  - Facilita a extensão futura do sistema com novos comportamentos, mantendo baixo acoplamento.

---

## Instruções para executar o projeto

#### Subir o projeto Spring Boot (ou executar a classe principal no Spring):

```bash
mvn spring-boot:run
```

#### Testar o endpoint de exportação via terminal, escolhendo formato e funcionalidades:

##### Via CMD (o terminal ainda vai esperar)
```
curl -X POST "http://localhost:8080/export?format=json&encrypt=true&compress=true&validate=true" ^
-H "Content-Type: application/json" ^
-d "{\"nome\":\"Hugo\",\"idade\":25}"
```

##### Via Bash (melhor)

```
curl -X POST "http://localhost:8080/export?format=json&encrypt=true&compress=true&validate=true" \ -H "Content-Type: application/json" \ -d '{"nome":"Hugo","idade":25}'
```
#### Resultado esperado:

```
W0NPTVBSRVNTRURdeyJub21lIjoiSHVnbyIsImlkYWRlIjoyNX1bL0NPTVBSRVNTRURd
```

#### Os dados serão exportados em JSON, validados, comprimidos e criptografados dinamicamente.