// Cold Code: JavaScript Engine
function sayHello() {
    console.log("Hello");
}

sayHello(); // Runs only once

// Hot Code: JavaScript Engine
function add(a, b) {
    return a + b;
    
}

for (let i = 0; i < 1000000; i++) {
    add(i, 10);
}
