import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
})

export default {

    addBookToReadingList(id, book) {

        return http.post(`/reading-list/${id}`, book);

    },

    getReadingList(id) {
        return http.get(`/reading-list/${id}`);
    },

    deleteFromReadingList(id, isbn) {
        return http.delete(`/reading-list/${id}`, isbn);
    }
}