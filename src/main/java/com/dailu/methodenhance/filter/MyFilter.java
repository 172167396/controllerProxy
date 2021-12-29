package com.dailu.methodenhance.filter;

import com.dailu.methodenhance.annotation.ValidAuth;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyFilter implements TypeFilter {
	/**
	 * metadataReader:读取到的当前正在扫描的类的信息 
	 * metadataReaderFactory：可以获取到其他任何类信息
	 */
	@SneakyThrows
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
//		// 获取当前类注解信息(当前类指componentScan指定扫描的类,)
//		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前正在扫描的类的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		Class<?> aClass = Class.forName(classMetadata.getClassName());
		return Arrays.stream(aClass.getDeclaredMethods()).anyMatch(m -> m.isAnnotationPresent(ValidAuth.class));

//		// 获取当前类的资源(类的路径)
//		Resource resource = metadataReader.getResource();
//		// 获取类名
//		String className = classMetadata.getClassName();
//		// 测试，类名包含"service"就返回true
//		if (className.contains("service")) {
//			return true;
//		}
//		return false;
	}
 
}