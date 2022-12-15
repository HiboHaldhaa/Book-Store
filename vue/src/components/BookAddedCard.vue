<template>

  <div >
    <img class="CoverImgCard" v-bind:src="book.coverLink">
    <new-books/>
  </div>
</template>

<script>
import NewBooks from './NewBooks.vue';
export default {
  components: { NewBooks },
  name : 'book-card',
  props : ['book'],
  computed: {
    isNew() {
      const today = new Date();
      const day = new Date(this.book.dateAdded);
      const diff = today - day;

      if (diff < 604800000) {
        return true;
      }
      return false;
  }
}

}
</script>

<style>
.badge {
    position: absolute;
    left:50px;
    top:30px;    
    text-transform: uppercase;
    font-size: 20px;
    font-weight: 700;
    background: red;
    color: #fff;
    padding: 3px 20px;
    
    
}

.CoverImg {
position:relative;
left:25px;

height: 400px;
}
.CoverImgCard {
      display: block;
      box-shadow: 0px -5px 20px 2px rgba(black, 0.3);
      width: 200px;
      height: 300px;
      object-fit: cover;
		}
</style>