<template>

  <div>
    
      <button class="button" v-on:click="showShareForm()"><span>Share</span></button>
    
    <form id="shareForm" ref="shareFormRef" @submit.prevent="sendemail()">
      <div>
        <input
          id="email" 
          type="email" required
          v-model.trim="email"
          placeholder="Recipient email"
        />
      </div>
      <div>
        <input
          id="name" 
          type="text" required
          v-model.trim="name"
          placeholder="Your Name"
        />
      </div>
      <div><button>Send Book</button> <button v-on:click="cancel()">Cancel</button></div>
    </form>
  </div>
</template>

<script>

import EmailService from '../services/EmailService'

export default {
  name: "share-button",
  props: ["book"],
  data() {
    return {
      email: "",
      name: "",
    };
  },
  methods: {
  showShareForm() {
    this.$refs['shareFormRef'].style.display = "block";
  },
  sendemail() {
    EmailService.sendEmail(this.email, this.name, this.book);
    this.hideShareForm();
    this.clearShareForm();
  },
  cancel() {
    this.hideShareForm();
    this.clearShareForm;
  }, hideShareForm() {
    this.$refs['shareFormRef'].style.display = "none";
  }, 
  clearShareForm() {
    this.email = "";
    this.name = "";
  }
}
};
</script>

<style>

#shareForm {
  position:static;
  bottom: 0;
  right: 0;
  z-index: 999;
  display: none;
  background-color: lavenderblush;
}


.button {
  border-radius: 4px;
  background-color: #f4511e;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: px;
  padding: 5px;
  width: 20;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '   \1F4E7';
  position: absolute;
  opacity: 0;
  top: 0;
  right: 15px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

</style>