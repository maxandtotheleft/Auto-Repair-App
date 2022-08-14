import axios from 'axios';

export default {

   
    getWorkOrders() {
        return axios.get('/customer/workorders').then((response => {
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
        return axios.get(`/customer/workorders/${workOrderId}/repairs`).then((response => {
            const repairs = response;
            return repairs; 
        }))
    },

    addWorkOrder(workOrder) {
        return axios.post('/employee/workorders', workOrder).then((response => {
            const workOrder = response;
            return workOrder;
        }))
    },
    updateWorkOrder(workOrderId, workOrder){
        return axios.put(`/customer/workorders/${workOrderId}`, workOrder).then((response => {
            const workOrder = response;
            return workOrder;
        }))
    }
}