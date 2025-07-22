# 📚 Sistema de Gerenciamento de Tarefas

Projeto onde foi desenvolvido um sistema de gerenciamento de tarefas, com foco no aprendizado e prática de conceitos fundamentais de backend. O objetivo principal é permitir o cadastro, visualização, atualização e exclusão de tarefas, com integração ao banco de dados relacional MySQL.

<br>

## 📦 Tecnologias

- `Java + Spring Boot`: Framework robusto e amplamente utilizado no mercado para o desenvolvimento de APIs REST.
- `Gradle`: Gerenciador de dependências e ferramenta de build do projeto.
- `MySQL`: Banco de dados relacional para armazenar as tarefas de forma estruturada.
- `GitHub Actions`: Para realizar testes automatizados.

- `HTML`: Estruturação da página.
- `CSS`: Responsável pelo layout e estilo visual do projeto.
- `JavaScript`: Adiciona interatividade ao sistema, como captura de eventos de usuários e requisições à API usando fetch.
<br>

## ▶️ Clonar e Rodar

1. Clone o repositório
~~~
git clone https://github.com/marvaleri/api-tarefas.git
~~~

2. Configure o Banco de Dados

- Abra o MySQL Workbench (ou outro cliente MySQL).
- Crie um banco de dados e o nomeie.

3. Entre no Backend do Projeto

- Adicione as credenciais no arquivo application.properties:
~~~
spring.datasource.url=jdbc:mysql://localhost:3306/(nome do banco)
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
~~~

4. Frontend
- Abra o Frontend do projeto no seu editor de código.
- Para atualizar ou deletar uma tarefa, execute o arquivo index.html diretamente no navegador.
- Certifique-se de que o backend esteja rodando para que o frontend consiga buscar os dados corretamente.
<br>

## 🧮 Metodologia Utilizada

Kanban foi a principal metodolofia utilizada, sendo fundamental para visualizar o andamento do projeto, com as tarefas sendo organizadas em colunas como:
`A Fazer`
`Em Progresso`
`Concluído`

<br>

## 📈 Mudanças no Projeto

Durante o decorrer do projeto, foi alterado atributos envolvendo data de criação e conclusão da classe tarefa, adicionando um novo atributo de descrição para melhor detalhamento da tarefa a ser criada.
