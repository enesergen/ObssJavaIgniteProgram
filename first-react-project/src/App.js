import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "./Login"
import Register from "./Register"


export default function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route exact path="/" element={<Login/>}/>
                    <Route exact path="/login" element={<Login/>}/>
                    <Route exact path="/register" element={<Register/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}
