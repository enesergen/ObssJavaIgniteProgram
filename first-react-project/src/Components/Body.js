import Books from "./Books";
import MyBooks from "./MyBooks";
import FavoriteBooks from "./FavoriteBooks";
import {useState} from "react";
import SearchBooks from "./SearchBooks";
import Profile from "./Profile";

export default function Body(props) {
    const [bodyComponent, setBodyComponent] = useState(<Books/>)
    if (props.state == "Home") {
        setBodyComponent(<Books/>)
    } else if (props.state == "MyBooks") {
        setBodyComponent(<MyBooks/>)
    } else if (props.state == "FavoriteBooks") {
        setBodyComponent(<FavoriteBooks/>)
    } else if (props.state == "SearchBooks") {
        setBodyComponent(<SearchBooks/>)
    } else if (props.state == "Profile") {
        setBodyComponent(<Profile/>)
    } else {
        setBodyComponent(<Books/>)
    }
    return (
        <div>
            asd
        </div>
    )
}