import axios from 'axios';

export default {

    getRequestById(id) {
        return axios.get(`/customer/requests/${id}`)
    },
    getAllRequests() {
        return axios.get('/customer/requests')
    },
    addRequest(request) {
        return axios.post('/customer/requests/', request).then((response => {
            const request = response;
            return request;
        }))
    },
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