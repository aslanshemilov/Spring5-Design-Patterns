package com.packt.patterninspring.chapter10.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.packt.patterninspring.chapter10.bankapp.model.Account;
import com.packt.patterninspring.chapter10.bankapp.repository.AccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	@Cacheable("accountCache")
	public Account findOne(Long id) {
		System.out.println("findOne called");
		return accountRepository.findOne(id);
	}

	@Override
	@CachePut("accountCache")
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	@Override
	@CacheEvict("accountCache")
	public void remove(Long id) {
		accountRepository.findOne(id);
	}
	
}
