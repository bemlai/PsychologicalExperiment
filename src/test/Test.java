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
		// TODO 自动生成的方法存根
		System.out.println("fine!");
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
		/*final Frame f = new Frame("Flowlayout");
		f.setLayout(new BorderLayout());
		f.setSize(200,300);
		//f.setLocation(00, 200);
		//f.setLocationRelativeTo(null);//窗体居中显示  
		f.setDefaultCloseOperation(System.exit(0));
		Button but1 = new Button("第一个按钮");
		f.add(but1);
		f.setVisible(true);
		but1.addActionListener(new ActionListener() {
			private int num = 1;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				f.add(new Button("第" + ++num +"个按钮"));
				f.setVisible(true);
			}
		});*/
		/*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//获得图形环境
		System.out.println(ge.getScreenDevices().length);
		String sIndex = ge.getDefaultScreenDevice().getIDstring().substring(8, 9);    
		System.out.println(sIndex);*/
		
				
		new Begin();

	}

}
