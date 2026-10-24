// Accessing & modifying array elements

const statuses = ["pass", "fail", "skip"];

console.log("First item:", statuses[0]);
console.log("Last item:", statuses[2]);

console.log("Last item using negative index:", statuses.at(-1));
console.log("Second last item:", statuses.at(-2));
console.log("Out-of-range negative index:", statuses.at(-4));

// Modify an existing element
statuses[1] = "blocked";
console.log("Updated statuses:", statuses);

console.log("Array length:", statuses.length);