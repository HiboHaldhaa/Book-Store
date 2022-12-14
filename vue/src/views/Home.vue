<template>
  <div class="display-book">
    
    <h2> Featured Author of the month: {{$store.state.featuredAuthor}} </h2>
    
     
    <BookCard v-bind:book="book" v-for="book in featuredList" v-bind:key="book.isbn"/>
   
  
</div>
</template>

<script>


//import ApiService from '../services/ApiService'
import BookServices from '../services/BookServices'
import BookCard from '../components/BookCard.vue'


export default {
  data(){
    return{
      featuredBooks :[]
    }
  },
  computed: {
    featuredList() {
      return this.featuredBooks;
    }
  },
 
  name: "home",
  newBooks: [ {
    newBadge: false
  }
  ],

   components: {
    BookCard
  },
  methods:{
   
  },
  created() {

    for (let i = 0; i < this.$store.state.featuredBooks.length; i++) {
    
    let book;
      BookServices.searchByIsbn(this.$store.state.featuredBooks[i]).then(response => {
        book = response.data;
        this.featuredBooks.push(book);
        })
      
      
      

    }
    }
}
</script>
<style >
.display-book{
  position:relative;
  right:300px;
  top:43px;
  min-height: 100vh;
  display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items: center;
  justify-content: center;
  background-color: #FFF3B0;
}


 
 
h2 {
position:relative;
left:800px;
top:-425px;
}






</style>