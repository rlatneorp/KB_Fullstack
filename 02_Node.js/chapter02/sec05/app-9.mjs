// 키워드로 전체 파일을 가져와서 사용 가능
// 하지만 안쪽의 변수나 함수를 접근할 때는 .을 써서 접근해야 함
import * as say from './greething-1.mjs';

say.hi('홍길동');
say.goodbye('홍길동');
