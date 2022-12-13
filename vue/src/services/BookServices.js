import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
})

export default {
    searchBooks(book) {
      return http.get(`/search?title=${book.title}&author=${book.author}&genre=${book.genre}&keyword=${book.keyword}&isbn=${book.isbn}`);
    },

    addBooks(books) {
        return http.post('/books', books)
    },
    addedBookList() {
        return http.get('/getAddedBooks');
      },
    searchByIsbn(isbn){
      return http.get(`/books/${isbn}`)
    }

}