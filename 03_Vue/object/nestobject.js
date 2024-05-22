let human = {
  name: '김상형',
  age: 29,
  address: {
    city: '하남시',
    dong: '덕풍동',
    bunji: 638,
  },
};

console.log('이름 = ' + human.name + ', 나이 = ' + human.age);
// human과 address가 둘 다 객체이기 때문에 '.'으로 2번 접근한다
console.log(
  '주소 = ' +
    human.address.city +
    ' ' +
    human.address.dong +
    ' ' +
    human.address.bunji
);
