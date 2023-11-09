class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        quickSort(citations, 0, citations.length - 1);
        for (int i = 0; i < citations.length; i++) {
            if (i+1 <= citations[i]) {
                answer = i+1;
            } else {
                break;
            }
        }
        return answer;
    }
    
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start;
        int right = end;
        int pivot = arr[(left + end) / 2];

        while (left <= right) {
            while (arr[left] > pivot) left++;
            while (arr[right] < pivot) right--;

            if (left <= right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}