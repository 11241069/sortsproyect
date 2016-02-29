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
public class Sortsproyect{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        for (int i = 0; i < 10; i++) {
            
        
        Sorts sort = new Sorts(100);
        //long startTime = System.currentTimeMillis();
        long startTime = System.nanoTime();
        //sort.imprimirArreglo();
        //sort.heapSort();
        
        //sort.quick_sort(0, sort.A.length-1);
        //sort.bubbleSort();
        //sort.insertionSort();
        sort.selectionSort();
        //sort.merge();
       //int a1[]=new int[10];
       // for (int i = 0; i < a1.length; ++i)
	//		a1[i] = (int) (Math.random()*a1.length+1);
        //sort2(a1);
        
        /*
        
        int A[]=new int[10];
        A=sort(A);
        
        
        for (int i = 0; i < A.length; ++i){
			if( i < A.length-1 )
			    System.out.println(A[i]+", ");
			else if( i == A.length-1 )
				System.out.println(A[i]);
		}*/
        
        
        //long estimatedTime = System.currentTimeMillis() - startTime;
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("Tiempo Ejecutado="+estimatedTime);
        System.out.println("Arreglado");
        //sort.imprimirArreglo();
        }
    }
    public static int[] sort(int[] input){

        // Largest place for a 32-bit int is the 1 billion's place
        for(int place=1; place <= 1000000000; place *= 10){
            // Use counting sort at each digit's place
            input = countingSort(input, place);
        }

        return input;
    }

    private static int[] countingSort(int[] input, int place){
        int[] out = new int[input.length];

        int[] count = new int[10];

        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i], place);
            count[digit] += 1;
        }

        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }

        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], place);

            out[count[digit]-1] = input[i];
            count[digit]--;
        }

        return out;

    }

    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void sort2(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
  
   
}
