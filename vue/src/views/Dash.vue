<template>
    <div class="dash">
        <Sidebar/>
        <div class="content">
            
            <router-view/>
        </div>
    </div>
</template>

<script>

import Sidebar from '../components/Navigation'
export default {
    name: 'dash',
    components: {
        Sidebar
       
    }
}
</script>

<style>
body {background-color:#335c67;
}

.dash {
    display:grid;
    grid-template-columns: .3fr 2fr;
    background-color: 335c67;
    height: 49vw;
    width: 100vw;
    
}

.content {

    display: flex;
    flex-direction: row;
    justify-content: center;
    
    background: url(../assets/bookshelf.jpg);
    
    
    border-radius: 50px;
    margin: 20px 90px 0px 0px;
    overflow-y: scroll;

     width: 1550px;
     height: 2500px;
  
  background-size: cover;
  background-repeat: no-repeat;
  background-position: 50% 50%;
}




</style>