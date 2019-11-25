import api from '../../Services/api';
import avatar from '../../assets/avatar.png';
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';





export default function CadastroNoc() {
  const [user, setUser] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [rsenha, setRsenha] = useState('');
  const [tipo, setTipo] = useState(false);


  const [isLoading, setLoading] = useState(false);


  useEffect(() => {
    if (isLoading) {
      setLoading(true);
    }
  }, [isLoading]);

  async function handleSubmit(event) {
    event.preventDefault();
    setLoading(true);

    if (user === '' || email === '' || rsenha === '' || senha === '') {
      alert("Preencha todos os campos");
      setLoading(false);
    }else if(rsenha != senha){
      alert("Os campos de senha são incompativeis");
      setLoading(false);

    } else {
      const response = await api.post('/usuarios', { user, email, senha, rsenha, tipo });
      
      if (response.data === 'Usuário já existente') {
        alert("Usuário já existente");
        setLoading(false);
      } else {
        alert("Cadastrado com sucesso");
        setLoading(false);
      }
    }

  }

  return (
    <div id="wrapper" >
      {/* 152036 */}

      <ul className="navbar-nav  sidebar sidebar-dark accordion transicao" style={{ backgroundColor: '#1B2A47' }} id="accordionSidebar">

        {/* <!-- Sidebar - Brand --> */}
        <a className="sidebar-brand d-flex align-items-center justify-content-center">
          <div className="sidebar-brand-text mx-3">DataSource.</div>

        </a>

        {/* <!-- Divider --> */}
        <hr className="sidebar-divider my-0" />

        {/* <!-- Nav Item - Dashboard --> */}
        <li className="nav-item active">
          <a className="nav-link" href="/dashboard">
            <i className="fas fa-fw fa-chart-area"></i>
            <span>Dashboard</span></a>
        </li>

        {/* <!-- Divider --> */}
        <hr className="sidebar-divider" />

        {/* <!-- Heading --> */}
        <div className="sidebar-heading">
          Interface
      </div>

        {/* <!-- Nav Item - Pages Collapse Menu --> */}
        <li className="nav-item">
          <a className="nav-link collapsed" href="/CadastroNoc">
            <i className="fas fa-fw fa-cog"></i>
            <span>Cadastro</span>
          </a>

        </li>

        {/* <!-- Nav Item - Utilities Collapse Menu --> */}
        {/* <li className="nav-item">
          <a className="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
            aria-expanded="true" aria-controls="collapseUtilities">
            <i className="fas fa-fw fa-wrench"></i>
            <span>Servidores</span>
          </a>
          <div id="collapseUtilities" className="collapse barraPersonalizada" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div className="py-2 collapse-inner overflow-auto" style={{ backgroundColor: '#1B2A47' }}>

              <ul className="list-unstyled ">
                {servidores && servidores.map((item, index) => (
                  <li key={item.ID_MAQU_CD_MAQUINA} id={item._ID_MAQU_CD_MAQUINA}>

                    <button className="btn btn-outline-primary btn-sm" onClick={() => { setMaquina(item.ID_MAQU_CD_MAQUINA); console.log(maquina) }} >{item.MAQU_NO_PROCESSADOR}</button>

                  </li>
                ))}
              </ul>
            </div>
          </div>
        </li> */}

        {/* <!-- Divider --> */}
        <hr className="sidebar-divider" />



      </ul>





      <div id="content-wrapper" className="d-flex flex-column">
        <div id="content">
          <nav className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
            {/* <button id="sidebarToggleTop" className="btn btn-link d-md-none rounded-circle mr-3">
              <i className="fa fa-bars"></i>
            </button> */}
            <ul className="navbar-nav ml-auto">
              {/* <!-- Nav Item - Search Dropdown (Visible Only XS) --> */}
              <li className="nav-item dropdown no-arrow d-sm-none">

              </li>
              {/* <!-- Nav Item - Alerts --> */}

              {/* <!-- Nav Item - Messages --> */}

              <div className="topbar-divider d-none d-sm-block"></div>
              {/* <!-- Nav Item - User Information --> */}
              <li className="nav-item dropdown no-arrow">
                <a className="nav-link dropdown-toggle" id="userDropdown" role="button" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false">
                  <span id="nameUser" className="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                  <img className="img-profile rounded-circle" src={avatar}></img>
                </a>
                {/* <!-- Dropdown - User Information --> */}
                <div className="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                  <Link to="/">
                    <a className="dropdown-item">
                      <span id="nameUser2" className="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                      <i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                      Logout
                </a>
                  </Link>
                </div>
              </li>
            </ul>
          </nav>
          <div className="container-fluid pr-4 pl-4 ">
            <div className="card o-hidden border-0 shadow-lg ">
              <div className="card-body p-0 ">
                {/* <!-- Nested Row within Card Body --> */}
                <div className="row">

                  <div className="col-lg-8 ">
                    <div className="p-5">
                      <div className="text-center">
                        <h1 className="h4 text-gray-900 mb-4">Cadastrar novo noc</h1>
                      </div>
                      <form className="user">
                        <div className="form-group">

                          <div className="col-sm-6">

                          </div>
                        </div>
                        <div className="form-group">
                          <input
                            type="text"
                            className="form-control "
                            id="inputEmail"
                            placeholder="Usuário"
                            onChange={event => setUser(event.target.value)}
                          />
                        </div>
                        <div className="form-group">
                          <input
                            type="email"
                            className="form-control "
                            id="inputEmail"
                            placeholder="Email"
                            onChange={event => setEmail(event.target.value)}
                          />
                        </div>
                        <div className="form-group row">
                          <div className="col-sm-6 mb-3 mb-sm-0">
                            <input
                              type="password"
                              className="form-control "
                              id="inputPassword"
                              placeholder="Senha"
                              onChange={event => setSenha(event.target.value)}
                            />
                          </div>
                          <div className="col-sm-6">
                            <input
                              type="password"
                              className="form-control "
                              id="repeatPassword"
                              placeholder="Repita sua senha"
                              onChange={event => setRsenha(event.target.value)}
                            />
                          </div>
                        </div>
                        <button
                          className="btn btn-primary  btn-block"
                          disabled={isLoading}
                          onClick={!isLoading ? handleSubmit : null}
                          type="submit">
                          {isLoading ? 'Loading…' : 'Cadastrar'}
                        </button>
                        



                      </form>



                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="row">


              <div className="container">


              </div>









            </div>





          </div>
        </div>





        {/* <!-- Footer --> */}
        <footer className="sticky-footer bg-white">
          <div className="container my-auto">
            <div className="copyright text-center my-auto">
              <span>Copyright &copy; DataSource. 2019</span>
            </div>
          </div>
        </footer>
        {/* <!-- End of Footer --> */}
      </div>
    </div>



  )
}