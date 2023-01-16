<template>
  <div class="d-flex pt-5 mt-5">
    <div class="d-flex flex-column shadow-lg p-3 mb-5 bg-body rounded w-25 m-auto ">
      <div class="border-bottom">
        <h3>Register</h3>
      </div>
      <form class="d-flex flex-column justify-content-center" @submit.prevent="registerUser">
        <input type="text"
               id="username"
               name=username
               required
               class="form-control mt-3"
               v-model="username"
               placeholder="Username"/>

        <input type="text"
               id="name"
               name="name"
               required
               class="form-control mt-3"
               v-model="name"
               placeholder="Name"
        />

        <input type="text"
               id="lastname"
               name="lastname"
               required
               class="form-control mt-3"
               v-model="lastName"
               placeholder="Lastname"
        />

        <input type="password"
               id="password"
               name="password"
               required
               class="form-control mt-3"
               v-model="password"
               placeholder="Password"
        />

        <input type="password"
               id="repeatPassword"
               name="repeatPassword"
               required
               class="form-control mt-3"
               placeholder="Repeat Password"
               v-model="repeatPassword"
        />

        <button type="submit"
                class="btn btn-success w-100 mt-3">Sign up
        </button>
      </form>
      <router-link class="text-primary text-center mt-3" to="/login">Already have an account?</router-link>
    </div>
  </div>
</template>

<script>
import userService from "@/repository/userRepository";
export default {
  name: "RegisterForm",
  data() {
    return {
      username: '',
      name: '',
      lastName: '',
      password: '',
      repeatPassword: ''
    }
  },
  methods: {
    registerUser() {
      userService.register({
        username: this.username,
        name: this.name,
        lastName: this.lastName,
        password: this.password,
        repeatPassword: this.repeatPassword,
        role: 'USER',
      }).then(response => {
        if (response.status === 200) {
          // this.$router.push("/login");
          this.$router.back();
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
