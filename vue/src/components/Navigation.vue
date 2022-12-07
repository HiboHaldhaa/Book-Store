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
            <router-link to="/book" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                    <img class="menu-icon" src="../assets/open-book.png"> Book
                </div>
            </router-link>
            <router-link to="/search" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                    <img class="menu-icon" src="../assets/book.png"> Search
                </div>
            </router-link>
            <router-link v-if="isLoggedIn" to="/login" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                     <img class="menu-icon" src="../assets/login.png"> Sign In | Sign Up
                </div>
            </router-link>
            <router-link v-if="!isLoggedIn" to="/logout" active-class="active" tag="button" exact class="side-btn">
                <div class="link-container">
                     <img class="menu-icon" src="../assets/login.png"> Log Out
                </div>
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            isLoggedIn: false
        }
    },

    computed: {
        isAdmin() {
            return this.$store.state.user.authorities[0].name == "ROLE_ADMIN";
        }
    }
    
}
</script>

<style >
div{
   overflow-x: hidden;
}
.menu-icon{
    position: relative;
    width: 15%;
    padding: 10px;

}
.title {
    color: white;
    font-size: 24px;
    margin-top: 10px;
    text-align: center;
}
.logo {
display: flex;
flex-direction: column;
margin-top: 30px;
margin-left:40px;
width:150px;
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
    color: rgb(251, 250, 250);
    background-color: transparent;
}

.side-btn:focus {
    outline: none;
}

.side-btn.active {
    position: relative;
    background-color: rgb(255, 255, 255);
    color: rgb(6, 75, 139);
    font-weight: 600;
    margin-left: 10px;
    border-radius: 30px 0 0 30px;
}

.side-btn.active::before {
    top: -30px;
}

.side-btn.active::after {
    bottom: -30px;
}

.side-btn.active::before, .side-btn.active::after {
    position: absolute;
    content: "";
    right: 0;
    height: 30px;
    width: 30px;
    background-color: rgb(255, 255, 255);
}

.side-btn.active .link-container::before {
    top: -60px;
}

.side-btn.active .link-container::after {
    bottom: -60px;
    z-index: 99;
}

.side-btn.active .link-container::before, .side-btn.active .link-container::after {
    position: absolute;
    content: "";
    right: 0px;
    height: 60px;
    width: 60px;
    border-radius: 50%;
    background-color: #250D4B;
}
</style>