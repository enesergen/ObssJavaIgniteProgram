import "../Css/navbar.css"
import {SearchedBooks} from "../Services/UserBookService";

export default function searchBar(props) {

    function switchBody(event) {
        props.handleClick.changeBody(props.name)
        props.handleClick.searchFunction(event.target.value)
    }

    function searchButton(event, searchWord) {
        props.handleClick.changeBody(props.name)
        props.handleClick.searchFunction(searchWord)
        console.log("butona tıklandı")

    }

    return (
        <div>
            <input onChange={(e) => switchBody(e)} id="searc-input" className="search-input" type="text"
                   placeholder="Kitap ya da yazar ara..."/>
            <button id={props.id} onClick={(e) => {
                searchButton(e,document.getElementById("searc-input").value)
            }} name={props.id}>Ara
            </button>
        </div>

    )
}