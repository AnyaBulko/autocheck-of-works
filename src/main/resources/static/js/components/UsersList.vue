<template>
  <v-container>
    <v-card>
      <v-card-title>Список пользователей</v-card-title>

      <v-table density="compact" fixed-header>
        <thead>
        <tr>
          <th class="text-left">ID</th>
          <th class="text-left">Имя пользователя</th>
          <th class="text-left">Имя</th>
          <th class="text-left">Фамилия</th>
          <th class="text-left">Отчество</th>
          <th class="text-left">Дата регистрации</th>
          <th class="text-left">Роль</th>
          <th class="text-left"></th>
        </tr>
        </thead>
        <tbody>
        <tr
            v-for="user in users"
        >
          <td>{{ user.id }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.patronymic }}</td>
          <td>{{ user.registrationDate }}</td>
          <td>{{ user.roles[0] }}</td>
          <td>
            <v-btn @click="edit(user)" icon="edit" variant="text" size="x-small"/>
          </td>
        </tr>
        </tbody>
      </v-table>
      <input type="text" placeholder="Имя пользователя" v-model="username">
      <input type="text" placeholder="Пароль" v-model="password">
      <input type="button" value="Сохранить" @click="save">
    </v-card>


  </v-container>
</template>

<script>
import axios from "axios"

const instance = axios.create({
  baseURL: 'http://localhost:9000/api/',
});

export default {
  name: "UsersList",
  data() {
    return {
      users: [],
      username: '',
      password: '',
      editUsername: null
    }
  },
  mounted() {
    instance.get('/users').then(res => {
      this.users = res.data
    })
  },
  methods: {
    save() {
      let user = {username: this.username, password: this.password};
      instance.post('/users', user).then(res => {
        this.users.push(res.data)
        this.username = ''
        this.password = ''
      })
    },
    edit(user) {
      this.username = user.username
    }
  }
}
</script>

<style scoped>

</style>