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

package org.joinfaces.autoconfigure.mojarra;

import java.util.EventListener;

import javax.servlet.ServletRegistration;

import org.mockito.Mockito;

import org.springframework.mock.web.MockServletContext;

public class MojarraMockServletContext extends MockServletContext {

	@Override
	public ServletRegistration.Dynamic addServlet(String servletName, String className) {
		return Mockito.mock(ServletRegistration.Dynamic.class);
	}

	@Override
	public void addListener(Class<? extends EventListener> listenerClass) {
	}

}
