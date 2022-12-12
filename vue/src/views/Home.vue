<template>
  <div class="display-book">
    
    <DisplayBook v-bind:book="book" v-for="book in featuredBooks" v-bind:key= "book.isbn"/>
    <!-- <DiffBookDisplay/> -->
  
</div>
</template>

<script>
import DisplayBook from '../components/DisplayBook.vue'
// import DiffBookDisplay from '../components/DiffBookDisplay.vue'

export default {
  data(){
    return{
      featuredBooks :[]
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
    getFeaturedBooks(isbn){
      let book = ApiService.search(isbn);
      return book;

    }

  },
  created() {
    for (let i = 0; i < this.$store.state.featuredBooks.length; i++)
    this.featuredBooks.push(this.getFeaturedBooks(this.$store.state.featuredBooks[i]));


    }
};
</script>
<style >




</style>