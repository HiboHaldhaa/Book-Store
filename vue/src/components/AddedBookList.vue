<template>
  <div class="bookshelf">
    
    <div class="book-grid">
      
    <BookCard v-bind:book="book" v-for="book in $store.state.addedBookList" v-bind:key="book.isbn"/>
    </div>
  </div>
</template>

<script>
import BookServices from "../services/BookServices";
import BookCard from '../components/BookCard.vue';

export default {
    components: {
    BookCard
},
  name: "book-list",
  methods: {
    getAddedBooks() {
        BookServices.addedBookList().then(response => {
            this.$store.commit("SET_ADDED_BOOK", response.data);
      });
    }
  },
  created() {
    this.getAddedBooks();
  },
 
};
</script>

<style scope >
.book-grid {
display: flex;
  flex-direction: row;

}

</style>