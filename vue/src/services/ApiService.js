import axios from "axios";

const ApiKey = "AIzaSyCQ_gF2dgdtt4IYuqTb9AdOgx5irydJiV0";

const newInstanceOfAxios = axios.create();

export default {
    search(isbn, author, title) {
        return newInstanceOfAxios.get(`https://www.googleapis.com/books/v1/volumes?q=isbn:${isbn}&author:${author}&title:${title}&key=${ApiKey}`);
    }
    



}