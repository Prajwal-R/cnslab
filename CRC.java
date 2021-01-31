import java.util.*;
public class CRC {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int m,g[],n,d[],r[],msb,i,j,k;
		//m->size of the generator
		//g[]-> Generator or divisor array
		//n-> size of the dataword
		//d[]-> Array for dataword
		//z[]-> Zero Array
		//r[]-> Array for remainder
		//msb-> most significant bit
		//i,i,k->Array variables
				
		System.out.println("Enter no. of bits in Dataword(d) : ");
		n=sc.nextInt();

		System.out.println("Enter no. of generator bits : ");
		m=sc.nextInt();

		d=new int[n+m];
		g=new int[m];
		r=new int[m+n];
		
		System.out.println("Enter Dataword bits");
		for(i=0;i<n;i++)
			d[i]=sc.nextInt();

		System.out.println("Enter generator bits:");
		for(j=0;j<m;j++)
			g[j]=sc.nextInt();
		
				
		for(i=0;i<m-1;i++)
			d[n+i]=0; //Appending (m-1) 0s 

		
		for(i=0;i<m;i++)
			r[i]=d[i];//intial data to be divided(First part of dividend)

			

		for(i=0;i<n;i++)
		{
			k=0; // Number of iterations or division steps
			msb=r[i];
			for(j=i;j<m+i;j++)
			{
				if(msb==0)
					r[j]=r[j]^0;
				else
					r[j]=r[j]^g[k];
				k++;
			}
			r[m+i]=d[m+i]; // Final remainder
		}
		
		System.out.println("The redundant(r) bits added are : ");
		for(i=n;i<n+m-1;i++)   // i started with n value
		{
			d[i]=r[i];
			System.out.print(d[i]+" ");
		}
		
		System.out.println();
		
		System.out.println("The codeword(c=d+r) is :");
		for(i=0;i<n+m-1;i++)  // i started with 0 value
		{
			System.out.print(d[i]+" ");
		}

		int c[]=new int[n+m];
		System.out.println();
		
		System.out.println("Enter the data bits recieived");
		
		for(i=0;i<n+(m-1);i++)
			c[i]=sc.nextInt();
		int count=0;    //to print error at particular position
		for(i=0;i<n+m-1;i++)
		{	if(c[i]==d[i])
				count++;
			else
				break;
		}
		
		if(count==n+m-1)
			System.out.println("No error");
		else{
			System.out.println("Error present");
			System.out.println("Error occurs at "+(count+1));
		}	}
}