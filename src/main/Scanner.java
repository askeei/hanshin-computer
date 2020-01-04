package main;

import java.io.*;

/*
** Scanner - Free format���� ���ڿ� �Ǵ� ������ �Է��ϱ� ���� �޼ҵ带 �����ϱ� ���� Ŭ����.
**     ��ü�� �������� �ʰ� ��������� �޼ҵ带 ����ϱ� ���� 
**     ��� ��������� �޼ҵ带 static���� �����Ѵ�.
**     ��� �� :  int no = Scanner.getInt(); String name = Scanner.getString();
*/

public class Scanner { 
  private  static int peekc = 0;	  // ���� ���ڸ� �ٽ� �б� ���� �����ϴ� peekc 
  private  static int sign;		    // ���� ������ ��ȣ�� ����ϱ� ���� ����

  Scanner(Object o)  {
  }
  
  
  // getchar() : �� ���ڸ� �б� ���� �޼ҵ�. peekc�� 0�� �ƴϸ� 
  private  static int getchar() {	
		int retval;

		try {
 			 if (peekc != 0) { 
						// peekc�� 0�� �ƴϸ� peekc�� ��ȯ, 0���� reset
				 		retval = peekc; 
						peekc = 0; 
						return retval;
			}

			return System.in.read();  //�� ���ڸ� �о� ��ȯ
		} catch (IOException e)  {  return -1;}
	}

   // ungetc(): �Է��� ���ڸ� �ٽ� ���� �� �ֵ��� peekc�� �����ϴ� �޼ҵ�
   private  static 	void ungetc(int c) {	
			peekc = c;	// �־��� ���ڸ� peekc�� ����
	} 

   // skipUntilDigit() : ù ����Ʈ�� ���� ������ ���ڵ��� skip�Ͽ� ù ����Ʈ�� ��ȯ�ϴ� 
   //    �޼ҵ�. �� ������ȣ�� ����Ʈ �տ� ���� ������ sign ��������� -1�� �����.
   private static  int skipUntilDigit() {	
  		 int c;
  		
 		 sign = 1;    // sign�� +�� �����ϰ� ��
		 while((c=getchar()) != -1)  {
		    if (c>='0' && c <= '9')  // ���� ���ڰ� ����Ʈ�̸� �̸� ��ȯ
						return c;
		    else if (c == '-')         // ���� ���ڰ� '-'�̸� sign�� ����(-1)��
						sign = -1;	     	
		    else
						sign	 = 1;	     // �׿ܴ� �����ϰ� sign�� ���(1)�� set
		 }

		 return -1;
	}

  // getint() : ǥ���Է¿����� �������ڵ鸦 �о� ������ ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�.
  //     ����� �ƴ϶� ������ ó���Ѵ�.
  public static  int getInt() {
 		int c, val;
 		
		c = skipUntilDigit();   // ù ��° ����Ʈ�� ��´�								';          // ����Ʈ�� ���ڷ� ��ȯ
		val = c -'0'; 
		
		while((c = getchar()) >='0' && c <='9') //���ӵǴ� ����Ʈ���� ���ں�ȯ
				val = val * 10 + (c - '0');  
		ungetc(c);           // ������ ���� ���ڴ� ���� getchar()�� �е��� ������
		return sign * val ;
  }
  
  public  static int nextDouble() {
  	    return getInt();
  }
  
  public  static int nextInt() {
  	    return getInt();
  }
  
//  // getchar1() : �� ���ڸ� �б� ���� �޼ҵ�. no peekc 
//  private  static int getchar1() {	
//  	int retval;
//
//  	try {  		 
//  		return System.in.read();  //�� ���ڸ� �о� ��ȯ
//  	} catch (IOException e)  {  return -1;}
//  }
  
  public  static String getString()  {
  	 int i=0;
	 int c;
	 char cs[] = new char[200];
	 
	 while((c =  getchar()) == '\n' || c == '\r' ) ;  // skip first '\n' or '\r'
	 ungetc(c);
	 
	 
     while((c = getchar()) != '\n' &&  c != '\r' ) 
	     cs[i++] = (char) c;
		 
     cs[i] = 0;
	 
	 String s =  new String(cs,0, i);
	 
	 return toKSC5601(s);	 
  }
  
  public static String nextString() {
   	return nextString();
  } 

	public static String toKSC5601(String str) // throws java.io.UnsupportedEncodingException 
	{ 
		if (str == null) return null; 

		try {
			return new String(str.getBytes("8859_1"), "KSC5601"); 
		}
		catch(Exception e) {}
		
		return null;
		
	} 





// public static void main(String argc[]) 
  
//  {	
//	  System.out.print("  no= ");
//	  int no = Scanner.getInt(); 
//
//	  System.out.print("  name= ");
//
//	  String name = Scanner.getString();
//
//      System.out.println("  no="+no+ "   name='"+name+"'");  
//  }
//  
  
}

