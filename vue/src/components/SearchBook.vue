<template>

  <form @submit.prevent="submitForm">
    <h1> Search a Book in our Library</h1>
    <div class="form-control">
      <label for="title">Title</label>
      <input id="title" name="title" type="text" v-model.trim="title" />
    </div>
    <div class="form-control">
      <label for="author">Author</label>
      <input id="author" name="author" type="text" v-model.trim="author" />
    </div>
    <div class="form-control">
      <label for="genre">Select Genre</label>
      <select id="genre" name="genre" v-model="genre">
        <option value="action">Action</option>
        <option value="adventure">Adventure</option>
        <option value="sci-fi">Science Fiction/Fantasy</option>
      </select>
    </div>
    <div class="form-control">
      <label for="keyword">Keyword(s)</label>
      <input id="keyword" name="keyword" type="text" v-model.trim="keyword" />
    </div>
    <div class="form-control">
      <label for="isbn">ISBN </label>
      <input id="isbn" name="isbn" type="text" v-model.trim="isbn" />
    </div>
    
    
    
    <div>
      <button>Search Books</button>
    </div>
  </form>
</template>

<script>

export default{
    name: "search",
  data () {
    return {
      title: '',
      author: '',
      genre: 'action',
      keyword: '',
      isbn: '',
    };
  },
  methods: {
    submitForm() {
      console.log('title: ' + this.title);
      this.title = '';
      console.log('author: ' + this.author);
      this.author = '';
      console.log('genre: ' + this.genre);
      this.genre = 'action';
      console.log('keyword: ' + this.keyword);
      this.keyword = '';
      console.log('isbn: ' + this.isbn);
      this.isbn = '';
      
    },
  },
};

</script>

<style scoped>
form {
  margin: 2rem auto;
  max-width: 40rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 2rem;
  background-color: #ffffff;
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
  width: 100%;
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