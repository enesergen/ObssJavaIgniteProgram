import {SearchedBooks} from "../Services/UserBookService";
import Item from "./Item";
import {useState} from "react";

export default function SearchBooks(props) {
    const SearchedBook=()=>{
        var data = SearchedBooks(props.searchFunction.searchWord());
        if (data !== "loading" && data.data.success) {
            return data.data.data.map(item => <Item page="SearchBooks" key={item.id} data={item}/>)
        } else {
            return <h1>Aranan Kitap Bulunamadı...</h1>
        }
    }


    return (
        <>
            <div className="item-container">
            {<SearchedBook/>}
            </div>
        </>
    )
}