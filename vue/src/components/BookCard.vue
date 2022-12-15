<template>
  
	<div class="hero-container">
				

		<div class="main-container">
			<div class="poster-container">
				<div v-if="isNew" class="ribbon ribbon-top-left"><span>New</span></div>
				<a href="#"><img v-bind:src="book.coverLink" class="poster" /></a>
        </div>
		
          <div class="ticket-container">
              <div class="ticket__content">
                <h2 class="ticket__movie-title">{{ book.title }}</h2>
                <p class="ticket__movie-slogan">
                  {{ book.author }}
                </p>
                <share-button :book="book" class="ticket__buy-btn">Buy now</share-button>
              </div>
          </div>
      </div>
  </div>
</template>

<script>

import ShareButton from './ShareButton.vue';

export default {
  components: { ShareButton },
  
  name: "book-card",
  props: ["book"],
  data() {
    return {
      email: "",
      name: "",
    };
  },
  computed: {
    isNew() {
      const today = new Date();
      const day = new Date(this.book.dateAdded);
      const diff = today - day;
      if (diff < 604800000) {
        return true;
      }
      return false;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap");

* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

body {
	background: #457fb4;
	font-family: "Roboto", sans-serif;
	display: flex;
	height: auto;
}
.hero-container {
position:relative;
left:170px;
top:4px;
}

.hero-container {
	margin: auto;
	display: flex;
}

.main-container {
	width: 270px;
	height: 540px;
	position: relative;
	margin: 0 20px;
}

.poster-container {
	width: 230px;
	position: absolute;
	top: 0;
	left: 20px;
	z-index: 9999;
}

.poster {
	width: 100%;
	box-shadow: 0 5px 20px 3px rgba(0, 0, 0, 0.6);
}

.ticket-container {
	background: #fff;
	width: 270px;
	height: 520px;
	display: flex;
	flex-direction: column;
	align-items: center;
	border-radius: 5px;
	position: absolute;
	top: 20px;
	box-shadow: 0 5px 20px 3px rgba(0, 0, 0, 0.6);
	opacity: 0;
}

.main-container:hover .ticket-container {
	opacity: 1;
	animation: bounceIn 0.6s linear;
}

@keyframes bounceIn {
	0%,
	20%,
	40%,
	60%,
	80%,
	to {
		-webkit-animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
		animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
	}
	0% {
		opacity: 0;
		-webkit-transform: scale3d(0.3, 0.3, 0.3);
		transform: scale3d(0.3, 0.3, 0.3);
	}
	20% {
		-webkit-transform: scale3d(1.03, 1.03, 1.03);
		transform: scale3d(1.03, 1.03, 1.03);
	}
	40% {
		-webkit-transform: scale3d(0.9, 0.9, 0.9);
		transform: scale3d(0.9, 0.9, 0.9);
	}
	60% {
		opacity: 1;
		-webkit-transform: scale3d(1.01, 1.01, 1.01);
		transform: scale3d(1.01, 1.01, 1.01);
	}
	80% {
		-webkit-transform: scale3d(0.97, 0.97, 0.97);
		transform: scale3d(0.97, 0.97, 0.97);
	}
	to {
		opacity: 1;
		-webkit-transform: scaleX(1);
		transform: scaleX(1);
	}
}

/* @keyframes bounce {
  50% {
    opacity: 1;
    transform: scale(1.1);
  }

  100% {
    opacity: 1;
    transform: scale(1);
  }
} */

.ticket__content {
	width: 100%;
	position: absolute;
	bottom: 0;
	text-align: center;
}

.ticket__movie-title {
	text-transform: uppercase;
	margin-bottom: 5px;
}

.ticket__movie-slogan {
	color: #999;
	font-size: 0.9rem;
	margin-bottom: 20px;
}

.ticket__current-price {
	color: #69c982;
	font-size: 1.4rem;
	font-weight: bold;
}

.ticket__old-price {
	color: #999;
	text-decoration: line-through;
	margin-bottom: 10px;
}

.ticket__buy-btn {
	cursor: pointer;
	width: 100%;
	background: #2f2f2f;
	color: white;
	padding: 15px 0;
	font-size: 1rem;
	font-weight: bold;
	text-transform: uppercase;
	border: 0;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
}



/* common */
.ribbon {
  width: 150px;
  height: 150px;
  overflow: hidden;
  position: absolute;
}
.ribbon::before,
.ribbon::after {
  position: absolute;
  z-index: -1;
  content: '';
  display: block;
  border: 5px solid #2980b9;
}
.ribbon span {
  position: absolute;
  display: block;
  width: 225px;
  padding: 15px 0;
  background-color: #3498db;
  box-shadow: 0 5px 10px rgba(0,0,0,.1);
  color: #fff;
  font: 700 18px/1 'Lato', sans-serif;
  text-shadow: 0 1px 1px rgba(0,0,0,.2);
  text-transform: uppercase;
  text-align: center;
}

/* top left*/
.ribbon-top-left {
  top: -10px;
  left: -10px;
}
.ribbon-top-left::before,
.ribbon-top-left::after {
  border-top-color: transparent;
  border-left-color: transparent;
}
.ribbon-top-left::before {
  top: 0;
  right: 0;
}
.ribbon-top-left::after {
  bottom: 0;
  left: 0;
}
.ribbon-top-left span {
  right: -25px;
  top: 30px;
  transform: rotate(-45deg);
}

</style>