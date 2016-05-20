package FirstPackage;
import java.util.Scanner; // Su dụng de nhap gia tri tu ban phim vao
public class Sohoc {
	
	/** Tao cac ham cho cac phep toan so hoc, cac ham logic va cac vong lap */
	
	// 1. Tao ham cho phep cong
	public static int PhepCong(int a, int b){
		int sum;
		sum = a+b;
		System.out.println("Tong hai so la:" + sum);
		return(sum);
	}
	
	// 2. Tao ham cho phep tru
	public static int PhepTru(int a, int b){
		int minus;
		minus = a-b;
		System.out.println("Hieu hai so la:" + minus);
		return(minus);
	}
	
	// 3. Tao ham cho phep nhan
	public static int PhepNhan(int a, int b){
		int tich;
		tich = a*b;
		System.out.println("Tich hai so la:" + tich);
		return(tich);
	}

	// 4. Tao ham cho phep chia lay so du
	public static int PhepChia(int a, int b){
		int sodu;
		sodu = a%b;
		System.out.println("So du cua phep chia hai so la:" + sodu);
		return(sodu);
	}
	
	// 5. Tao ham tinh min su dung phep toan logic ><
	public static int min(int a, int b){
		int min; 
		if(a>b){
			min=b;
		}
		else{
			min=a;
		}
		System.out.println("Min cua hai so la:" + min);
		return(min);
	}
	
	// 6. Tao phuong thuc su dung vong lap For
	   public static void loofFor(){
		   System.out.println("Cac so tu 1 den 10 duoc in ra bang cach su dung vong For:");
		   for(int i=1; i<=10; i++){
			   System.out.println(String.valueOf(i));
		   }
	   }
	   
	// 7. Tao phuong thuc su dung vong lap Do While
	   public static void loofDoWhile(){
		   int i=1;
		   System.out.println("Cac so tu 1 den 10 duoc in ra bang cach su dung vong lap Do While:");
		   do {
			   System.out.println(String.valueOf(i));
			   i++;
			   }while(i<=10);
	   }
	   
	// 8. Tao phuong thuc su dung vong lap While
	   public static void loofWhile(){
		   int i=1;
		   System.out.println("Cac so tu 1 den 10 duoc in ra bang cach su dung vong lap While:");
		   while(i<=10){
			   System.out.println(String.valueOf(i)); 
			   i++;
		   }
	   }		   
	   	   
	/** Tao ham main de test cac ham tren */ 
	public static void main(String arg[]){
		int x, y;
		// Nhap 2 so bat ki tu ban phim
	    System.out.println("Nhap so thu nhat:");
	    Scanner in = new Scanner(System.in);
	    x = in.nextInt();
	    System.out.println("Nhap so thu hai:");
	    y = in.nextInt();
	    
	    // Test cho phep cong hai so
	    int sum = PhepCong(x,y);
	    
	    // Test cho phep tru hai so
		int minus = PhepTru(x,y);
		
	    // Test cho phep nhan hai so	
		int tich = PhepNhan(x,y);
		
		// Test cho phep chia lay so du cua hai so	
		int sodu = PhepChia(x,y);
		
		// Test cho tim min cua hai so
		int min = min(x,y);
	
		// Test cho in 10 so tu 1 den 10 ra man hinh bang cach su dung vong lap For
		 System.out.println("Cac so tu 1 den 10 duoc in ra bang cach su dung vong For:");
		 for(int i=1; i<=10; i++){
			   System.out.println(String.valueOf(i));
		 }
		 
		// Test cho in 10 so tu 1 den 10 ra man hinh bang cach su dung vong lap Do While
		 System.out.println("Cac so tu 1 den 10 duoc in ra bang cach su dung vong lap Do While:");
		 int j=1;
		   do {
			   System.out.println(String.valueOf(j));
			   j++;
			   }while(j<=10);
		   
	   // Test cho in 10 so tu 1 den 10 ra man hinh bang cach su dung vong lap While
		   int k=1;
	     System.out.println("Cac so tu 1 den 10 duoc in ra bang cach su dung vong lap While:");
	     while(k<=10){
		   System.out.println(String.valueOf(k));
		   k++;
	      }
	}
}
	   