package ch15.sec04.exam01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapExample {
    public static void main(String[] args) {
        //Map 컬렉션 생성
        Map<String, Integer> map = new HashMap< >();

        //객체 저장
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("홍길동", 95);
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();

        //키로 값 얻기
        String key = "홍길동";
        // get(key)를 사용하면 해당 키에 저장되어있는 value값을 얻을수 있다
        int value = map.get(key);
        System.out.println(key + ": " + value);
        System.out.println();

        //키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        // keySet에는 키값들만 Set형태로 저장되어있다.
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            // 키값을 이용해서 value값을 얻어냄
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
        }
        System.out.println();

        //엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        // 엔트리에는 key와 value를 모두 담고 있다
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            // 엔트리 Set를 돌면서 다음 엔트리를 가져옴
            Entry<String, Integer> entry = entryIterator.next();
//            getKey : 해당 엔트리의 키값 가져오는 메소드
            String k = entry.getKey();
//            getValue : 해당 엔트리의 value값 가져오는 메소드
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        // "홍길동"이라는 키값을 가진 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        System.out.println();
    }
}

