
<template>
<div>
  <div class="sidebar" :style="{ width: sidebarWidth }">
    <h1>
      <span v-if="collapsed">
        <div>V</div>
        <div>S</div>
      </span>
      <img class="logo" src=".\LogoBrown.png" alt="Bravo Books">
      
    </h1>

    <SidebarLink to="/" icon="fas fa-home">Home</SidebarLink>
    <SidebarLink v-if="isAdmin" to="/book" icon="fas fa-columns" >Add Book</SidebarLink>
    <SidebarLink v-if="isUser" to="/reading_list" icon="fas fa-chart-bar">Reading List</SidebarLink>
    <SidebarLink to="/search" icon="fas fa-users">Search</SidebarLink>
    <SidebarLink to="/about_us" icon="fas fa-image">About us</SidebarLink>
    <SidebarLink v-if="!isLoggedIn" to="/login" icon="fas fa-image">Sign In </SidebarLink>
    <SidebarLink v-if="isLoggedIn" to="/logout" icon="fas fa-image">Log Out</SidebarLink>

    <span
      class="collapse-icon"
      :class="{ 'rotate-180': collapsed }"
      @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
  </div>
</div>
</template>

<script>
import SidebarLink from './SidebarLink'
import { collapsed, toggleSidebar, sidebarWidth } from './state'

export default {
  props: {},
  components: { SidebarLink },
  setup() {
    return { collapsed, toggleSidebar, sidebarWidth }
  },

  
    computed: {
        isAdmin() {
            if (Object.keys(this.$store.state.user).length > 0 ) {
                return this.$store.state.user.authorities[0].name == 'ROLE_ADMIN';

            }
            return false;
        },
        isUser() {
            if (Object.keys(this.$store.state.user).length > 0 ) {
                return this.$store.state.user.authorities[0].name == 'ROLE_USER';

            }
            return false;
        },
        isLoggedIn(){
        return this.$store.state.token != '';
    }
    }
    
}
</script>
<style>
:root {
  --sidebar-bg-color: #34495e;
  --sidebar-item-hover: #38a169;
  --sidebar-item-active: #276749;
}
</style>

<style scoped>
.logo {
width:150px;
height:auto;
}
.sidebar {
  color: white;
  background-color: var(--sidebar-bg-color);
  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;
  transition: 0.3s ease;
  display: flex;
  flex-direction: column;
}



.collapse-icon {
  position: absolute;
  bottom: 0;
  padding: 0.75em;
  color: rgba(255, 255, 255, 0.7);
  transition: 0.2s linear;
}

.rotate-180 {
  transform: rotate(180deg);
  transition: 0.2s linear;
}
</style>
