<template>
  <div class="d-flex flex-column m-2 rounded-1 shadow-lg mb-5 bg-body" style="height: 400px;width: 350px;">
    <div class="d-flex flex-column ps-2">
      <h5 class="text-center">{{ research.title }}</h5>
      <h6>Description: {{ research.description }}</h6>
      <div class="flex m-auto">
        <div class="flex justify-content-end">
          <router-link class="flex btn btn-dark m-1" :to="linkToMore">More info</router-link>
          <button v-if="$store.getters?.getUser?.role === 'ADMIN'" class="btn btn-danger m-1" @click="deleteResearch(research.id)">
          </button>
          <router-link v-if="$store.getters?.getUser?.role === 'ADMIN'"  class="btn btn-primary m-1" :to="editLink">Edit</router-link>
        </div>
      </div>
    </div>
    <div class="d-flex flex-column justify-content-center">
    </div>
  </div>
</template>

<script>

import researchService from "@/repository/researchRepository";

export default {
  props: ['research'],
  inject: ['deleteResearch'],
  name: "ResearchItem",
  computed: {
    linkToMore() {
      return {
        name: 'research-info',
        params: {
          id: this.research.id
        }
      }
    },
    editLink() {
      return '/edit-research/' + this.research.id;
    }
  }
}
</script>

<style scoped>

</style>