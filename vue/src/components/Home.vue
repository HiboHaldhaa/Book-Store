<template>
 

<div class="bookshelf--frame">

  <div id="mainGrid">

    <AddedBookList/>
  </div>  

    
</div>


</template>

<script>
import AddedBookList from './AddedBookList.vue'
export default {
  components: { AddedBookList },

}
</script>

<style lang="scss" scoped>
html {
	box-sizing: border-box;
	font-size: 62.5%;
}
*, *:after, *:before {
	box-sizing: inherit;
}

// variables
$darktan: #9A8548;
$grad2: #373737;
$grad1: darken($grad2, 2);
$grad3: lighten($darktan, 4);
$grad5: darken($darktan, 4);

// for presentation's sake
body {
  background: lightgray;
}
.bookshelf--frame {
  max-width: 1200px;
  margin: 0 auto;
}

.bookshelf--frame {
	background: tan;
	background: url('https://static.tumblr.com/8x9m588/C8ho55ylx/bg-wood2.png'), linear-gradient($grad1,$grad2 290px,$grad3 290px,$grad3 292px,$darktan 292px,$darktan 298px,$grad5 298px,$grad5 300px);	
	background-size: auto;
	border-left: 10px solid $darktan;
	border-right: 20px solid $darktan;
	text-align: center;
	&:first-of-type {
		border-top: 10px solid $darktan;
	}

}



</style>