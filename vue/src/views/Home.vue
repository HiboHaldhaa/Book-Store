<template>
  <div class="display-book">
     
    <DisplayBook v-bind:book="book" v-for="book in featuredBooks" v-bind:key="book.industryIdentifiers[1].identifier"/>
    <!-- <DiffBookDisplay/> -->
  
</div>
</template>

<script>


import ApiService from '../services/ApiService'
import DisplayBook from '../components/DisplayBook.vue'
// import DiffBookDisplay from '../components/DiffBookDisplay.vue'

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
    
    //  DiffBookDisplay
    
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
<style >
.display-book{
  position:relative;
  left:1px;
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


 
 







</style>