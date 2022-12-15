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
  background-color:#005F66;
}
search form{
  background-color:#E1B07E
}




</style>
