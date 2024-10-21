package com.Finance.Tracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Finance.Tracker.entities.Category;
import com.Finance.Tracker.repository.CategoryRepo;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepo;
	
	@PostMapping("/addCategory")
	public void addCategory(@RequestBody Category  category)
	{
		categoryRepo.saveCategory(category);
	}
	
	@PutMapping("/addTransToCategory/{trans_id}/{cat_id}")
	public void addTransToCategory(@PathVariable Long trans_id, @PathVariable Long cat_id)
	{
		categoryRepo.addTransactionToCategory(trans_id, cat_id);
	}
	
}
