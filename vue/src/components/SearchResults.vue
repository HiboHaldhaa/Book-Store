<template>
  <div>
    <BookCard v-bind:book="book" v-for="book in booklist" v-bind:key="book.isbn"/>
    <div id="apiBooks">
        <ApiBookSearch v-if="booklist.length > 0" />
    </div>
  </div>    
</template>

<script>
import BookCard from '../components/BookCard.vue';
import ApiBookSearch from './ApiBookSearch.vue';
export default {
components: {
    BookCard,
    ApiBookSearch
},

computed: {
    booklist() {
        return this.$store.state.currentSearch;
    }
},
mounted() {
    this.$store.commit('SET_CURRENT_SEARCH', []);
}
}
</script>

<style>

</style>