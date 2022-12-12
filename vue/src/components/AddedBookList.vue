<template>
  <div class="bookshelf">
    <div class="book-grid">
    <BookAddedCard v-bind:book="book" v-for="book in $store.state.addedBookList" v-bind:key="book.isbn"/>
    </div>
  </div>
</template>

<script>
import BookServices from "../services/BookServices";
import BookAddedCard from '../components/BookAddedCard.vue';

export default {
    components: {
    BookAddedCard
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

<style>

.bookshelf{
  width: 900px;
  margin: 5rem auto;
  text-align: center;
  position: relative;
}

.book-grid{
  z-index: 2;
  position: relative;
  transform: translateY(-15px);
}
</style>