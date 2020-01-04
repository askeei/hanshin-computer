package main;

import java.io.*;

/*
** Scanner - Free format으로 문자열 또는 정수를 입력하기 위한 메소드를 정의하기 위한 클래스.
**     객체를 생성하지 않고 멤버변수나 메소드를 사용하기 위해 
**     모든 멤버변수와 메소드를 static으로 선언한다.
**     사용 예 :  int no = Scanner.getInt(); String name = Scanner.getString();
*/

public class Scanner { 
  private  static int peekc = 0;	  // 읽은 문자를 다시 읽기 위해 저장하는 peekc 
  private  static int sign;		    // 읽은 정수의 부호를 기록하기 위한 변수

  Scanner(Object o)  {
  }
  
  
  // getchar() : 한 문자를 읽기 위한 메소드. peekc가 0이 아니면 
  private  static int getchar() {	
		int retval;

		try {
 			 if (peekc != 0) { 
						// peekc가 0이 아니면 peekc를 반환, 0으로 reset
				 		retval = peekc; 
						peekc = 0; 
						return retval;
			}

			return System.in.read();  //한 문자를 읽어 반환
		} catch (IOException e)  {  return -1;}
	}

   // ungetc(): 입력한 문자를 다시 읽을 수 있도록 peekc에 저장하는 메소드
   private  static 	void ungetc(int c) {	
			peekc = c;	// 주어진 문자를 peekc에 저장
	} 

   // skipUntilDigit() : 첫 디지트가 나올 때까지 문자들을 skip하여 첫 디지트를 반환하는 
   //    메소드. 단 음수부호가 디지트 앞에 나올 때에는 sign 멤버변수를 -1로 만든다.
   private static  int skipUntilDigit() {	
  		 int c;
  		
 		 sign = 1;    // sign은 +로 시작하게 함
		 while((c=getchar()) != -1)  {
		    if (c>='0' && c <= '9')  // 읽은 문자가 디지트이면 이를 반환
						return c;
		    else if (c == '-')         // 읽은 문자가 '-'이면 sign을 음수(-1)로
						sign = -1;	     	
		    else
						sign	 = 1;	     // 그외는 무시하고 sign을 양수(1)로 set
		 }

		 return -1;
	}

  // getint() : 표준입력에서의 정수문자들를 읽어 정수로 변환하여 반환하는 메소드.
  //     양수뿐 아니라 음수도 처리한다.
  public static  int getInt() {
 		int c, val;
 		
		c = skipUntilDigit();   // 첫 번째 디지트를 얻는다								';          // 디지트를 숫자로 변환
		val = c -'0'; 
		
		while((c = getchar()) >='0' && c <='9') //연속되는 디지트들의 숫자변환
				val = val * 10 + (c - '0');  
		ungetc(c);           // 마지막 읽은 문자는 다음 getchar()이 읽도록 보관함
		return sign * val ;
  }
  
  public  static int nextDouble() {
  	    return getInt();
  }
  
  public  static int nextInt() {
  	    return getInt();
  }
  
//  // getchar1() : 한 문자를 읽기 위한 메소드. no peekc 
//  private  static int getchar1() {	
//  	int retval;
//
//  	try {  		 
//  		return System.in.read();  //한 문자를 읽어 반환
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

