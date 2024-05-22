let x = 100;
let y = 200;
// 전역변수 : 스코프 바깥 범위의 변수
// 전체 영역에 적용된다

function swap(x, y) {
  // 우선순위 : 지역변수 > 전역변수
  // 함수내에서는 지역변수로 쓰이고, 함수가 끝나는 즉시 반환된다
  let temp = x;
  x = y;
  y = temp;
  console.log(`swap 함수 안 -> x: ${x}, y: ${y}`);
}

console.log(`swap 호출 전 -> x: ${x}, y: ${y}`);
swap(x, y);
console.log(`swap 호출 후 -> x: ${x}, y: ${y}`);
