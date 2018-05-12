package test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GuestComputer extends JFrame implements Runnable{
	private int width,height;
	private ExperimentService exService;
	public GuestComputer(int x,int y,int width,int height , ExperimentService exService) {
		// TODO 自动生成的构造函数存根
		this.setTitle("人机实验次窗口");
		this.setSize(width, height);
		this.width = width;
		this.height = height;
		this.setLocation(x, y);  
		
		this.exService = exService;
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
                int flag = JOptionPane.showConfirmDialog(null, "确认退出？",  
                        "提示", JOptionPane.YES_NO_OPTION,  
                        JOptionPane.INFORMATION_MESSAGE);  
                if(JOptionPane.YES_OPTION == flag){  
                	 GuestComputer.this.setVisible(false);  
                }else{  
                    return;  
                }  
            }  
		});
		this.setVisible(true);

	}
	
	
	
	

	@Override
	public void run() {
		exService.setGuestComputer(true);
		
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
