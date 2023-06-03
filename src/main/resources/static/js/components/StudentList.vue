<template>

  <v-card>
    <v-card-title>Список студентов</v-card-title>

    <v-table density="compact" fixed-header>
      <thead>
      <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Группа</th>
        <th>Просмотр оценок</th>
      </tr>
      </thead>
      <tbody>
      <tr
          v-for="student in students"
      >
        <td>{{ student.user.firstName }}</td>
        <td>{{ student.user.lastName }}</td>
        <td>{{ student.user.patronymic }}</td>
        <td>{{ student.studentGroup }}</td>

        <td>
          <v-btn @click="showRating(student)" icon="import_contacts" variant="text" size="x-small"/>
        </td>
      </tr>
      </tbody>
    </v-table>

  </v-card>
</template>

<script>
import axios from "axios"

const instance = axios.create({
  baseURL: 'http://localhost:9000/api/',
});

export default {
  name: "StudentList",
  data() {
    return {
      students: [],
    }
  },
  mounted() {
    instance.get('/students').then(res => {
      this.students = res.data
    })
  },
  methods: {
    showRating(student) {
      this.$router.push(this.$route.path + `/rating/${student.user.id}`)
    }
  }
}
</script>

<style scoped>

</style>