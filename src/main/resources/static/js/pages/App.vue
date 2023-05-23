<template>
  <div>Оно работает</div>
  <users-list></users-list>

</template>

<script>
import UsersList from "../components/UsersList.vue";

export default {
  name: "App",
  components: {
    UsersList
  }
}
</script>

<style>

</style>