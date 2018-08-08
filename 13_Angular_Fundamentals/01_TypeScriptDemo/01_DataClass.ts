
class RequestData {
   
    public method : String;
    public uri : String;
    public version : String;
    public message : String;
    public response : String;
    public fulfilled : Boolean;
    
    constructor(method, uri, version, message){
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.message = message;
        this.response = undefined;
        this.fulfilled = false;
    }
    
}

let data = new RequestData('GET', 'http://google.com', 'HTTP/1.1', '');
console.log(data);
