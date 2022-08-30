import React from "react"
import Button from "./Button"
import Searchbar from "./SearchBar"
import "../Css/navbar.css"

export default function Navbar(props) {
    return (
        <>
            <nav>
                <div id="navbar">

                    <Button handleClick={props} name="Anasayfa" id="home"/>

                    <Button handleClick={props} name="Kitap Listem" id="mybooks"/>


                    <Button handleClick={props} name="Favori Listem" id="favoritebooks"/>

                    <Searchbar handleClick={props} name="searchbooks" id="searchbooks"/>

                    <Button handleClick={props} name="Profil" id="profile"/>

                </div>
            </nav>
        </>
    )
}