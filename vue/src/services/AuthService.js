import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  registerCustomer(user) {
    return axios.post('/register-customer', user)
  },

  registerEmployee(user) {
    return axios.post('/register-employee', user)
  }

}
