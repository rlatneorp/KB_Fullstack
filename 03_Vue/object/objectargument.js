let human = { name: '김상형', age: 29 };

// human의 주소값이 h로 넘어간다
function changeName(h) {
  h.name = '김태희';
}
changeName(human);

// human의 주소값에 있는 name을 변경했기 때문에 human이 변경된다
console.log('name = ' + human.name);
console.log('age = ' + human.age);
