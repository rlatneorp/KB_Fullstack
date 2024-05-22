let getTriangle = (base, height) => (base * height) / 2;

// 객체 return 시에는 소괄호로 한번 더 감싸준다
// 구현부와 차이점을 두기위해
let getObject = () => ({ 이름: 'yura' });

console.log('삼각형의 면적 :' + getTriangle(5, 2));
