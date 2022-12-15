<template>
 
  <div id="mainGrid">
<h1 class="addedHeader"> HE GOT AN OFFERRRRRRRR</h1>
<div id="addedBooks">

    <AddedBookList/>

    </div>
  </div>  

    



</template>

<script>
import AddedBookList from './AddedBookList.vue'
export default {
  components: { AddedBookList },

}
</script>

<style scoped >
.addedHeader{
 text-align: center;
  margin-top: 5%;
  color: aliceblue;
}

</style>