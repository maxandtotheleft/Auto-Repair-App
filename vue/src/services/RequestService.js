import axios from 'axios';

export default {

    getRequestById(id) {
        return axios.get(`/requests/${id}`).then((response => {
            const request = response;
            return request;
        }))
    },
    getAllRequests(id) {
        return axios.get(`/customerRequests/${id}`).then((response => {
            const request = response;
            return request;
        }))
    },
    addRequest(request) {
        return axios.post('/requests/', request).then((response => {
            const request = response;
            return request;
        }))
    },
    getCustomerByUserId(userId) {
        return axios.get(`/account/${userId}`).then((response => {
            const customer = response;
            return customer;
        }))
    },
    getEmployeeByUserId(userId){
        return axios.get(`/employeeAccount/${userId}`).then((response => {
            const employee = response;
            return employee;
        }))
    }
}