import axios from "axios";

const ApiKey = "AIzaSyADNHzh2ftWxrpAlTbubnJxqNoH0Eq4agQ";

const newInstanceOfAxios = axios.create();

export default {
    search(isbn, author, title) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=isbn:${isbn}&author:${author}&title:${title}&key=${ApiKey}`);
    },

    searchByIsbn(isbn) {

        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=inauthor:${isbn}&key=${ApiKey}`);
        
    },

    searchByAuthor(author) {

        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=inauthor:${author}&key=${ApiKey}`);
        
    },
    
    searchByTitle(title) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=intitle:${title}&key=${ApiKey}`);

    },

    searchBySubject(subject) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=subject:${subject}&key=${ApiKey}`);

    }, searchByIsbn(isbn) {

        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=isbn:${isbn}&key=${ApiKey}`);

    }
    



}