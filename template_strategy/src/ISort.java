public interface ISort {
    public void sort(int[] arr);
}


class Bubble implements ISort {


    public void sort(int[] arr){
        int i, j, temp;
        boolean swapped;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }


}

class Quick implements ISort {
    public void sort(int[] arr) {
        this.sortQuick(arr, 0, arr.length - 1);
    }



    int partition(int a[], int low, int high)
    {
        int pivot = a[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            // If current element is smaller than or
            // equal to pivot
            if (a[j] <= pivot)
            {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }


    void sortQuick(int a[], int l, int h)
    {
        if (l < h)
        {
            int pi = partition(a, l, h);

            sortQuick(a, l, pi-1);
            sortQuick(a, pi+1, h);
        }
    }



}

class Insertion implements ISort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}



// Klasa wybierająca algorytm na podstawie rozmiaru tablicy
class AdaptiveSort implements ISort {
    private final ISort quickSort = new Quick();
    private final ISort insertionSort = new Insertion();
    private final ISort bubbleSort = new Bubble();
    private final int threshold_1 = 100; // Próg rozmiaru tablicy dla wyboru algorytmu
    private final int threshold_2 = 1000; // Próg rozmiaru tablicy dla wyboru algorytmu

    @Override
    public void sort(int[] array) {
        if (array.length >= threshold_2)
        {
            quickSort.sort(array);
        } else if (array.length >= threshold_1  )
        {
            insertionSort.sort(array);
        } else {
            bubbleSort.sort(array);
        }
    }
}