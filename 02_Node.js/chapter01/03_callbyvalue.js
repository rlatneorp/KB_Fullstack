function swap(x, y) {
  let temp = x;
  x = y;
  y = temp;
  console.log(`swap 함수 안 -> x: ${x}, y: ${y}`);
}

let a = 100;
let b = 200;

console.log(`swap 호출 전 -> a: ${a}, b: ${b}`);
swap(a, b);
// 값만 복사되기 때문에 100,200이 변경없이 출력된다
// 프리미 타입(number) 이기 때문에
console.log(`swap 호출 후 -> a: ${a}, b: ${b}`);
