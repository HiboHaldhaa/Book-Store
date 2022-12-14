<template>
  <div class="display-book">
    
    
    <h2> Featured Author of the month: Kurt Vonnegut </h2>
    
     
    <DisplayBook v-bind:book="book" v-for="book in featuredBooks" v-bind:key="book.industryIdentifiers[1].identifier"/>
   
  
</div>
</template>

<script>


import ApiService from '../services/ApiService'
import DisplayBook from '../components/DisplayBook.vue'


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
    DisplayBook,
    
    
    
  },
  methods:{
   
  },
  created() {

    for (let i = 0; i < this.$store.state.featuredBooks.length; i++) {
    
    let book;
      ApiService.search(this.$store.state.featuredBooks[i]).then(response => {
        book = response.data.items[0].volumeInfo;
        this.featuredBooks.push(book);
        })
      
      
      

    }
    }
}
</script>
<style scoped>




.display-book{
  position:relative;
  
  
  min-height: 100vh;
  display: flex;
  
  justify-content:space-around;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  
  
}


 
 
h2 {
position:relative;
left:800px;
top:-425px;
}






</style>