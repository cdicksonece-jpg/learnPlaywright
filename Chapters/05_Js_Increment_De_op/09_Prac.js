
let a = 100;

console.log(a++ + ++a +a++ + ++a);//100+102+102+104

console.log(a);


let b = 37;

console.log(--b + b--); //36+36 

console.log(b);


let a1 = 5; 
let b1 = a1-- - --a1; //5-3
console.log(b1, a1);


let i = 1; 

let r = i++ > 1 ? i++ : ++i; //
console.log(r, i);