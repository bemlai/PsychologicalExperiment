package test;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Begin extends JFrame{
	
	private int framWidth;
	private int framHeight;
	
	private int owerX,owerY,owerWidth,owerHeight;
	private int guestX,guestY,guestWidth,guestHeight;
	
	
	
	private ExperimentService exService;
	private ExperimentService exService2;
	
	private String version = "v2.01 180512";
	private JFrame jFrame;
	
	private String experimentTip;
	
	private JLabel extipLabel1 = new JLabel();
	private JLabel extipLabel2 = new JLabel();
	
	public Begin(){
		
            try {
            	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        
		
		experimentTip = "<html>"
				+ "<p>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;欢迎您参加本实验！本实验由2个阶段组成，每个阶段包括休息和任务两个过程。第一阶段，您将与在线玩家完成合作算数任务。第二阶段，您将与实验搭档完成合作算数任务。两个阶段具体实验任务如下："
				+ "</p>"
				+ "<p>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;首先，屏幕中央将呈现“＋”注视点0.5s。然后，屏幕上方将呈现数学等式，下方呈现待选数字1-9(注意：每一轮中数字不可重复选择)。请您在5s内按键选择一个数字填入等式相应位置。您选择的数字与实验搭档/在线玩家选择的数字，两数相加需使等式成立。随后，屏幕反馈正确或错误的计算结果3s(若您在规定时间内未做出选择，则反馈错误)。最后，呈现空白屏1.5s。"
				+ "</p>"
				+ "<p>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;实验中共有6轮计算任务，每轮需完成9道计算题，共54道。每轮之间将有10s休息时间。如果您无其他疑问，请按“P1阶段实验”按钮开始第一阶段的实验。"
				+ "</p>"
				+ "</html>";
		if (getFramHW()) {
			exService = new ExperimentService();
			exService2 = new ExperimentService();
			setFramHW(1.2);
			initFrame();
			initForm();
			initMenu();
			/*initLabel();
			initButton();*/
			this.setVisible(true);
			this.repaint();
			
			
			
		}
		
		
		
		
		
		
		
	}
	
	private void setFramHW(double d) {
		// TODO 自动生成的方法存根
		framWidth = (int)(owerWidth/d);
		framHeight = (int)(owerHeight/d);
	}

	private void initForm(){
		JLabel tip = new JLabel("请填写实验信息",JLabel.CENTER);
		tip.setSize(framWidth,100);
		tip.setLocation(0,30);
		tip.setFont(new Font("楷体",Font.BOLD, 30));
		this.add(tip);
		
		JLabel tip1 = new JLabel("实验参与者1",JLabel.CENTER);
		tip1.setSize(500,50);
		tip1.setLocation(framWidth/2-400,150);
		tip1.setFont(new Font("楷体",Font.BOLD, 30));
		this.add(tip1);
		
		JLabel tip2 = new JLabel("实验参与者2",JLabel.CENTER);
		tip2.setSize(500,50);
		tip2.setLocation(framWidth/2,150);
		tip2.setFont(new Font("楷体",Font.BOLD, 30));
		this.add(tip2);
		
		JLabel[] owerjLabels = new JLabel[4];
		JLabel[] guestjLabels = new JLabel[4];
		JTextField[] owerjFields = new JTextField[4];
		JTextField[] guestjFields = new JTextField[4];
		String[] labelTxt = {"姓名:","年龄:","性别:","组号:"};
		Font font = new Font("宋体",Font.BOLD, 20);
		for(int i=0;i<4;i++){
			owerjLabels[i] = new JLabel( labelTxt[i] );
			owerjLabels[i].setSize(100,30);
			owerjLabels[i].setLocation((int)(framWidth/2-300), (int)(250+50*i));
			owerjLabels[i].setFont(font);
			this.add(owerjLabels[i]);
			
			guestjLabels[i] = new JLabel( labelTxt[i] );
			guestjLabels[i].setSize(100,30);
			guestjLabels[i].setLocation((int)(framWidth/2+100), (int)(250+50*i));
			guestjLabels[i].setFont(font);
			this.add(guestjLabels[i]);
			
			
			
			owerjFields[i] = new JTextField();
			owerjFields[i].setSize(200,30);
			owerjFields[i].setLocation((int)(framWidth/2-240), (int)(250+50*i));
			owerjFields[i].setFont(font);
			this.add(owerjFields[i]);
			
			guestjFields[i] = new JTextField();
			guestjFields[i].setSize(200,30);
			guestjFields[i].setLocation((int)(framWidth/2+160), (int)(250+50*i));
			guestjFields[i].setFont(font);
			this.add(guestjFields[i]);
		}
		
		JButton button = new JButton("确认");
		button.setSize(150,40);
		button.setFont(font);
		button.setLocation((int)(framWidth/2-75),(int)(500));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				String[] owerInfo = new String[4];
				String[] guestInfo = new String[4];
				Boolean temp = false;
				for(int i=0;i<4;i++){
					if(owerjFields[i].getText().equals("") || guestjFields[i].getText().equals("")){
						temp = true;
						//showDialog();
					}
					owerInfo[i] = owerjFields[i].getText();
					guestInfo[i] = guestjFields[i].getText();
				}
				if (temp) {
					int response=JOptionPane.showConfirmDialog(Begin.this, "有未填写的内容,继续?", "提示", JOptionPane.YES_NO_OPTION);
					if (response == 0) {
						Begin.this.getContentPane().removeAll();
						initLabel();
						initButton();
						
						exService.setOwerInfo(owerInfo);
						exService.setGuestInfo(guestInfo);
						
						exService2.setOwerInfo(owerInfo);
						exService2.setGuestInfo(guestInfo);
					}
				}else {
					Begin.this.getContentPane().removeAll();
					initLabel();
					initButton();
					
					exService.setOwerInfo(owerInfo);
					exService.setGuestInfo(guestInfo);
					exService2.setOwerInfo(owerInfo);
					exService2.setGuestInfo(guestInfo);
				}
				
				
				
			}
		});
		this.add(button);
		
	}
	
	private void initFrame(){
		this.setTitle("心理实验");
		this.setSize( framWidth,framHeight );
		this.setLocationRelativeTo(null);//窗体居中显示 
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	private boolean getFramHW() {
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	GraphicsDevice[] gs = ge.getScreenDevices();
    	if(gs.length == 2){
    		GraphicsConfiguration[] gc = gs[0].getConfigurations();
    		Rectangle bounds = gc[0].getBounds();
    		owerX = (int) bounds.getX();
    		owerY = (int) bounds.getY();
    		owerWidth = (int) bounds.getWidth();
    		owerHeight = (int) bounds.getHeight();
    		
    		gc = gs[1].getConfigurations();
    		bounds = gc[0].getBounds();
    		guestX = (int) bounds.getX();
    		guestY = (int) bounds.getY();
    		guestWidth = (int) bounds.getWidth();
    		guestHeight = (int) bounds.getHeight();
    	    return true;
    	}else {
    		int response=JOptionPane.showConfirmDialog(Begin.this,"检测到"+gs.length+"屏,本实验程序需要双屏,继续?", "提示", JOptionPane.YES_NO_OPTION);
			if (response == 0) {
				GraphicsConfiguration[] gc = gs[0].getConfigurations();
				Rectangle bounds = gc[0].getBounds();
	    		owerX = (int) bounds.getX();
	    		owerY = (int) bounds.getY();
	    		owerWidth = (int) bounds.getWidth();
	    		owerHeight = (int) bounds.getHeight();
	    		
	    		guestX = owerWidth /2;
	    		guestY = owerY;
	    		guestWidth =  owerWidth;
	    		guestHeight = owerHeight;
	    		return true;
			}else {
				return false;
			}
		}
	}
	
	private void initLabel() {
		JLabel title = new JLabel("实验指导语",JLabel.CENTER);
		title.setSize(framWidth,100);
		title.setLocation(0,30);
		title.setFont(new Font("楷体",Font.BOLD, 35));
		this.add(title);
		
		
		extipLabel1.setFont(new Font("楷体",Font.PLAIN, 27));
		extipLabel1.setText(experimentTip);
		extipLabel1.setSize(framWidth-200,400);
		extipLabel1.setLocation(100,60);
		this.add(extipLabel1);
		this.repaint();
		initJframe2();
		
	}
	
	private void initJframe2() {
		jFrame = new JFrame("心理实验");
		jFrame.setSize( framWidth,framHeight );
		jFrame.setLocation(guestX+(guestWidth-framWidth)/2, guestY+(guestHeight-framHeight)/2);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel title = new JLabel("实验指导语",JLabel.CENTER);
		title.setSize(framWidth,100);
		title.setLocation(0,30);
		title.setFont(new Font("楷体",Font.BOLD, 35));
		jFrame.add(title);
		
		
		extipLabel2.setFont(new Font("楷体",Font.PLAIN, 27));
		extipLabel2.setText(experimentTip);
		extipLabel2.setSize(framWidth-200,400);
		extipLabel2.setLocation(100,60);
		jFrame.add(extipLabel2);
		
		jFrame.setVisible(true);
		jFrame.repaint();
	}
	
	
	
	public void initButton() {
		
		
		JButton btn1= new JButton("P2阶段实验");
		JButton btn2 = new JButton("P1阶段实验");
		
		Font font = new Font("宋体",Font.BOLD, 25);
		btn1.setSize(new Dimension(200,50));
		btn1.setFocusPainted(false);
		btn1.setFont(font);
		btn1.setLocation(framWidth-550,400+100);
		
		btn2.setSize(new Dimension(200,50));
		btn2.setFocusPainted(false);
		btn2.setFont(font);
		btn2.setLocation(350,400+100);
		
		
		this.add(btn1);
		this.add(btn2);
	
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
				if (GetScreenCount()>1) {
					Ower ower = new Ower(owerX-8, owerY, owerWidth+16, owerHeight+8 ,exService);
	
					Guest guest = new Guest(guestX-8,guestY,guestWidth+16,guestHeight+8,exService);
					new Thread(ower).start();
					new Thread(guest).start();
					
				}else {
					
					new Thread(new Ower(owerX-8, owerY, (int)((owerWidth+8)/2), owerHeight+8 ,exService )).start();
					new Thread(new Guest(guestX-8,guestY,(int)((guestWidth+16)/2),guestHeight+8,exService)).start();
				}
				//showDialog();
			}
		});
		
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
                if (GetScreenCount()>1) {
					
					new Thread(new OwerComputer(owerX-8, owerY, owerWidth+16, owerHeight+8 ,exService2)).start();
					new Thread(new GuestComputer(guestX-8,guestY,guestWidth+16,guestHeight+8,exService2)).start();
					
					
				}else {
					
					new Thread(new OwerComputer(owerX-8, owerY, (int)((owerWidth+8)/2), owerHeight+8 ,exService2 )).start();
					new Thread(new GuestComputer(guestX-8,guestY,(int)((guestWidth+16)/2),guestHeight+8,exService2)).start();
				
				}
			}
		});
	}
	
	public void initMenu() {
		//初始化一个菜单栏
        JMenuBar menuBar = new JMenuBar();

        JMenuItem menu1 = new JMenu("关于帮助");
        JMenuItem menu11 = new JMenuItem("帮助");
        JMenuItem menu12 = new JMenuItem("关于");
       
        menu1.add(menu11);
        menu1.add(menu12);
       
        
        JMenuItem menu2 = new JMenu("实验设置");
        
        JMenuItem menu21 = new JMenuItem("静息时间设置");
        JMenuItem menu22 = new JMenuItem("block设置");
        JMenuItem menu23 = new JMenuItem("指导语设置");
        JMenuItem menu24 = new JMenuItem("切换主题风格");
       
        menu2.add(menu21);
        menu2.add(menu22);
        menu2.add(menu23);
        menu2.add(menu24);
       
        menuBar.add(menu2);
        menuBar.add(menu1);                       
        
       
        menu11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				showHelp();
				
			}

			
		});
       
        menu12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				showAbout();
			}

			
		});
        
        //修改第一阶段等待时间
        menu21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String oneTime  = (String) JOptionPane.showInputDialog(null,"请输入第一次等待时间(单位:ms 整数)：\n","时间设置",JOptionPane.PLAIN_MESSAGE,null,null,exService.getOneTime());  
				 if(oneTime == null){
                   return;
                }else if (oneTime.equals("") ){
                  JOptionPane.showMessageDialog(null,"请输入数字","提示信息",JOptionPane.ERROR_MESSAGE);
                  return;
                }else {
					exService.setOneTime(Integer.valueOf(oneTime));
					exService2.setOneTime(Integer.valueOf(oneTime));
				}
				
			}

			
		});
        
      //修改block
        menu22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String block  = (String) JOptionPane.showInputDialog(null,"请输入Block(整数)：\n","Block设置",JOptionPane.PLAIN_MESSAGE,null,null,exService.getBlock());  
				 if(block == null){
                   return;
                }else if (block.equals("") ){
                  JOptionPane.showMessageDialog(null,"请输入数字","提示信息",JOptionPane.ERROR_MESSAGE);
                  return;
                }else {
					exService.setBlock(Integer.valueOf(block));
					exService2.setBlock(Integer.valueOf(block));
				}
				
			}

			
		});
        
      
        
        // 修改提示语
        menu23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strid  = (String) JOptionPane.showInputDialog(null,"请输入指导语(使用html语法)：\n","指导语设置",JOptionPane.PLAIN_MESSAGE,null,null,experimentTip);  
				 if(strid == null){
                    return;
                 }else if (strid.equals("") ){
                   JOptionPane.showMessageDialog(null,"请输入指导语","提示信息",JOptionPane.ERROR_MESSAGE);
                   return;
                 }else {
					experimentTip = strid;
					extipLabel1.setText(experimentTip);
					extipLabel2.setText(experimentTip);
				}
			}
		});
        menu24.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
	        	try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
						
	        		
				
			}
		});
        this.setJMenuBar(menuBar);
	}
	private void showHelp() {
		// TODO 自动生成的方法存根
		JOptionPane.showMessageDialog(null, "时间单位为ms\n 在人机实验条件下 切换至英文输入法 \nqwe对应789 asd对应456 zxc对应123\n人人实验条件下 主屏使用英文代替数字 次屏使用数字键盘 \n v2.01更新:\n1、可设置参数\n2、切换界面样式", "帮助", JOptionPane.PLAIN_MESSAGE); 
		
	}
	private void showAbout() {
		// TODO 自动生成的方法存根
		System.out.println("about");
		JOptionPane.showMessageDialog(null, "基于JavaSwing jdk1.8\n作者：niuini\n邮箱：admin@niuini.com\n版本："+version+"\n源码：https://github.com/bemlai/PsychologicalExperiment", "关于", JOptionPane.PLAIN_MESSAGE); 
		
		
	}
	
	public void showDialog(){
		final JDialog dialog = new JDialog(this, "提示", true);
		dialog.setTitle("ddd");
		dialog.setVisible(true);
		//new Begin();
	}
	public int GetScreenCount() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//获得图形环境
		return ge.getScreenDevices().length;
	}
	
}
