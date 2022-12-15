<template>
  <div class="hello">
    <StreamBarcodeReader
     @decode="onDecode" @loaded="onLoaded"
    ></StreamBarcodeReader>
    Input Value: {{ text || "Nothing" }}
    <book-card v-if="showBook" v-bind="book" />
  </div>
 
</template>

<script>
import { StreamBarcodeReader } from "vue-barcode-reader";
import BookServices from '../services/BookServices';
import BookCard from './BookCard.vue';


export default {
  name: "HelloWorld",
  components: {
    StreamBarcodeReader,
    BookCard,
    
    
  },
  data() {
    return {
      text: "",
      id: null,
      book: ""
    };
  },
  props: {
    scanned_isbn: String,
  },
  watch:{
text:function(){
BookServices.searchByLibraryId(this.text).then(response => {
this.book = response.data
})
}
  },
  computed: {
        showBook() {
            return this.book;
        }
        },

  created() {
    let book = this.$store.state.currentSearch[0];
    this.text = book.text;
  },
  methods: {
    onDecode(a, b, c) {
      console.log(a, b, c);
      this.text = a;
      if (this.id) clearTimeout(this.id);
      this.id = setTimeout(() => {
        if (this.text === a) {
          this.text = "";
        }
      }, 5000);
    },
    onLoaded() {
      console.log("load");
    },
  },
};
</script>
<style scoped>
form{
 margin: 2rem auto;
  max-width: 40rem;
  min-height: 25rem;
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

button {
  font: inherit;
  border: 1px solid #0076bb;
  background-color: #0076bb;
  color: white;
  cursor: pointer;
  padding: 0.75rem 2rem;
  border-radius: 30px;

  position:relative;
left:243px;

}

button:hover,
button:active {
  border-color: #002350;
  background-color: #002350;
}
form.div{
  position:relative;
left:-2px;
top:13px;
}





</style>
