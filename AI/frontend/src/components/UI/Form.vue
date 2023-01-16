<template>
  <div class="mb-5 mt-5">
    <div class="d-flex flex-column bg-light border border-dark m-auto rounded"
         :style="style">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: ['height', 'width'],
  name: "Form",
  computed: {
    style() {
      console.log(this.width,this.height);
      return {
        width: this.width,
        height: this.height
      }
    }
  }
}
</script>

<style scoped>
</style>