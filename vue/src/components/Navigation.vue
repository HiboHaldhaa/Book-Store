<template>
    <div class="sidebar">
        <div>
          <img class="logo" src="../assets/logo.png" alt="Bravo Books">
          <h1 class="title"> The Bravo Book </h1>
        </div>
        <!-- <div class="search-bar">
            search
          // <img class="search_icon" src="../assets/book.png">
        </div> -->
        <div class="menu-items">
            <router-link to="/" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                   <img class="menu-icon" src="../assets/house.png"> Home
                </div>
            </router-link>
            <router-link v-if="isAdmin" to="/book" active-class="active" tag="button" exact class="side-btn">
                <!--  v-if="$store.state.user.authorities[0].name == 'ROLE_ADMIN'" -->
                <div class="link-container">
                    <img class="menu-icon" src="../assets/open-book.png"> Book
                </div>
            </router-link>
            <router-link v-if="isUser" to="/reading_list" active-class="active" tag="button" exact class="side-btn">
                <!--  v-if="$store.state.user.authorities[0].name == 'ROLE_ADMIN'" -->
                <div class="link-container">
                    <img class="menu-icon" src="../assets/reading.png"> Reading List
                </div>
            </router-link>
            <router-link to="/search" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                    <img class="menu-icon" src="../assets/book.png"> Search
                </div>
            </router-link>
           

            <router-link v-if="!isLoggedIn" to="/login" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                     <img class="menu-icon" src="../assets/login.png"> Sign In | Sign Up
                </div>
            </router-link>
            <router-link v-if="isLoggedIn" to="/logout" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                     <img class="menu-icon" src="../assets/login.png"> Log Out
                </div>
            </router-link>


        </div>
    </div>
</template>

<script>
export default {
    

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

<style >
div{
   overflow: hidden;
}
.menu-icon{
    position: relative;
    width: 15%;
    padding: 10px;

}
.title {
    color: #fff3b0;
    font-size: 24px;
    margin-top: 10px;
    text-align: center;
}
.logo {
display: flex;
flex-direction: column;
margin-top: 30px;
margin-left:30px;
width:200px;


}

.menu-items {
    display: flex;
    flex-direction: column;
    margin-top: 90px;
    /* margin-left: 10px; */
}

.menu-items > * {
    margin-top: 60px;
}

.side-btn {
    border: none;
    padding: 16px 0px;
    cursor: pointer;
    font-size: 16px;
    font-weight: 500;
    color:#335C67
}

.side-btn.active {
    position: relative;
    background-color: #fff3b0;
    color: #335C67;
    font-weight: 600;
    margin-left: 10px;
    border-radius: 30px 0 0 30px;
}

.side-btn.active::before {
    top: -30px;
    color: #fff3b0;
    
}

.side-btn.active::after {
    bottom: -30px;
    color: #fff3b0;
    
}

.side-btn.active::before, .side-btn.active::after {
    position: absolute;
    content: "";
    right: 0;
    height: 30px;
    width: 30px;
    background-color: #335C67;
}

.side-btn.active .link-container::before {
    top: -60px;
    color: #fff3b0;
}

.side-btn.active .link-container::after {
    bottom: -60px;
    z-index: 99;
    color: #fff3b0;
}

.side-btn.active .link-container::before, .side-btn.active .link-container::after {
    position: absolute;
    content: "";
    right: 0px;
    height: 60px;
    width: 50px;
    border-radius: 50%;
    background-color: #335C67;
}
</style>