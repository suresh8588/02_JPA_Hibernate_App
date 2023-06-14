package in.suresh.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import in.suresh.entity.ProductEntity;

public class ProductDAOImpl implements ProductDAO {

	private EntityManagerFactory factory;

	public ProductDAOImpl() {
		factory = Persistence.createEntityManagerFactory("test");
	}

	@Override
	public ProductEntity saveProduct(ProductEntity product) {

		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(product);
			tx.commit();
			System.out.println("Product is inserted to the Database....");
		} catch (Exception ex) {
			tx.rollback();
			System.out.println("Error in inserting a product...." + ex);
		} finally {
			entityManager.close();
		}

		return product;
	}

	@Override
	public ProductEntity loadProductById(Integer productId) {

		EntityManager entityManager = factory.createEntityManager();
		ProductEntity p = entityManager.find(ProductEntity.class, productId);
		entityManager.close();
		return p;
	}

	@Override
	public ProductEntity updateProduct(Integer productId, Double price) {

		EntityManager em = factory.createEntityManager();
		ProductEntity product = em.find(ProductEntity.class, productId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		product.setPrice(price);
		tx.commit();
		em.close();
		return product;
	}

	@Override
	public void deleteProduct(Integer productId) {

		EntityManager em = factory.createEntityManager();
		ProductEntity product = em.find(ProductEntity.class, productId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(product);
		//System.out.println(productId + " is deleted");
		tx.commit();
		em.close();

	}

}
