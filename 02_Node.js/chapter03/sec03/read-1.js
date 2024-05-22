fs = require('fs');

//fs.readFileSync : 동기로 파일을 읽어온다
const data = fs.readFileSync('./chapter03/sec03/example.txt');
console.log(data);
