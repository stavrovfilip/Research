import carService from "@/repository/researchRepository";
import userService from "@/repository/userRepository";

export default {
    fetchResearches(state) {
        carService.fetchAllResearches().then(data => {
            console.log(data.data);
            state.brands = data.data
        });
    },
    authenticateUser(state, authRequest) {
        console.log("authenticateUser");
        userService.authenticate({username: authRequest.username, password: authRequest.password})
            .then(response => {
                state.userToken = response.data;
                this.commit('checkTokenExpiration', {token: state.userToken, thisObj: authRequest.thisObj});
            })
    },
    checkTokenExpiration(state, tokenRequest) {
        console.log("checkTokenExpiration");
        userService.checkTokenExpiration({token: tokenRequest.token}).then(response => {
                state.userAvailability = response.data;
                console.log(state.userAvailability);
                if (state.userAvailability) {
                    this.commit("fetchUser", {token: tokenRequest.token, thisObj: tokenRequest.thisObj})
                } else {
                    state.userToken = null;
                }
            }
        )
    },
    fetchUser(state, tokenRequest) {
        console.log("fetchUser enter");
        userService.getUserByToken({token: tokenRequest.token}).then(response => {
            if (response.status === 200) {
                console.log("user returned");
                state.user = response.data;
                console.log(state.user);
                if (tokenRequest.thisObj.$router.currentRoute.value.path === '/login' &&
                    tokenRequest.thisObj.$router.options.history.state.back !== '/register') {
                    tokenRequest.thisObj.$router.back();
                }
            }
        })
    },
}