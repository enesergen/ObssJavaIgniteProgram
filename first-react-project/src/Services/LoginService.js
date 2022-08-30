import axios from "axios"

export async function LoginService(formData) {
    const bodyFormData = new FormData();
    bodyFormData.append("username", formData.username)
    bodyFormData.append("password", formData.password)
    let data
    await axios({
        method: "post",
        url: "http://localhost:8080/api/login",
        data: bodyFormData,
        headers: {"Content-Type": "multipart/form-data"},
    }).then(function (response) {
        data={
            token:response.data,
            code:response.status
        }

    }).catch(function (response) {
        data={
            token:response.data,
            code:response.status
        }
    })
    return data
}
