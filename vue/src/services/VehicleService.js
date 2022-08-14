import axios from 'axios';

export default {

    /** Get vehicles of logged in user */
    getVehicles() {
        return axios.get(`/vehicle`).then((response => {
            const vehicle = response;
            return vehicle;
        }))
    },

    /** ADd vehicles for logged in user */
    addVehicle(vehicle) {
        return axios.post('/vehicle/', vehicle).then((response => {
            return response;
        }))
    },
    
}