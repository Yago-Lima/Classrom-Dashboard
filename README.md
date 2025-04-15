# Classroom_DashBoard

Este projeto é um aplicativo educacional desenvolvido para fins de aprendizado. Ele fornece insights estatísticos sobre o desempenho de uma turma, incluindo métricas como médias de notas, idades e status dos alunos (aprovados ou reprovados).

## Funcionalidades

- Exibição de estatísticas gerais da turma:
  - Média geral das notas
  - Média de idade
  - Aluno com a maior nota
  - Aluno com a menor nota
- Listagem de alunos aprovados e reprovados utilizando `RecyclerView`.
- Visualização detalhada das informações de cada aluno.
- Interface limpa e responsiva com suporte a rolagem.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Frameworks**: Android SDK
- **Ferramenta de Build**: Gradle
- **Componentes de UI**: RecyclerView, ConstraintLayout, ScrollView
- **Bibliotecas**:
  - [Lottie](https://airbnb.io/lottie/) para animações
  - [Gson](https://github.com/google/gson) para serialização/deserialização de JSON

## Estrutura do Projeto

- `model/`: Contém os modelos de dados como `Turma`, `Estudante` e `Estatisticas`.
- `adapter/`: Inclui os adaptadores personalizados para o `RecyclerView`.
- `Activity2.java`: Exibe informações detalhadas sobre um aluno selecionado.
- `Activity3.java`: Exibe as estatísticas da turma e as listas de alunos.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/NOME_DO_PROJETO.git
   ```
2. Abra o projeto no Android Studio.
3. Sincronize o Gradle e certifique-se de que todas as dependências estão instaladas.
4. Execute o aplicativo em um emulador ou dispositivo físico.

## Capturas de Tela

*(Adicione capturas de tela do aplicativo aqui para demonstrar suas funcionalidades.)*

## Propósito

Este projeto foi criado como parte de uma jornada de aprendizado pessoal para aprimorar habilidades no desenvolvimento Android, com foco em design de interface, manipulação de dados e arquitetura de aplicativos.

## Licença

Este projeto é destinado apenas para fins educacionais e não possui fins comerciais.
 
