<template>
<div>
  <form class="addbook-form" @submit.prevent="addBooks()">
    <h1> Add Book to Library</h1>
    <div class="form-control">
      <label for="title">Title</label>
      <input id="title" name="title" type="text" v-model.trim="book.title" />
    </div>
    <div class="form-control">
      <label for="author">Author</label>
      <input id="author" name="author" type="text" v-model.trim="book.author" />
    </div>
    <div class="form-control">
      <label for="genre">Select Genre</label>
      <select id="genre" name="genre" v-model="genre">
        <option value="action">Action</option>
        <option value="drama">Drama</option>
        <option value="adventure">Adventure</option>
        <option value="autobiography">Autobiography</option>
        <option value="children's">Children's Literature</option>
        <option value="fiction">Fiction</option>
        <option value="Horror">Horror</option>
        <option value="literary fiction">Literary Fiction</option>
        <option value="non-fiction">Non-Fiction</option>
        <option value="sci-fi">Science Fiction/Fantasy</option>
        <option value="true-crime">True Crime</option>
        <option value="young-adult">Young Adult</option>
      </select>
    </div>
    <div class="form-control">
      <label for="keyword">Keyword(s)</label>
      <input id="keyword" name="keyword" type="text" v-model.trim="keyword" />
    </div>
    <div class="form-control">
      <label for="isbn">ISBN </label>
      <input id="isbn" name="isbn" type="text" v-model.trim="book.isbn" />
    </div>
    <div class = "form-control">
      <label for="coverImage">Cover Image </label>
      <input id="coverImage" name="coverImage" type="file" @change="previewImage($event)" accept="image/*" />
    </div>
    <div class = "form-control" v-if="previewUrl">
        <img class="post_image" :src="previewUrl" />
      </div>
    <div >
      <button>Add Book</button>
    </div>

    
    
    <!-- <div class= "barcode-reader">
    <BarcodeReader/>
    </div> -->
  </form>

  <!-- -------------------------------------------------------------------------------------------------------- -->


  <div class="barcode-form">
     <form @submit.prevent="downloadBarCode()" class="barcode-generator">
  <!-- <h1>Type to view BarCode</h1> -->


    <div class= "barcode-img" ref="barCodeDiv">
      <vue-barcode
        ref="BarImg"
        v-if="BarcodeValue"
        tag="img"
        :value="BarcodeValue"
        :options="{ displayValue: true, 
        height: 25, 
        fontOptions: 'bold',
        margin: 50
       }"
      />
    </div>


      <div >
    
    <button v-if="BarcodeValue">Save Barcode</button>
      </div>
    </form>
  </div>


  <div class= "book-list">
    
  <addedBookList/>
  </div>


  </div>
</template>

<script>
import VueBarcode from "@chenfengyuan/vue-barcode";
// import BarcodeReader from '../components/Barcode.vue'
import addedBookList from '../components/AddedBookList.vue'
import bookServices from "@/services/BookServices.js"
import {initializeApp} from 'firebase/app'
import {getStorage, ref, uploadBytes, getDownloadURL} from 'firebase/storage'

const firebaseConfig = {
  apiKey: "AIzaSyBCsabXM3rKBPvpn_Q6HV2TQvVlKAX4Xi8",
  authDomain: "book-library-81961.firebaseapp.com",
  projectId: "book-library-81961",
  storageBucket: "book-library-81961.appspot.com",
  messagingSenderId: "512610618843",
  appId: "1:512610618843:web:967cf38a5fb46f03ec6bfe"
};

  // Initialize Firebase
  initializeApp(firebaseConfig);
  

export default{
  components: {
    "vue-barcode": VueBarcode,
    //  BarcodeReader,
    addedBookList
  },
     name: "addBook",
  data () {
    return {
      genre: '',
      keyword: '',
      BarcodeValue: "",
      book: {
        title: '',
        author: '',
        genres: [],
        tags: [],
        isbn: '',
        coverLink: "",
        libraryId: ""
      }
    };
  },
  computed: {
     isAdmin() {
            if (Object.keys(this.$store.state.user).length > 0 ) {
                return this.$store.state.user.authorities[0].name == 'ROLE_ADMIN';
            }
            return false;
     }
  },
  methods: {
    randNum(){
      let randomBarcode = Math.floor(Math.random() * 100000000);
      return randomBarcode;
    },
    handleSave() {
      if (this.imageData) {
        this.uploadImage().then((URL) => {
          this.bookCover.coverLink = URL;
          this.addBooks();
        });
      } 
    },
    addBooks() {
      this.book.genres.push(this.genre);
      this.book.tags.push(this.keyword);
      // random num generator for barcode
      this.BarcodeValue = this.randNum()
      this.book.libraryId = this.BarcodeValue;
      if (this.isAdmin) { 
      bookServices.addBooks(this.book).then((response) => {
        if(response.status === 200) {
          alert("Book added successfully");
          this.book.title = "";
          this.book.author = "";
          this.genre = [];
          this.keyword = [];
          this.book.isbn = "";
          this.book.coverLink = "";
          this.previewUrl="";
          // this.$router.go();
          
          

        }
      })}
    },
    previewImage(event) {
      let imageData = event.target.files[0];
      this.previewUrl = URL.createObjectURL(imageData);
      this.uploadImage(imageData);
    },
    uploadImage(img) {
      const storage = getStorage();
      let storageRef = ref(storage, '/Books/' + img.name);
      uploadBytes(storageRef, img).then(() => {
        getDownloadURL(storageRef).then(downloadURL => {
          this.book.coverLink = downloadURL;
        });
      })
    },

  }
};

</script>

<style scoped>

.barcode-form{
  position:relative;
  top: 50px;
  margin: 2rem auto;
  min-height: 20rem;
  max-width: 40rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  background-color: #E1B07E;
}

.barcode-img{
position:relative;
left:170px;
top:20px;
}


.addbook-form {
  margin: 2rem auto;
  min-height: 30rem;
  max-width: 40rem;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  padding: 2rem;
  background-color: #E1B07E;
}

.form-control {
  margin: 0.5rem 0;
}

label {
  font-weight: bold;
}

h2 {
  font-size: 1rem;
  margin: 0.5rem 0;
}

input,
select {
  display: block;
  width: 95%;
  font: inherit;
  margin-top: 0.5rem;
}

select {
  width: auto;
}

button:hover,
button:active {
  border-color: #002350;
  background-color: #002350;
}
.book-list{
  margin-top: 10%;
}


</style>