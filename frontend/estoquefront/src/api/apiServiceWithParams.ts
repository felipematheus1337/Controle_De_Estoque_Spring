import axios from "axios"



const apiServiceWithParams = async (method:string,params?: Object | Object[] | null, path?: string) => {

    const URL = `http://localhost:8081/server/${path}`

    let response = await axios({
        method,
        url: URL,
        params
    });

    return response;

}

export default apiServiceWithParams;