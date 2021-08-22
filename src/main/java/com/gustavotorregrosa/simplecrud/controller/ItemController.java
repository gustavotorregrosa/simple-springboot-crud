package com.gustavotorregrosa.simplecrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavotorregrosa.simplecrud.entity.Item;
import com.gustavotorregrosa.simplecrud.repository.ItemRepository;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
	
	private ItemRepository itemRepository;
	
	public ItemController(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}
	
	@GetMapping
	public List<Item> getAll() {
		
		List<Item> resultado = new ArrayList<Item>();
		resultado = this.itemRepository.findAll();
		return resultado;
		
	}
	
	@PostMapping
	public Item save(@RequestBody Item item) {
	itemRepository.save(item);
	return item;
	}
	
	@DeleteMapping(path ="/{id}")
	public Item delete(@PathVariable Integer id){
		try {
			Item item = this.itemRepository.getById(id);
			this.itemRepository.delete(item);
			return item;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping(path = "/{id}")
	public Item getById(@PathVariable Integer id) {
		try {
			Item item = this.itemRepository.findById(id).get();
			return item;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	@PutMapping(value = "/{id}")
	public Item update(@PathVariable Integer id, @RequestBody Item newItem) {
		try {
			Item item = this.itemRepository.findById(id).get();
			item.setDescricao(newItem.getDescricao());
			this.itemRepository.save(item);
			return item;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
			
		}
	}
	

}
