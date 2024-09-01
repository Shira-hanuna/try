import axios from "axios";

export const CalculateMe=(str)=>{
    const url=process.env.REACT_APP_CALCULATE_URL;
    return axios.get(`${url}${str}`);
}