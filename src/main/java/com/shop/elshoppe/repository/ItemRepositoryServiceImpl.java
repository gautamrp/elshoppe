package com.shop.elshoppe.repository;

import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.elshoppe.exception.ResourceNotFoundException;
import com.shop.elshoppe.model.Item;
import com.shop.elshoppe.model.ItemView;

@Transactional
@Service("itemRepositoryServiceImpl")
public class ItemRepositoryServiceImpl implements IItemRepositoryService{
	
	private static final Logger logger = LoggerFactory.getLogger(ItemRepositoryServiceImpl.class);

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> findAll() {
		logger.info("Inside ItemRepositoryServiceImpl findAll : Reterive all items");
		return itemRepository.findAll();
	}
	
	@Override
	public Item findById(Integer itemid) {
		logger.info("Inside ItemRepositoryServiceImpl findById : Reterive item info for :" +itemid);

		Item item = itemRepository.findById(itemid).orElseThrow(
						() -> new ResourceNotFoundException("Item", "id", new Integer(itemid))
		          	);
		
		return item;
	}

	@Override
	public void deleteById(Integer itemid) {
		logger.info("Inside ItemRepositoryServiceImpl deleteBtId : Delete item info for :" +itemid);
		itemRepository.deleteById(itemid);
	}

	@Override
	public Page<Item> findAllByPage(Pageable pageable) {
		logger.info("Inside ItemController getAllItems : Reterive items for page :" +pageable.getPageNumber());
		return itemRepository.findAll(pageable);
	}

	@Override
	public boolean addItem(ItemView itemView) {
		logger.info("Inside ItemRepositoryServiceImpl addItem : Add new item with Item name : "
				+itemView.getItemname() 
				+" Item price :" +itemView.getPrice() 
				+" Available :" +itemView.getAvailable()
				+" Image : " +itemView.getImage());
		
		Item item = new Item();
		item.setItemName(itemView.getItemname());
		item.setAvailable(itemView.getAvailable());
		item.setPrice(itemView.getPrice());
		item.setImage(Paths.get(itemView.getImage()).getFileName().toString());
		item.setCreatedBy("ADMIN");
		item.setCreationDate(new Timestamp(System.currentTimeMillis()));
		itemRepository.save(item);
		return true;
	}
}
