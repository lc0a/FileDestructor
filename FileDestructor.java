/*  
 *   File Destructor
 *   Copyright (C) 2022  LightCloud <3330339585@qq.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

import java.util.*;
import java.io.*;

public class FileDestructor {
	public static void main (String[] args) {
		System.out.print("输入文件名:");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		File infile = new File(filename);
		if (!infile.exists()) {
			System.out.println(String.format("错误: 文件 %s 不存在!", filename));
			System.exit(-1);
		}
		int filelength = (int)infile.length();
		System.out.println("文件大小: " + filelength + " 字节");
		byte[] infilebs = new byte[filelength];
		try{
			FileInputStream fis = new FileInputStream(infile);
			System.out.print(String.format("正在读取文件 %s ...", filename));
			fis.read(infilebs, 0, infilebs.length);
			System.out.print("\n读取文件完成!\n");
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-2);
		}

		System.out.print("每隔多少字节进行一次损坏？");
		int stepLength = Integer.parseInt(scanner.next());
		System.out.print("每次损坏多少个字节？");
		int cbn = Integer.parseInt(scanner.next());

		for (int i = stepLength; i < filelength; i += stepLength){
			for(int offset = 0; offset < cbn; offset++){
				infilebs[i - offset] = (byte)(Math.random() * 256 - 128);
			}
		}

		System.out.print("将损坏后的文件保存到:");
		String outfilename = scanner.next();
		File outfile = new File(outfilename);
		try{
			if(outfile.exists()) {
				System.out.println(String.format("文件 %s 已存在。将覆盖该文件。", outfilename));
				outfile.delete();
			}
			outfile.createNewFile();
			FileOutputStream fos = new FileOutputStream(outfile);
			System.out.print(String.format("正在保存文件 %s ...", outfilename));
			fos.write(infilebs);
			System.out.print("\n保存成功!\n");
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-2);
		}
	}
}