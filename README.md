# Projeto-POO2
Melhoria do projeto da AV1

## 🧑‍💻 Detalhamento de Implementação — Integrante 2

Esta seção descreve a evolução da arquitetura do sistema nas camadas de encapsulamento, contratos de interfaces, processamento financeiro polimórfico e modelagem de associações estruturais avançadas (UML). O trabalho foi segmentado em três blocos funcionais para garantir o versionamento incremental do código:

### 📦 BLOCO 1 — Etapas 6 e 7: Encapsulamento, Validações e Interfaces de Contrato

#### ⚙️ Como funciona:
Este bloco foca estritamente na segurança dos dados em memória e no estabelecimento de contratos comportamentais da aplicação.
* **Encapsulamento e Validações Rígidas:** Os métodos modificadores (*setters*) da superclasse `Pessoa` foram reestruturados para incluir filtros de validação. O sistema agora barra comportamentos inconsistentes, impedindo a atribuição de idades negativas ou o registro de CPFs nulos/vazios.
* **Contratos Estruturais:** Foram introduzidas as interfaces obrigatórias `Agendavel` (para gestão de ciclo de vida de horários) e `Exportavel` (para auditoria de dados).
* **Implementação Múltipla:** A classe `Consulta` foi projetada para demonstrar a aplicação de múltiplos tipos. Ela implementa simultaneamente ambas as interfaces, respondendo de forma isolada às rotinas operacionais de agendamento e gerando sua própria representação textual padronizada para exportação.

---

### 📦 BLOCO 2 — Etapa 8: Polimorfismo e Regras de Pagamento Específicas

#### ⚙️ Como funciona:
Este bloco elimina estruturas condicionais genéricas (`if/else`) na camada de faturamento, substituindo-as por uma arquitetura polimórfica robusta e escalável.
* **Abstração Financeira:** A classe `Pagamento` foi elevada ao status de classe abstrata e vinculada ao contrato da interface `Exportavel`.
* **Especializações Polimórficas:** Foram criadas três subclasses distintas para gerenciar as regras financeiras da clínica em tempo de execução:
  * `PagamentoDinheiro`: Executa a aplicação automática do desconto de 5%.
  * `PagamentoCartao`: Valida o limite de até 6 parcelas e processa o acréscimo de taxas de juros incrementais caso o parcelamento exceda 3 prestações.
  * `PagamentoConvenio`: Realiza a leitura dinâmica das regras contratuais e do percentual de cobertura do objeto `Convenio` associado ao paciente para calcular o saldo final devido.

---

### 📦 BLOCO 3 — Etapa 9: Modelagem Semântica de Relacionamentos (Agregação e Composição)

#### ⚙️ Como funciona:
Este bloco traduz para o código-fonte as restrições de ciclo de vida e acoplamento estabelecidas no diagrama de classes UML do sistema.
* **Agregação:** A classe `HorarioDisponivel` foi desenvolvida e integrada a uma coleção interna da classe `Profissional`. Por se tratar de uma agregação, garante-se a independência semântica: a grade de horários da clínica permanece íntegra no sistema mesmo se o profissional associado for desligado.
* **Composição Estrita:** O relacionamento entre `Atendimento` e `Prontuario` foi codificado como uma composição pura. O construtor da classe `Prontuario` possui visibilidade protegida e sua instância é obrigatoriamente vinculada ao ciclo de vida de um `Atendimento`. Isso impede a existência de prontuários órfãos e garante que, caso um atendimento seja removido do sistema, seu prontuário seja deletado da memória por consequência.
