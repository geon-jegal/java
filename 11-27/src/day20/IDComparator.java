package day20;

import java.util.*;

public class IDComparator implements Comparator<Integer> {

	/*
	@Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
        // 역순으로 정렬
        //return str2.compareTo(str1);        
    }
    */
	
	/*
	 * public int compare(Integer n1, Integer n2) {
	 * 	return n2.intValue() - n1.intValue();
	 * }
	 */
	public int compare(Integer n1, Integer n2) {
		return n2.intValue() - n1.intValue();
	}
}
