package com.enterprise.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.enterprise.accounts.dto.CardsDto;

@FeignClient(name="cards", url = "http://cards:9000", fallback = CardsFallBack.class)
public interface CardsFeignClient {

	@GetMapping(value="/api/fetch", consumes = "application/json")
	public ResponseEntity<CardsDto> fetchCardDetails(@RequestHeader("entailment-correlation-id") 
				String correlationId, @RequestParam String mobileNumber);
}
