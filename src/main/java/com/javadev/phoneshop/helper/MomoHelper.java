package com.javadev.phoneshop.helper;

import com.mservice.shared.sharedmodels.Environment;
import com.mservice.shared.sharedmodels.PartnerInfo;

public class MomoHelper {
	  private MomoHelper() {
	    }

	    // test env only
	    public static Environment getMomoEnvironment() {
	        PartnerInfo partnerInfo = new PartnerInfo("MOMOFI0D20211216", "xoBsZPJrArYUxvjY", "CUaixIC7rjpqp1zrCU5IOHv1HgpOE3fz");
	        return new Environment("https://test-payment.momo.vn/gw_payment/transactionProcessor", partnerInfo, Environment.EnvTarget.DEV);
	    }
}
