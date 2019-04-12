package com.shop.elshoppe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.elshoppe.model.Item;
import com.shop.elshoppe.model.ItemView;
import com.shop.elshoppe.repository.IItemRepositoryService;

@Service
public class ItemService {
	@Autowired
    IItemRepositoryService itemRepositoryService;
	
	public List<Item> getAllItems(){
		List<Item> items = itemRepositoryService.findAll();
		return items;
	}
	
	public Item getItemById(Integer itemid){
		System.out.println("Itemid :" +itemid);
		Item item = itemRepositoryService.findById(itemid);
		return item;
	}
	
	public void deleteById(Integer itemid){
		System.out.println(" itemid:" +itemid);
		itemRepositoryService.deleteBtId(itemid);
	}
	
	public List<Item> findAllByPage(int page) {
		System.out.println(" page:" +page);
		List<Item> items  = new ArrayList<Item>();
		PageRequest pageable = PageRequest.of(page - 1, 10, Sort.by("creationDate").descending());
		Page<Item> pageItem = itemRepositoryService.findAllByPage(pageable);
		for(Item item : pageItem){
			items.add(item);
		}
		
		return items;
	}
	
	public boolean addItem(ItemView itemView){
		System.out.println("Item name:" +itemView.getItemname() 
							+" Item price :" +itemView.getPrice() 
							+" Available :" +itemView.getAvailable()
							+" Image : " +itemView.getImage());
		itemRepositoryService.addItem(itemView);
		return true;
		
	}
}
