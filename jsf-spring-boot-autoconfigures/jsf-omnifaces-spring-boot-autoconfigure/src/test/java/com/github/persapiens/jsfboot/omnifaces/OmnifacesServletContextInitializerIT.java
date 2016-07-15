/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.persapiens.jsfboot.omnifaces;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.github.persapiens.jsfboot.JsfClassFactory;

import org.omnifaces.component.output.cache.CacheInitializerListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringApplicationConfiguration(classes = OmnifacesSpringBootAutoConfiguration.class)
@WebAppConfiguration
@Test
public class OmnifacesServletContextInitializerIT extends AbstractTestNGSpringContextTests {

	@Autowired
	private OmnifacesProperties omnifacesProperties;

	private Set<Class<?>> classes;

	@BeforeSuite
	public void setupClasses() {
		OmnifacesServletContextInitializer configuration = new OmnifacesServletContextInitializer(null);

		this.classes = JsfClassFactory.builder()
			.jsfAnnotatedClassFactoryConfiguration(configuration)
			.build().find();
	}

	public void testEmpty() {
		assertThat(this.classes).isEmpty();
	}

	public void testOnStartup() throws ServletException {
		OmnifacesServletContextInitializer omnifacesServletContextInitializer
			= new OmnifacesServletContextInitializer(this.omnifacesProperties);

		ServletContext servletContext = new MockServletContext();

		omnifacesServletContextInitializer.onStartup(servletContext);

		assertThat(servletContext.getInitParameter(CacheInitializerListener.CACHE_PROVIDER_INIT_PARAM_NAME))
			.isEqualTo("myCacheProvider");
	}

	public void testAnotherFacesConfig() throws ServletException {
		OmnifacesServletContextInitializer omnifacesServletContextInitializer
			= new OmnifacesServletContextInitializer(this.omnifacesProperties);

		assertThat(omnifacesServletContextInitializer.getAnotherFacesConfig()).isNull();
	}

	public void testExcludeScopedAnnotations() throws ServletException {
		OmnifacesServletContextInitializer omnifacesServletContextInitializer
			= new OmnifacesServletContextInitializer(this.omnifacesProperties);

		assertThat(omnifacesServletContextInitializer.isExcludeScopedAnnotations()).isTrue();
	}

}