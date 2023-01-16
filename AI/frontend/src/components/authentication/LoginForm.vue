<template>
  <div>
    <div class="d-flex pt-5 mt-5">
      <div class="d-flex flex-column shadow-lg p-3 mb-5 bg-body rounded w-25 m-auto ">
        <div class="border-bottom">
          <h3>Login</h3>
        </div>
        <form class="d-flex flex-column justify-content-center" @submit.prevent="authenticateUser">
          <input type="text"
                 id="username"
                 name=username
                 required
                 class="form-control mt-3"
                 v-model="username"
                 placeholder="Username"/>

          <input type="password"
                 id="password"
                 name="password"
                 required
                 class="form-control mt-3"
                 v-model="password"
                 placeholder="Password"/>

          <button type="submit"
                       class="btn btn-success w-100 mt-3">Sign in
          </button>
        </form>
        <router-link class="btn btn-primary w-100 mt-3" to="/register">Sign up</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginForm",
  data() {
    return {
      username: '',
      password: '',
    }
  },
  created() {
    console.log("Login");
  },
  methods: {
    authenticateUser() {
        this.$store.dispatch("authenticateUser",{
          username:this.username,
          password:this.password,
          thisObj:this
        });
        console.log(this.$store.getters.getUser);
        if(this.$store.getters.getUser){
          this.$router.push("/researches");
        }
    }
  }
}
</script>

<style scoped>
</style>