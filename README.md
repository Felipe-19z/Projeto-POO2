# Projeto-POO2

# Refatoração das Etapas 2 a 5

Este documento apresenta as alterações realizadas durante a refatoração do projeto, com o objetivo de reorganizar a estrutura do sistema utilizando conceitos de Programação Orientada a Objetos. 
As modificações foram divididas em três etapas, contemplando abstração, herança e associação entre as classes.
---

## Bloco 1 - feat: refatoração etapa 2 - Criação da superclasse abstrata Pessoa

Nesta etapa foi criada uma superclasse responsável por reunir as informações comuns utilizadas pelas entidades do sistema, como nome, CPF, idade e telefone.
A partir dessa reorganização, os dados compartilhados passaram a ficar centralizados em um único local, reduzindo a repetição de informações e estabelecendo uma base para as demais classes do projeto.

---

## Bloco 2 - feat: refatoração etapa 3 - Implementação de heranca em Paciente e associação com Convenio

Nesta etapa foi realizada a reorganização da estrutura do paciente, permitindo o reaproveitamento das informações comuns definidas na superclasse.
Também foi criada uma estrutura própria para representar o convênio do paciente, tornando esse relacionamento mais organizado e facilitando o gerenciamento das informações relacionadas ao atendimento.
Além disso, a apresentação das informações do paciente foi adaptada para seguir a nova organização do sistema.

---

## Bloco 3 - feat: refatoração etapas 4 e 5 - Criação da hierarquia abstrata de Profissional e Especialidades

Nesta etapa foi criada a hierarquia dos profissionais da clínica, estabelecendo uma estrutura comum para as diferentes especialidades cadastradas no sistema.
Cada especialidade passou a possuir suas próprias características e responsabilidades, mantendo uma organização única para os elementos compartilhados entre elas.
Também foi adicionada uma estrutura de apoio utilizada durante o desenvolvimento desta etapa para permitir a integração da nova hierarquia ao restante do projeto.

---

## A organização geral ficou estruturada da seguinte forma:

Pessoa
|-- Paciente
|-- Profissional
    |-- Fisioterapeuta
    |-- Psicologo
    |-- Nutricionista
    |-- ClinicoGeral
