let p = new Promise((resolve, reject) => {
  resolve('first!');
});

p.then((msg) => {
  console.log(msg); // first
  // 에러를 강제 발생시키느 코드, catch로 바로 이동
  // throw new Error("## 에러!!")
  return 'second';
})
  // 그 전에 return된 값을 이어서 받음
  .then((msg) => {
    console.log(msg); // second
    return 'third';
  })
  .then((msg) => {
    console.log(msg); // thrid
  })
  .catch((error) => {
    console.log('오류 발생 ==> ' + error);
  });
