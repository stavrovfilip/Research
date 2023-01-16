<template>
  <div v-if="fetchFinished" >
    <div>
      <TheHeader/>
      <router-view></router-view>
      <Footer/>
    </div>
  </div>
</template>

<script>
import TheHeader from "@/components/UI/TheHeader";
import TheFooter from "@/components/UI/TheFooter";
export default {
  components: {TheHeader,TheFooter},
  name: "Configuration",
  computed: {
    fetchFinished() {
      let check;
      if (this.$store.getters.getUserToken) {
        console.log(this.$store.getters.getUserToken);
        console.log(this.$store.getters.getUser);
        check = this.getCategories?.length > 0 && this.$store.getters.getUser;
      }
      return check;
    },
    getCategories() {
      return this.$store.getters.getCategories;
    },
  },
  watch: {
    fetchFinished() {
      return this.fetchFinished;
    }
  },
  methods: {
    fetchCategories() {
      this.$store.dispatch("fetchCategories");
    },
    fetchUser() {
      console.log(this.$store.getters.getUserToken);
      if (this.$store.getters.getUserToken) {
        this.$store.dispatch("checkTokenExpiration", {thisObj: this, token: this.$store.getters.getUserToken})
      }
    }
  },
  created() {
    this.fetchCategories();
    this.fetchUser();
  }
}
</script>
<style scoped>
</style>
