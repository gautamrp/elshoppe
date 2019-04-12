package com.shop.elshoppe.controller;

import java.util.List;

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
	
	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="/items", method = RequestMethod.GET)
    public List<Item> getAllItems(@RequestParam("page") int page) {
		List<Item> items = itemService.findAllByPage(page);
        return items;
    }
	
	@RequestMapping(value="/item/{itemid}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable Integer itemid) {
		Item item = itemService.getItemById(itemid);
        return item;
    }
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ItemView createItem(@RequestBody ItemView item){
		itemService.addItem(item);
		return item;
	}
	
	@RequestMapping(value="/delete/{itemid}", method = RequestMethod.DELETE)
	public boolean deleteItem(@PathVariable Integer itemid){
		itemService.deleteById(itemid);
		return true;
	}
}