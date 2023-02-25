import React from 'react';
import { Login } from './pages/Login/Login';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home/Home';
import { CadastrarProduto } from './pages/CadastroProduto/CadastrarProduto';
import { ProdutosParaEditar } from './pages/ProdutosParaEditar/ProdutosParaEditar';
import { EditarProduto } from './pages/EditarProduto/EditarProduto';
import * as C from "./GlobalStyle";
import { CadastrarMovimentacao } from './pages/CadastrarMovimentacao/CadastrarMovimentacao';
import { ListarMovimentacao } from './pages/ListarMovimentacao/ListarMovimentacao';



function App() {
  return (
   <C.Main>
     <Router>
      <Routes>
        <Route path="/" element={<Login/>} />
        <Route path="/home" element={<Home/>} />
        <Route path="/cadastrarProduto" element={<CadastrarProduto/>} />
        <Route path="/produtosParaEditar" element={<ProdutosParaEditar/>} />
        <Route path="/editar/:id" element={<EditarProduto/>} />
        <Route path="/lancarMovimentacao" element={<CadastrarMovimentacao/>} />
        <Route path="/listarMovimentacao" element={<ListarMovimentacao/>} />
      </Routes>
    </Router>
   </C.Main>
  );
}

export default App;
