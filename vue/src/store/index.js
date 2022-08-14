import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    isAdmin: false,
    isCustomer: false,
    isEmployee: false,
    // activeCustomer: {
    //   customerId: '',
    //   userId: ''
    // },
    // activeEmployee: {
    //   employeeId: '',
    //   userId: ''
    // },
    vehicles: [],
    requests: [],
    workOrders: []
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      localStorage.removeItem('vehicles');
      localStorage.removeItem('requests');
      localStorage.removeItem('workOrders');
      state.token = '';
      state.user = {};
      state.vehicles = [],
      state.requests = [],
      state.workOrders = []
      axios.defaults.headers.common = {};
      state.isAdmin = false;
      state.isCustomer = false;
      state.isEmployee = false;
    },
    // SET_CUSTOMER(state, customer) {
    //   state.activeCustomer = customer;
    // },
    // SET_EMPLOYEE(state, employee){
    //   state.activeEmployee = employee;
    // },
    SET_VEHICLES(state, data) {
      state.vehicles = data;
    },
    SET_REQUESTS(state, data) {
      state.requests = data;
    },
    SET_WORKORDERS(state, data) {
      state.workOrders = data;
    },
    SET_ADMIN(state, data) {
      state.isAdmin = data;
    },
    SET_CUSTOMER(state, data) {
      state.isCustomer = data;
    },
    SET_EMPLOYEE(state, data) {
      state.isEmployee = data;
    }
  }
})
