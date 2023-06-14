package in.suresh.client;

import in.suresh.dao.ProductDAO;
import in.suresh.dao.ProductDAOImpl;

public class TestApp {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAOImpl();

		/*
		 * ProductEntity p1 = new ProductEntity(); p1.setProductId(102);
		 * p1.setProductName("Mouse"); p1.setPrice(650.00); dao.saveProduct(p1);
		 */

		/*
		 * ProductEntity productById = dao.loadProductById(102);
		 * System.out.println(productById.getProductName());
		 * 
		 */

		/*
		 * ProductEntity updateProduct = dao.updateProduct(101, 50000.00);
		System.out.println(updateProduct.getProductName() + "====" + updateProduct.getPrice());
		*/
		
		dao.deleteProduct(102);
	}
}
