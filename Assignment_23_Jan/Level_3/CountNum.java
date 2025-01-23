import java.util.*;
public class CountNum{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
int num=sc.nextInt();
int cnt=0;
while(num!=0){
num/=10;
cnt++;
}
System.out.println("The number of digits in an integer is "+cnt);
}
}
