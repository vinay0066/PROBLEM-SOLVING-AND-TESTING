import java.util.Scanner;
public class task7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a=0,b=1,c=0;
        for(int i=1;i<n;i++){
            c=a+b;
            a=b;
            b=c;
            System.out.println(a);
        }
    }
}