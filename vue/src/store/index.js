import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    currentSearch: [],
    readingList:[],
<<<<<<< HEAD
    addedBookList:[]
=======
    featuredBooks :["9780812988529",  "9780385334204" , "9780385333481", "9780385333498"]

>>>>>>> 8f0f22bfde30abef4261a3791874d25a9a689fe2
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_CURRENT_SEARCH(state, books) {
      this.state.currentSearch=books;
    },
    SAVE_BOOK(state, books) {
      this.state.books.push(books);
  },
  SET_ADDED_BOOK(state, books) {
    this.state.addedBookList = books;
  },
    
  }
})
