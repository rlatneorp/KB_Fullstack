function displayA() {
  console.log('A');
}

// 콜백함수를 이용하면 원하는대로 순서를 보장할 수 있다
// 하지만 콜백함수를 계속 쓰면 콜백지옥에 도착한다..
// -> 그래서 등장한 것이 Promise, async/awit이다.
function displayB(callBack) {
  setTimeout(() => {
    console.log('B');
    callBack();
  }, 2000);
}

function displayC() {
  console.log('C');
}
displayA();
displayB(displayC);
