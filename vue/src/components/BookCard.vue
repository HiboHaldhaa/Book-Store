<template>
  <!-- <div class="returningValue"> -->
  <div class="returningValue">
    <h2 class="book-title">{{ book.title }}</h2>
    <h3 class="book-author">{{ book.author }}</h3>
    <img class="CoverImg" v-bind:src="book.coverLink" />
    <div v-if="isNew" class="badge">New</div>
    <share-button :book="book"></share-button>
  </div>
  <!-- </div> -->
</template>
<script>
import ShareButton from './ShareButton.vue';

export default {
  components: { ShareButton },
  
  name: "book-card",
  props: ["book"],
  data() {
    return {
      email: "",
      name: "",
    };
  },
  computed: {
    isNew() {
      const today = new Date();
      const day = new Date(this.book.dateAdded);
      const diff = today - day;
      if (diff < 604800000) {
        return true;
      }
      return false;
    },
  },
};
</script>
<style>
.badge {
    position: absolute;
    left:30px;
    top:30px;    
    text-transform: uppercase;
    font-size: 20px;
    font-weight: 700;
    background: rgb(243, 7, 7);
    color: #fff;
    padding: 3px 20px;
    
    
}
.book-title {
  margin-bottom: 20px;
}
.returningValue {
   position: relative;
   width: var(--mobile-width);
  height: var(--mobile-height);
  margin: 30px 0;
  border-radius: var(--mobile-radius);
  perspective: 500px;
  overflow: hidden;
  color: var(--font-color);
  background-color:#e09f3e;;
  box-shadow: 36px 36px 50px 15px #eed7d1d1;
 }
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
.book-title {
  position:relative;
left:60px;
top:500px;
} 
.book-author {
  position:relative;
left:79px;
top:500px;
 
}
.CoverImg {
  position:relative;
left:50px;

height: 400px;
}
</style>