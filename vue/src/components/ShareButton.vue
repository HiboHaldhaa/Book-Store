<template>
  <div>
    <div class="shareBtn">
      <button class="shareButton" v-on:click="showShareForm()">Share</button>
    </div>
    <form id="shareForm" ref="shareFormRef" @submit.prevent="sendemail()">
      <div>
        <label for="email">Email: </label>
        <input
          id="email" 
          type="email" required
          v-model.trim="email"
          placeholder="Recipient email"
        />
      </div>
      <div>
        <label for="name">From: </label>
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
  position: absolute;
  bottom: 0;
  right: 0;
  z-index: 999;
  display: none;
  background-color: white;
}


 .shareBtn {
  position: absolute;
  left: 40px;
}
</style>