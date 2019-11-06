import axios from 'axios';

const api = axios.create({
  baseURL: 'https://apidatasource.azurewebsites.net',
});

export default api;
