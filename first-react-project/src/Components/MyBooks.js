import {GetAllActiveBooks, GetMyBooks} from "../Services/UserBookService";
import Item from "./Item";

export default function MyBooks(props) {
    var data = GetMyBooks();

    return (
        <>
            <div className="item-container">
            {data !== "loading" && data.data.data.map(item => <Item  page="MyBooks"
                                                                    key={item.id} data={item}/>)}
            </div>
        </>
    )
}