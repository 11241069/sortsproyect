/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortsproyect;

/**
 *
 * @author Carlos
 */
public class Sorts {
    int A[];
    int n;
    public Sorts(int longitud){
		n=longitud;
		A = new int[n];
		llenarArreglo();
	};
    void llenarArreglo(){
		for (int i = 0; i < n; ++i)
			A[i] = (int) (Math.random()*n+1);
	};
    void imprimirArreglo(){
		for (int i = 0; i < n; ++i){
			if( i < n-1 )
			    System.out.println(A[i]+", ");
			else if( i == n-1 )
				System.out.println(A[i]);
		}
	};
    /*
    Implementacion del swap y algoritmo de Heap sort
    */
    void swap(int i, int j ){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	};
    void heapSort(){
		int item, j;
		for(int k = n-1; k >= 0; k-- ){
	        for(int i = 1; i <= k; i++ ){
	            item = A[i];
	            j = i/2;
	            while( j > 0 && A[j] < item ){
	                A[i] = A[j];
	                i = j;
	                j = j/2;
	            }
	            A[i] = item;
	        }
	        swap(1, k );
	    }
	};
    	void selectionSort(){
		int min;
		for( int i = 0; i <= (n-1); i++ ){
			min = i;
			for( int j = i+1; j < n; j++ ){
				if( A[min] > A[j] )
					min = j;
			}
			swap( min, i );
		}
	};

	void insertionSort(  ){
		int i, j;
		for( i = 1; i < n; i++ ) {
			j = i;
			while( j > 0 && A[j-1] > A[j] ){
				swap( j-1, j );
				j--;
			}
		}
	};
        void bubbleSort(  ){
		for( int i = n-2; i >= 0; i-- ){
			for( int j = 0; j <= i; j++ ){
				if( A[j] > A[j+1] )
					swap(j, j+1 );
			}
		}
	};
         void quick_sort(int izq, int der ){
		int i, j, x; 
		i = izq; 
		j = der; 
		x = A[(izq + der)/2]; 
	    do{ 
	        while( (A[i] < x) && (j <= der) )
	            i++;
	 
	        while( (x < A[j]) && (j > izq) )
	            j--;
	 
	        if( i <= j ){
	            swap(i, j );
	            i++;
	            j--; 
	        }
	         
	    }while( i <= j ); 
	 
	    if( izq < j ) 
	        quick_sort(izq, j ); 
	    if( i < der ) 
	        quick_sort( i, der ); 
	};
         void merge(){
             sort(A);
         }
    private int[] array;
    private int[] tempMergArr;
    private int length;

         public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

 }
      
    

