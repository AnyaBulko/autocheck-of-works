import {createApp} from 'vue'
import App from "./pages/App.vue"
import store from "./store/store"
// Vuetify
import 'vuetify/styles'
import {createVuetify} from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import 'material-design-icons-iconfont/dist/material-design-icons.css'
import {aliases, md} from 'vuetify/iconsets/md'

// Router
import UsersList from './components/UsersList.vue';
import Auth from "./pages/Auth.vue";
import Profile from "./pages/Profile.vue";
import StudentList from "./components/StudentList.vue";
// import ProfileEdit from "./pages/ProfileEdit.vue";

import {createWebHistory, createRouter} from "vue-router"

const routes = [
    {path: '/users', component: UsersList},
    {path: '/login', component: Auth},
    {path: '/profile', component: Profile},
    {path: '/students', component: StudentList}
]

const router = createRouter({
    history: createWebHistory(),
    routes,
});


const vuetify = createVuetify({
    components,
    directives,
    theme: {
        themes: {
            light: {
                dark: false,
                colors: {
                    primary: '#3f51b5',
                    // secondary: '#fce4ec', // #FFCDD2
                }
            },
        },
    },
    icons: {
        defaultSet: 'md',
        aliases,
        sets: {
            md,
        }
    }
})

createApp(App).use(router).use(vuetify).use(store).mount('#app')
