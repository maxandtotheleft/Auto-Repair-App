import axios from 'axios';

export default {

    getRequestById(id) {
        return axios.get(`/customer/requests/${id}`)
    },
    // Get all requests by logged in user
    getAllRequests() {
        return axios.get('/customer/requests')
    },
    addRequest(request) {
        return axios.post('/customer/requests/', request).then((response => {
            const request = response;
            return request;
        }))
    },
    // Get all requests
    getEveryRequest(){
        return axios.get('/customer/requests/all')
    }
    // getLoggedInUser() {
    //     return axios.get(`/account`).then((response => {
    //         return response;
    //     }))
    // }
    // getCustomerByUserId(userId) {
    //     return axios.get(`/account/${userId}`).then((response => {
    //         const customer = response;
    //         return customer;
    //     }))
    // },
    // getEmployeeByUserId(userId){
    //     return axios.get(`/account/${userId}`).then((response => {
    //         const employee = response;
    //         return employee;
    //     }))
    // }
}