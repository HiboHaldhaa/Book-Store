<template>
  <div class="reading-list">
     <header>
    <h3>Search Results</h3>
    <h4>Add to Reading List</h4>

    
  </header>

    
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
h3{
font-size: 25px;
position:relative;
left:277px;
top:565px;
}

h4{
  font-size: 25px;
position:relative;
left:1013px;
top:533px;
}


</style>