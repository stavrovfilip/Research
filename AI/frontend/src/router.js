import {createRouter, createWebHistory} from "vue-router";
import ResearchPages from "@/pages/ResearchesPage";
import LoginPage from "@/pages/LoginPage";
import RegisterForm from "@/components/authentication/RegisterForm";
import AddResearchForm from "@/components/researches/form/AddResearchForm";
import EditResearchForm from "@/components/researches/form/EditResearchForm";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            redirect: "/researches",
        },
        {
            path: "/researches",
            component: ResearchPages,
        },
        {
            path: "/add-research",
            component: AddResearchForm,
        },
        {
            path: "/edit-research/:id",
            component: EditResearchForm,
            props: true,
        },
        {
            path: "/login",
            component: LoginPage,
        },
        {
            path: "/register",
            component: RegisterForm,
        }
    ],
});

export default router;