import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
})

export default {
    searchBooks() {
      return http.get('/search', "search");  
    },

    addBooks(books) {
        return http.post('/books', books)
    }
}