package com.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.pages.BrowserActions;

public class RetryAnalyzer extends BrowserActions implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}
