fs = require('fs');

const data = fs.readFileSync('./chapter03/sec03/example.txt', 'utf8');
if (fs.existsSync('./chapter03/sec03/example.txt')) {
  console.log('file already exist');
} else {
  fs.writeFileSync('./chapter03/sec03/example.txt');
}
