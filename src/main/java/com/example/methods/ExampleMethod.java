/*
 * Divroll, Platform for Hosting Static Sites
 * Copyright 2019-present Divroll, and individual contributors
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

import com.divroll.backend.customcode.method.CustomCodeMethod;
import com.divroll.backend.customcode.rest.CustomCodeRequest;
import com.divroll.backend.customcode.rest.CustomCodeResponse;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExampleMethod implements CustomCodeMethod {

	@Override
	public String getMethodName() {
		return "example";
	}

	@Override
	public List<String> getParams() {
		return new LinkedList<>();
	}

	@Override

	public CustomCodeResponse execute(CustomCodeRequest customCodeRequest) {
		Map map = new LinkedHashMap();
		String message = customCodeRequest.getParams().get("message");
		String body = customCodeRequest.getStringBody();
		map.put("message", message);
		map.put("body", body);
		CustomCodeResponse result = new CustomCodeResponse(200, map);
		return result;
	}

}