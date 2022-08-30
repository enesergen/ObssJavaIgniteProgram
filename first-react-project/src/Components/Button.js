import "../Css/navbar.css"
export default function Button(props) {
    function switchBody(event) {
        props.handleClick.changeBody(event.target.name)
    }

    return (
        <div>
            <button id={props.id} onClick={(event)=>switchBody(event)} name={props.id}>{props.name}</button>
        </div>
    )
}