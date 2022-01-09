package com.javadev.phoneshop.service;

import java.util.Optional;

import com.javadev.phoneshop.dto.CrawProduct;

public interface CrawService {
	Optional<CrawProduct> crawProductTGDD(String productName);

	Optional<CrawProduct> crawProductFPT(String productName);

	Optional<CrawProduct> crawProductCELLPHONE(String productName);

	Optional<CrawProduct> crawProductHH(String productName);
}
