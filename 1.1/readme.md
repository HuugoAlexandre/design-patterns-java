# Padrão Criacional: Singleton (Sistema de Logs em Memória)

## Descrição do Problema e Solução

A aplicação precisava de um sistema de **logs centralizado**, capaz de registrar mensagens em diferentes níveis (`INFO`, `WARN`, `ERROR`) e armazenar as últimas 100 entradas **em memória**, sem depender de banco de dados.  

Para garantir que todas as partes do sistema acessassem o mesmo serviço de log — mantendo **um único estado compartilhado** — foi aplicado o padrão **Singleton**, utilizando o gerenciamento automático de instâncias do Spring Boot.

O serviço `LogService` foi definido com a anotação `@Service`, tornando-se um **bean Singleton** gerenciado pelo container do Spring.  
Com isso, qualquer classe que precise registrar logs (como o `LogController`) recebe a mesma instância do serviço.

---

## Padrão Aplicado e Justificativa

**Padrão:** Singleton  
**Categoria:** Criacional  

### Explicação
O padrão **Singleton** garante que exista **apenas uma instância** de uma classe em toda a aplicação, fornecendo um ponto global de acesso a ela.

No contexto do Spring Boot, isso foi alcançado automaticamente pelo uso da anotação `@Service`, que cria e gerencia o ciclo de vida de um bean único (`LogService`).

### Benefícios
- Consistência: todos os logs são armazenados no mesmo serviço.
- Desempenho: evita recriações desnecessárias do objeto.
- Simplicidade: controle de instâncias delegado ao Spring.
- Baixo acoplamento: o `LogController` apenas consome o serviço injetado.

---

## Instruções para Executar o Projeto

### 1️. Executar a aplicação
Certifique-se de estar na raiz do projeto e rode (ou apenas clique em executar no Spring):

```bash
mvn spring-boot:run
```

A aplicação iniciará no endereço padrão:
```
http://localhost:8080
```

### 2️. Testar os Endpoints
#### obs: execute esses comandos via CMD, no bash são diferentes.
Registrar logs
```
curl -X POST "http://localhost:8080/logs/info?message=Teste%20de%20info"
curl -X POST "http://localhost:8080/logs/warn?message=Aviso%20teste"
curl -X POST "http://localhost:8080/logs/error?message=Erro%20teste"
``` 

Consultar logs registrados
```
curl http://localhost:8080/logs
```

### Conclusão

O uso do padrão Singleton permitiu criar um serviço de logs centralizado, eficiente e seguro, mantendo um único estado de execução em toda a aplicação.
A combinação com os princípios de Inversão de Controle (IoC) e Injeção de Dependência (DI) garantiu baixo acoplamento e fácil manutenção, cumprindo integralmente os requisitos do projeto.