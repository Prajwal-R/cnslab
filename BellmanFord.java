import java.util.*;
import java.lang.*;

public class bellmanford
{
	int n,a[][],d[],strt,i,j;
	public static final int max=999;
	public void read()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter number of nodes");
		n=scan.nextInt();
		a=new int [n+1][n+1];
		System.out.println("Enter Adjacency matrix");
		for(i=0;i<n;i++)
			for(j=0;j<n;j++)
				a[i][j]=scan.nextInt();
		System.out.println("enter starting vertex");
		strt=scan.nextInt();
		scan.close();
	}
	public void calculation()
	{
		d=new int [n+1];
		for(i=0;i<n;i++)
			d[i]=max;
		d[strt-1]=0;
		for(int k=0;k<n-1;k++)
		{
			for (i=0;i<n;i++)
				for(j=0;j<n;j++)
				{
					if(a[i][j]!=max)
						if(d[j] > d[i]  + a[i][j])
							d[j]=d[i]+a[i][j];
				}
		}
		for (i=0;i<n;i++)
			for(j=0;j<n;j++)
			{
				if(a[i][j]!=max)
					if(d[j]>d[i]+a[i][j])
					{
						System.out.println("Graph contains negative cycle");
						return;
					}
			}
			
		
		
		for(i=0;i<n;i++)
			System.out.println(" distance fron "+strt+" vertex to "+(i+1)+" is : "+d[i]);
				
	}
	public static void main(String args[])
	{
		bellmanford obj = new bellmanford();
		obj.read();
		obj.calculation();
	}
}