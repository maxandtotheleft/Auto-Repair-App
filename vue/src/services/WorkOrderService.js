import axios from 'axios';

export default {

   
    getWorkOrders() {
        return axios.get('/workorders').then((response => {
            const workOrder = response;
            return workOrder;
        }))
    }
}