import axios from "axios"

export async function RegisterService(formData) {
    await axios({
        method: "post",
        url: "http://localhost:8080/api/users/create",
        data: formData,
        headers: {"Content-Type": "application/json"},
    }).then(function (response) {
        console.log(response)
    }).catch(function (response) {
        console.log(response)
    })
}
