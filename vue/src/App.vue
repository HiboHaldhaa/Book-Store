<template>
  <div id="app">
    
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{name: 'search-books' }">Search</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'add-books' }">Add Book</router-link>&nbsp;|&nbsp;

    </div>
    <router-view />
  </div>
</template>

<script>
//import BookList from './components/BookList.vue';

export default {
  name: "app",
 components: {
   //BookList
 }
};
</script>

