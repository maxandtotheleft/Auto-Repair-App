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
    }
}