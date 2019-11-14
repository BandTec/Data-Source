import './styles.css';
import React, { useState} from 'react';
import api from '../../Services/api';
import Particles from 'react-particles-js';

export default function Login({ history }) {
    const [user, setUser] = useState('');
    const [email, setEmail] = useState('');
    const [senha, setSenha] = useState('');
    const [indicacao, setIndicacao] = useState("");
    const [tipo, setTipo] = useState(false);

  async function handleSubmit(event) {
    event.preventDefault();


    if (user === '' || email === '' || senha === '' ) {
      alert("Preencha todos os campos");
    } else {
      const response = await api.post('/usuarios', { user, email, senha, indicacao, tipo });
    console.log(response)
      if (response.data === null) {
        alert("Falha ao cadastrar");
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
      <br/>
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

        <button className="btn" type="submit">Entrar</button>
      </form>
      </div>
      </div>
      <Particles className="particle"
        params={{
          "particles": {
            "number": {
              "value": 80,
              "density": {
                "enable": true,
                "value_area": 800
              }
            },
            "color": {
              "value": "#0ce3ec"
            },
            "shape": {
              "type": "circle",
              "stroke": {
                "width": 0,
                "color": "#000000"
              },
              "polygon": {
                "nb_sides": 4
              },
              "image": {
                "src": "img/github.svg",
                "width": 100,
                "height": 100
              }
            },
            "opacity": {
              "value": 0.5,
              "random": false,
              "anim": {
                "enable": false,
                "speed": 1.542946703372556,
                "opacity_min": 0.1,
                "sync": false
              }
            },
            "size": {
              "value": 5,
              "random": true,
              "anim": {
                "enable": false,
                "speed": 40,
                "size_min": 0.1,
                "sync": false
              }
            },
            "line_linked": {
              "enable": true,
              "distance": 150,
              "color": "#ffffff",
              "opacity": 0.4,
              "width": 1
            },
            "move": {
              "enable": true,
              "speed": 9.620472365193136,
              "direction": "none",
              "random": false,
              "straight": false,
              "out_mode": "out",
              "bounce": false,
              "attract": {
                "enable": false,
                "rotateX": 600,
                "rotateY": 1200
              }
            }
          },
          "interactivity": {
            "detect_on": "canvas",
            "events": {
              "onhover": {
                "enable": true,
                "mode": "repulse"
              },
              "onclick": {
                "enable": true,
                "mode": "repulse"
              },
              "resize": true
            },
            "modes": {
              "grab": {
                "distance": 400,
                "line_linked": {
                  "opacity": 1
                }
              },
              "bubble": {
                "distance": 400,
                "size": 40,
                "duration": 2,
                "opacity": 8,
                "speed": 3
              },
              "repulse": {
                "distance": 200,
                "duration": 0.4
              },
              "push": {
                "particles_nb": 4
              },
              "remove": {
                "particles_nb": 2
              }
            }
          },
          "retina_detect": true
        }
        }/>
    </>
  )
}











