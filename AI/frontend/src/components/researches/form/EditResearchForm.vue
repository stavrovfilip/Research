<template>
  <Form width="800px" height="650px">
    <form @submit.prevent="editCar">
      <div class="d-flex justify-content-center">
        <h3 class="mt-5">Edit Research Form</h3>
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
        <label>Category</label>
        <select class="form-control" v-model="selectedCategory">
          <option v-for="cateogry in categories" :key="category">{{ category }}</option>
        </select>
      </div>
      <div class="d-flex ms-2 mt-3">
        <button type="submit" class="btn btn-secondary">Edit Research</button>
      </div>
    </form>
  </Form>
</template>

<script>
import researchService from "@/repository/researchRepository";
import Form from "@/components/UI/Form";
export default {
  name: "EditResearchForm",
  props: ['id'],
  components: {Form},
  data() {
    return {
      title: '',
      description: '',
      categories: [],
      selectedCategory: null
    }
  },
  methods: {
    editResearch() {
      researchService.editResearch({
        id: this.id,
        title: this.title,
        description: this.description,
        category: this.selectedCategory
      }).then(() => {
        this.$router.push('/researches')
      })
    },
    fetchCategories() {
      this.categories = this.$store.getters.getCategories();
      this.selectedCategory = this.categories[0];
    }
  },
  mounted() {
    this.fetchCategories();
  }
}
</script>

<style scoped>
</style>