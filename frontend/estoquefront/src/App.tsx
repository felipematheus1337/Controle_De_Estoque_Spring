import React from 'react';
import { Login } from './pages/Login/Login';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home/Home';
import { CadastrarProduto } from './pages/CadastroProduto/CadastrarProduto';
import { ProdutosParaEditar } from './pages/ProdutosParaEditar/ProdutosParaEditar';
import { EditarProduto } from './pages/EditarProduto/EditarProduto';


function App() {
  return (
   <main>
     <Router>
      <Routes>
        <Route path="/" element={<Login/>} />
        <Route path="/home" element={<Home/>} />
        <Route path="/cadastrarProduto" element={<CadastrarProduto/>} />
        <Route path="/produtosParaEditar" element={<ProdutosParaEditar/>} />
        <Route path="/editar/:id" element={<EditarProduto/>} />
      </Routes>
    </Router>
   </main>
  );
}

export default App;
