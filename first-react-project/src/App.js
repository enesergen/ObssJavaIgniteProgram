import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./Pages/Login"
import Register from "./Pages/Register"
import Home from "./Pages/Home"


export default function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route exact path="/" element={<Login/>}/>
                    <Route exact path="/login" element={<Login/>}/>
                    <Route exact path="/register" element={<Register/>}/>
                    <Route exact path="/home" element={<Home/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}
