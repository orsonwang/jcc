/**
 * Copyright 2011 Joe Choi, All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package taobe.tec.jcc;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Joe Choi
 */
public class JChineseConvertorTest {
	@Before public void setup() throws IOException {
		conv = JChineseConvertor.getInstance();
	}

	@Test public void testConvertU554A() {
		char tc = '\u554A';
		char sc = '\u554A';
		testConvert(tc, sc);
	}
	
	@Test public void testConvertU8A9E() {
		char tc = '\u8A9E';
		char sc = '\u8BED';
		testConvert(tc, sc);
	}
	
	@Test public void testConvertU9F44() {
		char tc = '\u9F47';
		char sc = '\u9F44';
		testConvert(tc, sc);
	}
	
	@Test public void testConvertU796A() {
		char tc = '\u769A';
		char sc = '\u7691';
		testConvert(tc, sc);
	}	
	
	@Test public void testConvertNonChinese() {
		char a = 'A';
		
		Assert.assertEquals("fail to convert A with t2s method", 'A', conv.t2s(a).charValue());
		Assert.assertEquals("fail to convert A with s2t method", 'A', conv.s2t(a).charValue());
	}
	
	private void testConvert(char tc, char sc) {
		Assert.assertEquals("fail to convert Traditional to Simplified" , 
				(Character) sc, (Character) conv.t2s(tc));
		Assert.assertEquals("fail to convert Simplified to Traditional", 
				(Character) tc, (Character) conv.s2t(sc));		
	}
	
	private JChineseConvertor conv;
}
