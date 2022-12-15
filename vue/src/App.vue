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

</style>
