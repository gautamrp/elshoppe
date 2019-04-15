package com.shop.elshoppe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shop.elshoppe.exception.InvalidDataException;
import com.shop.elshoppe.model.Item;
import com.shop.elshoppe.model.ItemView;
import com.shop.elshoppe.repository.IItemRepositoryService;

@Service
public class ItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
	
	@Autowired
    IItemRepositoryService itemRepositoryService;
	
	public List<Item> getAllItems(){
		logger.info("Inside ItemService getAllItems : Reterive all items");
		List<Item> items = itemRepositoryService.findAll();
		return items;
	}
	
	public Item getItemById(Integer itemid){
		logger.info("Inside ItemService getItemById : Reterive item details for : " +itemid);
		Item item = itemRepositoryService.findById(itemid);
		return item;
	}
	
	public void deleteById(Integer itemid){
		logger.info("Inside ItemService deleteById : Delete item details for : " +itemid);
		itemRepositoryService.deleteById(itemid);
	}
	
	public List<Item> findAllByPage(int page) {
		logger.info("Inside ItemService findAllByPage : Reterive items details for page : " +page);
		
		if(page < 1){
			throw new InvalidDataException("Item", "Page");
		}
		
		List<Item> items  = new ArrayList<Item>();
		PageRequest pageable = PageRequest.of(page - 1, 10, Sort.by("creationDate").descending());
		Page<Item> pageItem = itemRepositoryService.findAllByPage(pageable);
		for(Item item : pageItem){
			items.add(item);
		}
		
		return items;
	}
	
	public boolean addItem(ItemView itemView){
		logger.info("Inside ItemService addItem : Add new item with Item name : "
							+itemView.getItemname() 
							+" Item price :" +itemView.getPrice() 
							+" Available :" +itemView.getAvailable()
							+" Image : " +itemView.getImage());
		
		if(null == itemView.getItemname() || itemView.getItemname().equals("")){
			throw new InvalidDataException("Item", "ItemName");
		}
		
		if(null == itemView.getAvailable() || !(itemView.getAvailable().equals("Yes") || itemView.getAvailable().equals("No"))){
			throw new InvalidDataException("Item", "Available");
		}
		
		if(null == itemView.getItemname() || itemView.getImage().equals("")){
			throw new InvalidDataException("Item", "Image");
		}
		
		itemRepositoryService.addItem(itemView);
		return true;
		
	}
}
