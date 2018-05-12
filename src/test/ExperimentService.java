package test;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ExperimentService {
	
	private int owerScreenWidth;
	private int owerScreenHeight;
	private int guestScreenWidth;
	private int guestScreenHeight;
	
	

	private int owerNum;
	private int guestNum;
	
	private JFrame owerFrame;
	private JFrame guestFrame;
	
	private JLabel owerLabelEq;
	private JLabel owerLabelJu;
	private JLabel guestLabelEq;
	private JLabel guestLabelJu;
	
	private JPanel owerNumPan = new JPanel();
	private JPanel owerResultPan = new JPanel();
	private JPanel guestNumPan = new JPanel();
	private JPanel guestResultPan = new JPanel();
	
	public ArrayList<Integer> trailOwerList = new ArrayList<Integer>();
	public ArrayList<Integer> trailGuestList = new ArrayList<Integer>();
	
	public ArrayList<Integer> trailOwerListComputer = new ArrayList<Integer>();
	public ArrayList<Integer> trailGuestListComputer = new ArrayList<Integer>();
	
	private JButton[] owerTrailBtn = new JButton[9];
	private JButton[] guestTrailBtn = new JButton[9];
	
	private boolean numBtnTemp0 = false;//主窗口 按钮标识
	private boolean numBtnTemp1 = false;//次窗口 按钮标识
	
	private Toolkit tk=Toolkit.getDefaultToolkit();
	private AWTEventListener awtEventListener;
	
	private String[] owerInfo = new String[4];
	private String[] guestInfo = new String[4];
	
	

	private Object[][] owerDate = new Object[10][9];
	private Object[][] guestDate = new Object[10][9];
	
	private long owerStartTime;
	private long owerEndTime;
	
	private long guestStartTime;
	private long guestEndTime;
	
	private int oweri = 0;
	private int owerj = 0;
	
	private int guesti = 0;
	private int guestj = 0;
	
	private int OneTime = 20;
	private int Block = 6;
	private int Trail = 9;
	
	private int rightCount = 0;
	
	private int owerRightCountCompute = 0;
	private int guestRightCountCompute = 0;
	private boolean owerComputer = false;
	private boolean guestComputer = false;

	

	public ExperimentService() {
		
		
		
		owerLabelEq = new JLabel("",JLabel.CENTER);
		owerLabelEq.setFont(new Font("宋体", Font.PLAIN, 50));
		
		owerLabelJu = new JLabel("",JLabel.CENTER);
		owerLabelJu.setFont(new Font("宋体", Font.PLAIN, 80));	
		
		
		guestLabelEq = new JLabel("",JLabel.CENTER);
		guestLabelEq.setFont(new Font("宋体", Font.PLAIN, 50));
		
		guestLabelJu = new JLabel("",JLabel.CENTER);
		guestLabelJu.setFont(new Font("宋体", Font.PLAIN, 80));	
	
	}
	
	public void initTrailList(ArrayList<Integer> trailList) {
		trailList.clear();
		for(int i=1;i<=9;i++){
			trailList.add(i);
		}
	}
	
	
	
	
	
	
	public JFrame getOwerFrame() {
		return owerFrame;
	}

	public void setOwerFrame(JFrame owerFrame) {
		this.owerFrame = owerFrame;
	}

	public JFrame getGuesFrame() {
		return guestFrame;
	}

	public void setGuesFrame(JFrame guestFrame) {
		this.guestFrame = guestFrame;
		
	}

	/***
	 * 第一部分
	 */
	public void owerRestingOne() {
		int i = OneTime;
		owerFrame.setLayout(null);
		
		owerLabelEq.setText("请您放松、保持安静状态！");
		owerLabelEq.setSize(owerScreenWidth,50);
		owerLabelEq.setLocation(0,(int)(owerScreenHeight/2-50));
		owerLabelEq.setFont(new Font("宋体",Font.PLAIN, 40));
		owerFrame.add(owerLabelEq);
		
		JLabel tip2 = new JLabel("",JLabel.CENTER);
		tip2.setSize(owerScreenWidth,50);
		tip2.setLocation(0,(int)(owerScreenHeight/2));
		tip2.setFont(new Font("宋体",Font.PLAIN, 20));
		owerFrame.add(tip2);
		owerFrame.repaint();
		while(i!=0){
			try{  
				tip2.setText("还剩"+i+"秒");
				Thread.sleep(1000);
				i--;
			}catch(Exception   eee){}
		}
		
		owerFrame.remove(tip2);
		owerFrame.setLayout(new BorderLayout());
		owerFrame.repaint();
		
		
	}
	public void guestRestingOne() {
		int i = OneTime;
		guestFrame.setLayout(null);
		
		guestLabelEq.setText("请您放松、保持安静状态！");
		guestLabelEq.setSize(guestScreenWidth,50);
		guestLabelEq.setLocation(0,(int)(guestScreenHeight/2-50));
		guestLabelEq.setFont(new Font("宋体",Font.PLAIN, 40));
		guestFrame.add(guestLabelEq);
		
		JLabel tip2 = new JLabel("",JLabel.CENTER);
		tip2.setSize(guestScreenWidth,50);
		tip2.setLocation(0,(int)(guestScreenHeight/2));
		tip2.setFont(new Font("宋体",Font.PLAIN, 20));
		guestFrame.add(tip2);
		guestFrame.repaint();
		while(i!=0){
			try{  
				tip2.setText("还剩"+i+"秒");
				Thread.sleep(1000);
				i--;
			}catch(Exception   eee){}
		}
		
		guestFrame.remove(tip2);
		guestFrame.setLayout(new BorderLayout());
		guestFrame.repaint();
	}
	
	/***
	 * 第二部分
	 */
	public void owerGazeAddTwo() {
		try {
			owerLabelEq.setText("实验开始");
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {}
		owerFrame.repaint();
	}	
	public void guestGazeAddTwo() {
		try {
			guestLabelEq.setText("实验开始");
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		guestFrame.repaint();
	} 
	
	/***
	 * 
	 * @param type 访客类型 0主窗口  1次窗口
	 */
	private void owerInitThree(){		
		owerNumPan.setLayout(null);
		owerResultPan.setLayout(null);
		
		owerResultPan.setPreferredSize(new Dimension(owerScreenWidth, 400));
	
		//等式
		owerLabelEq.setSize(owerScreenWidth,100);
		owerLabelEq.setLocation(0,180);
		
		
		//判断结果
		owerLabelJu.setSize(owerScreenWidth,100);
		owerLabelJu.setLocation(0,300);
		
		owerResultPan.add(owerLabelEq);
		owerResultPan.add(owerLabelJu);
		
		//数字按钮
		int temp = 0;
		Font f=new Font("宋体",Font.PLAIN,20);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				owerTrailBtn[temp] = new JButton(temp+1+"");
				owerTrailBtn[temp].setSize(150,50);
				owerTrailBtn[temp].setLocation(owerScreenWidth/2-285+j*200, owerScreenHeight/3-i*100);
				owerTrailBtn[temp].setFont(f);
				
				owerTrailBtn[temp].setFocusPainted(false);
				owerTrailBtn[temp].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						
						JButton button = (JButton) e.getSource();
						if(!numBtnTemp0){
							
							button.setEnabled(false);//按钮失效
							owerNum = Integer.parseInt(button.getText()); // 按钮
							owerLabelEq.setText("( "+owerNum+" ) + ( ? ) = 3的倍数");
							numBtnTemp0 = true;
							trailOwerList.remove(trailOwerList.indexOf(owerNum));
							owerEndTime =System.currentTimeMillis();
							owerDate[oweri][owerj] = "num:"+ owerNum + "  time:" +String.format("%-4d",(int) (owerEndTime-owerStartTime));
						}
				        //trailOwerList.remove(trailOwerList.indexOf(owerNum));
				        //System.out.println(trailOwerList.toString());
						
					}
				});
				owerNumPan.add(owerTrailBtn[temp]);
				temp++;	
			}
		}
		
		owerNumPan.updateUI();
		owerResultPan.updateUI();
		System.out.println("主窗口添加 数字面板");
		owerFrame.add( owerNumPan , BorderLayout.CENTER);
		owerFrame.add( owerResultPan , BorderLayout.NORTH);
		owerResetBtn();
		owerFrame.repaint();
	}
	private void guestInitThree(){
		
		guestNumPan.setLayout(null);
		guestResultPan.setLayout(null);
		
		guestResultPan.setPreferredSize(new Dimension(guestScreenWidth, 400));
	
		//等式
		guestLabelEq.setSize(guestScreenWidth,100);
		guestLabelEq.setLocation(0,180);
		
		//判断结果
		guestLabelJu.setSize(guestScreenWidth,100);
		guestLabelJu.setLocation(0,300);
		
		guestResultPan.add(guestLabelEq);
		guestResultPan.add(guestLabelJu);
		
		//数字按钮
		int temp = 0;
		Font f=new Font("宋体",Font.PLAIN,20);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				
				guestTrailBtn[temp] = new JButton(temp+1+"");
				guestTrailBtn[temp].setSize(150,50);
				guestTrailBtn[temp].setLocation(guestScreenWidth/2-285+j*200,guestScreenHeight/3-i*100);
				guestTrailBtn[temp].setFont(f);
				
				guestTrailBtn[temp].setFocusPainted(false);
				guestTrailBtn[temp].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						
						JButton button = (JButton) e.getSource();
						if (!numBtnTemp1) {
							button.setEnabled(false);//按钮失效
							guestNum = Integer.parseInt(button.getText()); // 按钮
							guestLabelEq.setText("( ? ) + ( "+guestNum+" ) = 3的倍数");
							numBtnTemp1 = true;
							trailOwerList.remove(trailOwerList.indexOf(guestNum));
							guestEndTime =System.currentTimeMillis();
							guestDate[guesti][guestj] ="num:"+ guestNum + "  time:" + String.format("%-4d",(int) (guestEndTime-guestStartTime));
						}
				        //trailOwerList.remove(trailOwerList.indexOf(owerNum));
				        //System.out.println(trailOwerList.toString());
						
					}
				});
				guestNumPan.add(guestTrailBtn[temp]);
				temp++;
					
			}
		}
		
		guestNumPan.updateUI();
		guestResultPan.updateUI();
		System.out.println("次窗口添加 数字面板");
		guestFrame.add( guestNumPan , BorderLayout.CENTER);
		guestFrame.add( guestResultPan , BorderLayout.NORTH);
		guestResetBtn();
		guestFrame.repaint();
		
	}

	private void owerResetBtn() {
		initTrailList(trailOwerList);
		initTrailList(trailOwerListComputer);
		int temp = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				owerTrailBtn[temp].setEnabled(true);
				temp++;	
			}
		}
	}
	private void guestResetBtn() {
		
		initTrailList(trailGuestList);
		initTrailList(trailGuestListComputer);
		int temp = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				guestTrailBtn[temp].setEnabled(true);
				temp++;	
			}
		}
	}
	
	public void owerCalculationThree() {
			
		owerInitThree();
		
		keyListener(); 
		
		for( int p=0 ;p<Block ;p++ ){
			oweri = p;
			owerResetBtn();
			
			try{
				int i = 0;
				while(i< Trail){
					owerj = i;
					
					if (isOwerComputer()) {
						owerFrame.setTitle("人机实验主窗口-block "+(p+1)+"-trail "+(i+1));
					}else{
						owerFrame.setTitle("主窗口-block "+(p+1)+"-trail "+(i+1));
					}
					
					owerShowAdd();
					Thread.sleep(500); //毫秒
					owerNum = 0;
				
					//按钮未点击
					numBtnTemp0 = false;
					owerShowNumpan();
					
					tk.addAWTEventListener(awtEventListener, AWTEvent.KEY_EVENT_MASK);
					Thread.sleep(5000); //毫秒
					tk.removeAWTEventListener(awtEventListener);
					
					owerShowResult(owerNum, guestNum);
					Thread.sleep(3000); //毫秒
					owerShowNull();
					Thread.sleep(1500); //毫秒
					i++;
				}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
			} 
			
			showRest(owerFrame);
		}
		
	}
	/***
	 * 休息
	 * @param jFrame
	 */
	private void showRest(JFrame jFrame) {
		
		int i=10;
		JLabel tip = new JLabel("",JLabel.CENTER);
		if (jFrame == owerFrame) {
			tip.setSize(owerScreenWidth,50);
			tip.setLocation(0,(int)(owerScreenHeight/2-25));
		}else {
			tip.setSize(guestScreenWidth,50);
			tip.setLocation(0,(int)(guestScreenHeight/2-25));
		}
		
		tip.setFont(new Font("宋体",Font.PLAIN, 30));
		jFrame.add(tip);
		while(i!=0){
			try{  
				tip.setText("休息"+i+"秒");
				Thread.sleep(1000);
				i--;
			}catch(Exception   eee){}
		}
		jFrame.remove(tip);
		
	}
	
	public void guestCalculationThree() {
		guestInitThree();
		keyListener();
		
		for(int p=0 ; p<Block ;p++){
			guestResetBtn();
			guesti = p;
			try{
				int i = 0;
				while(i<Trail){
					guestj = i;
					if (isGuestComputer()) {
						guestFrame.setTitle("人机实验次窗口-block "+(p+1)+"-trail "+(i+1));
					}else{
						guestFrame.setTitle("次窗口-block "+(p+1)+"-trail "+(i+1));
					}
					
					
					guestShowAdd();
					Thread.sleep(500); //毫秒
					guestNum = 0;
				
					//按钮未点击
					numBtnTemp1 = false;
					guestShowNumpan();
					tk.addAWTEventListener(awtEventListener, AWTEvent.KEY_EVENT_MASK);
					Thread.sleep(5000); //毫秒
					tk.removeAWTEventListener(awtEventListener);
					
					guestShowResult(owerNum, guestNum);
					
					Thread.sleep(3000); //毫秒
					guestShowNull();
					Thread.sleep(1500); //毫秒
					i++;
				}
			}catch(Exception   eee){} 
			//block
			showRest(guestFrame);
		}
		
	}
	
	public void owerShowInfo() {
		owerFrame.setLayout(null);
		
		JLabel tip = new JLabel("数据统计1",JLabel.CENTER);
		if (isOwerComputer()) {
			tip = new JLabel("人机数据统计1",JLabel.CENTER);
			owerFrame.setTitle("人机实验主窗口-数据统计");
		}else {
			owerFrame.setTitle("主窗口-数据统计");
		}
		tip.setSize(owerScreenWidth,50);
		tip.setLocation(0,50);
		tip.setFont(new Font("楷体",Font.BOLD, 30));
		owerFrame.add(tip);
		JLabel[] jLabels = new JLabel[4];
		
		String[] labelTxt = {"姓名:","年龄:","性别:","组号:"};
		Font font = new Font("宋体",Font.BOLD, 15);
		int temp = 0;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				jLabels[temp] = new JLabel( labelTxt[temp] + this.owerInfo[temp] );
				jLabels[temp].setSize(200,30);
				System.out.println(owerScreenWidth);
				jLabels[temp].setLocation(owerScreenWidth/2-150+j*200, 150+50*i);
				jLabels[temp].setFont(font);
				owerFrame.add(jLabels[temp]);
				temp++;
			}
		}
		String[] Names =new String[9];
		for(int i=0;i<9;i++){
			Names[i] = "trail"+(i+1);
		}
		
		JTable table = new JTable(owerDate, Names);
		table.setPreferredScrollableViewportSize(new Dimension(owerScreenWidth-50, 425));
		table.setFont(font);
		table.setRowHeight(40);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(owerScreenWidth-50,425);
		scrollPane.setLocation(20,300);
		
		JLabel tip2 = new JLabel("正确次数:"+rightCount,JLabel.CENTER);
		if (isOwerComputer()) {
			tip2 = new JLabel("正确次数:"+owerRightCountCompute,JLabel.CENTER);
		}
		tip2.setSize(200,50);
		tip2.setLocation(owerScreenWidth-250,720);
		tip2.setFont(new Font("楷体",Font.BOLD, 20));
		owerFrame.add(tip2);
		
		JLabel tip3 = new JLabel("感谢您参加本次实验！",JLabel.CENTER);
		tip3.setSize(owerScreenWidth,50);
		tip3.setLocation(0,720);
		tip3.setFont(new Font("宋体",Font.BOLD, 20));
		owerFrame.add(tip3);
		
		JButton button = new JButton("保存至文件");
		button.setSize(120,40);
		button.setFont(font);
		button.setLocation(owerScreenWidth-200,50);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				savaDate(owerDate,owerInfo);
			}
		});
		owerFrame.add(button);
		
		
		owerFrame.add(scrollPane);
		owerFrame.repaint();
		
	}
	public void guestShowInfo() {
		guestFrame.setLayout(null);
		JLabel tip = new JLabel("数据统计2",JLabel.CENTER);
		if (isGuestComputer()) {
			tip = new JLabel("人机数据统计2",JLabel.CENTER);
			guestFrame.setTitle("人机实验次窗口-数据统计");
		}else {
			guestFrame.setTitle("次窗口-数据统计");
		}
		tip.setSize(guestScreenWidth,50);
		tip.setLocation(0,50);
		tip.setFont(new Font("楷体",Font.BOLD, 30));
		guestFrame.add(tip);
		
		JLabel[] jLabels = new JLabel[4];
		
		String[] labelTxt = {"姓名:","年龄:","性别:","组号:"};
		Font font = new Font("宋体",Font.BOLD, 15);
		int temp = 0;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				jLabels[temp] = new JLabel( labelTxt[temp] + this.guestInfo[temp] );
				jLabels[temp].setSize(200,30);
				jLabels[temp].setLocation(guestScreenWidth/2-150+j*200, 150+50*i);
				jLabels[temp].setFont(font);
				
				guestFrame.add(jLabels[temp]);
				temp++;
			}
		}
		String[] Names =new String[9];
		for(int i=0;i<9;i++){
			Names[i] = "trail"+(i+1);
		}
		JTable table = new JTable(guestDate, Names);
		table.setPreferredScrollableViewportSize(new Dimension(guestScreenWidth-50, 425));
		table.setFont(font);
		table.setRowHeight(40);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(guestScreenWidth-50,425);
		scrollPane.setLocation(20,300);
		
		JLabel tip2 = new JLabel("正确次数:"+rightCount,JLabel.CENTER);getClass();
		if (isGuestComputer()) {
			tip2 = new JLabel("正确次数:"+guestRightCountCompute,JLabel.CENTER);
		}
		tip2.setSize(200,50);
		tip2.setLocation(owerScreenWidth-250,720);
		tip2.setFont(new Font("楷体",Font.BOLD, 20));
		guestFrame.add(tip2);
		
		JLabel tip3 = new JLabel("感谢您参加本次实验！",JLabel.CENTER);
		tip3.setSize(owerScreenWidth,50);
		tip3.setLocation(0,720);
		tip3.setFont(new Font("宋体",Font.BOLD, 20));
		guestFrame.add(tip3);
		
		JButton button = new JButton("保存至文件");
		button.setSize(120,40);
		button.setFont(font);
		button.setLocation(owerScreenWidth-200,50);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				savaDate(guestDate,guestInfo);
			}
		});
		guestFrame.add(button);
		
		
		guestFrame.add(scrollPane);
		guestFrame.repaint();
		
	}
	
	
	private boolean savaDate(Object[][] Date , String[] info) {
		//在d盘上创建一个名为testfile的文本文件
		String inputValue = JOptionPane.showInputDialog("请输入文件名 文件将保存至D盘根目录 格式txt");  
		String fileName = new String();
		fileName = "D:"+File.separator+inputValue+".txt";
		if (inputValue == null ){
			return false;
		}else if (inputValue.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入正确文件名称", "标题", JOptionPane.ERROR_MESSAGE); 
			return false;
		}else if (new File(fileName).exists()) {
			int response=JOptionPane.showConfirmDialog(null,fileName+"已存在，继续将追加在该文件后面，继续？", "提示", JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				
				File f = new File(fileName);
				//用FileOutputSteam包装文件，并设置文件可追加
				OutputStream out;
				try {
					out = new FileOutputStream(f,true);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					String date = "保存时间:" + df.format(new Date());
					out.write( date.getBytes());
					out.write('\r'); // \r\n表示换行
					out.write('\n');
					
					String[] labelTxt = {"姓名:","年龄:","性别:","组号:"};
					for(int i=0;i<4;i++){
						out.write((labelTxt[i]+info[i]+"      ").getBytes());
					}
					
					out.write('\r'); // \r\n表示换行
					out.write('\n');
					
					
					for(int i =0; i<Date.length; i++){
						for(int j=0 ;j<Date[i].length;j++){
							out.write( ((String)(Date[i][j] + " | ")).getBytes());
						}
						out.write('\r'); // \r\n表示换行
						out.write('\n');
				     }
					out.write('\r'); // \r\n表示换行
					out.write('\n');
					out.write('\r'); // \r\n表示换行
					out.write('\n');
					out.close();
				
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "文件保存至"+fileName, "提示", JOptionPane.PLAIN_MESSAGE); 
				
				return true;
			}else {
				return false;
			}
			
		}else {
			
			File f = new File(fileName);
			//用FileOutputSteam包装文件，并设置文件可追加
			OutputStream out;
			try {
				out = new FileOutputStream(f,true);
				for(int i =0; i<Date.length; i++){
					for(int j=0 ;j<Date[i].length;j++){
						out.write( ((String)(Date[i][j] + " | ")).getBytes());
					}
					out.write('\r'); // \r\n表示换行
					out.write('\n');
			     }
				out.close();
			
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "文件保存至"+fileName, "提示", JOptionPane.PLAIN_MESSAGE); 
			
			return true;
		}
		
		
	}

	public void keyListener(){
		awtEventListener = new AWTEventListener() {
			public void eventDispatched(AWTEvent event) {
				if (((KeyEvent) event).getID() == KeyEvent.KEY_PRESSED) {
					//放入自己的键盘监听事件
					char keyChar = ((KeyEvent) event).getKeyChar();
					class Key{
						public void owerKeyClick(int num) {
							if (trailOwerList.contains(num)) {
								owerNum = num;
								owerTrailBtn[owerNum-1].setEnabled(false);
								numBtnTemp0 = true;
								owerEndTime =System.currentTimeMillis();
								owerDate[oweri][owerj] = "num:"+ owerNum + "  time:" +String.format("%-4d", (int) (owerEndTime-owerStartTime)); 
								owerLabelEq.setText("( "+owerNum+" ) + ( ? ) = 3的倍数");
							
								trailOwerList.remove(trailOwerList.indexOf(owerNum));
								owerFrame.repaint();
								
							}
							
						}
						
						public void guestKeyClick(int num) {
							if (trailGuestList.contains(num)) {
								guestNum = num;
								guestTrailBtn[guestNum-1].setEnabled(false);
								numBtnTemp1 = true;
								guestEndTime =System.currentTimeMillis();
								guestDate[guesti][guestj] ="num:"+ guestNum + "  time:"+ String.format("%-4d",(int) (guestEndTime-guestStartTime));
								guestLabelEq.setText("( ? ) + ( "+guestNum+" ) = 3的倍数");
								
								trailGuestList.remove(trailGuestList.indexOf(guestNum));
								guestFrame.repaint();
							}
							
						}
					}
					Key key = new Key();
					if (!numBtnTemp0) {
						switch (keyChar) {
						case 'z':key.owerKeyClick(1);break;
						case 'x':key.owerKeyClick(2);break;
						case 'c':key.owerKeyClick(3);break;
						case 'a':key.owerKeyClick(4);break;
						case 's':key.owerKeyClick(5);break;
						case 'd':key.owerKeyClick(6);break;
						case 'q':key.owerKeyClick(7);break;
						case 'w':key.owerKeyClick(8);break;
						case 'e':key.owerKeyClick(9);break;
						
						
						default:
							break;
						}
					}
					if (!numBtnTemp1) {
						switch (keyChar) {
						case '1':key.guestKeyClick(1);break;
						case '2':key.guestKeyClick(2);break;
						case '3':key.guestKeyClick(3);break;
						case '4':key.guestKeyClick(4);break;
						case '5':key.guestKeyClick(5);break;
						case '6':key.guestKeyClick(6);break;
						case '7':key.guestKeyClick(7);break;
						case '8':key.guestKeyClick(8);break;
						case '9':key.guestKeyClick(9);break;
						default:
							break;
						}
					}
					//System.out.println(((KeyEvent) event).getKeyCode());// 获取按键的code
					System.out.println(((KeyEvent) event).getKeyChar());// 获取按键的字符
					}
				}
		};
		
	}
	
	
	
	
	public void owerShowResult(int owerNum , int guestNum) {
		System.out.println("显示结果面板");
		
		//frame.remove(numPan);
		owerNumPan.setVisible(false);
		
		if (isOwerComputer()) {
			//System.out.println("get前trailOwerListComputer:"+trailOwerListComputer.toString());
			int index = (int)(Math.random() *  trailOwerListComputer.size());
			guestNum = trailOwerListComputer.get(index);
			trailOwerListComputer.remove(index);
			//System.out.println("get后trailOwerListComputer:"+trailOwerListComputer.toString());
			//System.out.println("电脑获取随机数："+guestNum);
			owerDate[oweri][owerj] += " cnum:"+guestNum;
			
		}
		guestFrame.toFront();
		
		
		int result = owerNum + guestNum;
		
		
		if (owerNum == 0  && guestNum == 0) {
			owerLabelEq.setText("( 超时 ) + ( 超时 ) = 错误");
			owerLabelJu.setText("错误");
			
			
		}else if (owerNum == 0 ){
			owerLabelEq.setText("( 超时 ) + ( "+ guestNum +" ) = 错误");
			owerLabelJu.setText("错误");
			
			
		}else if (guestNum == 0) {
			owerLabelEq.setText("( "+ owerNum + " ) + ( 超时 ) = 错误");
			owerLabelJu.setText("错误");
			
			
		}else if(result % 3 !=0){
			owerLabelEq.setText("( "+ owerNum +" ) + ( "+ guestNum +" ) = " + result);
			owerLabelJu.setText("错误");
			
		}else {
			owerLabelEq.setText("( "+ owerNum +" ) + ( "+ guestNum +" ) = " + result);
			owerLabelJu.setText("正确");	
			//正确次数加1 只能一个进程加
			
			if (isOwerComputer()) {
				owerRightCountCompute++;
			}else {
				rightCount++;
			}
			
		}
		
		
		
		
	}
	
	public void guestShowResult(int owerNum , int guestNum) {
		System.out.println("显示结果面板");
		
		//frame.remove(numPan);
		
		guestNumPan.setVisible(false);
		
		if (isGuestComputer()) {
			int index = (int)(Math.random() *  trailGuestListComputer.size());
			owerNum = trailGuestListComputer.get(index);
			trailGuestListComputer.remove(index);
			
			guestDate[guesti][guestj] += " cnum:"+owerNum;
		}
		owerFrame.toFront();//刷新窗口，响应键盘输入
		
		int result = owerNum + guestNum;
		
		
		
		if (owerNum == 0  && guestNum == 0) {
			
			guestLabelEq.setText("( 超时 ) + ( 超时 ) = 错误");
			guestLabelJu.setText("错误");
		}else if (owerNum == 0 ){
			
			guestLabelEq.setText("( 超时 ) + ( "+ guestNum +" ) = 错误");
			guestLabelJu.setText("错误");
		}else if (guestNum == 0) {
			
			guestLabelEq.setText("( "+ owerNum + " ) + ( 超时 ) = 错误");
			guestLabelJu.setText("错误");
		}else if(result % 3 !=0){
			
			guestLabelEq.setText("( "+ owerNum +" ) + ( "+ guestNum +" ) = " + result);
			guestLabelJu.setText("错误");
		}else {
			
			guestLabelEq.setText("( "+ owerNum +" ) + ( "+ guestNum +" ) = " + result);
			guestLabelJu.setText("正确");	
			if (isGuestComputer()) {
				guestRightCountCompute++;
			}
		}
		
		
		
	}
	
	private void owerShowAdd() {
		
		owerResultPan.setPreferredSize(new Dimension(owerScreenWidth,owerScreenHeight));
		owerLabelEq.setText("＋");
		owerLabelJu.setText("");
		owerResultPan.setVisible(true);
		owerLabelEq.setLocation(0,(int)(owerScreenHeight/2-50));
		
	}
	
	private void guestShowAdd() {
		
		guestResultPan.setPreferredSize(new Dimension(guestScreenWidth,guestScreenHeight));
		guestLabelEq.setText("＋");
		guestLabelJu.setText("");
		guestResultPan.setVisible(true);
		guestLabelEq.setLocation(0,(int)(guestScreenHeight/2-50));
	}
	
	

	private void owerShowNumpan(){
		System.out.println("主显示数字面板");
		owerLabelEq.setText("(   ) + ( ? ) = 3的倍数");
		
		owerResultPan.setPreferredSize(new Dimension(owerScreenWidth,400));
		owerLabelEq.setLocation(0,180);
		
		owerResultPan.setVisible(true);
		owerNumPan.setVisible(true);
		owerFrame.repaint();
		owerStartTime=System.currentTimeMillis();
	}
	
	private void guestShowNumpan(){
		System.out.println("次显示数字面板");
		guestLabelEq.setText("( ? ) + (   ) = 3的倍数");
		
		guestResultPan.setPreferredSize(new Dimension(guestScreenWidth,400));
		guestLabelEq.setLocation(0,180);
		
		
		guestResultPan.setVisible(true);
		guestNumPan.setVisible(true);
		guestFrame.repaint();
		guestStartTime=System.currentTimeMillis();
	}
	
	private void owerShowNull() {
		System.out.println(" 主 显示空白1.5s");
		owerResultPan.setVisible(false);
		owerNumPan.setVisible(false);
		owerFrame.repaint();
		
	}
	
	private void guestShowNull() {
		System.out.println("次 显示空白1.5s");
		guestResultPan.setVisible(false);
		guestNumPan.setVisible(false);
		guestFrame.repaint();
		
	}

	
	public int getOwerScreenWidth() {
		return owerScreenWidth;
	}

	public void setOwerScreenWidth(int owerScreenWidth) {
		this.owerScreenWidth = owerScreenWidth;
	}

	public int getOwerScreenHeight() {
		return owerScreenHeight;
	}

	public void setOwerScreenHeight(int owerScreenHeight) {
		this.owerScreenHeight = owerScreenHeight;
	}

	public int getGuestScreenWidth() {
		return guestScreenWidth;
	}

	public void setGuestScreenWidth(int guestScreenWidth) {
		this.guestScreenWidth = guestScreenWidth;
	}

	public int getGuestScreenHeight() {
		return guestScreenHeight;
	}

	public void setGuestScreenHeight(int guestScreenHeight) {
		this.guestScreenHeight = guestScreenHeight;
	}
	
	public void setOwerInfo(String[] owerInfo) {
		
		this.owerInfo = owerInfo;
	}
	
	public String[] getGuestInfo() {
		return guestInfo;
	}

	public void setGuestInfo(String[] guestInfo) {
		this.guestInfo = guestInfo;
	}

	public String[] getOwerInfo() {
		return owerInfo;
	}
	
	public boolean isOwerComputer() {
		return owerComputer;
	}

	public void setOwerComputer(boolean owerComputer) {
		this.owerComputer = owerComputer;
	}

	public boolean isGuestComputer() {
		return guestComputer;
	}

	public void setGuestComputer(boolean guestComputer) {
		this.guestComputer = guestComputer;
	}
	
	
	public int getOneTime() {
		return OneTime;
	}

	public void setOneTime(int oneTime) {
		OneTime = oneTime;
	}

	public int getBlock() {
		return Block;
	}

	public void setBlock(int block) {
		Block = block;
	}

	public int getTrail() {
		return Trail;
	}

	public void setTrail(int trail) {
		Trail = trail;
	}

	
	
}
