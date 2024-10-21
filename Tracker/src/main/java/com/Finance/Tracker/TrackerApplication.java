package com.Finance.Tracker;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Finance.Tracker.entities.Category;
import com.Finance.Tracker.entities.CurrentBalance;
import com.Finance.Tracker.entities.Transactions;
import com.Finance.Tracker.entities.User;
import com.Finance.Tracker.repository.CategoryRepo;
import com.Finance.Tracker.repository.CurrentBalanceRepo;
import com.Finance.Tracker.repository.TransactionRepo;
import com.Finance.Tracker.repository.UserRepo;

@SpringBootApplication
public class TrackerApplication implements CommandLineRunner {	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CategoryRepo car;
	public static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
     	userRepo.deleteUser(10001L);
	}
	
}
