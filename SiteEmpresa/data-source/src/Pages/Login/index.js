import './styles.css';
import React, { useState } from 'react';
import api from '../../Services/api';
import { Link } from 'react-router-dom'

export default function Login({ history }) {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');

  async function handleSubmit(event) {
    event.preventDefault();


    if (email === '' || senha === '' ) {
      alert("Preencha todos os campos");
    } else {
      const response = await api.post('/login', { email, senha });
      console.log(response)
      if (response.data.data === null) {
        alert("Verifique suas credenciais");
      } else {
         //const { ID_USUA_CD_USUARIO } = response.data;
        //await localStorage.setItem('_id', _id)
        history.push('/dashboard');
      }
    }


    
   
    //const { ID_USUA_CD_USUARIO } = response.data;

    //localStorage.setItem('user', id);

    //history.push('/dashboard');
  }

  return (
    
    <>
    <div className="container">
      <h1 className="h1">DataSource.</h1>
      <br/>
      <div className="content">
      <form onSubmit={handleSubmit}>
        <label htmlFor="email">E-MAIL *</label>
        <input 
          id="email" 
          type="email" 
          value={email}
          onChange={event => setEmail(event.target.value)}
        />
         <label htmlFor="senha">SENHA *</label>
        <input 
          id="senha" 
          type="password"
          value={senha}
          onChange={event => setSenha(event.target.value)}
        />
        <>Não possui conta? <Link to="/Cadastro">cadastre-se</Link></>
        <button className="btn" type="submit">Entrar</button>
      </form>
      </div>
      </div>
    </>
  )
}











