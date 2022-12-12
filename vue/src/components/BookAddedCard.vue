<template>

  <li class="returningValue" >
    <img class="CoverImg " v-bind:src="book.coverLink">
  </li>
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
      display: block;
      box-shadow: 0px -5px 20px 2px rgba(black, 0.3);
      width: 200px;
      height: 300px;
      object-fit: cover;
		}
</style>