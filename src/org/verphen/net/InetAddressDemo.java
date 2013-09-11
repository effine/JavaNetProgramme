/**
 * @author VerpHen
 * @date 2013年9月11日  下午3:39:24
 */

package org.verphen.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*演示InetAddress类的基本使用*/
public class InetAddressDemo {
	public static void main(String[] args) {

		try {
			/* 使用域名创建对象 */
			InetAddress inet1 = InetAddress.getByName("www.163.com");

			System.out.println("域名对象：" + inet1);

			/* 使用IP创建对象 */
			InetAddress inet2 = InetAddress.getByName("127.0.0.1");
			System.out.println("使用IP创建对象：" + inet2);

			/* 获得本机地址对象 */
			InetAddress inet3 = InetAddress.getLocalHost();
			System.out.println("获得本机地址对象：" + inet3);

			/* 获取对象中的域名 */
			String host = inet3.getHostName();
			System.out.println("域名：" + host);

			/* 获取对象中存储的IP */
			String ip = inet3.getHostAddress();
			System.out.println("ip :" + ip);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}
}
