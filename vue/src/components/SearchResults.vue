<template>
  <div>
      <BookCard v-bind:book="book" v-for="book in booklist" v-bind:key="book.isbn"/>

  </div>    
</template>

<script>
import BookCard from '../components/BookCard.vue';
export default {
components: {
    BookCard

},

computed: {
    booklist() {
        return this.$store.state.currentSearch;
    },
},
mounted() {
    this.$store.commit('SET_CURRENT_SEARCH', []);
}
}
</script>

<style>

</style>