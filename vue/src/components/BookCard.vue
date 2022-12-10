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
  top: 350px;
  left: 40px;
}
.badge {
    position: absolute;
    left:21px;
    top:7px;    
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
.returningValue  { 
    width: 95%; 
    font: inherit;
    position:relative;
    width: 399px; 
    height: 511px;
    max-width: 350px; 
    float:left; 
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
 position:relative;
left:38px;
top:408px;
} 
 .book-author {
position:relative;
left:79px;
top:387px;
 background-color:#ffffff;
}
.CoverImg {
position:relative;
left:21px;
top:-121px;
height: 400px;
}

#shareForm {
  position: absolute;
  bottom: 100px;
  left: 100px;
  z-index: 999;
  display: none;
  background-color: white;
}
</style>