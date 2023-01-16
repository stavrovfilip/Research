<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style="z-index: 100">
    <div class="container">
      <div class="d-flex justify-content-between align-items-center">
        <button
            class="navbar-toggler me-4"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="">
          <router-link class="navbar-brand" to="/researches">Researches</router-link>
        </div>
      </div>
      <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item ps-5">
            <router-link
                class="btn btn-outline-light"
                to="/login"
                v-if="!$store.getters.getUser">Login
            </router-link>
          </li>
          <li v-if="$store.getters.getUser">
            <router-link
                class="btn btn-outline-light"
                to="/logout"> Logout
            </router-link>
          </li>
              </ul>
            </div>
      </div>
  </nav>
</template>

<script>
export default {
  name: "TheHeader",
  data() {
    return {
      user: null,
    };
  },
  methods: {
    logoutUser() {
      this.$store.state.user = null;
      this.$store.state.userToken = null;
      this.$store.state.userAvailability = false;
      sessionStorage.clear();
    },
    getUser() {
      this.user = this.$store.getters.getUser;
    },
    isLoggedIn() {
      return this.$store.getters.getUser;
    },
  },
  mounted() {
    this.getUser();
  },
};
</script>

<style>
.header-sticky {
  z-index: 100;
}
</style>