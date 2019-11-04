import React from 'react';
import ReactDOM from 'react-dom';
// import { BrowserRouter, Switch, Route } from 'react-router-dom'
// import Login from './Pages/Login';
// import Dashboard from './Pages/Dashboard';

import App from './App';

ReactDOM.render(<App />, document.getElementById('root'));


// ReactDOM.render(
//     <BrowserRouter>
//         <Switch>
//             <Route exact path='/' component={Login} />
//             <Route exact path='/Dashboard' component={Dashboard}/>
//             <Route path="*" component={() => <h1>Page not found</h1>} />
//         </Switch>
//     </ BrowserRouter>
//     , document.getElementById('root'));

            //<Route exact path='/' component={Login}/>
            //<Route exact path='/Dashboard' component={Dashboard}/>