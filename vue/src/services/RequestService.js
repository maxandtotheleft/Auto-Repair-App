import axios from 'axios';

export default {
    getRequestById(id){
        return axios.get(`/requests/${id}`).then((response => {
            const request = response;
            return request;
          }))
    }
}