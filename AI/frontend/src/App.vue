<template>
  <configuration></configuration>
</template>

<script>
import AppConfig from "@/components/config/Configuration";
export default {
  name: 'App',
  components: {
    Configuration,
  },
  created() {
    console.log("created app");
  }
}
</script>