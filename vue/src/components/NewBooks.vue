<template>
  <div class="book-card">
		<div v-if="isNew" class="ribbon ribbon__right-bottom"><span>NEW BOOK</span></div>
    
 </div>    
</template>

<script>
export default {

}
</script>

<style>

/* corner-ribbon base styles */
.ribbon {
  z-index: 1;
  overflow: hidden;
  position: absolute;
}
.ribbon:before, .ribbon:after {
  content: "";
  display: block;
  z-index: -1;
  position: absolute;
}
.ribbon span {
  display: block;
  text-align: center;
  line-height: 3;
  position: absolute;
}

/* corner-ribbon styles, left-bottom */
.ribbon__left-top {
  width: 150px;
  height: 150px;
  margin-left: -10px;
  margin-top: -10px;
  left: 0;
  top: 0;
}
.ribbon__left-top:before {
  right: 0;
  top: 0;
  border-width: 5px;
  border-style: solid;
  border-left-color: transparent;
  border-right-color: #148f77;
  border-top-color: transparent;
  border-bottom-color: #148f77;
}
.ribbon__left-top:after {
  left: 0;
  bottom: 0;
  border-width: 5px;
  border-style: solid;
  border-left-color: transparent;
  border-right-color: #148f77;
  border-top-color: transparent;
  border-bottom-color: #148f77;
}
.ribbon__left-top span {
  width: 225px;
  color: #fff;
  right: -15%;
  top: 22%;
  -webkit-transform: rotate(-45deg);
          transform: rotate(-45deg);
  background-color: #1abc9c;
  box-shadow: 0 0 7px rgba(35, 46, 57, 0.8);
}



</style>