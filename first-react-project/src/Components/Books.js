import {GetAllActiveBooks} from "../Services/UserBookService";
import Item from "./Item";
import {useEffect, useState} from "react";
import Cookies from "universal-cookie";
import axios from "axios";


export default function Books() {
    var data = GetAllActiveBooks();
    return (
        <>
            <div className="item-container">
                {data !== "loading" && data.data.data.map(item => <Item page="Books" key={item.id} data={item}/>)}
            </div>
        </>
    )
}