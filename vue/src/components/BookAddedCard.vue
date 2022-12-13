<template>

  <div >
    <img class="CoverImgCard" v-bind:src="book.coverLink">
  </div>
</template>

<script>
export default {
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


.CoverImg {
position:relative;
left:50px;

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