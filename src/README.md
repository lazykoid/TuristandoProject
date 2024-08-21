# Turistando - Code Review 
## Teste IO Errado

[![Video Testando Erros](https://img.youtube.com/vi/E3teUefF-d4/0.jpg)](https://www.youtube.com/watch?v=E3teUefF-d4)

## Estrutura do Projeto

### Explicação das classes

- *Localidade.java*
  - Classe abstrata que serve como base para Pais, Estado, Cidade e PontoTuristico.
  - Contém o atributo nome e o método abstrato obterInformacoes().

- *Pais.java*
  - Extende Localidade.
  - Contém uma lista de objetos Estado.
  - Métodos principais:
    - adicionarEstado(Estado estado): Adiciona um estado à lista de estados do país.
    - getEstados(): Retorna a lista de estados.
    - obterInformacoes(): Retorna informações sobre o país, incluindo o número de estados.

- *Estado.java*
  - Extende Localidade.
  - Contém uma lista de objetos Cidade.
  - Métodos principais:
    - adicionarCidade(Cidade cidade): Adiciona uma cidade à lista de cidades do estado.
    - getCidades(): Retorna a lista de cidades.
    - obterInformacoes(): Retorna informações sobre o estado.

- *Cidade.java*
  - Extende Localidade.
  - Atributos: cep, area, e uma lista de PontoTuristico.
  - Métodos principais:
    - adicionarPontoTuristico(PontoTuristico ponto): Adiciona um ponto turístico à lista.
    - getArea(), getCep(), setArea(String area), setCep(String cep): Métodos de acesso e modificação para area e cep.
    - obterInformacoes(): Retorna informações sobre a cidade.

- *PontoTuristico.java*
  - Representa um ponto turístico com atributos nome, tipo, review e rating.
  - Métodos principais:
    - setReview(String review, int rating): Define o review e a nota do ponto turístico.
    - getNome(), getTipo(), getReview(), getRating(): Métodos de acesso para os atributos.

- *GerenciadorDeLocalidades.java*
  - Gerencia uma lista de Localidade.
  - Métodos principais:
    - adicionarLocalidade(Localidade localidade): Adiciona uma localidade à lista.
    - exportToCSV(String filePath): Exporta os dados de localidades e reviews para um arquivo CSV.
    - displayCSVContents(String filePath): Exibe o conteúdo do arquivo CSV no console.

- *Main.java*
  - Interface de linha de comando que permite ao usuário interagir com o sistema.
  - Oferece opções para adicionar reviews, visualizar reviews e sair do sistema.
  - Utiliza Scanner para capturar entradas do usuário e gerencia exceções para garantir entradas válidas.
