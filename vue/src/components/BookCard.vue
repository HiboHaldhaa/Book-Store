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


.returningValue {
  display: flex;
  flex-wrap: wrap;
  align-content: center;
   position: relative;
   width: var(--mobile-width);
  height: var(--mobile-height);
  
  border-radius: var(--mobile-radius);
  perspective: 500px;
  overflow: hidden;
  color: var(--font-color);
  background-color:#71e03e;;
  box-shadow: 36px 36px 50px 15px #eed7d1d1;
  }

  .book-title{
    display: flex;
    ;


    

  }

.card.read {
  background-color: lightgray;
}


 
</style>