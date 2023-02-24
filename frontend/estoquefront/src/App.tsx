import React from 'react';
import { Login } from './pages/Login/Login';
import {BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {
  return (
   <main>
     <Router>
      <Routes>
        <Route path="/" element={<Login/>} />
      </Routes>
    </Router>
   </main>
  );
}

export default App;
