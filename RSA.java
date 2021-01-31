import java.io.*;
import java.math.*;
import java.util.*;

public class rsa{
	BigInteger p, q, e, d, z, n,c,m;
	String msg,rmsg,code;
	BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
	
	void read() throws IOException
	{
		System.out.println("Enter 2 large prime number");
		p=new BigInteger(keyin.readLine());
		q=new BigInteger(keyin.readLine());
		n= p.multiply(q);
		z=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		System.out.println("Enter encrytion key(e) such that 1<e<z and gcd(e,z)=1");
		e= new BigInteger(keyin.readLine());
		d=e.modInverse(z);
		System.out.println("Emter messaage for encryption");
		msg=keyin.readLine();
		code="";
		rmsg="";
	}
	
	void encrypt()
	{
		for(int i=0;i<msg.length();i++)
		{
			m=BigInteger.valueOf((int)msg.charAt(i));
			c=m.modPow(e,n);
			code+=(char)c.intValue();
		}
	}
	
	void decrypt()
	{
		for(int i=0;i<code.length();i++)
		{
			c=BigInteger.valueOf(code.charAt(i));
			m=c.modPow(d,n);
			rmsg+=(char)m.intValue();
		}
	}
	
	void show()
	{
		System.out.println("the public key (N,E) =("+n+","+e+")");
		System.out.println("the message at sender side: \t\""+msg+"\"");
		System.out.println("the encryted message :\t\t\""+code+"\"");
		System.out.println("the message at reciever end :\t\""+rmsg+"\"");
	}
	
	public static void main(String args[])throws IOException
	{
		rsa obj= new rsa();
		obj.read();
		obj.encrypt();
		obj.decrypt();
		obj.show();
	}
}