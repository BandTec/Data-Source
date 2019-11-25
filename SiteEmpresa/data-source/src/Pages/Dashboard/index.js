import api from '../../Services/api';
import avatar from '../../assets/avatar.png';
import React, { useState, useEffect } from 'react';
import LineChart from '../../components/Chart';
import { Link } from 'react-router-dom';





export default function Dashboard() {

  

  const [servidores, setServidores] = useState([]);
  const [maquina, setMaquina] = useState();
  const [dados, setDados] = useState({});
  const [dadosGrafico, setDadosGrafico] = useState([]);
  const [componente, setComponente] = useState("");

  useEffect(() => {
    async function loadServer() {

      const response = await api.get('/servidores/');

       setServidores([response.data]);
    }

    loadServer();
  }, []);


  useEffect(() => {
    async function loadDadosServer() {

      const response = await api.get('/dadosServidores/2');

        setDados(response.data[response.data.length - 1]);
        setDadosGrafico(response.data);
       console.log(response.data);
       setComponente("CPU");
       
    }

    // setInterval(loadDadosServer(), 1000);
    loadDadosServer();

  }, []);


  
  
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
          <a className="nav-link" href="/Dashboard">
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
        <li className="nav-item">
          <a className="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
            aria-expanded="true" aria-controls="collapseUtilities">
            <i className="fas fa-fw fa-wrench"></i>
            <span>Servidores</span>
          </a>
          <div id="collapseUtilities" className="collapse barraPersonalizada" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div className="py-2 collapse-inner overflow-auto" style={{ backgroundColor: '#1B2A47' }}>

              <ul className="list-unstyled ">
                {servidores && servidores.map((item, index)=> (
                  <li key={item.ID_MAQU_CD_MAQUINA} id={item.MAQU_NOME}>
                      
                    <button className="btn btn-outline-primary btn-sm" onClick={() => {setMaquina(item.ID_MAQU_CD_MAQUINA); console.log(maquina)}} >{item.MAQU_NO_PROCESSADOR}</button>
                    
                  </li>
                ))}
              </ul>
            </div>
          </div>
        </li>

        {/* <!-- Divider --> */}
        <hr className="sidebar-divider" />

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
          <div className="container-fluid pr-4 pl-4">
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
              <div className="col-xl-3 col-md-6 mb-4 pointer">
              <a onClick={()=> setComponente("CPU")}>
                <div id="fundoCartaoTemperatura" className="card border-left-primary shadow h-100 py-1">
                  <div className="card-body">
                    <div className="row no-gutters align-items-center">
                      <div className="col mr-2">
                        <div id="textoTitulo" className="font-weight-bold text-primary text-uppercase mb-1">CPU</div>
                        <div className="h5 mb-0 mr-3 font-weight-bold text-gray-600" id="dado_CPU">{dados.CODA_USO_CPU ? dados.CODA_USO_CPU : "Aguarde..."}</div>
                      </div>

                    </div>
                  </div>
                </div>
              </a>
              </div>

              {/* <!-- Earnings (Monthly) Card Example --> */}
              <div className="col-xl-3 col-md-6 mb-4 pointer">
              <a onClick={()=> setComponente("MEM")}>
                <div className="card border-left-primary shadow h-100 py-1">
                  <div className="card-body">
                    <div className="row no-gutters align-items-center">
                      <div className="col mr-2">
                        <div className=" font-weight-bold text-primary text-uppercase mb-1">Memória</div>
                        <div className="row no-gutters align-items-center">
                          <div className="col-auto">
                            <div className="h5 mb-0 mr-3 font-weight-bold text-gray-600" id="dado_memoria">{dados.CODA_USO_MEM_RAM ? dados.CODA_USO_MEM_RAM : "Aguarde..."}</div>
                          </div>
                          <div className="col">

                          </div>
                        </div>
                      </div>

                    </div>
                  </div>
                </div>
              </a>
              </div>

              {/* <!-- Pending Requests Card Example --> */}
              <div className="col-xl-3 col-md-6 mb-4 pointer">
              <a onClick={()=> setComponente("HD")}>
                <div className="card border-left-primary shadow h-100 py-1">
                  <div className="card-body">
                    <div className="row no-gutters align-items-center">
                      <div className="col mr-2">
                        <div className=" font-weight-bold text-primary text-uppercase mb-1">HD</div>
                        <div className="h5 mb-0 font-weight-bold text-gray-600" id="dado_HD">{dados.CODA_USO_DISCO ? dados.CODA_USO_DISCO : "Aguarde..."}</div>
                      </div>

                    </div>
                  </div>
                </div>
              </a>
              </div>


            </div>
            <div className="card col-xl-12 col-lg-7 container-fluid border-left-primary shadow h-100">
              {/* <div className=" shadow mb-4"> */}
                {/* <!-- Card Header - Dropdown --> */}
                <div className="card-header  py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 className="m-0 font-weight-bold text-primary">Dados</h6>

                </div>
                {/* <!-- Card Body --> */}
                <div classNameName="card-body">
                  <div className="chart-area">
                    <div className="chartjs-size-monitor">
                      <div className="chartjs-size-monitor-expand">
                        <div className=""></div>
                      </div>
                      <div className="chartjs-size-monitor-shrink">
                        <div className=""></div>
                      </div>
                    </div>


                    {dadosGrafico.length > 0 ? <LineChart 
                      dados={dadosGrafico}
                      componenteEscolhido={componente}
                      className="chartjs-render-monitor d-block p-2" 
                      /> : <></>}


                  </div>
                </div>
              {/* </div> */}
            </div>

            {/* <div className="">
              <LineChart/>

            </div> */}


          </div>
        </div>

        {/* <div className="modal fade " id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title" id="exampleModalLabel">Tem certeza?</h5>
                <button className="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
                </button>
              </div>
              <div className="modal-body">Selecione "Logout" abaixo, se você estiver pronto para encerrar sua sessão.</div>
              <div className="modal-footer">
                <button className="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                <Link className="btn btn-primary text-white" to="/">Logout</Link>
                 <a className="btn btn-success text-white" onclick="voltarIndex()">Logout</a> 
              </div>
            </div>
          </div>
        </div> */}



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