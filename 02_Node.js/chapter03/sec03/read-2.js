fs = require('fs');

// 인코딩 지정
// 기본 리턴 값은 Buffer 객체이기 때문에 인코딩을 해야 제대로 볼 수 있다
const data = fs.readFileSync('./chapter03/sec03/example.txt', 'utf-8');
console.log(data);
