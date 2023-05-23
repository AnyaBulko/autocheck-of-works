<template>
  <h2>Список пользователей</h2>
  <div v-for="user in users">
    ID: {{ user.id }}
    Имя пользователя: {{ user.username }}
    <input type="text" placeholder="Имя пользователя" v-model="text">
    <input type="button" value="Сохранить" @click="save">
  </div>
</template>

<script>
export default {
  name: "UsersList",
  data() {
    return {
      users: users,
      text: ''
    }
  },
  methods: {
    save: function () {
      let username = {text: this.text};
      // use axios
    }
  }
}
</script>

<style scoped>

</style>