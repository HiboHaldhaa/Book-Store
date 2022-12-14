<template>
  <div id="app">

    
   <headerComponent></headerComponent>

<router-view></router-view>

<footerComponent></footerComponent>
    
    
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
div{
   overflow: hidden;
}


</style>
