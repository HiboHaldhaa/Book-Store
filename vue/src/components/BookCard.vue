<template>
<!-- <div class="returningValue"> -->
  <div class="returningValue" >
    <h2 class="book-title">{{book.title}} </h2>
    <h3 class="book-author"> {{book.author}} </h3>
    <img class="CoverImg " v-bind:src="book.coverLink">
<div v-if="isNew" class="badge">New</div>
  </div>
  <!-- </div> -->
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

/* 
.returningValue{
    flex: 1;
    margin: 3px;
    height: 70vh;
    position: relative;
}

/* .badge {
    position: absolute;
    left:138px;
    top:33px;
    text-transform: uppercase;
    font-size: 13px;
    font-weight: 700;
    background: rgba(3, 3, 243, 0.795);
    color: #fff;
    padding: 3px 20px;
} */

.book-title {
    margin-bottom: 20px;
}

/* .book-author {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
} */

/* .CoverImg {
    /* width: 100%;
    height: 100%; */
    /* object-fit: cover; */
    /* display: flex;
    align-items: center;
    justify-content: center;
    position: relative;
    height: 75%;
}  */ 

.returningValue  { 
    width: 95%; 
    font: inherit;
    /* margin-top:1.5rem; */
    position:relative;
    width: 399px; 
    height: 511px;
    max-width: 350px; 
    /* object-fit: cover;
    flex: 1;
     display: flex; 
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center; */
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
/* left:38px;
top:405px; */
left:38px;
top:408px;
/* max-width: 500px; */
/* width:275px; */
/* white-space: initial; */
/* word-wrap:break-word; */
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

/* .book-title {
left:57px;
top:410px;
position:relative;
}

.book-author {
left:91px;
top:398px;
background-color:#ffffff;
} */





</style>