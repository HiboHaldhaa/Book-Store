<template>
  <div class="reading-list">
    
   <SearchBook/> 
  <SearchResults/>
  <ReadingList/> 
  </div>
</template>

<script>
import SearchBook from '../components/SearchBook.vue'
import SearchResults from '../components/SearchResults.vue'
import ReadingList from '../components/ReadingList.vue'
export default {
  components: {
    SearchBook,
    SearchResults,
    ReadingList
  }

}
</script>

<style>

</style>