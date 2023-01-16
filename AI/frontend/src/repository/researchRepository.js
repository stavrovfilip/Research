import axios from "@/custom-axios/axios";
import {researchPage} from "@/utils/constants";

const carService = {
    fetchAllResearches: () => {
        return axios.get(researchPage);
    },
    getResearchById: (id) => {
        return axios.get(researchPage + `/${id}`)
    },
    addResearch: (research) => {
        return axios.post(researchPage + '/add-research', research);
    },
    editResearch: (editResearch) => {
        return axios.post(researchPage + "/edit-research", editResearch);
    },
    deleteResearch: (id) => {
        return axios.delete(researchPage + `/delete-research/${id}`);
    }
}
export default carService;