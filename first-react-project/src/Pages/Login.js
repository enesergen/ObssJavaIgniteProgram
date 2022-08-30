import '../Css/style.css'
import '../Css/Login.css'
import {useState} from "react";
import {LoginService} from "../Services/LoginService";
import Cookies from 'universal-cookie';
import jwtDecode from "jwt-decode";
import {useNavigate} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

export default function Login() {
    const [formData, setFormData] = useState({
        username: "",
        password: ""
    })
    const navigate = useNavigate()
    const [login, setLogin] = useState(false)
    const [showMessage, setShowMessage] = useState(false)

    function navigateHome() {
        navigate("/home")
    }

    function handleLogin(event) {
        const response = Promise.resolve(LoginService(formData))
        const cookies = new Cookies();

        console.log(response)
        response.then((response) => {
            if (response.code === 200) {
                console.log(response.token.access_token)
                cookies.set('access_token', response.token.access_token, {path: '/'});
                cookies.set('refresh_token', response.token.refresh_token, {path: '/'});
                const decodedAccessToken = jwtDecode(response.token.access_token)
                cookies.set('username', decodedAccessToken.sub, {path: '/'});
                setLogin(true)
                setShowMessage(false)
                console.log("Giriş Başarılı")
                console.log("Login Status:" + login)
                console.log("Message Status:" + showMessage)
                navigateHome()
            } else {
                setShowMessage(true)
                console.log("Giriş Başarısız")
                console.log("Message Status:" + showMessage)
                cookies.remove('access_token', {path: '/'});
                cookies.remove('refresh_token', {path: '/'});
                cookies.remove('username', {path: '/'});
            }
        })
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
                         Giriş Ekranı</h1></div>
                    <div className="card-body bg-light">
                        <form>
                            <div className="form-group">
                                <div className="m-3"><input className="form-control" type="text" name="username" onChange={handleChange}
                                            placeholder="Username"/>
                                </div>
                                <div className="m-3"><input className="form-control" type="password" name="password"
                                            onChange={handleChange}
                                            placeholder="Password"/>
                                </div>
                                <div id="login-button-div" className="m-3">
                                    <button id="login-button" className="btn btn-outline-primary" onClick={handleLogin}>Giriş Yap</button>
                                </div>
                            </div>
                        </form>
                        <div id="error-message" className="alert alert-danger" hidden={!showMessage} role="alert" >{showMessage && <p>Kullanıcı adı veya şifre yanlış!</p>}</div>
                        <div id="navigate-register">
                            <button id="navigate-button" className="link-primary border-0 bg-light"
                            onClick={()=>{
                                navigate("/register")
                            }}>Hesabınız yok mu? Kayıt Ol</button></div>
                    </div>
                </div>
            </div>
        </>
    )
}