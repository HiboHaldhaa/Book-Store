<template>

      

  <div class="flex-container">
<h1 class="title">Book Bravo's Team</h1>
   <div class="page">
    </div>
    <div class="about">
    <img class="profile" src="../assets\Michael Chaney.jpg" />
    <h1 class="names">Michael Chaney</h1>
          <h5 class="position">Software Developer</h5>

    <a href="https://www.linkedin.com/in/michael-scott-chaney/" target=_blank>
            <img class="icon" src="../assets\icon.png" />
 </a>
    </div>

    <div class="about">
     
        <img class="profile" src="../assets\Henos Efrem.jpg" />
      
      <h1 class="names">Henos Efrem</h1>
          <h5 class="position">Software Developer</h5>

       <a href="https://www.linkedin.com/in/henosefrem/" target=_blank>
              <img class="icon" src="../assets\icon.png" />
      </a>

    </div>

<div class="about">
      <img class="profile" src="../assets/Hibo Jama.jpg" />

    <h1 class="names">Hibo Jama</h1>
          <h5 class="position">Software Developer</h5>

    <a href="https://www.linkedin.com/in/hibo-jama/" target=_blank>
            <img class="icon" src="../assets\icon.png" />
 </a>

    </div>

      <div class="about">
      <img class="profile" src="../assets\Edgardo Martinez.jpg" />
       <h1 class="names">Edgardo Martinez</h1>

          <h5 class="position">Software Developer</h5>

       <a href="https://www.linkedin.com/in/eddymtez/" target=_blank>
        <img class="icon" src="../assets\icon.png" />
 </a>

          </div>


  </div>
</template>

<script>
export default {

}
</script>

<style>

.profile{
  max-width: 100%;
  border-radius: 999px;
  margin: 0 10px;
  /* border: 5px solid #bb9d26; */
  width: auto;  
text-align: center;  

padding: 15px;  
height:300px;
}

.flex-container {
    display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items: center;
  justify-content: center;

  size:100%;
  padding-top: 300px;
}

.names {
  display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items: center;
  justify-content: center;
  height:30px;

  position:relative;
left:2px;
top:-17px;
}

.position {
  display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items: center;
  justify-content: center;
  height:30px;
  position:relative;
left:3px;
top:-12px;
}
/* 
div .page .title{
  position: relative;
  max-width:500px;
  height:400px;
} */

.title {
  color: black;
  position:relative;
left:681px;
top:-506px;
  
}

.icon {
 display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items: center;
  justify-content: center;
  height:20px;

  position:relative;
left:123px;
top:-3px;
 transform: rotate(360deg)}
</style>