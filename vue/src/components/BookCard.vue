<template>
<!-- <div class="returningValue"> -->
  <div class="returningValue" >
    <h2 class="book-title">{{book.title}} </h2>
    <h3 class="book-author"> {{book.author}} </h3>
    <img class="CoverImg " v-bind:src="book.coverLink">
    <div class="shareBtn">
    <button class="shareButton" v-on:click="showShareForm()">Share</button>
    </div>
    <form id="shareForm" @submit.prevent="sendemail()">
    <div>
      <label for="email">Email: </label>
      <input id="email" type="text" v-model.trim="email" placeholder="Recipient email"/>
    </div>
    <div>
      <label for="name">From: </label>
      <input id="name" type="text" v-model.trim="name" placeholder="Your Name"/>
    </div>
    <div><button>Send Book</button></div>
    
   

  </form>

<div v-if="isNew" class="badge">New</div>

  </div>
  <!-- </div> -->
</template>
<script>
import EmailService from '../services/EmailService'

export default {
  name : 'book-card',
  props : ['book'],
  data() {
    return {
      email: "",
      name: ""
    }
    
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
  }
},
methods: {
  showShareForm() {
    document.getElementById('shareForm').style.display = "block";
  },
  sendemail() {

    EmailService.sendEmail(this.email, this.name, this.book);

    document.getElementById('shareForm').style.display = "none";

  }
}
}
</script>
<style>
.shareBtn {
  position: absolute;
  left: 40px;
}
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
.returningValue  { 
  position: rela;
   width: var(--mobile-width);
  height: var(--mobile-height);
  margin: 30px 0;
  border-radius: var(--mobile-radius);
  perspective: 500px;
  overflow: hidden;
  color: var(--font-color);
  background-color: var(--mobile-bg);
  box-shadow: 36px 36px 50px 15px #eed7d1d1;
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
left:25px;

height: 400px;
}

#shareForm {
  position: absolute;
  bottom: 25px;
  left: 100px;
  z-index: 999;
  display: none;
  background-color: white;
}
</style>