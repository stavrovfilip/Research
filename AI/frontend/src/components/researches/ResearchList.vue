<template>
  <div class="d-flex flex-wrap">
    <research-item v-for="research in researches" :key="research.id" :research="research"></research-item>
  </div>
</template>

<script>
import ResearchItem from "@/components/researches/ResearchItem";
export default {
  props: ['researches'],
  name: "ResearchList",
  components: {ResearchItem}
}
</script>

<style scoped>
</style>