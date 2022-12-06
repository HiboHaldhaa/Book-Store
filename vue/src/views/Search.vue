<template>
  <div class="search">
   
  <SearchBook/> 
  <SearchResults/>
  </div>
</template>

<script>

import SearchBook from '../components/SearchBook.vue'
import SearchResults from '../components/SearchResults.vue'
export default {
  components: {
    SearchBook,
    SearchResults
  }

}
</script>

<style>

</style>

