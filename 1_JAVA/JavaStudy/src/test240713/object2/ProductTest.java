package test240713.object2;
import java.util.Scanner;
public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명 : ");
		String name = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("수량 : ");
		int quantity = sc.nextInt();
		Product pd = new Product(name,price,quantity);
		String[] arr = pd.information().split(",");
		System.out.println("상품명 : "+arr[0]);
		System.out.println("가격 : "+arr[1]+"원");
		System.out.println("수량 : "+arr[2]+"개");
		System.out.println("총 구매 가격 : "+(pd.getPrice()*pd.getQuantity())+"원");
	}

}
