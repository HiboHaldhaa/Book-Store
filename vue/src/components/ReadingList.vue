<template>
<div class="card-list-container">
    <Container id="from"
      drag-class="card-ghost"
      drop-class="card-ghost-drop"
      :drop-placeholder="dropPlaceholderOptions"
      :get-child-payload="getChildPayload1"
      group-name="1"
      @drop="onDrop('listOne', $event)">
      <Draggable v-for="book in bookList"  v-bind:key="book.isbn">
        <BookCard v-bind:book="book" />
      </Draggable>
    </Container>
    <Container id="to"
      drag-class="card-ghost"
      drop-class="card-ghost-drop"
      :drop-placeholder="dropPlaceholderOptions"
      :get-child-payload="getChildPayload2"
      group-name="1"
      @drop="onDrop('listTwo', $event)"
    >
      <Draggable v-for="book in listTwo"  v-bind:key="book.isbn">
        <BookCard v-bind:book="book" />
      </Draggable>
    </Container>
  </div>
</template>
<script>
import { Container, Draggable } from "vue-smooth-dnd";
import { applyDrag } from "../utils/applyDrag";
import BookCard from '../components/BookCard.vue';
import ReadingListService from '../services/ReadingListService'
export default {
  name: "CardList",
  components: {
    BookCard,
    Container,
    Draggable,
  },
  created() {
      ReadingListService.getReadingList(this.$store.state.user.id).then((response) => {
        this.listTwo = response.data;
      });
        
        
  },
  computed: {
    bookList() {
        return this.$store.state.currentSearch;
    },
  },
  data() {
    return {
      dropPlaceholderOptions: {
        className: "drop-preview",
        animationDuration: "150",
        showOnTop: false,
      },
      listOne: [
        
      ],
      listTwo: [
        
        
      ]
    };
  },
  mounted() {
    this.$store.commit('SET_CURRENT_SEARCH', []);
},
  methods: {
    onDrop(collection, dropResult) {
      this[collection] = applyDrag(this[collection], dropResult);
      if (dropResult.removedIndex != null && dropResult.addedIndex == null && collection != "listTwo") {
        ReadingListService.addBookToReadingList(this.$store.state.user.id, dropResult.payload);
      } else {
        ReadingListService.deleteFromReadingList(this.$store.state.user.id, dropResult.payload.isbn)
      }
  },
  getChildPayload1(index) {
      return this.$store.state.currentSearch[index];
    },
    getChildPayload2(index) {
      return this.listTwo[index];
    },
   
  }
  
};
</script>
<style scoped>
.card-list-container {
  display: flex;
  justify-content: space-evenly;
}
.smooth-dnd-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 30%;
  max-width: 30%;
  flex: 0 0 30%;
  height: 100%;
  border: 9px solid #a5a9ac;
  border-radius: 6px;
  padding: 9rem 1rem 0 1rem;
  margin-top: 5rem;
  margin-right: 2.5rem;
  margin-left: 1rem;
  
}
.card-ghost {
  transition: transform 0.18s ease;
  transform: rotateZ(5deg);
}
.card-ghost-drop {
  transition: transform 0.18s ease-in-out;
  transform: rotateZ(0deg);
}
</style>









