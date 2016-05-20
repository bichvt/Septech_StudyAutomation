package FirstPackage;
import java.util.Scanner; 
/** Tao ham MainClass goi cac doi tuong cua class Sohoc */
public class MainClass {
	static Sohoc sh;
public static void main(String[] args){
	sh = new Sohoc();
	int x,y;	
	// Nhap 2 so bat ki tu ban phim
    System.out.println("Nhap so thu nhat:");
    Scanner in = new Scanner(System.in);
    x = in.nextInt();
    System.out.println("Nhap so thu hai:");
    y = in.nextInt();
    System.out.println("Phep cong hai so:");
    sh.PhepCong(x, y);
    sh.PhepTru(x, y);
    sh.PhepNhan(x, y);
    sh.PhepChia(x, y);
    sh.min(x,y);
    sh.loofFor();
    sh.loofDoWhile();
    sh.loofWhile();  
}
}
