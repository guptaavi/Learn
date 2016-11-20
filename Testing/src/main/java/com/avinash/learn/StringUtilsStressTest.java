package com.avinash.learn;

import java.io.Serializable;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class StringUtilsStressTest extends AbstractJavaSamplerClient implements Serializable {

	private static final String ARG1_TAG = "inputStr";

	private static final long serialVersionUID = -4537358620199171581L;

	@Override
	public Arguments getDefaultParameters() {
		Arguments defaultParameters = new Arguments();
		defaultParameters.addArgument(ARG1_TAG, "Avinash");

		return defaultParameters;
	}

	@Override
	public SampleResult runTest(JavaSamplerContext javaSamplerContext) {

		SampleResult sampleResult = new SampleResult();
		sampleResult.sampleStart();

		try {
			String message = StringUtils.reverse(javaSamplerContext.getParameter("inputStr"));
			sampleResult.sampleEnd();
			sampleResult.setSuccessful(Boolean.TRUE);
			sampleResult.setResponseCodeOK();
			sampleResult.setResponseMessage(message);
		} catch (Exception e) {
			sampleResult.sampleEnd();
			sampleResult.setResponseMessage(e.getMessage());
			sampleResult.setSuccessful(Boolean.FALSE);
		}

		return sampleResult;
	}

}
