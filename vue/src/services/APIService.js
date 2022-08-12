import axios from "axios";

const options = {
    method: 'GET',
    url: 'https://car-data.p.rapidapi.com/cars/years',
    headers: {
        'X-RapidAPI-Key': '3ce156a0cbmsh3cdebac2f07584ap1f99dejsn462087aef6d1',
        'X-RapidAPI-Host': 'car-data.p.rapidapi.com'
    }
};

export default {

    getVehicleYears() {
        return axios.request(options).then((response) => {
            return response.data;

        }
        )}

}