import Navbar from "../Components/Navbar";
import Body from "../Components/Body";
import React, {useEffect, useState} from "react";
import "../Css/style.css"
import {GetAllActiveBooks} from "../Services/UserBookService";

export default function Home() {
    const [body, setBody] = useState("home");

    function setBodyState(state) {
        setBody(state)
    }

    const [searchWord,setSearchWord]=useState("")
    function changeSearchWord(value) {
       setSearchWord(value)
    }

    function returnWord() {
        if(searchWord===undefined){
            return "tanımsız"
        }else{
            return searchWord
        }

    }


    return (
        <>
            <div className="container">
                <Navbar changeBody={setBodyState} searchFunction={changeSearchWord}/>
                <hr className="border-5 border-dark border-top"/>
                <Body searchFunction={changeSearchWord} bodystate={body} searchWord={returnWord}/>
            </div>
        </>
    )

}