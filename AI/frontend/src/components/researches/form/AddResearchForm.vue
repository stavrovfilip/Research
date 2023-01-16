<template>
  <div>
    <Modal width="800px" height="1350px">
      <form @submit.prevent="addNewResearch">
        <div class="d-flex justify-content-center">
          <h3 class="mt-5">Add new Research Form</h3>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Title:</label>
          <input type="text" required class="form-control" placeholder="Enter the title of the Research" v-model="title">
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Description:</label>
          <textarea type="number" required class="form-control" placeholder="Enter the description of the Research"
                    v-model="description"/>
        </div>
        <div class="d-flex flex-column ms-2 mt-3 me-2">
          <label>Category:</label>
          <select class="form-control" id="selectedCategory" name="selectedCategory" v-model="selectedCategory">
            <option v-for="category in categories" :key="category.name" :value="category">{{ category.name }}</option>
          </select>
        </div>
        <div class="d-flex ms-2 mt-3">
          <button type="submit" class="btn btn-secondary">Add Research</button>
        </div>
      </form>
    </Modal>
  </div>
</template>

<script>
import Modal from "@/components/UI/Form";
import researchService from "@/repository/researchRepository";
export default {
  name: "AddResearchForm",
  components: {Modal},
  data() {
    return {
      title: '',
      description: '',
      categories: [],
      selectedCategory: null,
    }
  },
  methods: {
    addNewResearch() {
      let formData = new FormData();
      formData.append("description", this.description);
      formData.append("title", this.title);
      formData.append("category", JSON.stringify(this.selectedCategory));
      researchService.addResearch(formData).then(() => {
        this.$router.push("/researches");
      });
    },
    getCategories() {
      this.categories = this.$store.getters.getCategories;
      this.selectedCategory = this.categories[0];
      this.models = this.categories[0].models;
      this.selectedModel = this.models[0];
    },
  },
  mounted() {
    this.getCategories();
  }
}
</script>
<style scoped>
</style>