import '../Css/style.css'
import '../Css/Login.css'
import {useState} from "react";
import {RegisterService} from "../Services/RegisterService"
import {useNavigate} from "react-router-dom";
export default function Register() {
    const [formData, setFormData] = useState({
        username: "",
        password: ""
    })
    const [showMessage, setShowMessage] = useState(false)
    const navigate = useNavigate()
    function handleRegister(event) {
        console.log(`username ${formData.username} password ${formData.password}`)
        RegisterService(formData)
        setShowMessage(true)
        event.preventDefault()
    }

    function handleChange(event) {
        setFormData((prevState) => {
            return {
                ...prevState,
                [event.target.name]: event.target.value
            }
        })
    }

    return (
        <>
            <div className="container">
                <div id="card" className="card m-auto">
                    <div><h1 id="login-header" className="card-header bg-light">
                        Kayıt Ekranı</h1></div>
                    <div className="card-body bg-light">
                        <form>
                            <div className="form-group">
                                <div className="m-3"><input className="form-control" type="text" name="username"
                                                            onChange={handleChange}
                                                            placeholder="Username"/>
                                </div>
                                <div className="m-3"><input className="form-control" type="password" name="password"
                                                            onChange={handleChange}
                                                            placeholder="Password"/>
                                </div>
                                <div id="login-button-div" className="m-3">
                                    <button id="register-button" className="btn btn-success"
                                            onClick={handleRegister}>Kayıt Ol
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div id="info-message" className="alert alert-success" hidden={!showMessage}
                             role="alert">{showMessage && <p>Kayıt işlemi başarılı</p>}</div>
                        <div id="navigate-login">
                            <button id="navigate-button" className="link-success border-0 bg-light"
                                    onClick={()=>{
                                        navigate("/login")
                                    }}>Hesabın var mı? Giriş yap</button></div>
                    </div>
                    </div>

            </div>
        </>
    )
}