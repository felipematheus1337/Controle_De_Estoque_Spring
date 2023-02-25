import axios from "axios"




const apiService = async (method:string,body?: Object | Object[] | null, path?: string,token?:string) => {

    const URL = `http://localhost:8081/server/${path}`

    let headers = {};
    
    if(token) {
        headers = { 
            Authorization: `Bearer ${token}`,
            ContentType: "application/json",
            Accept: "application/json",
            //Origin:"http://localhost:3000"
        };
    }
   
    let response = await axios({
        method,
        url: URL,
        data:body,
        headers,
        xsrfCookieName:"csrftoken",
        xsrfHeaderName:"X-CSRFToken",
        withCredentials:false,
    });
    return response;
}

export default apiService;
