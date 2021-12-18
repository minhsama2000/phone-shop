package com.javadev.phoneshop.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.constant.Constant;
import com.javadev.phoneshop.dto.ApiResponse;
import com.javadev.phoneshop.entity.DhBlog;
import com.javadev.phoneshop.model.BlogModel;
import com.javadev.phoneshop.repository.BlogRepository;
import com.javadev.phoneshop.service.BlogService;
import com.javadev.phoneshop.utility.DateUtil;
import com.javadev.phoneshop.utility.FileUtil;
import com.javadev.phoneshop.utility.MapperUtil;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogRepository blogRepository;

	@Override
	public ResponseEntity<ApiResponse> getAll() {
		ApiResponse apiResponse = null;
		List<DhBlog> blogs = null;
		try {
			blogs = blogRepository.findAll();
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", blogs);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", blogs);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> getOne(Integer blogId) {
		ApiResponse apiResponse = null;
		DhBlog blog = null;
		try {
			Optional<DhBlog> optionalBlog = blogRepository.findById(blogId);
			if (optionalBlog.isPresent()) {
				blog = optionalBlog.get();
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}
	
	@Override
	public ResponseEntity<ApiResponse> delete(Integer blogId) {
		ApiResponse apiResponse = null;
		DhBlog blog = null;
		try {
			Optional<DhBlog> optionalBlog = blogRepository.findById(blogId);
			if (optionalBlog.isPresent()) {
				blog = optionalBlog.get();
				blogRepository.delete(blog);
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> updateOne(BlogModel blogModel) {
		ApiResponse apiResponse = null;
		System.out.println(blogModel.toString() + " / " + blogModel.getFile().getOriginalFilename());
		DhBlog blog = null;
		try {
			Optional<DhBlog> optionalBlog = blogRepository.findById(blogModel.getId());
			if (optionalBlog.isPresent()) {
				blog = optionalBlog.get();
				if (!FileUtil.isEmptyUploadFile(blogModel.getFile())) {
					if (!blog.getAvatar().equals(blogModel.getFile().getOriginalFilename())
							&& blog.getAvatar() != null) {
						blog.setAvatar(blogModel.getFile().getOriginalFilename());
						blogModel.getFile().transferTo(
								new File(Constant.ROOT_UPLOAD_BLOG + blogModel.getFile().getOriginalFilename()));
					}
				}
				blog.setUpdatedDate(new Date());
				blogRepository.save(blog);
			}
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> saveOne(BlogModel blogModel) {
		ApiResponse apiResponse = null;
		DhBlog blog = new DhBlog();
		try {
			blog = MapperUtil.convertModelToBlog(blogModel);
			blogModel.getFile()
					.transferTo(new File(Constant.ROOT_UPLOAD_BLOG + blogModel.getFile().getOriginalFilename()));
			blogRepository.save(blog);
			apiResponse = new ApiResponse(200, DateUtil.toStrDate(new Date()), "success", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.ACCEPTED).ok(apiResponse);
		} catch (Exception e) {
			// TODO: handle exception
			apiResponse = new ApiResponse(400, DateUtil.toStrDate(new Date()), "failure", blog);
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST).ok(apiResponse);
		}
	}

	@Autowired
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

}
