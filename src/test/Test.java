package test;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.ColorModel;

public class Test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("fine!");
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
		/*final Frame f = new Frame("Flowlayout");
		f.setLayout(new BorderLayout());
		f.setSize(200,300);
		//f.setLocation(00, 200);
		//f.setLocationRelativeTo(null);//���������ʾ  
		f.setDefaultCloseOperation(System.exit(0));
		Button but1 = new Button("��һ����ť");
		f.add(but1);
		f.setVisible(true);
		but1.addActionListener(new ActionListener() {
			private int num = 1;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				f.add(new Button("��" + ++num +"����ť"));
				f.setVisible(true);
			}
		});*/
		/*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//���ͼ�λ���
		System.out.println(ge.getScreenDevices().length);
		String sIndex = ge.getDefaultScreenDevice().getIDstring().substring(8, 9);    
		System.out.println(sIndex);*/
		
				
		new Begin();

	}

}
