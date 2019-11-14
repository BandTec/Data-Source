import './styles.css';
import React, { useState, useEffect } from 'react';
import api from '../../Services/api';
import { Link } from 'react-router-dom'


export default function Login({ history }) {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [isLoading, setLoading] = useState(false);


  useEffect(() => {
    if (isLoading) {
      setLoading(false);
    }
  }, [isLoading]);

 

  async function handleSubmit(event) {
    event.preventDefault();
    setLoading(true);

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
  }

  return (
    
    <>
    <div className="container">
      <h1 className="h1">DataSource.</h1>
      <br/>
      <div className="content">
      <form >
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
         <Link to="/Cadastro">Não possui conta? Cadastre-se</Link><br/>
        <button disabled={isLoading} onClick={!isLoading ? handleSubmit : null} className="btn" type="submit"> {isLoading ? 'Loading…' : 'Entrar'}</button>
      </form>
      </div>
      </div>
    </>
  )
}











