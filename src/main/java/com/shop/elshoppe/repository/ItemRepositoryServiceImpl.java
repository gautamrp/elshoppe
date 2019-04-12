package com.shop.elshoppe.repository;

import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.elshoppe.model.Item;
import com.shop.elshoppe.model.ItemView;

@Transactional
@Service("itemRepositoryServiceImpl")
public class ItemRepositoryServiceImpl implements IItemRepositoryService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	
	@Override
	public Item findById(Integer itemid) {
		return itemRepository.findById(itemid).get();
	}

	@Override
	public void deleteBtId(Integer itemid) {
		itemRepository.deleteById(itemid);
	}

	@Override
	public Page<Item> findAllByPage(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}

	@Override
	public boolean addItem(ItemView itemView) {
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
