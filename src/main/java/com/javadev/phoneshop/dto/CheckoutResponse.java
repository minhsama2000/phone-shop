package com.javadev.phoneshop.dto;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import com.javadev.phoneshop.constant.Constant;
import com.javadev.phoneshop.exceptions.UnknownPaymentMethodException;

import java.util.Date;
import java.util.Objects;

@Getter
public class CheckoutResponse {
	private final Integer r;
	private final String msg;
	private final Integer type;
	private final String payUrl;
	private final String date;

	public CheckoutResponse(Builder builder) {
		this.r = builder.r;
		this.msg = builder.msg;
		this.type = builder.type;
		this.payUrl = builder.payUrl;
		date = (new Date()).toString();
	}

	public static class Builder {
		private Integer r;
		private String msg;
		private Integer type;
		private String payUrl;

		public Builder withRes(Integer r) {
			this.r = r;
			return this;
		}

		public Builder withMsg(String msg) {
			this.msg = msg;
			return this;
		}

		public Builder withType(Integer type) throws UnknownPaymentMethodException {
			Constant.PaymentMethod paymentMethod = Constant.PaymentMethod.getFromEnum(type);
			if (Objects.isNull(paymentMethod)) {
				throw new UnknownPaymentMethodException("Payment method is not supported");
			}
			this.type = type;
			return this;
		}

		public Builder withPayUrl(String payUrl) {
			this.payUrl = payUrl;
			return this;
		}

		public CheckoutResponse build() {
			return new CheckoutResponse(this);
		}
	}

	public static CheckoutResponse getSuccessMomoResponseWithPayUrl(String payUrl) {
		try {
			return new CheckoutResponse.Builder().withRes(0).withMsg("ok")
					.withType(Constant.PaymentMethod.MOMO.getType()).withPayUrl(payUrl).build();
		} catch (Exception ex) {
		}
		return null;
	}

	public static CheckoutResponse getSuccessCodResponse() {
		try {
			return new CheckoutResponse.Builder().withRes(0).withMsg("ok")
					.withType(Constant.PaymentMethod.COD.getType()).withPayUrl(StringUtils.EMPTY).build();
		} catch (Exception ex) {
		}
		return null;
	}
}
