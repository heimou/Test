package TestSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 
* @ClassName: createSocket 
* @Description: Socket 通讯测试
* @author liyujie 
* @date 2017年6月20日 上午10:16:44 
*
 */
public class createSocket {

	public static void main(String[] args) {
		//创建一个实例  12345 端口值 信息可以从1-65535 
		try {
			ServerSocket serverSocket=new ServerSocket(12345);
			//block 堵塞掉这个进程通讯
			Socket socket=serverSocket.accept();
			//建立连接 有人访问就弹出消息
			JOptionPane.showConfirmDialog(null, "有人访问了12345这个端口!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
