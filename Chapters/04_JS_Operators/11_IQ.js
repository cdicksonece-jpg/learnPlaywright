let environment = "staging";
let baseUrl = environment === "prod"
    ? "https://api.example.com"
    : "https://staging-api.example.com";
console.log(baseUrl);

let environment1 = "staging";
let baseUrl1 = environment === "staging"
    ? "https://api.example.com"
    : "https://staging-api.example.com";
console.log(baseUrl1);