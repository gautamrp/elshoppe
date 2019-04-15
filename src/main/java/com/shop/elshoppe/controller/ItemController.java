package com.shop.elshoppe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.elshoppe.model.Item;
import com.shop.elshoppe.model.ItemView;
import com.shop.elshoppe.service.ItemService;

@RestController
public class ItemController{
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="/items", method = RequestMethod.GET)
    public List<Item> getAllItems(@RequestParam("page") int page) {
		logger.info("Inside ItemController getAllItems : Reterive items for page :" +page);
		List<Item> items = itemService.findAllByPage(page);
        return items;
    }
	
	@RequestMapping(value="/item/{itemid}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable Integer itemid) {
		logger.info("Inside ItemController getItemById : Reterive item info for :" +itemid);
		Item item = itemService.getItemById(itemid);
        return item;
    }
	
	@RequestMapping(value="/add", method = RequestMethod.PUT)
	public ItemView createItem(@RequestBody ItemView item){
		logger.info("Inside ItemController createItem : Creating item with itemName :" +item.getItemname());
		itemService.addItem(item);
		return item;
	}
	
	@RequestMapping(value="/delete/{itemid}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable Integer itemid){
		logger.info("Inside ItemController getItemById : Delete item info for :" +itemid);
		itemService.deleteById(itemid);
		return true;
	}
}