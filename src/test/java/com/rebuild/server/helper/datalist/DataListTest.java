/*
rebuild - Building your business-systems freely.
Copyright (C) 2019 devezhao <zhaofang123@gmail.com>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package com.rebuild.server.helper.datalist;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rebuild.server.TestSupport;
import com.rebuild.server.configuration.portals.DataListManager;
import com.rebuild.server.service.bizz.UserService;

/**
 * @author zhaofang123@gmail.com
 * @since Jan 6, 2019
 */
public class DataListTest extends TestSupport {

	private static JSONObject queryExpr = null;
	static {
		queryExpr = JSON.parseObject("{ entity:'User' }");
		JSON fields = JSON.parseArray("[ 'userId', 'loginName', 'createdOn', 'createdBy', 'createdBy.fullName', 'modifiedBy.fullName' ]");
		queryExpr.put("fields", fields);
		JSON filter = JSON.parseObject("{ entity:'User', type:'QUICK', values:{ 1:'admin' } }");
		queryExpr.put("filter", filter);
		queryExpr.put("sort", "createdOn:desc");
		queryExpr.put("pageNo", 1);
		queryExpr.put("pageSize", 100);
	}
	
	@Test
	public void testQueryParser() throws Exception {
		QueryParser queryParser = new QueryParser(queryExpr);
		System.out.println(queryParser.toSql());
		System.out.println(queryParser.toCountSql());
	}
	
	@Test
	public void testQuery() throws Exception {
		DataList dlc = new DefaultDataList(queryExpr, UserService.ADMIN_USER);
		System.out.println(dlc.getJSONResult());
	}
	
	@Test
	public void testJoinFields() throws Exception {
		QueryParser queryParser = new QueryParser(queryExpr);
		System.out.println(queryParser.getQueryJoinFields());
	}
	
	@Test
	public void testColumnLayout() throws Exception {
		JSON layout = DataListManager.instance.getColumnLayout("Account999", SIMPLE_USER);
		System.out.println(layout);
	}
}
