<template>
  <div class="card-container">
    <h2 class="book-title">{{book.title}} </h2>
    <h3 class="book-author"> {{book.author}} </h3>
    <img class="CoverImg" v-bind:src="book.coverLink">
  </div>
</template>

<script>
export default {
  name: "Card",
  props: ['readingList'],
};
</script>

<style scoped>
.card-container {
  background: #fff;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.15);
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  margin-bottom: 2rem;
  
}
.card-body {
  padding: 1rem 2rem;
}
p {
  font-size: 1.6rem;
}
</style>