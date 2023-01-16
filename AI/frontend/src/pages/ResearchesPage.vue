<template>
  <div>
    <div v-if="researches">
      <div class="d-flex justify-content-center mt-5">
        <router-link class="btn btn-secondary w-25" to="/add-car" v-if="$store.getters?.getUser?.role === 'ADMIN'">Add Car</router-link>
      </div>
      <div class="d-flex">
        <research-list :researches="researches"></research-list>
      </div>
    </div>
  </div>
</template>
<script>
import researchService from "@/repository/researchRepository";
import researchList from "@/components/researches/researchList";
export default {
  name: "ResearchesPage",
  components: {researchService, researchList},
  data() {
    return {
      researches: [],
    }
  },
  methods: {
    listResearches() {
      researchService.fetchAllResearches().then(response => {
        this.researches = response.data;
      })
    },
    deleteResearch(id) {
      researchService.deleteResearch(id).then(() => {
        this.listResearches();
      })
    },
  },
  provide() {
    return {
      deleteResearch: this.deleteResearch
    }
  },
  mounted() {
    this.listResearches();
  }
}
</script>
<style scoped>
</style>