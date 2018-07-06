let subscription = {loginUser: [], logoutUser: []};
let isAdmin = false;

export default {
    events: {
        loginUser: 'loginUser',
        logoutUser: 'logoutUser'
    },
    subscribe: (eventName, func) => {
        subscription[eventName].push(func);
    },
    trigger: (eventName, data) => {
        subscription[eventName].forEach(fn => fn(data));
    },
    setAdmin: () => { isAdmin = true },
    isAdmin: () => { return isAdmin }
}
