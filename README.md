### Password Validator

- Java 11
- Spring Boot

#

Para executar e subir o projeto, rodar os comandos:

``` bash  
mvn clean install && mvn spring-boot:run
```  

#

#### Endpoint

``` xpath2 
localhost:PORT/api/password/{PASSWORD}/validate
```

# 

Como contexto do projeto é bem simples, então usei o mínimo de dependências possível.

Por exemplo, não fiz uso do Lombok, já que não tem muito boilerplate.

Sobre a solução:
No controler, e mais especificamente, no endpoint de validação, 
como é uma consulta para validar se a chave é válida, utilizei GET,
passando a senha como parametro no PATH. Já que o retorno é um boolean,
não fiz uso do ResponseEntity e nem do ResponseStatus, uma vez que o retorno
default já OK (200). 

A fim de seguir o princípio da Injeção de Dependência, o Service responsável
por ter as regras de negócio da validação da senha, foi injetado no Construtor
do Controller.

Como mencionado anteriormente, o Service carrega toda a regra de negócio para
a validação. Sua única dependência é o pacote do Regex. Sobre a validação,
resolvi separá-la em duas etapas: caracters repetidos e padrão da senha.

O motivo de separá-la, foi para poder reaproveitar os métodos do Regex em outro
cenário, caso seja necessário. Da forma como está, posso utilizar a verificação
de caracteres repetidos em outro contexto sem precisar incluir nenhuma nova linha
na classe de Regex.

Sobre o método de validação de regex, optei por deixar o mais genérico possível,
uma vez que só precisar informar qual é o padrão que ele irá usar para validar 
a String informada.

Apesar da solução do Regex possuir um acopamento entre a classe Util e o Enum,
acredito (tradeoff) fazer sentido pra esse contexto, uma vez que basta eu adicionar 
um novo padrão válido no Enum e referencia-lo na chamada do método. Caso eu 
mantivesse o regex como String, poderia ocorrer de informarem um padrão de Regex 
que não é compatível.

Agora, no contexto dos testes, segui com os Unitário e Integrado. Talvez, fizesse
sentido desenvolver os testes unitários para a classe de serviço, porém
como consigo cobrir toda a regra de negócios com o teste integrado, utilizei o
Unitário apenas na classe Util do Regex.

Reforçando a ideia inicial, da baixa complexidade do desafio, não quis inserir nada
além do necessário. Por conta disso, talvez seja difícil termos exemplos de 
todos princípios do SOLID, mas temos um exemplo claro do KISS (Keep is Simple Stupid).


