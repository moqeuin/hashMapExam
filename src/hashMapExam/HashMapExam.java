package hashMapExam;


import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExam {

	public static void main(String[] args) {
		
		// 맵 : key와 value를 가진 entry로 구성된 데이터 구조
		// 데이터를 순서와 상관없이 데이터를 저장하는 구조로 되어 있다.
		// 해쉬맵 : 객체마다 고유의 해쉬코드를 가지고 배열에 저장이 된다.
		// 데이터를 가지고 올 때 해쉬코드를 해쉬함수로 얻고 인덱스로 변환해서 배열에 접근한다.
		// 객체의 해쉬코드가 동일할 경우 같은 인덱스 저장이 되는 데 이를 해쉬충돌이라고 한다.
		// 이를 해결하기 위해서 첫 번째 배열의 요소를 head로 데이터를 연결리스트로 구성한다.
		// 배열리스트는 내부에 배열을 가지고 있고 기본 사이즈는 10이다.
		// 이를 넘겨서 데이터를 추가할 때는 배열의 크기를 재설정하기 위해서 배열를 새로 생성한다.
		// 때문에 적절한 크기를 설정하지 않는다면 데이터를 추가할 때마다 지연시간이 늘어난다.
		 
		// map은 키와 값을 제너릭으로 둔다.
		Map<String, String> hm = new HashMap<String, String>();
		
		hm.put("one", "test1");
        hm.put("one", "test2");
        hm.put(null,null); // hashTable과의 차이점으로 데이터의 키와 값을 null로 설정할 수 있다.
        System.out.println(hm.get("one")); // test2
        
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
        hm2.put("김지바", new Integer(10));
        hm2.put("이지바", new Integer(30));
        hm2.put("강지바", new Integer(90));
        hm2.put("안지바", new Integer(20));
        hm2.put("송지바", new Integer(15));
        
        @SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, Integer>> it = hm2.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry<String, Integer> me = it.next();
        	System.out.println("key : " + me.getKey() + "value : " + me.getValue() );
        	/*
        	 	key : 안지바value : 20
				key : 김지바value : 10
				key : 송지바value : 15
				key : 강지바value : 90
				key : 이지바value : 30

        	 */
        }
        
        // key값만 추출
        Set<String> set = hm2.keySet();
        System.out.println("참가자 명단 : " + set); // 참가자 명단 : [안지바, 김지바, 송지바, 강지바, 이지바]
        
        // value값만 추출
        Collection<Integer> values = hm2.values();
        Iterator<Integer> it2 = values.iterator();
        
        int total = 0;
        while(it2.hasNext()) {
        	Integer i = (Integer)it2.next();
        	total += i.intValue();
        	
        }
        System.out.println("총점 : " + total);
        System.out.println("최고점수 : " + Collections.max(values));
        System.out.println("최소점수 : " + Collections.min(values));
        
	}

}
