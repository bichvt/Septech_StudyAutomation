package FirstPackage;
import java.util.Scanner; 
/** Tao ham MainClass goi cac doi tuong cua class Sohoc */
public class MainClass {
	static Sohoc sh;
	public static void main(String[] args){
		sh = new Sohoc();
		int x,y;	
		Scanner in = new Scanner(System.in);
		// Nhap 2 so bat ki tu ban phim
		System.out.println("Nhap so thu nhat:");
		x = in.nextInt();
		System.out.println("Nhap so thu hai:");
		y = in.nextInt();
		sh.cong2So(x, y);
		sh.tru2So(x, y);
		sh.nhan2So(x, y);
		sh.chia2So(x, y);
		sh.min2So(x,y);
		sh.loofFor();
		sh.loofDoWhile();
		sh.loofWhile();  
	}
}
