import React, {useState} from "react";
import Books from "./Books";
import MyBooks from "./MyBooks";
import FavoriteBooks from "./FavoriteBooks";
import SearchBooks from "./SearchBooks";
import Profile from "./Profile";


export default function Body(props) {

    return (
        <>
            {props.bodystate === "home" && <Books/>}
            {props.bodystate === "mybooks" && <MyBooks/>}
            {props.bodystate === "favoritebooks" && <FavoriteBooks/>}
            {props.bodystate === "searchbooks" && <SearchBooks searchFunction={props}/>}
            {props.bodystate === "profile" && <Profile/>}
        </>
    );
}