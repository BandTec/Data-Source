import React from 'react';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

 import Login from './Pages/Login';
 import Cadastro from './Pages/Cadastro';
 import Dashboard from './Pages/Dashboard';

export default function Routes() {
  return (
    <BrowserRouter>
         <Switch>
         
             <Route exact path='/' exact component={Login} />
             <Route exact path='/Cadastro' component={Cadastro}/>
             <Route exact path='/Dashboard' component={Dashboard}/>
             <Route path="*" component={() => <h1>Page not found</h1>} />
         </Switch>
     </ BrowserRouter>
  );
}











