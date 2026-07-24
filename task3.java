class task3{
    public static void main(String[] args){
        int m[] = {4,8,2,5,9};
        int max = m[0];
        for(int i=1;i<m.length;i++){
            if(m[i]>max){
                max=m[i];
            }
        }
        System.out.println("max element= " +max);
    }
}