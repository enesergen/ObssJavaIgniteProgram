import axios from "axios"
import Cookies from 'universal-cookie';
import {useEffect, useState} from "react";

function GetAllActiveBooks() {
    const [books, setBooks] = useState({});
    const [loading, setLoading] = useState(true)
    useEffect(() => {
        const cookie = new Cookies();
        const access_token = cookie.get('access_token')
        axios({
            method: 'get',
            url: 'http://localhost:8080/api/userbooks/books',
            headers: {
                'Authorization': 'Bearer ' + access_token
            }
        }).then((response => {
            setBooks(response)
            setLoading(false)
        })).catch((error) => {
            setBooks(error)
        })
    }, [])

    if (loading === false) {
        return books
    } else {
        return "loading"
    }
}

function GetMyBooks() {
    const [books, setBooks] = useState({});
    const [loading, setLoading] = useState(true)
    useEffect(() => {
        const cookie = new Cookies();
        const access_token = cookie.get('access_token')
        const username = cookie.get('username')
        axios({
            method: 'get',
            url: 'http://localhost:8080/api/userbooks/books/' + username,
            headers: {
                'Authorization': 'Bearer ' + access_token
            }
        }).then((response => {
            setBooks(response)
            setLoading(false)
        })).catch((error) => {
            setBooks(error)
        })
    }, [])

    if (loading === false) {
        return books
    } else {
        return "loading"
    }
}

function GetFavoriteBooks() {
    const [books, setBooks] = useState({});
    const [loading, setLoading] = useState(true)
    useEffect(() => {
        const cookie = new Cookies();
        const access_token = cookie.get('access_token')
        const username = cookie.get('username')
        axios({
            method: 'get',
            url: 'http://localhost:8080/api/userbooks/fbooks/' + username,
            headers: {
                'Authorization': 'Bearer ' + access_token
            }
        }).then((response => {
            setBooks(response)
            setLoading(false)
        })).catch((error) => {
            setBooks(error)
        })
    }, [])

    if (loading === false) {
        return books
    } else {
        return "loading"
    }
}

function AddBook(isbn) {
    const cookie = new Cookies();
    const access_token = cookie.get('access_token')
    const username = cookie.get('username')
    axios({
        method: "post",
        url: "http://localhost:8080/api/userbooks/books/" + username,
        headers: {
            "authorization": "Bearer " + access_token,
            'Content-Type': 'application/json'
        },
        data: {
            "isbn": isbn
        }
    }).then(response => {
        console.log(response)
    }).catch(error => {
        console.log(error)
    })
}

function AddFavoriteBook(isbn) {
    const cookie = new Cookies();
    const access_token = cookie.get('access_token')
    const username = cookie.get('username')
    axios({
        method: "post",
        url: "http://localhost:8080/api/userbooks/fbooks/" + username,
        headers: {
            "authorization": "Bearer " + access_token,
            'Content-Type': 'application/json'
        },
        data: {
            "isbn": isbn
        }
    }).then(response => {
        console.log(response)
    }).catch(error => {
        console.log(error)
    })
}

function RemoveBook(isbn) {
    const cookie = new Cookies();
    const access_token = cookie.get('access_token')
    const username = cookie.get('username')
    axios({
        method: "delete",
        url: "http://localhost:8080/api/userbooks/books/" + username,
        headers: {
            "authorization": "Bearer " + access_token,
            'Content-Type': 'application/json'
        },
        data: {
            "isbn": isbn
        }
    }).then(response => {
        console.log(response)
    }).catch(error => {
        console.log(error)
    })
}

function RemoveFavoriteBook(isbn) {
    const cookie = new Cookies();
    const access_token = cookie.get('access_token')
    const username = cookie.get('username')
    axios({
        method: "delete",
        url: "http://localhost:8080/api/userbooks/fbooks/" + username,
        headers: {
            "authorization": "Bearer " + access_token,
            'Content-Type': 'application/json'
        },
        data: {
            "isbn": isbn
        }
    }).then(response => {
        console.log(response)
    }).catch(error => {
        console.log(error)
    })
}
function SearchedBooks(searchWord) {
    console.log("search function worked")
    const [books, setBooks] = useState({});
    const [loading, setLoading] = useState(true)
    useEffect(() => {
        const cookie = new Cookies();
        const access_token = cookie.get('access_token')
        axios({
            method: 'get',
            url: 'http://localhost:8080/api/userbooks/'+searchWord,
            headers: {
                'Authorization': 'Bearer ' + access_token,
                'Content-Type': 'application/json'

            }
        }).then((response => {
            setBooks(response)
            setLoading(false)
        })).catch((error) => {
            setBooks(error)
        })
    }, [])

    if (loading === false) {
        return books
    } else {
        return "loading"
    }
}
function ChangePassword(password){
    const cookie = new Cookies();
    const access_token = cookie.get('access_token')
    const username = cookie.get('username')
    axios({
        method: "put",
        url: "http://localhost:8080/api/userbooks",
        headers: {
            "authorization": "Bearer " + access_token,
            'Content-Type': 'application/json'
        },
        data: {
            "username": username,
            "password":password
        }
    }).then(response => {
        console.log(response)
    }).catch(error => {
        console.log(error)
    })
}

export {GetAllActiveBooks, GetMyBooks, GetFavoriteBooks, AddBook, AddFavoriteBook, RemoveBook, RemoveFavoriteBook,SearchedBooks,ChangePassword}