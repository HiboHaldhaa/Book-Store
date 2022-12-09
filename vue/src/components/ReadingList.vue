<template>
<div class="card-list-container">
    <Container id="from"
      drag-class="card-ghost"
      drop-class="card-ghost-drop"
      :drop-placeholder="dropPlaceholderOptions"
      :get-child-payload="getChildPayload1"
      group-name="1"
      @drop="onDrop('listOne', $event)"> <div class="one">
  <h1>Search Result</h1>
</div>
      <Draggable v-for="book in bookList"  v-bind:key="book.isbn">
        <BookCard v-bind:book="book" />
      </Draggable>
    </Container>
<<<<<<< HEAD
    <div class="eleven">
    <h1>Add to your Reading List</h1> </div>
=======

    
    <h1 class="h3 mb-3 font-weight-normal">Add to your Reading List =>></h1>
>>>>>>> a13b72fdd3882e06fe2ae65d7b9b9a2029097b6d
    <Container id="to"
      drag-class="card-ghost"
      drop-class="card-ghost-drop"
      :drop-placeholder="dropPlaceholderOptions"
      :get-child-payload="getChildPayload2"
      group-name="1"
      @drop="onDrop('listTwo', $event)"
    > <div class="one">
  <h1>Reading List</h1>
</div>
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

.eleven {
left:-19px;
position:relative;
bottom:0px;
height:100px;
}
.eleven h1 {
  font-size:35px;
  text-align:center; 
  line-height:1.5em; 
  padding-bottom:50px; 
  font-family:"Playfair Display", serif; 
  text-transform:uppercase;
  letter-spacing: 2px; 
  color:#111;
}


.eleven h1:before {
  position: absolute;
  left: 0;
  bottom: 20px;
  width: 60%;
  left:50%; 
  margin-left:-30%;
  height: 2px;
  content: "";
  background-color: #777; z-index: 4;
}
.eleven h1:after {
  position:absolute;
  width:40px; 
  height:40px; 
  left:50%; margin-left:-20px; bottom:0px;
  content: '\00a7'; font-size:30px; line-height:40px; color:#c50000;
  font-weight:400; z-index: 5;
  display:block;
  background-color:#ffffff;
}

/* === HEADING STYLE #1 === */
.one h1 {
  text-align: center;
  text-transform: uppercase;
  padding-bottom: 5px;
}
.one h1:before {
  width: 28px;
  height: 5px;
  display: block;
  content: "";
  position: absolute;
  bottom: 3px;
  left: 50%;
  margin-left: -14px;
  background-color: #b80000;
}
.one h1:after {
  width: 100px;
  height: 1px;
  display: block;
  content: "";
  position: relative;
  margin-top: 25px;
  left: 50%;
  margin-left: -50px;
  background-color: #b80000;
}

</style>