/**
 * @author VerpHen
 * @date 2013年9月11日  下午5:01:35
 */

package org.verphen.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*服务器类，功能：将客户端发送的内容反馈给客户端*/
public class SimpleSocketServer {

	public static void main(String[] args) {

		ServerSocket server = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;

		/* 监听端口 */
		int port = 8090;

		try {
			/* 建立连接 */
			server = new ServerSocket(port);

			/* 获得连接 */
			socket = server.accept();

			System.out.println("SimpleSocletServer 启动");

			/* 接收客户端发送的内容 */
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);

			/* 控制台标准输出 */
			System.out.println("客户端发送到服务器的内容：" + new String(b, 0, n));

			/* 反馈到客户端 */
			os = socket.getOutputStream();
			os.write(b, 0, n);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				is.close();
				os.close();
				server.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
