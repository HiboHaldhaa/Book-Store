<template>
   
  <div class="book-1">

        <div class="mobile-layout">
        <div class="notification-header">
      
      
    </div>
    <div class="actions">
      <i class="fas fa-chevron-left"></i>
      <i class="fas fa-bookmark"></i>
    </div>  
    <div class="book-cover">
        <img class="book-top" v-bind:src="book.imageLinks.thumbnail" alt="book-top" />
       
    </div>
    <div class="preface">
     
        <div class="header">
          
          <div class="icon">
            <i class="fas fa-chevron-down"></i>
          </div>
        </div>
        <div class="author">{{book.title}}</div>
        <div class="author">{{book.authors[0]}}</div>
        <div class="body">
          <p>
            {{book.description}}
          </p>
          
        </div>
      
        </div>
        </div>
  </div>

        
 
</template>

<script>
export default {
  props: ["book"]

}
</script>

<style>
* {
  border: 0;
  margin: 0;
  box-sizing: border-box;
}



:root {
   --mobile-width: 325px;
  --mobile-height: 670px;
  --mobile-radius: 25px;
  --separator-height: 500px;
  
  --bg: #d7e8ba;
  --mobile-bg:  hsla(208, 90%, 88%, 1);

background: linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

background: -moz-linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

background: -webkit-linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#C3E1FC", endColorstr="#E09F3E", GradientType=1 );;
  --intro-bg: hsla(208, 90%, 88%, 1);

background: linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

background: -moz-linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

background: -webkit-linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#C3E1FC", endColorstr="#E09F3E", GradientType=1 );;
  --font-color: #540B0E;
  
  --transition: transform 0.7s ease-in-out;
}


.info {
  font-family: 'Quicksand', sans-serif;
  font-family: 'Open Sans', sans-serif;
  font-style: italic;
  font-size: 26px;
  margin-top: 10px;
  color: var(--font-color);
}

.mobile-layout {
   width: var(--mobile-width);
  height: var(--mobile-height);
  margin: 30px 0;
  border-radius: var(--mobile-radius);
  perspective: 500px;
  overflow: hidden;
  color: var(--font-color);
  background-color: var(--mobile-bg);
  box-shadow: 36px 36px 50px 15px #FFF3B0;
}
  
  .notification-header {
    position: fixed;
    top: 5px;
    width: 100%;
    padding: 5px 15px;
    display: flex;
    justify-content: space-between;
    font-size: 12px;
    font-family: 'Open Sans', sans-serif;
    font-weight: bold;
    z-index: 6;
  }
  
  .actions { 
    position: fixed;
    top: 37px;
    width: 100%;
    padding: 50px;
    display: flex;
    justify-content: space-between;
    font-size: 20px;
    z-index: 6;
  }
  
  .book-cover {
    position: relative;
    height: var(--separator-height);
    width: calc(var(--mobile-width) * 2);
    left: -52.5%;
    border-top-left-radius: var(--mobile-radius);
    border-top-right-radius: var(--mobile-radius);
    background-color:#ffa630;
    transform-style: preserve-3d;
    transform-origin: 50% 40%;
    transition: var(--transition);
    z-index: 4;
  }
  
  .book-top {
    width: 40%;
    height: 80%;
    position: absolute;
    top: 50px;
    left: 200px;
    z-index: 5;
    transform: translateZ(28.5px);
  }

  .book-side {
    position: absolute;
    top: 430px; 
    left: 222px;
    transform: translateY(-15px) translateX(0px) translateZ(15px) rotateX(104deg);
  }
  
  .book-cover:hover {
    transform: rotateX(75deg) translateZ(3px) scale(0.75);
  }

  .book-cover:hover + .preface {
    transform: translateY(-302px);
  }
    
    .icon {
      transform: rotateX(180deg);
    }
  
  
  .preface {
    height: var(--separator-height);
    padding: 50px;
    transition: var(--transition);
    background:hsla(208, 90%, 88%, 1);

background: linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

background: -moz-linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

background: -webkit-linear-gradient(90deg, hsla(208, 90%, 88%, 1) 0%, hsla(36, 72%, 56%, 1) 100%);

filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#C3E1FC", endColorstr="#E09F3E", GradientType=1 );;
  }

      .header {
        display: flex;
        align-items: center;
      }

      .title {
        
        font-family: 'Quicksand', sans-serif;
        font-size: 26px;
        margin-bottom: 10px;
      }

      .author {
        font-family: 'Open Sans', sans-serif;
        font-style: italic;
        margin-bottom: 20px;
      }

      .icon {
        transform-origin: top;
        transition: var(--transition);
      }

      .body {
        font-family: 'Quicksand', sans-serif;
      }

      .body p:first-child {
        margin-bottom: 15px;
      }
  


/* .container:hover > .mobile-layout .book-cover {      
 transform: rotateX(75deg) translateZ(3px) scale(0.75); 
} 
 .container:hover >.mobile-layout .book-cover + .preface { 
  transform: translateY(-302px); 
 } 
 .container:hover > .mobile-layout .book-cover + .preface .icon { 
   transform: rotateX(180deg); 
 } */


</style>