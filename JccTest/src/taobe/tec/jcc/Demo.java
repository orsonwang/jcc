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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import taobe.tec.jcc.JChineseConvertor;

/**
 * @author Joe Choi
 */
public class Demo {
	public static void main(String[] args) throws Exception {
		// Get a JChineseConvertor instance  
		JChineseConvertor jcc = JChineseConvertor.getInstance();
		
		BufferedReader in = new BufferedReader(
			new InputStreamReader(new FileInputStream("res/description.txt"), "UTF-8")
		);
		
		BufferedWriter out = new BufferedWriter(
			new OutputStreamWriter(new FileOutputStream("res/description-sc.txt"), "UTF-8")
		);
		
		String line = "";
		while((line = in.readLine()) != null) {
			// Convert a line to Simplified Chinese
			out.write(jcc.t2s(line));
			out.write(System.getProperty("line.separator"));
		}
		out.flush();
		
		in.close();
		out.close();
	}	
}
