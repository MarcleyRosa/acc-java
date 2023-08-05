### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio: Sistema Bancário 

Suponha que chegou até você uma demanda para fazer algumas classes de um sistema bancário, utilizando, obrigatoriamente, a prática de Test Driven Development. Nessa demanda, você será responsável por fazer 3 classes (`ContaBancaria`, `Cliente`, `ValidaCPF`), com as seguintes características:

- `ValidaCPF`: será uma classe com apenas um método estático. O método é o `validarCPF()`, que é responsável por receber uma String de números (ex: 17892255710), que representa o CPF da pessoa cliente, e verificar se é um CPF válido (no final desta seção há uma explicação sobre o cálculo que valida CPF). 

Resumindo, esse método:
    1. recebe uma String que representa o CPF da pessoa cliente, ex: 17892255710;
    2. faz o cálculo para verificar se o CPF é válido ou inválido;
    3. retorna um valor booleano, ou seja, retorna true se o CPF for válido, e false se for inválido.

    ⚠️🔴**Dica: a declaração dessa classe deve ser** `public static boolean validarCPF(String cpf)`**.** 🔴⚠️

- `Cliente`: será uma classe com dois atributos privados e seus respectivos getters e setters. Os atributos são o nome e o cpf da pessoa cliente. A descrição dos atributos e dos métodos getters e setters são:

    - `nome`: esse atributo é uma String para representar o nome da pessoa cliente da conta bancária. Seus getters e setters são:
          - `setNome`: recebe uma String que representa o nome da pessoa cliente e adiciona ao atributo `nome`;
          - `getNome`: retorna uma String que representa o nome da pessoa cliente;
          
    - `cpf`: esse atributo é uma String para representar o CPF da pessoa cliente da conta bancária. Seus getters e setters são:
        - `setCPF`: recebe uma String que representa o CPF da pessoa cliente, e então realiza os seguintes passos: 
            1. chama o método estático `validarCPF()` da classe `ValidaCPF`, passando a String recebida.
            2. se o método `validarCPF` retornar `true`, então a String é adicionada ao atributo `cpf`, caso contrário o `null` deve ser adicionado ao atributo `cpf`.
        - `getCPF`: retorna uma String que representa o CPF da pessoa cliente;

    ⚠️🔴**IMPORTANTE: o método** `setCPF` **verifica se a String recebida representa um número de CPF válido através do método estático** `validaCPF()`**.** 🔴⚠️

- `ContaBancaria`: será uma classe com dois atributos e sete métodos estáticos. Os atributos são: `saldo` do tipo inteiro e `cliente` do tipo `Cliente`. Você deverá também implementar o construtor dessa classe para instanciar o objeto da classe Cliente e iniciar o saldo da conta como 0. Os métodos e os atributos estão descritos a seguir:

    - **Atributos**
        - `saldo`: tipo inteiro;
        - `cliente`: é uma instância da classe `Cliente`.
        
    - **Métodos**
        - `setNomeCliente`: esse método é responsável por receber uma String que representa o nome da pessoa cliente, e chama o método `setNome` do objeto `cliente`, passando a String recebida;
        - `getNomeCliente`: esse método é responsável por chamar o método `getNome` do objeto `cliente` e retornar como String;
        - `setCPFCliente`: esse método é responsável por receber uma String que representa o cpf da pessoa cliente, e chama o método `setCPF` do objeto `cliente`, passando a String recebida;
        - `getCPFCliente`: esse método é responsável por chamar o método `getCPF` do objeto `cliente` e retornar como String;
        - `depositar`: esse método recebe um valor inteiro, adiciona-o ao atributo `saldo` e depois retorna o novo valor do atributo `saldo`;
        - `sacar`: esse método recebe um valor inteiro, subtrai esse valor do atributo `saldo` e depois retorna o novo valor do atributo `saldo`;
        - `verSaldo`: retorna um valor inteiro, que representa o valor armazenado no atributo `saldo`;
        
    ⚠️🔴**IMPORTANTE: implemente o construtor da classe** `ContaBancaria` **para instanciar o objeto** `cliente` **e iniciar o atributo** `saldo` **como zero.** 🔴⚠️
    
Pronto, essa é a descrição da nossa demanda! Lembre-se de que você deve iniciar a codificação pelos testes, porque a exigência é que esse projeto seja feito utilizando Test Driven Development. Então, no teste você terá que implementar 3 classes, cada uma referente ao teste das classes da demanda, além de seus respectivos métodos para testar os métodos da demanda.

- `TesteValidaCPF`: essa classe teste será responsável por conter os métodos testes para avaliar a classe `ValidaCPF`. Essa classe deve ter no mínimo dois métodos testes.
    - `testeValidarCPFValido`: responsável por testar se o retorno de um CPF válido é `true`;
    - `testeValidarCPFInvalido`: responsável por testar se o retorno de um CPF inválido é `false`.

    ⚠️🔴**Dica: lembre-se de usar** `assertTrue` **e** `assertFalse` **para avaliar condições.** 🔴⚠️
    
- `TesteCliente`: essa classe teste será responsável por conter os métodos testes para avaliar a classe `Cliente`. Essa classe deve ter no mínimo três métodos testes.
    - `testeNome`: responsável por testar se a String recebida é adicionada ao atributo `nome`;
    - `testeSetCPFValido`: responsável por testar se a String recebida de um CPF válido é adicionada ao atributo `cpf`;
    - `testeSetCPFInvalido`: responsável por testar se a String recebida de um CPF inválido não é adicionada ao atributo `cpf`, e nesse caso o atributo `cpf` deve ser `null`;

- `TesteContaBancaria`: essa classe teste será responsável por conter os métodos testes para avaliar a classe `ContaBancaria`. Essa classe deve ter no mínimo seis métodos testes.
    - `testeNomeCliente`: responsável por testar se a String recebida é adicionada ao atributo `nome` do objeto `cliente`;
    - `testeCPFClienteValido`: responsável por testar se a String recebida representando um CPF válido é adicionada ao atributo `cpf` do objeto `cliente`;
    - `testeCPFClienteInvalido`: responsável por testar se a String recebida representando um CPF inválido não é adicionada ao atributo `cpf` do objeto `cliente`, e se o atributo `cpf` é null;
    - `testeDepositar`: responsável por testar se o valor recebido é adicionado ao atributo `saldo`;
    - `testeSacar`: responsável por testar se o valor recebido é subtraído do atributo `saldo`;
    - `testeVerSaldo`: responsável por testar se o valor retornado é o mesmo do atributo `saldo`.


⚠️🔴**Fórmula de calcular o CPF** 🔴⚠️


O CPF (Cadastro de Pessoa Física) é um número com 11 dígitos, cujos dois últimos são calculados com base nos dígitos anteriores. Os dois últimos números são chamados de dígitos verificadores, ou DV. Vamos utilizar o 988.841.550-61 como exemplo para o cálculo.

No CPF temos dois dígitos verificadores, e para calcular cada um deles há duas etapas: a primeira é a soma da multiplicação de cada dígito por pesos; a segunda faz uma subtração utilizando a soma módulo 11 ("módulo" aqui pode ser entendido como o resto da divisão). Vamos a um exemplo:

- Primeiro DV:

    1. Primeiro Passo: os nove primeiros dígitos do CPF são multiplicados por pesos, que começam de 10 e vão diminuindo de 1 em 1, e depois se soma tudo:
        ```
        soma = (9*10)+(8*9)+(8*8)+(8*7)+(4*6)+(1*5)+(5*4)+(5*3)+(0*2)
        soma = 346
        ```
    2. Segundo passo: usamos o resultado dessa soma para calcular o primeiro DV:
        ```
        11 - (soma % 11)
        11 - (346 % 11)
        11 - 5 = 6
        ```
    ⚠️🔴**IMPORTANTE** 🔴⚠️ se a subtração 11 - (soma % 11) for 10 ou 11, o dígito verificador será 0; nos outros casos, o dígito verificador é o próprio resultado da subtração.
    
    Exemplo:
    ```
    11 - (soma % 11)
    11 - 1 = 10
    então o DV tem que ser zero
    ```
    ou
    ```
    11 - (soma % 11)
    11 - 0 = 11
    então o DV tem que ser zero
    ```

- Segundo DV:
    
    1. Primeiro Passo: os dez primeiros dígitos do CPF (os nove originais e o primeiro DV) são multiplicados por pesos que começam de 11 e vão sendo diminuídos de 1, depois se soma tudo:
        ```
        soma = (9*11)+(8*10)+(8*9)+(8*8)+(4*7)+(1*6)+(5*5)+(5*4)+(0*3)+(6*2)
        soma = 406
        ```
    2. Segundo passo: usamos o resultado dessa soma para calcular o segundo DV:
        ```
        11 - (soma % 11)
        11 - (406 % 11)
        11 - 10 = 1
        ```
     ⚠️🔴**IMPORTANTE** 🔴⚠️ se a subtração 11 - (soma % 11) for 10 ou 11, o dígito verificador será 0; nos outros casos, o dígito verificador é o próprio resultado da subtração.
    Exemplo:
    ```
    11 - (soma % 11)
    11 - 1 = 10
    então o DV tem que ser zero
    ```
    ou
    ```
    11 - (soma % 11)
    11 - 0 = 11
    então o DV tem que ser zero
    ```

---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
