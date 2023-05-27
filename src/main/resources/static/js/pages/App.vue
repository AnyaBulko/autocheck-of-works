<template>
  <v-app class="bg-indigo-lighten-5">

    <v-app-bar>
      <v-app-bar-title @click="this.$router.push('/')">Auto-checker</v-app-bar-title>
      <v-btn v-if="profile" variant="plain" :disabled="$route.path === '/profile'" @click="$router.push('/profile')">
        {{ profile.username }}</v-btn>

      <v-btn v-if="!profile" href="/login">Войти</v-btn>
      <form v-else class="px-4" action="/logout" method="POST">
        <v-btn type="submit" color="primary" append-icon="logout" >Выйти</v-btn>
      </form>

    </v-app-bar>
    <v-navigation-drawer v-if="profile">
      <navigate-list/>
    </v-navigation-drawer>

    <v-main>

      <router-view></router-view>

    </v-main>
  </v-app>

</template>

<script>
import axios from "axios"

const instance = axios.create({
  baseURL: 'http://localhost:8080/api/',
});

import UsersList from "../components/UsersList.vue";
import NavigateList from "../components/NavigateList.vue";
import EditUserForm from "../components/EditUserForm.vue";

export default {
  name: "App",
  components: {
    UsersList, NavigateList, EditUserForm
  },
  data() {
    return {
      profile: profile
    }
  },
  // mounted() {
  //   console.log(`the component is now mounted.`)
  //   instance.get('/users/1').then(res => {
  //     this.users = res.data
  //   })
  // },
  // methods: {
  //   async getlist() {
  //     const test = await instance.get('/users')
  //     this.users = test.data
  //
  //   },


  // }

}
</script>

<style>

</style>