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
position:relative;
left:50px;

height: 400px;
}
</style>