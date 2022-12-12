<template>
  <!-- <div class="container"> 
      <h1 class="bookList">Books</h1>

      <div class="classList">
          <div class="booksCards" v-for="book in books" v-bind:key="book.isbn">
              <book-details v-bind:book="book" />



          </div>
      </div>


  </div> -->


  <form @submit.prevent="search()">
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


// import axios from 'axios'

 import ApiService from '../services/ApiService'
// const instanceOfAxios = axios.create();

export default {
    name: 'book-list',
    computed: {
      bookList() {
        return this.books;
      }
    },
    data() {
        return{
            // books:
     book: {
        title: '',
        author: '',
        genre: '',
        keyword: '',
        isbn: '',
     },

     books:[],
     keyword: '',
     loadState: '',
     orderBy: 'newest'
                
}
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
      
    
    search() {
      
      let book;
      ApiService.search(this.book.isbn).then(response => {
        book = response.data.items[0].volumeInfo;
        this.books.push(book);

    });
    
}}}
    

</script>

<style scoped>
form {
  margin: 2rem auto;
  max-width: 40rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 2rem;
  background-color: #e09f3e;
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
}

button:hover,
button:active {
  border-color: #002350;
  background-color: #002350;
}
</style>