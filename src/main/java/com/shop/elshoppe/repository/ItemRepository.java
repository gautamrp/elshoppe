package com.shop.elshoppe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.elshoppe.model.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("SELECT item FROM Item item")
	public List<Item> findAll();
	
	@Query(value="SELECT * FROM elshoppe.item where itemid = ?0", nativeQuery=true)
	public Optional<Item> findById(int itemId);

	@Transactional
	@Modifying
	@Query(value="DELETE FROM elshoppe.item where itemid = ?0", nativeQuery=true)
	public boolean deleteById(int itemid);
	
	public Page<Item> findAll(Pageable pageable);
	
}
