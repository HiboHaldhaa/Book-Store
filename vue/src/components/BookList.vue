<template>
  <div class="container">
 

 <thead>
        <tr>
          <th>&nbsp;</th>
          <th>Title</th>
          <th>Author</th>
          <th>Genre</th>
          <th>Keyword</th>
          <th>ISBN</th>
        </tr>
      </thead>
    <form id = "searchBook">
       <div class="field">
          <label for= "title">Title:</label> 
           <input type="text" name="title"/>
        </div> 


        <div class="field">
          <label for= "author">Author:</label> 
           <input type="text" name="author"/>
        </div>


        <div class="field">
          <label for= "genre">Genre:</label> 
           <input type="text" name="genre"/>
        </div>

        <div class="field">
          <label for= "keyword">Keyword:</label> 
           <input type="text" name="keyword"/>
        </div>
        <div class="field">
          <label for= "isbn">ISBN:</label> 
           <input type="text" name="isbn"/>
        </div>

        
    </form>   
    </div>
</template>

<script>
export default {
    name: 'book-list',

  data() {
      return {
          bookList: {
              title: "",
              author: "",
              genre: "",
              keyword: "",
              isbn: ""
              
          }
      } 
  }  


}
</script>

<style scoped>

 </style>