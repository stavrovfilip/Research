export default {
    fetchCategories(context) {
        context.commit('fetchCategories');
    },
    authenticateUser(context, authRequest) {
        context.commit("authenticateUser", authRequest);
    },
    fetchUser(context, tokenRequest) {
        context.commit("fetchUser", tokenRequest);
    },
    checkTokenExpiration(context, tokenRequest) {
        context.commit("checkTokenExpiration", tokenRequest);
    },
}