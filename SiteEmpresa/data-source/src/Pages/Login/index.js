import './styles.css';
import React, { useState, useEffect } from 'react';
import api from '../../Services/api';
import { Link } from 'react-router-dom';
import Particles from 'react-particles-js';




export default function Login({ history }) {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [isLoading, setLoading] = useState(false);



  useEffect(() => {
    if (isLoading) {
      setLoading(true);
    }
  }, [isLoading]);



  async function handleSubmit(event) {
    event.preventDefault();
    setLoading(true);

    if (email === '' || senha === '') {
      
      alert("Preencha todos os campos");
      setLoading(false);
    } else {
      const response = await api.post('/login', { email, senha });
      console.log(response)
      if (response.data.data === null) {
        alert("Verifique suas credenciais");
        setLoading(false);
      } else {
        //const { ID_USUA_CD_USUARIO } = response.data;
        //await localStorage.setItem('_id', _id)
        history.push('/dashboard');
        setLoading(false);
      }
    }
  }

  return (

    <>
      {/* <Growl ref={(el) => this.growl = el}></Growl> */}
      <div className="container">
        <h1 className="h1">DataSource.</h1>
        <br />
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
            <Link to="/Cadastro">Não possui conta? cadastre-se</Link><br />
            <button className="btn" disabled={isLoading} onClick={!isLoading ? handleSubmit : null} type="submit">{isLoading ? 'Loading…' : 'Entrar'}</button>
          </form>
        </div>
      </div>
      <Particles className="particle"
        params={{
          "particles": {
            "number": {
              "value": 75,
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
              "speed": 3,
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
        } />



    </>
  )
}











