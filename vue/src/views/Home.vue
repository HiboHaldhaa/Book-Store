<template>
  <header>
    <nav>
      <ul>
        <li>
          <router-link to="/search-books">Search Library</router-link>
        </li>
        <li>
          <router-link to="/add-book">Add Book to Library</router-link>
        </li>
      </ul>
    </nav>
  </header>
</template>

<script>

export default {
  components: {
    
  },
  name: "home"
};
</script>
