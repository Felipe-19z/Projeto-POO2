# Projeto-POO2
Melhoria do projeto da AV1
## 🚀 Infraestrutura de Segurança, Coleções e Fluxo de Controle

Esta seção detalha a evolução do sistema nas camadas de resiliência, tratamento personalizado de erros, modernização do armazenamento em memória com o Java Collections Framework e a separação definitiva de responsabilidades arquiteturais. O desenvolvimento foi mapeado e enviado de forma incremental através da seguinte sequência de commits:

### 📌 Commit 1 — Etapa 11: Infraestrutura de Exceções de Negócio Personalizadas

#### ⚙️ Como funciona:
Este commit constrói o suporte de segurança de dados e consistência das regras clínicas por meio da criação de 5 exceções personalizadas, herdadas diretamente da classe base `Exception` (caracterizando-as como exceções verificadas). Cada uma dessas classes foi projetada com sobrecarga de construtores. Isso permite instanciar e lançar o erro passando tanto uma mensagem de texto explicativa quanto anexar uma causa original (`Throwable causa`), o que enriquece consideravelmente o rastreamento de falhas no console de depuração sem expor vulnerabilidades estruturais do código-fonte.

---

### 📌 Commit 2 — Etapas 10 e 13: Centralização de Regras de Negócio e Java Collections Framework

#### ⚙️ Como funciona:
Este commit implementa a classe de controle `ClinicaServico`, aplicando um padrão de arquitetura focado na separação de responsabilidades. Todos os antigos arrays de tamanho fixo e os contadores manuais da versão anterior do sistema foram completamente eliminados da memória. Em seu lugar, foi adotada a API do *Java Collections Framework*:
* **`ArrayList`**: Utilizado para gerenciar de forma dinâmica e ordenada o histórico crescente de consultas, atendimentos e transações financeiras.
* **`HashSet<String>`**: Aplicado para validar e bloquear de forma instantânea qualquer tentativa de cadastrar CPFs duplicados, tirando proveito da alta performance de busca em tempo constante.
* **`HashMap`**: Configurado em duas tabelas hash distintas para realizar buscas diretas indexadas por chave (CPF para mapeamento de pacientes e Nome para localização de profissionais), otimizando a eficiência das consultas operacionais.

---

### 📌 Commit 3 — Etapa 12: Resiliência do Fluxo e Isolamento da Interface Main

#### ⚙️ Como funciona:
Este commit reestrutura completamente a classe executável `Main` para atuar unicamente como a camada de interface gráfica textual com o usuário. A inteligência e as regras de processamento interno foram totalmente isoladas na camada de serviço, restando na `Main` apenas a exibição de menus e a captura de entradas do teclado via objeto `Scanner`. 

O fluxo de execução do console foi blindado contra falhas fatais por meio de blocos de tratamento interconectados (`try/catch`). Caso o operador insira caracteres de texto em campos estritamente numéricos do menu, a exceção nativa `NumberFormatException` é capturada imediatamente, disparando um alerta amigável na tela em vez de derrubar a aplicação. Por fim, o bloco `finally` garante a execução de procedimentos de encerramento seguro e a liberação controlada de recursos ao término de cada iteração operacional.
