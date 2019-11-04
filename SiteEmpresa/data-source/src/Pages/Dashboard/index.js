import React from 'react';
import api from '../../Services/api';
import avatar from '../../assets/avatar.png';


export default function dashboard() {


  return (
    <div id="wrapper">


    <ul className="navbar-nav  sidebar sidebar-dark accordion transicao" style={{backgroundColor: '#3E5367'}} id="accordionSidebar">

      {/* <!-- Sidebar - Brand --> */}
      <a className="sidebar-brand d-flex align-items-center justify-content-center">
      <div className="sidebar-brand-text mx-3">DataSource.</div>
      
      </a>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider my-0"/>

      {/* <!-- Nav Item - Dashboard --> */}
      <li className="nav-item active">
        <a className="nav-link" href="charts.html">
          <i className="fas fa-fw fa-chart-area"></i>
          <span>Dashboard</span></a>
      </li>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider"/>

      {/* <!-- Heading --> */}
      <div className="sidebar-heading">
        Interface
      </div>

      {/* <!-- Nav Item - Pages Collapse Menu --> */}
      <li className="nav-item">
        <a className="nav-link collapsed" >
          <i className="fas fa-fw fa-cog"></i>
          <span>Cadastro</span>
        </a>
       
      </li>

      {/* <!-- Nav Item - Utilities Collapse Menu --> */}
      {/* <li className="nav-item">
        <a className="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
          aria-expanded="true" aria-controls="collapseUtilities">
          <i className="fas fa-fw fa-wrench"></i>
          <span>Atualizar Dados</span>
        </a>
        <div id="collapseUtilities" className="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div className="py-2 collapse-inner " style={{backgroundColor: '#3E5367'}}>
            
            <a className="collapse-item" style={{color: 'white'}} href="attUsuario.html">Usuario</a>
            <a className="collapse-item" style={{color: 'white'}} href="attSala.html">Sala</a>
            <a className="collapse-item" style={{color: 'white'}} href="attSensor.html">Sensor</a>
           </div>
        </div>
      </li> */}

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider"/>

      {/* <!-- Heading --> */}
      {/* <div className="sidebar-heading">
        Registro
      </div> */}

     

      {/* <!-- Nav Item - Tables --> */}
      {/* <li className="nav-item">
        <a className="nav-link" href="tables.html">
          <i className="fas fa-fw fa-table"></i>
          <span>Registro</span></a>
      </li> */}

      {/* <!-- Divider --> */}
      {/* <hr className="sidebar-divider d-none d-md-block"/> */}

      {/* <!-- Sidebar Toggler (Sidebar) --> */}
      {/* <div className="text-center  d-none d-md-inline">
        <button className="rounded-circle border-0 " id="sidebarToggle"></button>
      </div> */}

    </ul>





    <div id="content-wrapper" className="d-flex flex-column">
      <div id="content">
        <nav className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
          <button id="sidebarToggleTop" className="btn btn-link d-md-none rounded-circle mr-3">
            <i className="fa fa-bars"></i>
          </button>
          <ul className="navbar-nav ml-auto">
            {/* <!-- Nav Item - Search Dropdown (Visible Only XS) --> */}
            <li className="nav-item dropdown no-arrow d-sm-none">
              
            </li>
            {/* <!-- Nav Item - Alerts --> */}
            
            {/* <!-- Nav Item - Messages --> */}
            
            <div className="topbar-divider d-none d-sm-block"></div>
            {/* <!-- Nav Item - User Information --> */}
            <li className="nav-item dropdown no-arrow">
              <a className="nav-link dropdown-toggle"  id="userDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <span id="nameUser" className="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                <img className="img-profile rounded-circle" src={avatar}></img>
              </a>
              {/* <!-- Dropdown - User Information --> */}
              <div className="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                
                <a className="dropdown-item"  data-toggle="modal" data-target="#logoutModal">
                    <span id="nameUser2" className="mr-2 d-none d-lg-inline text-gray-600 small"></span>
                  <i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>
          </ul>
        </nav>
        <div className="container-fluid">
          <div className="row">

            
            <div className="col-xl-3 col-md-6 mb-4">
              <div id="fundoCartaoTemperatura2" className="card border-left-primary shadow h-100 py-1">
                <div className="card-body">
                  <div className="row no-gutters align-items-center">
                    <div className="col mr-2">
                      <div id="textoTitulo2" className="font-weight-bold text-primary text-uppercase mb-1">Usuários</div>
                      <div className="h5 mb-0 mr-3 font-weight-bold text-gray-600 " id="dado_user">Aguarde...</div>
                    </div>
                    
                  </div>
                </div>
              </div>
            </div>

            {/* <!-- Earnings (Monthly) Card Example --> */}
            <div className="col-xl-3 col-md-6 mb-4">
              <div id="fundoCartaoTemperatura" className="card border-left-primary shadow h-100 py-1">
                <div  className="card-body">
                  <div className="row no-gutters align-items-center">
                    <div className="col mr-2">
                      <div id="textoTitulo" className="font-weight-bold text-primary text-uppercase mb-1">CPU</div>
                      <div className="h5 mb-0 mr-3 font-weight-bold text-gray-600" id="dado_CPU">Aguarde...</div>
                    </div>
                    
                  </div>
                </div>
              </div>
            </div>

            {/* <!-- Earnings (Monthly) Card Example --> */}
            <div className="col-xl-3 col-md-6 mb-4">
              <div className="card border-left-primary shadow h-100 py-1">
                <div className="card-body">
                  <div className="row no-gutters align-items-center">
                    <div className="col mr-2">
                      <div className=" font-weight-bold text-primary text-uppercase mb-1">Memória</div>
                      <div className="row no-gutters align-items-center">
                        <div className="col-auto">
                          <div className="h5 mb-0 mr-3 font-weight-bold text-gray-600" id="dado_memoria">Aguarde...</div>
                        </div>
                        <div className="col">
                         
                        </div>
                      </div>
                    </div>
                    
                  </div>
                </div>
              </div>
            </div>

            {/* <!-- Pending Requests Card Example --> */}
            <div className="col-xl-3 col-md-6 mb-4">
              <div className="card border-left-primary shadow h-100 py-1">
                <div className="card-body">
                  <div className="row no-gutters align-items-center">
                    <div className="col mr-2">
                      <div className=" font-weight-bold text-primary text-uppercase mb-1">HD</div>
                      <div className="h5 mb-0 font-weight-bold text-gray-600" id="dado_HD">Aguarde...</div>
                    </div>
                    
                  </div>
                </div>
              </div>
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