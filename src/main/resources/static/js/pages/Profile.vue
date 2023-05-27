<template>
  <v-container>
    <v-card class="mx-auto" rounded="lg" width="650" >

      <v-row no-gutters>
        <v-col cols="8">
          <v-card-item class="ma-2">
            <template v-slot:prepend>
              <v-avatar
                  color="primary" size="x-large">
                <v-icon icon="account_circle"/>
              </v-avatar>
            </template>
            <v-card-title>{{ profile.username }}</v-card-title>
          </v-card-item>
        </v-col>

        <v-col cols="4">
          <v-btn class="ma-6" variant="plain" @click="$router.push($route.path + '/edit')">Редактировать</v-btn>
        </v-col>
      </v-row>


      <v-divider/>

      <v-list class="ma-4">

        <v-list-item class="pb-4">
          <v-list-item-subtitle>Имя пользователя:</v-list-item-subtitle>
          <v-list-item-title>{{ profile.username }}</v-list-item-title>
        </v-list-item>

        <v-list-item class="pb-4">
          <v-list-item-subtitle>ФИО:</v-list-item-subtitle>
          <v-list-item-title>{{ profile.lastName }} {{profile.firstName}} {{profile.patronymic}}</v-list-item-title>
        </v-list-item>

      </v-list>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "Profile",
  data() {
    return {
      profile: profile
    }
  }
}
</script>

<style scoped>

</style>