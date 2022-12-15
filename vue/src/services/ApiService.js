import axios from "axios";

const ApiKey = "AIzaSyDk2ihFqZ7JzWh2pnRhWv8WeCgNmT0Ofs0";

const newInstanceOfAxios = axios.create();

export default {
    search(isbn, author, title) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=isbn:${isbn}&author:${author}&title:${title}&key=${ApiKey}`);
    },

    searchByAuthor(author) {

        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=inauthor:${author}&key=${ApiKey}`);
        
    },
    
    searchByTitle(title) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=intitle:${title}&key=${ApiKey}`);

    },

    searchBySubject(subject) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=subject:${subject}&key=${ApiKey}`);

    }
    



}