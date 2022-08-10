import axios from 'axios';

export default {

    getVehicleById(id) {
        return axios.get(`/vehicle/${id}`).then((response => {
            const vehicle = response;
            return vehicle;
        }))
    }
}