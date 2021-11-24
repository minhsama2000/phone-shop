package com.javadev.phoneshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
	private int status;
	private String datetime;
	private String message;
	private Object data;

	public ApiResponse(int status, String datetime, String message, Object data) {
		super();
		this.status = status;
		this.datetime = datetime;
		this.message = message;
		this.data = data;
	}

	private ApiResponse(ApiResponseBuilder builder) {
		this.status = builder.status;
		this.datetime = builder.datetime;
		this.message = builder.message;
		this.data = builder.data;
	}

	public static class ApiResponseBuilder {
		private int status;
		private String datetime;
		private String message;
		private Object data;

		public ApiResponseBuilder setStatus(int status) {
			this.status = status;
			return this;
		}

		public ApiResponseBuilder setDateTime(String datetime) {
			this.datetime = datetime;
			return this;
		}

		public ApiResponseBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiResponseBuilder setData(Object data) {
			this.data = data;
			return this;
		}

		public ApiResponse build() {
			return new ApiResponse(this);
		}

	}

}
