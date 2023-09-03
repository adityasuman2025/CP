class matrix {
    public static void main(String args []) {
        int arr [][] = new int [3][3];
       
        // num(arr);
        mum(arr);
        printArray(arr);
        
    }
    public static void num(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++){
                arr[i][j]=3*i+(j+1);
            } 
        }
    }

    public static void mum(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++){
                arr[i][j]=2*(i+1)+j;
            } 
        }
    }

    public static void printArray(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            // System.out.println(Arrays.toString(arr[i]));
            for(int j=0; j< arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}