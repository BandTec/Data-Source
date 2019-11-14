import './styles.css';
import React, { useState } from 'react';
import api from '../../Services/api';
import { Link } from 'react-router-dom'

export default function Login({ history }) {
  const [user, setUser] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [indicacao, setIndicacao] = useState("");
  const [tipo, setTipo] = useState(false);

  async function handleSubmit(event) {
    event.preventDefault();


    if (user === '' || email === '' || senha === '') {
      alert("Preencha todos os campos");
    } else {
      const response = await api.post('/usuarios', { user, email, senha, indicacao, tipo });
      console.log(response)
      if (response.data === 'Usuário já existente') {
        alert("Usuário já existente");
        history.push('/');
      } else {
        alert("Cadastrado com sucesso");
        history.push('/');
      }
    }


    //const { id } = response.data;

    //localStorage.setItem('user', id);

    //history.push('/');
  }

  return (

    <>
      <div className="container">
        <h1 className="h1">DataSource.</h1>
        <br />
        <div className="content">
          <form onSubmit={handleSubmit}>

            <label htmlFor="email">NOME *</label>
            <input
              id="user"
              type="text"
              value={user}
              onChange={event => setUser(event.target.value)}
            />
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
            <label htmlFor="senha">INDICAÇÃO opcional*</label>
            <input
              id="indicacao"
              type="text"
              value={indicacao}
              onChange={event => setIndicacao(event.target.value)}
            />
            <Link to="/">Já possui conta? Login</Link><br />
            <button className="btn" type="submit">Cadastrar</button>
          </form>
        </div>
      </div>
    </>
  )
}











