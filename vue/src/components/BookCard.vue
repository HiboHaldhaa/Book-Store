<template>
  <div class="container">
    <h2 class="book-title">{{book.title}} </h2>
    <h3 class="book-author"> {{book.author}} </h3>
    <img class="cover" v-bind:src="book.coverLink">
  </div>
</template>

<script>
export default {
  name : 'book-card',
  props : ['book'],

}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>