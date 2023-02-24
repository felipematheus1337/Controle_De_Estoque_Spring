import axios from "axios"

type apiType = {
    path: string;
    body?: Object | Object[];
    method: string;
}


const apiService = async (data:apiType) => {

    const URL = `http://localhost:8081/server/${data.path}`

    let response = await axios({
        method:data.method,
        url: URL,
        data:data.body
    });

    return response;

}

export default apiService;