const kinveyBaseUrl = "https://baas.kinvey.com/";
const kinveyAppKey = "kid_S1p2qC6oG";
const kinveyAppSecret = "f278d5d970b54748b0a0a7f97b90c105";

// Creates the authentication header
function makeAuth(type) {
    return type.toLowerCase() === 'basic'
        ?  'Basic ' + btoa(kinveyAppKey + ':' + kinveyAppSecret)
        :  'Kinvey ' + sessionStorage.getItem('authtoken');
}

// Creates request url
function makeUrl(module, endpoint) {
    return kinveyBaseUrl + module + '/' + kinveyAppKey + '/' + endpoint;
}

// Creates request body
function makeBody(method, auth, data) {
    let req = {
        method,
        mode: "cors", // no-cors, cors, *same-origin
        cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
        credentials: "include", // include, same-origin, *omit
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': makeAuth(auth)
        }
    }
    if (data) {
        req.body = JSON.stringify(data);
    }
    return req;
}

// Function to return GET promise
function get (module, endpoint, auth) {
    return fetch(makeUrl(module, endpoint), makeBody('GET', auth));
}

// Function to return POST promise
function post (module, endpoint, auth, data) {
    return fetch(makeUrl(module, endpoint), makeBody('POST', auth, data));
}

// Function to return PUT promise
function update (module, endpoint, auth, data) {
     return fetch(makeUrl(module, endpoint), makeBody('PUT', auth, data));
}

// Function to return DELETE promise
function remove (module, endpoint, auth) {
     return fetch(makeUrl(module, endpoint), makeBody('DELETE', auth));
}

export default {
        get,
        post,
        update,
        remove
    }
