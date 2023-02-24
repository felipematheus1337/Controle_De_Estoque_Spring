import React from 'react';
import { Login } from './pages/Login/Login';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Home } from './pages/Home/Home';
import { CadastrarProduto } from './pages/CadastroProduto/CadastrarProduto';


function App() {
  return (
   <main>
     <Router>
      <Routes>
        <Route path="/" element={<Login/>} />
        <Route path="/home" element={<Home/>} />
        <Route path="/cadastrarProduto" element={<CadastrarProduto/>} />
      </Routes>
    </Router>
   </main>
  );
}

export default App;
