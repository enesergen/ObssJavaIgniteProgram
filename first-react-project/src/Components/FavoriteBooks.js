import {GetFavoriteBooks} from "../Services/UserBookService";
import Item from "./Item";
import {useState} from "react";

export default function FavoriteBooks(props) {
    var data = GetFavoriteBooks();
    return (
        <>
            <div className="item-container">
                {data !== "loading" && data.data.data.map(item => <Item page="FavoriteBooks" key={item.id}
                                                                        data={item}/>)}
            </div>
        </>
    )
}