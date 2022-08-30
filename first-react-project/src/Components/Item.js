import React, {useState} from "react"
import "../Css/Item.css"
import {AddBook, AddFavoriteBook, RemoveBook, RemoveFavoriteBook} from "../Services/UserBookService";
import {useNavigate} from "react-router-dom";

export default function Item(props) {
    const [view, setView] = useState(true)
    return (
        <>
            {view && <div className="card m-2">
                <img className="card-img-top" src={`https://i.postimg.cc/Bv9CJ09k/bookimg.png`} al="görsel kitap"/>
                <div className="card-body"></div>
                <h5 className="card-title">{props.data.name}</h5>
                <p className="card-text">{props.data.description}</p>
                {(props.page === "Books" || props.page === "SearchBooks") &&
                    <button onClick={() => AddBook(props.data.isbn)}>Listeme Ekle</button>}
                {(props.page === "Books" || props.page === "SearchBooks") &&
                    <button onClick={() => AddFavoriteBook(props.data.isbn)}>Favori Ekle</button>}
                {props.page === "MyBooks" && <button onClick={() => {
                    RemoveBook(props.data.isbn)
                    setView(false)
                }}>Listeden Çıkar</button>}
                {props.page === "FavoriteBooks" &&
                    <button onClick={() => {
                        RemoveFavoriteBook(props.data.isbn)
                        setView(false)
                    }}>Favorilerden Çıkar</button>}

            </div>}

        </>
    )
}

