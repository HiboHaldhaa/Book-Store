<template>
  <div id="app">

 <Sidebar />
  <div :style="{ 'margin-left': sidebarWidth }">
    <router-view />
  </div>
 

  </div>
</template>

<script>

export default {
  name: "app",
 components: {
   
  
 }
};
</script>

<style>
#app{
background: hsla(126, 82%, 33%, 1);

background: linear-gradient(135deg, hsla(126, 82%, 33%, 1) 0%, hsla(184, 100%, 20%, 1) 59%);

background: -moz-linear-gradient(135deg, hsla(126, 82%, 33%, 1) 0%, hsla(184, 100%, 20%, 1) 59%);

background: -webkit-linear-gradient(135deg, hsla(126, 82%, 33%, 1) 0%, hsla(184, 100%, 20%, 1) 59%);

filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#0F971C", endColorstr="#005F66", GradientType=1 );
}




</style>
