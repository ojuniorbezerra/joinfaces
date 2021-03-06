/*
 * Copyright 2016-2017 the original author or authors.
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

package org.joinfaces.autoconfigure.test;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Lars Grefer
 */
@ConfigurationProperties("joinfaces.test")
@Getter
@Setter
public class TestProperties {

	private List<String> listA = new ArrayList<>();
	private List<String> listB = new ArrayList<>();
	private List<String> listC = new ArrayList<>();
	private List<String> listD = new ArrayList<>();

	private Class<? extends CharSequence> charSequenceClass;
	private Class<?> randomClass;

	private List<Class<?>> classList;

}
