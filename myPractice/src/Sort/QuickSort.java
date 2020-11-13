package Sort;


public class QuickSort extends Sort{
	@Override
	public int sort(int[] array) {
		quick_sort(array, 0, array.length);
		return 0;
	}
	
	public void quick_sort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot;
		int low, high;
		low = left;
		high = right - 1;
		pivot = array[left];
		
		while(low < high) {
			while(low < right && array[low] < pivot) {
				low++;
			}
			while(high > left && array[high] > pivot) {
				high--;
			}
			if(low < high) {
				int temp = array[low];
				array[low] = array[high];
				array[high] = temp;
			}
		}
		
		quick_sort(array, left, high - 1 );
		quick_sort(array, high + 1 , right);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public int partition(int[] array, int left, int right) {
//		int pivot, temp;
//		int low, high;
//		
//		low = left;
//		high = right + 1;
//		pivot = array[left];
//		while(low < high) {
//			while(low <= right && array[low]<pivot) {
//				low++;
//			}
//			
//			high--;
//			while(high>=left && array[high]>pivot) {
//				high--;
//			}
//			
//			if (low<high) {
//				temp = array[low];
//				array[low] = array[high];
//				array[high] = temp;
//			}
//		}
//		return high;
//	}
//	private void quick_sort(int[] array, int left, int right) {
//		if(left <right) {
//			int q = partition(array, left, right);
//			quick_sort(array, left, q-1);
//			quick_sort(array, q+1, right);
//		}
//	}
}
