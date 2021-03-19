package com.mycompany.jv30_project_final.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.jv30_project_final.entities.CategoryEntity;
import com.mycompany.jv30_project_final.entities.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
	
	@Query(value = "select * from product p "
			+ "order by p.publish_date desc "
			+ "limit 4", nativeQuery = true)
	public List<ProductEntity> getNewProducts();
	
	
	@Query(value = "select p.id, p.day_of_sale, p.brand ,p.hard_driver,p.name,p.price,p.proteted_time,p.publish_date,p.resolution,p.screen_size,p.status,p.support_maximun_ram ,p.category_id,p.cpu_id,ram_id,p.description "
			+ "from order_detail o inner join product p "
			+ "on o.product_order_detail_id = p.id "
			+ "group by product_order_detail_id "
			+ "order by sum(quantity) desc "
			+ "limit 5 "
			+ "", nativeQuery = true)
	public List<ProductEntity> getTopSellingProduct();
	
	public List<ProductEntity> findByCategoryEntity(CategoryEntity categoryEntity);
}
