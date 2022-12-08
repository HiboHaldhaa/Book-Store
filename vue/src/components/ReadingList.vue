<template>
  <body>

<div id="div1" @drop="onDrop(event)" @ondragover="allowDrop(event)">

  <img src="img_w3slogo.gif" draggable="true" ondragstart="drag(event)" id="drag1" width="88" height="31">
</div>

<div id="div2" @drop="onDrop(event)" @ondragover="allowDrop(event)"></div>

</body>
</template>

<script>
export default {
  methods:{
allowDrop(ev) {
  ev.preventDefault();
},

drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
},

onDrop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  ev.target.appendChild(document.getElementById(data));
},
}
}
</script>

<style>
#div1, #div2 {
  float: left;
  width: 100px;
  height: 35px;
  margin: 10px;
  padding: 10px;
  border: 1px solid black;
}
</style>