let msg = 'GLOBAL';
function outer() {
  // 스코프 내에서 가장 가까이 있는 변수 값을 먼저 찾는다
  let msg = 'OUTER';
  console.log(msg);
  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }
}
outer();
