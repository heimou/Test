package TestSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 
* @ClassName: createSocket 
* @Description: Socket ͨѶ����
* @author liyujie 
* @date 2017��6��20�� ����10:16:44 
*
 */
public class createSocket {

	public static void main(String[] args) {
		//����һ��ʵ��  12345 �˿�ֵ ��Ϣ���Դ�1-65535 
		try {
			ServerSocket serverSocket=new ServerSocket(12345);
			//block �������������ͨѶ
			Socket socket=serverSocket.accept();
			//�������� ���˷��ʾ͵�����Ϣ
			JOptionPane.showConfirmDialog(null, "���˷�����12345����˿�!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
