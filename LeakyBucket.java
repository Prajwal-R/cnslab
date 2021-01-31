import java.util.*;
import java.lang.*;
public class leakybucket{
    public static void main(String args[]){
        int n,i,buck_size,rate,recv,send,buck_rem=0;
        Scanner scan= new Scanner(System.in);
        System.out.println("enter number of packet");
        n=scan.nextInt();
        int a[] = new int[n+1];
        System.out.println("enter size of the bucket");
        buck_size=scan.nextInt();
        System.out.println("enter rate of flow");
        rate=scan.nextInt();
        System.out.println("enter packets");
        for (i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
        }
        System.out.println("clock\t packet_size\t acceptance\t sent\t remaining");
        for(i=0;i<n;i++)
        {
			recv=-1;
			send=0;
            if(a[i]!=0)
            {
                if(buck_rem+a[i]>buck_size)
                    recv=-1;
                else
                {
                    recv=0;
                    buck_rem+=a[i];
                }
            }
            if(buck_rem!=0)
            {
                if(buck_rem<rate)
                {
                    send=buck_rem;
                    buck_rem=0;
                }
                else
                {
                    send=rate;
                    buck_rem-=rate;
                }

            }
            if(recv==0)
                System.out.println(+i+"\t  "+a[i]+"\t\t accepted\t"+send+"\t"+buck_rem);
            else
                System.out.println(+i+"\t  "+a[i]+"\t\t rejected\t"+send+"\t"+buck_rem);
        }

    }
}