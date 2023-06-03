<template>

  <v-card
      class="mx-auto"
  >
    <v-list v-if="role.includes('ADMIN')">
      <v-list-subheader>Администратор</v-list-subheader>
      <v-list-item
          v-for="(item, i) in adminItems"
          :key="i"
          :value="item"
          active-color="primary"
          :href="item.href"
      >
        <template v-slot:prepend>
          <v-icon :icon="item.icon"></v-icon>
        </template>
        <v-list-item-title v-text="item.text"></v-list-item-title>
      </v-list-item>
    </v-list>

    <v-list v-if="role.includes('STUDENT')">
      <v-list-subheader>Студент</v-list-subheader>
      <v-list-item
          v-for="(item, i) in studentItems"
          :key="i"
          :value="item"
          active-color="primary"
          :href="item.href"
      >
        <template v-slot:prepend>
          <v-icon :icon="item.icon"></v-icon>
        </template>
        <v-list-item-title v-text="item.text"></v-list-item-title>
      </v-list-item>
    </v-list>

    <v-list v-if="role.includes('TEACHER')">
      <v-list-subheader>Преподаватель</v-list-subheader>
      <v-list-item
          v-for="(item, i) in teacherItems"
          :key="i"
          :value="item"
          active-color="primary"
          :href="item.href"
      >
        <template v-slot:prepend>
          <v-icon :icon="item.icon"></v-icon>
        </template>
        <v-list-item-title v-text="item.text"></v-list-item-title>
      </v-list-item>
    </v-list>

  </v-card>
</template>

<script>
export default {
  name: "NavigateList",
  data() {
    return {
      role: profile.roles,
      adminItems: [
        {
          text: 'Пользователи',
          icon: 'group',
          href: '/users',
        },
      ],
      studentItems: [
        {
          text: 'Мои работы',
          icon: 'list'
        },
      ],
      teacherItems: [
        {
          text: 'Список студентов',
          icon:'group',
          href: '/students'
        }
      ],
    }
  }
}
</script>

<style scoped>

</style>