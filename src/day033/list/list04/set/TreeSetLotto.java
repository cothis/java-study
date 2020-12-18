package day033.list.list04.set;

import java.util.*;
import java.util.stream.Collectors;

public class TreeSetLotto {
    /*
        (실습) Set을 이용한 로또만들기
        1. 로또번호 : 1 ~ 45 랜덤한 숫자 6개를 Set에 저장
        2. 로또번호 6개를 추첨 후 작은 숫자부터 순서대로 출력
        - Math.random() 사용해서 랜덤한 숫자 만들기
     *******************************************/

    public static void main(String[] args) {

        Set<Integer> lotto = new TreeSet<>();

        // 랜덤 생성
        while (lotto.size() < 6) {
            lotto.add((int) (Math.random() * 45 + 1));
        }

        // 방법 1. 어레이 리스트 만들어서 sort
        ArrayList<Integer> lottoNumbers = new ArrayList<>(lotto);
        Collections.sort(lottoNumbers);

        System.out.println("lottoNumbers : " + lottoNumbers);
        
        // 방법 2. stream 으로 sort
        List<Integer> sortedNumber = lotto
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sortedNumber : " + sortedNumber);

        // 방법 3. for with array
        Object[] array = lotto.toArray();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if ((Integer)array[i] > (Integer) array[j]) {
                    int temp = (Integer)array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("array : " + Arrays.toString(array));

        // 방법 4. for with ArrayList
        List<Integer> list = new ArrayList<>(lotto);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("list : " + list);

        // 방법 5. foreach
        List<Integer> list2 = new ArrayList<>();
        while(lotto.size() > 0) {
            int minVal = lotto.iterator().next();

            for (Integer lotto1 : lotto) {
                if(minVal > lotto1) {
                    minVal = lotto1;
                }
            }
            list2.add(minVal);
            lotto.remove(minVal);
        }
        System.out.println("list2 : " + list2);


    }
}
