package com.javadev.phoneshop.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javadev.phoneshop.constant.Constant;
import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhCategory;
import com.javadev.phoneshop.entity.DhProduct;
import com.javadev.phoneshop.model.DhProductModel;
import com.javadev.phoneshop.repository.CategoryRepository;
import com.javadev.phoneshop.repository.ProductRepository;
import com.javadev.phoneshop.service.ProductService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.FileUtil;
import com.javadev.phoneshop.utility.MapperUtil;
import com.javadev.phoneshop.utility.StringUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<ApiResponse> findAll() {
		List<DhProduct> listDhProducts = null;
		ApiResponse apiResponse = null;
		try {
			listDhProducts = productRepository.findAll();
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}
	
	@Override
	public ResponseEntity<ApiResponse> findLimitDesc(int limit) {
		List<DhProduct> listDhProducts = null;
		ApiResponse apiResponse = null;
		try {
			listDhProducts = productRepository.findByNew(limit);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}
	
	@Override
	public ResponseEntity<ApiResponse> findRandom(int limit) {
		List<DhProduct> listDhProducts = null;
		ApiResponse apiResponse = null;
		try {
			listDhProducts = productRepository.findByRandom(limit);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}
	
	@Override
	public ResponseEntity<ApiResponse> findAllById(Integer id, int limit) {
		List<DhProduct> listDhProducts = null;
		ApiResponse apiResponse = null;
		try {
			listDhProducts = productRepository.findAllById(id,limit);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", listDhProducts);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> getOne(Integer id) {
		DhProduct dhProduct = null;
		ApiResponse apiResponse = null;
		try {
			dhProduct = productRepository.findById(id).get();
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhProduct);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhProduct);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}
	
	@Override
	public ResponseEntity<ApiResponse> delete(Integer id) {
		DhProduct dhProduct = null;
		ApiResponse apiResponse = null;
		try {
			System.out.println(id);
			productRepository.deleteById(id);
			System.out.println("here");
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", null);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> saveOne(DhProductModel dhProductModel) {
		DhProduct dhProduct = null;
		ApiResponse apiResponse = null;
		try {
			dhProduct = insertProduct(dhProductModel);
			dhProductModel.getFile().transferTo(new File(Constant.ROOT_UPLOAD_PRODUCT + dhProduct.getAvatar()));
			productRepository.save(dhProduct);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhProduct);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhProduct);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> update(DhProductModel dhProductModel) {
		DhProduct dhProduct = dhProduct = updateProduct(dhProductModel);
		ApiResponse apiResponse = null;
		try {
			if (!FileUtil.isEmptyUploadFile(dhProductModel.getFile())) {
				if (!dhProduct.getAvatar().equals(dhProductModel.getFile().getOriginalFilename())) {
					dhProduct.setAvatar(dhProductModel.getFile().getOriginalFilename());
					dhProductModel.getFile().transferTo(
							new File(Constant.ROOT_UPLOAD_PRODUCT + dhProductModel.getFile().getOriginalFilename()));
				}
			}
			productRepository.save(dhProduct);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", dhProduct);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", dhProduct);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	public DhProduct insertProduct(DhProductModel dhProductModel) {
		DhProduct dhProduct = new DhProduct();
		Optional<DhCategory> optionalDhCategory = categoryRepository.findById(dhProductModel.getCategoryId());
		optionalDhCategory.ifPresent(dhProduct::setCategory);
		dhProduct.setColor(dhProductModel.getColor());
		dhProduct.setName(dhProductModel.getName());
		dhProduct.setAvailable(dhProductModel.getAvailable());
		dhProduct.setPrice(dhProductModel.getPrice());
		dhProduct.setStorage(dhProductModel.getStorage());
		dhProduct.setSeo(StringUtil.seo(dhProductModel.getName()) + "-" + System.currentTimeMillis());
		dhProduct.setCreatedDate(new Date());
		dhProduct.setDetailDescription(dhProductModel.getDetailDescription());
		dhProduct.setAvatar(dhProductModel.getFile().getOriginalFilename());
		return dhProduct;
	}

	public DhProduct updateProduct(DhProductModel dhProductModel) {
		DhProduct dhProduct = new DhProduct();

		Optional<DhProduct> optionalProduct = productRepository.findById(dhProductModel.getId());
		if (optionalProduct.isPresent()) {
			dhProduct = productRepository.findById(dhProductModel.getId()).get();
		}
		Optional<DhCategory> optionalDhCategory = categoryRepository.findById(dhProductModel.getCategoryId());
		optionalDhCategory.ifPresent(dhProduct::setCategory);
		dhProduct.setColor(dhProductModel.getColor());
		dhProduct.setName(dhProductModel.getName());
		dhProduct.setAvailable(dhProductModel.getAvailable());
		dhProduct.setPrice(dhProductModel.getPrice());
		dhProduct.setStorage(dhProductModel.getStorage());
		dhProduct.setSeo(StringUtil.seo(dhProductModel.getName()) + "-" + System.currentTimeMillis());
		dhProduct.setUpdatedDate(new Date());
		dhProduct.setDetailDescription(dhProductModel.getDetailDescription());
		return dhProduct;
	}
}
