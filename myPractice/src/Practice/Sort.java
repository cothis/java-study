package Practice;

// 삽입정렬 해보기
public class Sort {
	public static int sort(int[] array) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length ; j++) {
				if (array[i] < array[j]) {
					// 오름차순 정렬은 i가 작은쪽으로 가니까 이 조건은 스킵
				} else {
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					count++;
				}
				
			}
		}
		return count;
	}
	
}
