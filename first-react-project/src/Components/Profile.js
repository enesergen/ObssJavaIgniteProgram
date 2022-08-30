import {useState} from "react";
import {ChangePassword} from "../Services/UserBookService";

export default function Profile() {
    const [show, setShow] = useState(false)
    const [success,setSuccess]=useState(false)
    function CheckPassword() {
        const password = document.getElementById("password").value
        const repassword = document.getElementById("repassword").value
        if (password === repassword) {
            setShow(false)
        } else {
            setShow(true)
            setSuccess(false)
        }
    }

    function changePassword() {
        const password = document.getElementById("password").value
        const repassword = document.getElementById("repassword").value
        if (password === repassword) {
            ChangePassword(password)
            setSuccess(true)
        }
    }

    return (
        <div className="container-md">
            <h1 className="fw-bold m-3 text-center">ŞİFRE DEĞİŞTİRME</h1>
            <input className="form-control m-3" id="password" type="password" placeholder="Yeni parola"
                   name="password"/>
            <input className="form-control m-3" id="repassword" onChange={CheckPassword} type="password"
                   placeholder="Yeni parola tekrar"
                   name="repassword"/>
            {show && <h6 className="text-danger fw-bold m-3 text-center">Parolalar eşleşmedi</h6>}
            <input onClick={changePassword} className="form-control m-3" type="submit" value="Gönder"
                   name="submit-button"/>
            {success && <h6 className="text-info fw-bold m-3 text-center">Parolanız değiştirildi.</h6>}
        </div>
    )
}