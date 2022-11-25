package borrower;

import java.util.List;

public class ProduceTest {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		ProduceDAO dao = new ProduceDAO();
		List<Produce> result = dao.findAll();
		
		if(result != null) {
			System.out.println("test:成功");
		} else {
			System.out.println("test:失敗");
		}
	}
}
