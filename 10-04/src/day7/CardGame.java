package day7;

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
                    if (cardTemp[j].getMark() > cardTemp[maxIdx].getMark()) {
                        maxIdx = j;
                    }
                }
            }
            Card tempcard = cardTemp[i];
            cardTemp[i] = cardTemp[maxIdx];
            cardTemp[maxIdx] = tempcard;
        }
    }

    // 메인함수
    public static void main(String[] args) {
        ori_card = new Card[10];
        cardTemp = new Card[10];

        System.out.println("카피 전");

        for (int i = 0; i < 10; i++) {
            ori_card[i] = new Card();

            // 중복된 카드가 나오면 다시 뽑기
            for (int j = 0; j < i; j++) {
                while (ori_card[i].getMark() == ori_card[j].getMark() &&
                        ori_card[i].getNum() == ori_card[j].getNum()) {
                    ori_card[i] = new Card();
                    j = 0; // 처음부터 다시 검사
                }
            }

            ori_card[i].print();

            // hardCopy
            cardTemp[i] = new Card(Type.values()[ori_card[i].getMark()], ori_card[i].getNum());
        }

        sort();

        System.out.println("카피 후");

        for (int i = 0; i < 10; i++) {
            cardTemp[i].print();
        }
    }
}
