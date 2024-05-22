const hi = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};

const goodbye = (name) => {
  console.log(`${name}님, 안녕히 가세요.`);
};

// 여러 개를 export할 때는 객체로 묶어서 내보낸다
export { hi, goodbye };
