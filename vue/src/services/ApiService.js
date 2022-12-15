import axios from "axios";

const ApiKey = "AIzaSyBXgahO9dRrvWDEVGRVSK9PCZJCmEGLc4Y";

const newInstanceOfAxios = axios.create();

export default {
    search(isbn, author, title) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=isbn:${isbn}&author:${author}&title:${title}&key=${ApiKey}`);
    },

    searchByAuthor(author) {

        return fetch(`https://www.googleapis.com/books/v1/volumes?q=inauthor:${author}`);
        
    },
    
    searchByTitle(title) {
        return fetch(`https://www.googleapis.com/books/v1/volumes?q=intitle:${title}&key=${ApiKey}`);

    },

    searchBySubject(subject) {
        return fetch(`https://www.googleapis.com/books/v1/volumes?q=subject:${subject}&key=${ApiKey}`);

    }
    



}