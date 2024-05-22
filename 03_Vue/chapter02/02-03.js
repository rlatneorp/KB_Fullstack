// const는 상수값으로 메모리 주소 변경이 불가능
const p1 = { name: 'john', age: 20 };
// 메모리 주소는 그대로지만 안에 값이 변경되는 건 가능
p1.age = 22;
console.log(p1);

// 직접 p1을 변경하면 메모리 주소가 변경되기 때문에 오류
p1 = { name: 'john', age: 20 };
