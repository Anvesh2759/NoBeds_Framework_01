package com.app.nobeds.genericutility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryListner  implements IAnnotationTransformer
{
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
