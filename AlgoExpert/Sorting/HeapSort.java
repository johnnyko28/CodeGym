class HeapSort {

    static void sort(int a[]) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            MaxHeapify(a, n, i);
        for (int i = n - 1; i >= 1; i--) {
            swap(a, i, 0);
            MaxHeapify(a, i, 0);
        }
    }

    static void MaxHeapify(int a[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[largest])
            largest = l;
        if (r < n && a[r] > a[largest])
            largest = r;
        if (largest != i) {
            swap(a, i, largest);
            MaxHeapify(a, n, largest);
        }
    }

    static void swap(int []a, int l, int r) {
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
    }

    public static void main(String[] args) {
        int []a = {2, 4, 1, 5};
        sort(a);
        for (int i = 0; i < 4; i++)
            System.out.println(a[i]);
    }
}
