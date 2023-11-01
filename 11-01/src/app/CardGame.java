package app;

//import lib.Card;

public class CardGame {

	private static OneCard one, two;
	
    // 메인함수
    public static void main(String[] args) {
    	float Try = 1, p = 0;
    	float sum = 0;
    	one = new OneCard();
    	//two = new OneCard();
    	for(int j = 0; j< 1000; j++) {
    		Try = 1;
    		two = new OneCard();
    		while(!one.equals(two)) {
        		two = new OneCard();
        		Try++;
        	}
    		System.out.println(1 / Try);
    		p = 1/Try;
    		sum += Try;
    	}
    	
    	System.out.println("avg: " + sum / 1000);
    	System.out.println("확률 평균: " + p / 1000);
    	
    	System.out.println("1: " + one);
    	System.out.println("2: " + two);
    }
}
