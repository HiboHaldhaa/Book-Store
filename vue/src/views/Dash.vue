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

.dash {
    display:grid;
    grid-template-columns: .3fr 2fr;
    background-color: #250D4B;
    height: 49vw;
    width: 100vw;
     overflow-y: hidden;
}

.content {
    background-color: rgb(255, 255, 255);
    border-radius: 50px;
    margin: 20px 90px 0px 0px;
    overflow-y: scroll;
}
</style>