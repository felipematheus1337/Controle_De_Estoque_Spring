import axios from "axios"



const apiService = async (method:string,body?: Object | Object[] | null, path?: string) => {

    const URL = `http://localhost:8081/server/${path}`

    let response = await axios({
        method,
        url: URL,
        data:body
    });

    return response;

}

export default apiService;