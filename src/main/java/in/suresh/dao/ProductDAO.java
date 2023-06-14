package in.suresh.dao;

import in.suresh.entity.ProductEntity;

public interface ProductDAO {

	public ProductEntity saveProduct(ProductEntity product);

	public ProductEntity loadProductById(Integer productId);

	public ProductEntity updateProduct(Integer productId, Double price);

	public void deleteProduct(Integer productId);
}
