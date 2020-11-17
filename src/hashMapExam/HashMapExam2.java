package hashMapExam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


// 배열의 문자열을 맵에 저장하면서 중복된 수를 세는 프로그램

public class HashMapExam2 {

	public static void main(String[] args) {
		
		String[] data = {"A", "K", "A", "K", "D", "A", "K", "K", "Z", "D"};
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			}
			else {
				map.put(data[i], new Integer(1));
			}
		}
		
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + ":" + printBar('#', entry.getValue()) + " " +value);
		}
		/*
			A:### 3
			D:## 2
			Z:# 1
			K:#### 4
		 */
		
	}
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for (int i = 0; i < bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
}
