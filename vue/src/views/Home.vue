<template>
  <div class="cards-list">
  <!-- <NewBooks/> -->
  

<div class="card 1">
  <!-- <div class="card_image"> <img src="https://i.redd.it/b3esnz5ra34y.jpg" /> </div> -->
  <div class="card_title title-white">
    
  </div>


  
</div>

  <div class="card 2">
  <!-- <div class="card_image">
    <img src="https://cdn.blackmilkclothing.com/media/wysiwyg/Wallpapers/PhoneWallpapers_FloralCoral.jpg" />
    </div> -->
  <div class="card_title title-white">
    
  </div>
</div>

<div class="card 3">
  <div class="card_image">
    <!-- <img src="https://media.giphy.com/media/10SvWCbt1ytWCc/giphy.gif" /> -->
  </div>
  <div class="card_title">
    
  </div>
</div>
  
  <div class="card 4">
  <div class="card_image">
    <!-- <img src="https://m.media-amazon.com/images/I/41LmPEurOOL._SY346_.jpg" /> --> -->
    </div>
  <div class="card_title title-black">
    
  </div>
  </div>

  <!-- <div class="new" v-bind:class="{}" >
    <div class="badge">New</div>
  </div>   -->

</div>
</template>

<script>
// import NewBooks from '../components/NewBooks.vue'
export default {
 
  name: "home",
  newBooks: [ {
    newBadge: false
  }
  ],

   components: {
    // NewBooks
  },
};
</script>
<style >

/* .badge {
    position: absolute;
    left:57px;
    top:33px;
    text-transform: uppercase;
    font-size: 13px;
    font-weight: 700;
    background: rgba(3, 3, 243, 0.795);
    color: #fff;
    padding: 3px 20px;

} */
/* 
.badge:hover {
    transform: scale(0.9, 0.9);
  box-shadow: 5px 5px 30px 15px rgba(0,0,0,0.25), 
    -5px -5px 30px 15px rgba(0,0,0,0.22);
} */

.cards-list {
  position:relative;
left:2px;
top:188px;
  z-index: 0;
  width: 100%;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.card {
  margin: 30px auto;
  width: 300px;
  height: 300px;
  border-radius: 40px;
box-shadow: 5px 5px 30px 7px rgba(0,0,0,0.25), -5px -5px 30px 7px rgba(0,0,0,0.22);
  cursor: pointer;
  transition: 0.4s;
}

.card .card_image {
  width: inherit;
  height: inherit;
  border-radius: 40px;
}

.card .card_image img {
  width: inherit;
  height: inherit;
  border-radius: 40px;
  object-fit: cover;
}

.card .card_title {
  text-align: center;
  border-radius: 0px 0px 40px 40px;
  font-family: sans-serif;
  font-weight: bold;
  font-size: 30px;
  margin-top: -80px;
  height: 40px;
}


.card:hover {
  transform: scale(0.9, 0.9);
  box-shadow: 5px 5px 30px 15px rgba(0,0,0,0.25), 
    -5px -5px 30px 15px rgba(0,0,0,0.22);
}

.title-white {
  color: white;
}

.title-black {
  color: black;
}




.card {
  margin: 30px auto;
  width: 300px;
  height: 300px;
  border-radius: 40px; 
   background-image: url('https://github.com/appgamedev/book-Library/blob/main/wepik-the-blade-in-the-sea-wattpad-book-cover-2022117-12356.png?raw=true'); 
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center;
  background-repeat: no-repeat;
box-shadow: 5px 5px 30px 7px rgba(0,0,0,0.25), -5px -5px 30px 7px rgba(0,0,0,0.22);
  transition: 0.4s;
} 

</style>