package com.shop.elshoppe.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shop.elshoppe.model.Item;
import com.shop.elshoppe.model.ItemView;

public interface IItemRepositoryService {
	public List<Item> findAll();
	
	public Item findById(Integer itemid);
	
	public void deleteBtId(Integer itemid);
	
	public Page<Item> findAllByPage(Pageable pageable);
	
	public boolean addItem(ItemView itemView);
}
