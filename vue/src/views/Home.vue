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
    DisplayBook
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

.display-book {
  display: flex;
  justify-content: space-evenly;
}




</style>