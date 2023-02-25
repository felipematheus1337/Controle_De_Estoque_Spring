# Projeto Fullstack de Controle de Estoque
Um sistema de controle de estoque, utilizando Java com Spring para o Backend, e React com Typescript para o Frontend

## Tecnologias Utilizadas
<div style="display: inline_block" align="left">
  <img alt="lipe-Js" height="55" width="55" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-plain.svg">
  <img  alt="lipe--CSS" height="55" width="55" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
  <img alt ="lipe-CSS" height="55" width="55" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/react/react-original.svg">
  <img alt ="lipe-CSS" height="55" width="55" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/typescript/typescript-original.svg">
</div> 


## Pré-Requisitos
<p>Maven 3.6 >
<p>Java 17</p>
<p>React</p>
<p>Typescript</p>

## Features / Funcionalidades
<p>Autenticação com JWT</p>
<p>Gerenciamento de rotas por Role's</p>
<p>Tratamento personalizado de Exceção</p>

## Regras de negócio
<h3>Filtros:</h3>
<h4>Produto: Permitir filtrar os lançamentos por produto.</h4>
<h4>Período: Permitir filtrar os lançamentos de um determinado período.</h4>
<h4>Tipo de Movimento: Permitir filtrar os lançamentos de um determinado Tipo de Movimento.</h4>

<h3>Ordenações:</h3>
<h4>Produto</h4>
<h4>Data</h4>
<hr/>

# Tela do Menu
<img src="https://github.com/felipematheus1337/Controle_De_Estoque_Spring/blob/dev/docs/TELA_INICIAL.jpeg?raw=true" />
<p>Detalhe para regra de negócio: Usuário logado como Operador, não tem acesso a parte de Produtos!</p>

# Telas dos Produtos
<img src="https://raw.githubusercontent.com/felipematheus1337/Controle_De_Estoque_Spring/e39810f806236ef6842e92e5922ebd8569cef8f5/docs/TELA_PRODUTO.jpeg?token=ATCN3NTJO6O2PB3LYC2UKFTD7IK6M" />
<p>Somente usuário logado como gerente, tem acesso a essa funcionalidade!</p>

# Telas das Movimentações
<img src="https://github.com/felipematheus1337/Controle_De_Estoque_Spring/blob/dev/docs/TELA_MOVIMENTACAO.jpeg?raw=true" />

# Tela dos Modais dos filtros
<img src="https://github.com/felipematheus1337/Controle_De_Estoque_Spring/blob/dev/docs/TELA_MODAL.jpeg?raw=true" />


# Endpoints
BASE_URL : http://localhost:8081/server
<p> Ao utilizar Spring Security com JWT somente 2 portas estão liberadas o acesso público, são elas: </p>
<p> /server/usuario/create pra criar um usuário!, segue exemplo do json para criação do user : </p>
<p>Method: POST</p>
<span>{
    "name":"Felipe",
    "email":"felipe@mail.com",
    "password":"123456",
    "role":"GERENTE"
}</span>
<br>
<p> /server/login para logar e ser gerado o token!, segue o exemplo do json para criação do token/autenticação: </p>
<p> Method: POST </p>
<span>{
    "email":"felipe@mail.com",
    "password":"123456"
}
</span>
<br>
<h3> Outras rotas: </h3>
 <span>/produto</span>,
 <span>/movimentacao</span>
 <span>/business</span>
 <h4> Se faz necessário a autenticação através do Bearer Token, que é gerado pelo endpoint login</h4>
 <h4> Mas o frontend faz todo esse trabalho de autenticação com um hook customizado, fazendo uso da ContextAPI do React</h4>

# Backend

## Criando o Jar
mvn clean package

## Executando o Projeto (back)
mvn spring-boot:run

# Frontend

## Instalar NPM
<p>Instalar o NPM</p>
<p>Node a partir da versão 14 de preferência</p>
<p>Ir na pasta raíz do projeto, no terminal digitar: npm install</p>

## Executando o Projeto (front)
<p> Na pasta do Projeto, no terminal executar o comando: npm start</p>



