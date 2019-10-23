package com.educandoweb.curso.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.curso.dto.PaymentDTO;
import com.educandoweb.curso.entities.Payment;
import com.educandoweb.curso.repositories.PaymentRepository;
import com.educandoweb.curso.services.excceptions.ResourceNotFoundExcception;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	public List<PaymentDTO> findAll() {
		List<Payment> list =repository.findAll();
		return list.stream().map(e -> new PaymentDTO(e)).collect(Collectors.toList());
	}
	
	public PaymentDTO findById(Long id) {
		Optional<Payment> obj = repository.findById(id);
		Payment entity = obj.orElseThrow(() -> new ResourceNotFoundExcception(id));
		return new PaymentDTO(entity);
	}

}