# Projeto-POO2
Melhoria do projeto da AV1
# 📑 Resumo do Desenvolvimento Incremental

O processo de refatoração e evolução do sistema **VidaPlena** foi realizado de forma inteiramente incremental e isolada, assegurando a estabilidade e a compilação do código a cada nova etapa concluída. Abaixo encontra-se o resumo das frentes de desenvolvimento mapeadas no histórico de commits do repositório:

### 🏗️ Commits de Arquitetura de Classes e Hierarquias (Etapas 2, 3, 4 e 5)
* **Foco principal:** Construção da fundação estrutural e da árvore de herança profunda da aplicação.
* **Entregas:** Criação da superclasse abstrata `Pessoa`, reformulação da classe `Paciente` integrada a um objeto real de `Convenio`, desenvolvimento da classe abstrata `Profissional` e das quatro subclasses de especialidades clínicas (`Fisioterapeuta`, `Psicologo`, `Nutricionista` e `ClinicoGeral`), atingindo os três níveis de profundidade exigidos pelo modelo arquitetural.

### 🔒 Commits de Encapsulamento, Contratos e Regras Financeiras (Etapas 6, 7, 8 e 9)
* **Foco principal:** Proteção de dados em memória, definição de contratos de comportamento e regras de faturamento polimórficas.
* **Entregas:** Aplicação do encapsulamento rígido com filtros de validação nos métodos modificadores (*setters*), criação das interfaces de tipo múltiplo `Agendavel` e `Exportavel`, desenvolvimento do fluxo abstrato e polimórfico de `Pagamento` (Dinheiro, Cartão e Convênio) e codificação das associações estruturais de Agregação (horários) e Composição (prontuários).

### 🛡️ Commits de Estruturas de Dados, Segurança e Camada Service (Etapas 10, 11, 12 e 13)
* **Foco principal:** Robustez do fluxo de execução, modernização do armazenamento e separação de responsabilidades.
* **Entregas:** Desenvolvimento da infraestrutura de exceções customizadas para o domínio clínico, substituição definitiva de arrays fixos pelas coleções dinâmicas do *Java Collections Framework* (`ArrayList`, `HashSet` e `HashMap`), centralização de toda a inteligência do sistema na classe controladora `ClinicaServico` e blindagem da interface funcional `Main` com blocos `try/catch/finally`.

---
se quer mais detalhes, acesse cada branch
