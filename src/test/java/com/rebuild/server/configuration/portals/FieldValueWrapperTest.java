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

package com.rebuild.server.configuration.portals;

import cn.devezhao.persist4j.engine.ID;
import com.rebuild.server.TestSupport;
import com.rebuild.server.helper.cache.NoRecordFoundException;
import org.junit.Test;

/**
 * @author devezhao zhaofang123@gmail.com
 * @since 2019/05/22
 */
public class FieldValueWrapperTest extends TestSupport {

	@Test
	public void testGetLabel() throws Exception {
		System.out.println(FieldValueWrapper.getLabel(SIMPLE_USER));
	}
	
	@Test(expected = NoRecordFoundException.class)
	public void testGetLabelThrow() throws Exception {
		System.out.println(FieldValueWrapper.getLabel(ID.newId(1)));
	}
}
