package test;

import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ower extends JFrame implements Runnable{
	private int width,height;
	private ExperimentService exService;
	public Ower(int x,int y,int width,int height , ExperimentService exService) {
		// TODO �Զ����ɵĹ��캯�����
		this.setTitle("������");
		this.setSize(width, height);
		this.width = width;
		this.height = height;
		this.setLocation(x, y);  
		
		this.exService = exService;
		//this.setLocationRelativeTo(null);//���������ʾ 

		//this.setLayout(new FlowLayout(FlowLayout.CENTER,300,100));
		//GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
		  
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
                int flag = JOptionPane.showConfirmDialog(null, "ȷ���˳���",  
                        "��ʾ", JOptionPane.YES_NO_OPTION,  
                        JOptionPane.INFORMATION_MESSAGE);  
                if(JOptionPane.YES_OPTION == flag){  
                    Ower.this.setVisible(false);
                }else{  
                    return;  
                }  
            }  
		});
		this.setVisible(true);

	}
	
	
	
	

	@Override
	public void run() {
		
		exService.setOwerComputer(false);
		exService.setOwerFrame(this);
		exService.setOwerScreenWidth(width);
		exService.setOwerScreenHeight(height);
		
		exService.owerRestingOne();
		exService.owerGazeAddTwo();
		
		exService.owerCalculationThree();
		exService.owerShowInfo();
		
	}



	public ExperimentService getExService() {
		return exService;
	}



	public void setExService(ExperimentService exService) {
		this.exService = exService;
	} 

	
	
}
