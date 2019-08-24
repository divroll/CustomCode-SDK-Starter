/*
 * Divroll, Platform for Hosting Static Sites
 * Copyright 2019-present, Divroll, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.example.methods;

import com.divroll.backend.customcode.MethodVerb;
import com.divroll.backend.customcode.method.CustomCodeMethod;
import com.divroll.backend.customcode.rest.CustomCodeRequest;
import com.divroll.backend.customcode.rest.CustomCodeResponse;
import com.google.gson.Gson;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestExampleMethod extends TestCase {

	public TestExampleMethod(String testName ) {
		super( testName );
	}

	public static Test suite() {
		return new TestSuite( TestExampleMethod.class );
	}

	public void testExampleMethod() {
		CustomCodeMethod method = new ExampleMethod();
		Map<String, String> params = new LinkedHashMap<String, String>();

		params.put("message", "hello world");
		InputStream targetStream = new ByteArrayInputStream("This is an example CustomCode method".getBytes());
		CustomCodeRequest proccessedRequest = new CustomCodeRequest
				(MethodVerb.GET, "/example", params, targetStream, "example", 0L);
		CustomCodeResponse response = method.execute(proccessedRequest);
		System.out.println(new Gson().toJson(response.getResponseMap()));
	}

}
