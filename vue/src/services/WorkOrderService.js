import axios from 'axios';

export default {

   
    getWorkOrders() {
        return axios.get('/workorders').then((response => {
            const workOrder = response;
            return workOrder;
        }))
    },
    // getWorkOrdersByUserId(userId) {
    //     return axios.get(`/workorders/${userId}`).then((response => {
    //         const workOrder = response;
    //         return workOrder;
    //     }))
    // },
    getRepairsByWorkOrderId(workOrderId){
        return axios.get(`/repairs/${workOrderId}`).then((response => {
            const repairs = response;
            return repairs; 
        }))
    } 
}