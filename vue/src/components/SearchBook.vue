<template>

  <form @submit.prevent="searchBooks()">
    <h1> Search a Book in our Library</h1>
    <div class="form-control">
      <label for="title">Title</label>
      <input id="title" name="title" type="text" v-model.trim="book.title" />
    </div>
    <div class="form-control">
      <label for="author">Author</label>
      <input id="author" name="author" type="text" v-model.trim="book.author" />
    </div>
    <div class="form-control">
      <label for="genre">Select Genre</label>
      <select id="genre" name="genre" v-model="book.genre">
        <option value=""></option>
        <option value="action">Action</option>
         <option value="drama">Drama</option>
        <option value="adventure">Adventure</option>
        <option value="autobiography">Autobiography</option>
        <option value="children's">Children's Literature</option>
        <option value="fiction">Fiction</option>
        <option value="Horror">Horror</option>
        <option value="literary fiction">Literary Fiction</option>
        <option value="non-fiction">Non-Fiction</option>
        <option value="sci-fi">Science Fiction/Fantasy</option>
        <option value="true-crime">True Crime</option>
        <option value="young-adult">Young Adult</option>
      </select>
    </div>
    <div class="form-control">
      <label for="keyword">Keyword(s)</label>
      <input id="keyword" name="keyword" type="text" v-model.trim="book.keyword" />
    </div>
    <div class="form-control">
      <label for="isbn">ISBN </label>
      <input id="isbn" name="isbn" type="text" v-model.trim="book.isbn" />
    </div>
    
    <div>
      <button>Search Books</button>
    </div>
  </form>
</template>

<script>

import bookServices from "@/services/BookServices.js"
export default{
    // name: "search",


  data () {
    return {
      book: {
        title: '',
        author: '',
        genre: '',
        keyword: '',
        isbn: '',
      }
    };
  },
  methods: {
    submitForm() {
      // console.log('title: ' + this.title);
      this.title = '';
      // console.log('author: ' + this.author);
      this.author = '';
      // console.log('genre: ' + this.genre);
      this.genre = 'action';
      // console.log('keyword: ' + this.keyword);
      this.keyword = '';
      // console.log('isbn: ' + this.isbn);
      this.isbn = '';
      
    },

    searchBooks() {
      bookServices.searchBooks(this.book).then((response) => {
        
        this.$store.commit('SET_CURRENT_SEARCH', response.data);
      })
      .catch(error => {
        if(error.response.status == 404) {
          this.$router.push({name:"NotFound"})
        }
      })
    }
  },
};

</script>

<style scoped>


form {
  margin: 2rem auto;
  max-width: 40rem;
  min-height: 25rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 2rem;
  background-color: #E1B07E;
}

.form-control {
  margin: 0.5rem 0;
  
}

label {
  font-weight: bold;
}

h2 {
  font-size: 1rem;
  margin: 0.5rem 0;
}

input,
select {
  display: block;
  width: 95%;
  font: inherit;
  margin-top: 0.5rem;
}

select {
  width: auto;
}

button {
  font: inherit;
  border: 1px solid #0076bb;
  background-color: #0076bb;
  color: white;
  cursor: pointer;
  padding: 0.75rem 2rem;
  border-radius: 30px;

position:relative;
left:177px;
top:2px;
}



button:hover,
button:active {
  border-color: #002350;
  background-color: #002350;
}
form.div{
  position:relative;
left:-2px;
top:13px;
}

.search{
  display: flex;
  flex-direction: row;
   height: 2000px;
}

#search-results{
  display: flex;
  flex-direction: row;

 

}



</style>