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
background:hsla(126, 82%, 33%, 1);
background: linear-gradient(135deg, hsla(126, 82%, 33%, 1) 0%, hsla(184, 100%, 20%, 1) 59%);
background: -moz-linear-gradient(135deg, hsla(126, 82%, 33%, 1) 0%, hsla(184, 100%, 20%, 1) 59%);
background: -webkit-linear-gradient(135deg, hsla(126, 82%, 33%, 1) 0%, hsla(184, 100%, 20%, 1) 59%);
filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#0F971C", endColorstr="#005F66", GradientType=1 );
background-repeat: no-repeat;
scroll-behavior: smooth;
min-height: 2000px;
overflow-x: hidden;
}


</style>