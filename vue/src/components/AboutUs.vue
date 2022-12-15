<template>


      <div>

  <div class="flex-container">
    <!-- <h1 class="title">Book Bravo's Team</h1> -->
<h1 class="reveal-text">
	...
</h1>
<h1 class="reveal-text">
	Title Animation
</h1>  

 
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
          <h5 class="position">Junior Software Developer</h5>

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

    <div class="stack">
    <img class="languages" src="../assets\pm.png" />
    <img class="languages" src="../assets\sqll.png" />
    <img class="languages" src="../assets\Vue.png" />
    <img class="languages" src="../assets\Java.png" />
    <img class="languages" src="../assets\IntelliJ.png" />
    <img class="agile" src="../assets\agile3.png" />





      </div>      


      </div>
</template>

<script>
export default {

}
</script>

<style lang="scss">

$animation-delay: 2s;
$duration: 800ms;
$iterations: 1;

.reveal-text,
.reveal-text:after {
	animation-delay: $animation-delay;
	animation-iteration-count: $iterations;
	animation-duration: $duration;
	animation-fill-mode: both;
	animation-timing-function: cubic-bezier(0.0, 0.1, 1, 0);
}

.reveal-text {
  margin-top:20px;
	position: relative;
	font-size: 40px;
	user-select: none;
	animation-name: reveal-text;
color: rgb(25, 112, 184);
	white-space: nowrap;
  font-family: 'Work Sans', sans-serif;
	left:729px;
top:-388px;
	&:after {
		content: "";
		position: absolute;
		z-index: 999;
		top: 0;
		left: 1;
		right: 0;
		bottom: 0;
		background-color: #000;
		transform: scaleX(0);
		transform-origin: 0 50%;
		pointer-events: none;
		animation-name: revealer-text;
	}
	
}


@keyframes reveal-text {
	from {
		clip-path: inset(0 100% 0 0);
	}
	to {
		clip-path: inset(0 0 0 0);
	}
}


@keyframes revealer-text {
	
	0%, 50% {
		transform-origin: 0 50%;
	}
	
	60%, 100% {
		transform-origin: 100% 50%;		
	}

	50% {
		transform: scaleX(1);
	}
	
	60% {
		transform: scaleX(1);
	}
	
	100% {
		transform: scaleX(0);
	}
}



.stack {
      /* display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items:center;
  justify-content: center; */
position:relative;
left:690px;
top:73px;

}

.languages{
  height:99px;
  padding: 11px;
  left:121px;
top:3px;  
/* height:300px; */
}
.agile {
    height:99px;
  padding: -1px;
  left:121px;
top:3px;  
}


.profile{
  max-width: 100%;
  border-radius: 999px;
  margin: 0 10px;
  /* border: 5px solid #bb9d26; */
  width: auto;  
text-align: center;  

padding: 15px;  
height:300px;
/* left:25px;
top:-106px; */
left:-181px;
top:11px;
}

.flex-container {
    display: flex;
  flex-direction: row; 
  flex-wrap: wrap;
  row-gap: 10px;
  column-gap: 20px;
  align-items: center;
  justify-content: center;
position:relative;
/* left:-140px;
top:-57px; */

/* left:-76px;
top:9px; */
// left:-123px;
// top:6px;
left:-176px;
top:-6px;

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
color: rgb(6, 66, 114);

}
/* 
div .page .title{
  position: relative;
  max-width:500px;
  height:400px;
} */

.title {
color: rgb(25, 112, 184);
position:relative;
left:746px;
top:-354px;
height:100px;
min-width: 234px;
font-size: 2.5rem;
  
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
 transform: rotate(360deg);

}
</style>