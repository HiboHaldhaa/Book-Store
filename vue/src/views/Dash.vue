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
body {background-color:#250D4B;}
div{
   overflow: hidden;
}
.dash {
    display:grid;
    grid-template-columns: .3fr 2fr;
    background-color: #250D4B;
    height: 100vw;
    width: 100vw;
}

.content {
    background-color: white;
    border-radius: 50px;
    margin: 40px 90px 30px 0px;
}
</style>