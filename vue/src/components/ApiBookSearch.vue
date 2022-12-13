<template>
    <div id="displayBookDiv">
    <DisplayBook v-bind:book="book" v-for="book in bookList" v-bind:key="book.isbn"/>
  </div>
</template>

<script>
import ApiService from '../services/ApiService';
import DisplayBook from './DisplayBook.vue';

export default {
  components: {DisplayBook  },
    data() {
        return  {
            author: "",
            title: "",
            genre: "",
            books: []
        }
    },
    computed: {
        bookList() {
            return this.books;
        }
},
created() {
    let book = this.$store.state.currentSearch[0];
    this.author = book.author;
    this.title = book.title;
    this.genre = book.genres[0];

    ApiService.searchByAuthor(this.author).then(response => {
        let random = Math.floor(Math.random() * 10);
        let book = response.data.items[random].volumeInfo;
        this.books.push(book);

    }).catch(e => console.log(e))

    ApiService.searchByTitle(this.title).then(response => {
        let random = Math.floor(Math.random() * 10);
        let book = response.data.items[random].volumeInfo;
        this.books.push(book);

    }).catch(e => console.log(e))

    ApiService.searchBySubject(this.genre).then(response => {
        let random = Math.floor(Math.random() * 10);
        let book = response.data.items[random].volumeInfo;
        this.books.push(book);

    }).catch(e => console.log(e))
    
}
}
</script>

<style>
#displayBookDiv {
    display: flex;
  justify-content:space-evenly;
  align-content:flex-start;
  flex-wrap: wrap;
}
</style>