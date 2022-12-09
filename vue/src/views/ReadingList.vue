<template>
  <div class="reading-list">
    
   <SearchBook/> 
  <ReadingList/> 
  </div>
</template>

<script>
import SearchBook from '../components/SearchBook.vue'
import ReadingList from '../components/ReadingList.vue'
export default {
  components: {
    SearchBook,
    ReadingList
  }

}
</script>

<style>

</style>