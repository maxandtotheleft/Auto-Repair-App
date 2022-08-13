import axios from "axios";


const http = axios.create({
    baseURL: 'https://car-data.p.rapidapi.com/cars',
    headers: {
        'X-RapidAPI-Key': '3ce156a0cbmsh3cdebac2f07584ap1f99dejsn462087aef6d1',
        'X-RapidAPI-Host': 'car-data.p.rapidapi.com'
    }
});

export default {

    // addVehicle(vehicle) {
    //     return axios.post('/requests/', request).then((response => {
    //         const request = response;
    //         return request;
    //     }))
    // },

    getVehicleYears() {
        return http.get('/years');
    },

    getVehicleMakes() {
        return http.get('/makes');
    },

    getVehicleModels(year, make) {
        return http.get(`?year=${year}&make=${make}`);
    }

}