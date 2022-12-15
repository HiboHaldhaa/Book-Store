<template>
  <div class="bookshelf">
    <div class="book-grid">
      <div class="addedBook">
    <BookAddedCard v-bind:book="book" v-for="book in $store.state.addedBookList" v-bind:key="book.isbn"/>
      </div>
       <div class="shelf-shadows"> </div>
  <div class="shelf"></div>
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
  position: relative;
}
.addedBook{
display: flex;
flex-direction:row;
  margin: 100px;
}

.book-grid{
  position: relative;
  transform: translateY(-15px);
}


.shelf-shadows{
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 1rem;
  border-radius: 2px;
  z-index: 1;
  box-shadow: 0px -5px 3px 0px rgba(#aaa, 0.2), 0px 15px 20px 0px rgba(#aaa, 0.7), 0px 5px 5px 0px rgba(#777, 0.3);
}


.shelf{
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 1rem;
  background-color:rgb(90, 52, 8);
  border-radius: 2px;
  z-index: 3;
}
</style>