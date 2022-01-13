package com.javadev.phoneshop.helper;

import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.PartnerInfo;

public class MomoHelper {
	private MomoHelper() {
	}

	// test env only
	public static Environment getMomoEnvironment() {
		PartnerInfo partnerInfo = new PartnerInfo("MOMO8PAQ20211227", "H9RTMWPb5GxqwDRQ",
				"USucVNLp8X8Z6aMiLU2CoSVp0wzmsPFX");
		return new Environment("https://test-payment.momo.vn/gw_payment/transactionProcessor", partnerInfo,
				Environment.EnvTarget.DEV);
	}
}
