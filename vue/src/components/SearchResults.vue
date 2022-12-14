<template>
  <div id="box">
      <div id="search-results">
    <BookCard v-bind:book="book" v-for="book in booklist" v-bind:key="book.isbn"/>
    
    </div>
    <div id="recommendations" >
        <h1 style= "text-align: center" v-if="booklist.length > 0"> Recommendations for {{$store.state.user.username}} based on your search</h1>   
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
#search-results{
     display: flex;
  justify-content:space-evenly;
  align-content: flex-start;
  flex-wrap: wrap;
 }



 

</style>