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
  left: 21px;
  top: 7px;
  text-transform: uppercase;
  font-size: 13px;
  font-weight: 700;
  background: rgba(3, 3, 243, 0.795);
  color: #fff;
  padding: 3px 20px;
}
.book-title {
  margin-bottom: 20px;
}
.returningValue {
  width: 95%;
  font: inherit;
  position: relative;
  width: 399px;
  height: 511px;
  max-width: 350px;
  float: left;
  display: inline;
  white-space: inherit;
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
  position: relative;
  left: 38px;
  top: 408px;
}
.book-author {
  position: relative;
  left: 79px;
  top: 387px;
  background-color: #ffffff;
}
.CoverImg {
  position: relative;
  left: 21px;
  top: -121px;
  height: 400px;
}
</style>