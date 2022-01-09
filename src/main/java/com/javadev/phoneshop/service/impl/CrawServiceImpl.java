package com.javadev.phoneshop.service.impl;

import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.javadev.phoneshop.constant.Constant;
import com.javadev.phoneshop.dto.CrawProduct;
import com.javadev.phoneshop.service.CrawService;

@Service
public class CrawServiceImpl implements CrawService {

	private CrawService crawService;
	
	public Optional<CrawProduct> crawProductTGDD(String productName) {
		Optional<CrawProduct> optional = Optional.empty();
		CrawProduct crawProduct = null;
		try {
			Document document = Jsoup.connect(Constant.URL_FIND_PRODUCT_TGDD + productName).get();
			crawProduct = new CrawProduct();
			Elements elements = document.getElementsByClass("listsearch lowerProduct item2020 listproduct");
			Elements li = elements.get(0).getElementsByTag("li");
			Elements a = li.get(1).getElementsByTag("a");
			Elements div = a.get(0).getElementsByTag("div");
			Elements img = div.get(1).getElementsByTag("img");
			crawProduct.setName(a.get(0).attr("data-name"));
			crawProduct.setPrice(a.get(0).attr("data-price"));
			crawProduct.setUrl("https://www.thegioididong.com"+a.get(0).attr("href"));
			crawProduct.setAvatar(img.get(0).attr("data-src"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return optional.of(crawProduct);
	}

	public Optional<CrawProduct> crawProductFPT(String productName) {
		Optional<CrawProduct> optional = Optional.empty();
		CrawProduct crawProduct = null;
		String url = Constant.URL_FIND_PRODUCT_FPT + productName;
		try {
			Document document = Jsoup.connect(url).get();
			crawProduct = new CrawProduct();
			Elements elements = document.getElementsByClass("cdt-product");
			System.out.println(elements);
			Elements a = elements.get(0).getElementsByTag("a");
			Elements div = a.get(0).getElementsByTag("tcdm text-left");
			Elements price = div.get(0).getElementsByClass("price");
			Elements img = a.get(0).getElementsByTag("img");
			crawProduct.setName(productName);
			crawProduct.setPrice(price.text());
			crawProduct.setUrl(a.get(0).attr("href"));
			crawProduct.setAvatar(img.get(0).attr("src"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return optional.of(crawProduct);
	}
	
	public Optional<CrawProduct> crawProductCELLPHONE(String productName) {
		Optional<CrawProduct> optional = Optional.empty();
		CrawProduct crawProduct = null;
		String url = Constant.URL_FIND_PRODUCT_CELLPHONE + productName;
		try {
			Document document = Jsoup.connect(url).get();
			crawProduct = new CrawProduct();
			Elements elements = document.getElementsByClass("item-product__box-img");
			Elements a = elements.get(0).getElementsByClass("item-product__box-img").get(0).getElementsByTag("a");
			Elements div = a.get(0).getElementsByTag("tcdm text-left");
			Elements price = document.getElementsByClass("special-price");
			Elements img = a.get(0).getElementsByTag("img");
			crawProduct.setName(productName);
			crawProduct.setPrice(price.get(0).text());
			crawProduct.setUrl(a.get(0).attr("href"));
			crawProduct.setAvatar(img.get(0).attr("data-src"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return optional.of(crawProduct);
	}
	
	public Optional<CrawProduct> crawProductHH(String productName) {
		Optional<CrawProduct> optional = Optional.empty();
		CrawProduct crawProduct = null;
		String url = Constant.URL_FIND_PRODUCT_HOANGHA + productName;
		try {
			Document document = Jsoup.connect(url).get();
			crawProduct = new CrawProduct();
			Elements elements = document.getElementsByClass("col-content lts-product");
			Elements item = elements.get(0).getElementsByClass("item");
			Elements price = item.get(0).getElementsByClass("info").get(0).getElementsByClass("price");
			Elements img = item.get(0).getElementsByClass("img");	
			crawProduct.setName(productName);
			crawProduct.setPrice(price.get(0).getElementsByTag("strong").text());
			crawProduct.setUrl("https://hoanghamobile.com/"+img.get(0).getElementsByTag("a").get(0).attr("href"));
			crawProduct.setAvatar(img.get(0).getElementsByTag("a").get(0).getElementsByTag("img").attr("src"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return optional.of(crawProduct);
	}

	public static void main(String[] args) {
		CrawServiceImpl crawServiceImpl = new CrawServiceImpl();
		System.out.println(crawServiceImpl.crawProductTGDD("Điện%20thoại%20Samsung%20Galaxy%20Z%20Fold3%205G%20256GB").toString());

	}

}
