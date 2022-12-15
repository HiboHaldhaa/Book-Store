<template>
<div>
  <!-- <h1>The sidebar is {{ collapsed ? 'closed' : 'open' }}</h1> -->
  <!-- <button @click="toggleSidebar">Toggle Sidebar</button> -->
  <router-view/>
  <Sidebar/>
  
</div>
</template>

<script>
import { collapsed, toggleSidebar } from '@/components/sidebar/state'
import Sidebar from '../components/sidebar/Sidebar.vue'

export default {
  components: {
        Sidebar
       
    },
  setup() {
    return { collapsed, toggleSidebar }
  }
}
</script>

<style>
body{
display:grid;
background: #1f253d;
background-repeat: no-repeat;
scroll-behavior: smooth;
}

.invisible-scrollbar::-webkit-scrollbar {
  display: none;
}
</style>