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

</style>
