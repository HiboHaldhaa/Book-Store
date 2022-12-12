<template>
  <div class="display-book">
    
    <DisplayBook/>
    <!-- <DiffBookDisplay/> -->
  
</div>
</template>

<script>
import DisplayBook from '../components/DisplayBook.vue'
// import DiffBookDisplay from '../components/DiffBookDisplay.vue'

export default {
 
  name: "home",
  newBooks: [ {
    newBadge: false
  }
  ],

   components: {
    DisplayBook
    //  DiffBookDisplay
    
  },
};
</script>
<style >




</style>