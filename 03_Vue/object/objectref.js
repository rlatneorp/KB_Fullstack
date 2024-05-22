let human = {
  name: '김상형',
  age: 29,
};

// kim에 human 객체 주소값 복사
let kim = human;
kim.name = '김태희';

// human과 kim은 같은 주소값을 가지고 있기 때문에 값이 같이 변경된다.
console.log('name = ' + human.name);
console.log('age = ' + human.age);
