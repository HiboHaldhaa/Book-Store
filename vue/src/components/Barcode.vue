<template>
  <div class="hello">
    <StreamBarcodeReader
      @decode="(a, b, c) => onDecode(a, b, c)"
      @loaded="() => onLoaded()"
    ></StreamBarcodeReader>
    Input Value: {{ text || "Nothing" }}
  </div>
  
</template>

<script>
import { StreamBarcodeReader } from "vue-barcode-reader";
import ApiService from '../services/ApiService';

export default {
  name: "HelloWorld",
  components: {
    StreamBarcodeReader,
    
  },
  data() {
    return {
      text: "",
      id: null,
      books: []
    };
  },
  props: {
    scanned_isbn: String,
  },
  computed: {
        bookList() {
            return this.books;
        }
        },

  created() {
    let book = this.$store.state.currentSearch[0];
    this.text = book.text;

    ApiService.searchByIsbn(this.text).then(response => {
        let random = Math.floor(Math.random() * 10);
        let book = response.data.items[random].volumeInfo;
        this.books.push(book);

    }).catch(e => console.log(e))
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
