package test;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Guest extends JFrame  implements Runnable{
	private int i=10;
	private ExperimentService exService;
	private int width,height;
	public Guest(int x,int y,int width,int height , ExperimentService exService) {
		// TODO 自动生成的构造函数存根
		this.setTitle("次窗口");
		this.setSize(width,height);
		this.setLocation(x,y);
		this.width = width;
		this.height = height;
		
		this.exService = exService;
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
                int flag = JOptionPane.showConfirmDialog(null, "确认退出？",  
                        "提示", JOptionPane.YES_NO_OPTION,  
                        JOptionPane.INFORMATION_MESSAGE);  
                if(JOptionPane.YES_OPTION == flag){  
                	 Guest.this.setVisible(false);
                }else{  
                    return;  
                }  
            }  
		});
		this.setVisible(true);

	}

	@Override
	public void run() {
		exService.setGuestComputer(false);
		exService.setGuesFrame(this);
		exService.setGuestScreenWidth(width);
		exService.setGuestScreenHeight(height);
		
		exService.guestRestingOne();
		exService.guestGazeAddTwo();
		exService.guestCalculationThree();
		exService.guestShowInfo();
		
	}
	
	public ExperimentService getExService() {
		return exService;
	}



	public void setExService(ExperimentService exService) {
		this.exService = exService;
	} 
}

