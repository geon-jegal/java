package day8;

import java.util.Random;


public class CardGame {
	public static Card ori_card[], cardTemp[];
	
	public static void sort() {
		for(int i = 0; i < cardTemp.length - 1; i++) {
			int maxIdx = i;
			for (int j = i + 1; j < cardTemp.length; j++) {
	            if (cardTemp[j].getNum() > cardTemp[maxIdx].getNum()) {
	            	maxIdx = j;
	            }
	            else if(cardTemp[j].getNum() == cardTemp[maxIdx].getNum()) {
	            	if (cardTemp[j].getMark() < cardTemp[maxIdx].getMark()) {
		            	maxIdx = j;
		            }
	            }
	        }
	        //swap(cardTemp, i, minIdx);
			Card tempcard = cardTemp[i];
			cardTemp[i] = cardTemp[maxIdx];
			cardTemp[maxIdx] = tempcard;
		}
	}
	
	// 메인함수
	public static void main(String[] args) {
		ori_card = new Card[10];
		cardTemp = new Card[10];
		Random random = new Random();
		
		System.out.println("카피 전");
		for(int i = 0; i < 10; i++) {
			ori_card[i] = new Card(random.nextInt(10));
			ori_card[i].print();
			
			//hardCopy
			cardTemp[i] = new Card(Type.values()[ori_card[i].getMark()], ori_card[i].getNum());
		}
		
		sort();
		
		System.out.println("카피 후");
		
		for(int i = 0; i < 10; i++) {
			cardTemp[i].print();
		}
		
	}

}
