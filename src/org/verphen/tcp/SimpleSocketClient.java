/**
 * @author VerpHen
 * @date 2013年9月11日  下午4:01:01
 */

package org.verphen.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*简单地Socket客户端，功能：发送字符“hello”到服务器，打印服务器端的反馈*/
public class SimpleSocketClient {
	public static void main(String[] args) {

		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;

		/* 服务器端地址：127.0.0.1 */
		String serverIP = "127.0.0.1";

		/* 服务器端端口 */
		int port = 8090;

		/* 发送内容 */
		String data = "hello";

		try {
			/* 建立连接 */
			socket = new Socket(serverIP, port);

			/* 发送数据 */
			os = socket.getOutputStream();
			os.write(data.getBytes());

			/* 强制发送数据 */
			// os.flush();

			/* 接收数据 */
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);

			/* 输出反馈数据 */
			System.out.println("反馈数据：" + new String(b, 0, n));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				/* 关闭连接和流 */
				is.close();
				os.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
