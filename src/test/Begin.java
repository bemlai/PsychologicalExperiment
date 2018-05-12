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
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
        
		
		experimentTip = "<html>"
				+ "<p>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;��ӭ���μӱ�ʵ�飡��ʵ����2���׶���ɣ�ÿ���׶ΰ�����Ϣ�������������̡���һ�׶Σ����������������ɺ����������񡣵ڶ��׶Σ�������ʵ����ɺ����������������׶ξ���ʵ���������£�"
				+ "</p>"
				+ "<p>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;���ȣ���Ļ���뽫���֡�����ע�ӵ�0.5s��Ȼ����Ļ�Ϸ���������ѧ��ʽ���·����ִ�ѡ����1-9(ע�⣺ÿһ�������ֲ����ظ�ѡ��)��������5s�ڰ���ѡ��һ�����������ʽ��Ӧλ�á���ѡ���������ʵ��/�������ѡ������֣����������ʹ��ʽ�����������Ļ������ȷ�����ļ�����3s(�����ڹ涨ʱ����δ����ѡ����������)����󣬳��ֿհ���1.5s��"
				+ "</p>"
				+ "<p>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;ʵ���й���6�ּ�������ÿ�������9�������⣬��54����ÿ��֮�佫��10s��Ϣʱ�䡣��������������ʣ��밴��P1�׶�ʵ�顱��ť��ʼ��һ�׶ε�ʵ�顣"
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
		// TODO �Զ����ɵķ������
		framWidth = (int)(owerWidth/d);
		framHeight = (int)(owerHeight/d);
	}

	private void initForm(){
		JLabel tip = new JLabel("����дʵ����Ϣ",JLabel.CENTER);
		tip.setSize(framWidth,100);
		tip.setLocation(0,30);
		tip.setFont(new Font("����",Font.BOLD, 30));
		this.add(tip);
		
		JLabel tip1 = new JLabel("ʵ�������1",JLabel.CENTER);
		tip1.setSize(500,50);
		tip1.setLocation(framWidth/2-400,150);
		tip1.setFont(new Font("����",Font.BOLD, 30));
		this.add(tip1);
		
		JLabel tip2 = new JLabel("ʵ�������2",JLabel.CENTER);
		tip2.setSize(500,50);
		tip2.setLocation(framWidth/2,150);
		tip2.setFont(new Font("����",Font.BOLD, 30));
		this.add(tip2);
		
		JLabel[] owerjLabels = new JLabel[4];
		JLabel[] guestjLabels = new JLabel[4];
		JTextField[] owerjFields = new JTextField[4];
		JTextField[] guestjFields = new JTextField[4];
		String[] labelTxt = {"����:","����:","�Ա�:","���:"};
		Font font = new Font("����",Font.BOLD, 20);
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
		
		JButton button = new JButton("ȷ��");
		button.setSize(150,40);
		button.setFont(font);
		button.setLocation((int)(framWidth/2-75),(int)(500));
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				
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
					int response=JOptionPane.showConfirmDialog(Begin.this, "��δ��д������,����?", "��ʾ", JOptionPane.YES_NO_OPTION);
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
		this.setTitle("����ʵ��");
		this.setSize( framWidth,framHeight );
		this.setLocationRelativeTo(null);//���������ʾ 
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
    		int response=JOptionPane.showConfirmDialog(Begin.this,"��⵽"+gs.length+"��,��ʵ�������Ҫ˫��,����?", "��ʾ", JOptionPane.YES_NO_OPTION);
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
		JLabel title = new JLabel("ʵ��ָ����",JLabel.CENTER);
		title.setSize(framWidth,100);
		title.setLocation(0,30);
		title.setFont(new Font("����",Font.BOLD, 35));
		this.add(title);
		
		
		extipLabel1.setFont(new Font("����",Font.PLAIN, 27));
		extipLabel1.setText(experimentTip);
		extipLabel1.setSize(framWidth-200,400);
		extipLabel1.setLocation(100,60);
		this.add(extipLabel1);
		this.repaint();
		initJframe2();
		
	}
	
	private void initJframe2() {
		jFrame = new JFrame("����ʵ��");
		jFrame.setSize( framWidth,framHeight );
		jFrame.setLocation(guestX+(guestWidth-framWidth)/2, guestY+(guestHeight-framHeight)/2);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel title = new JLabel("ʵ��ָ����",JLabel.CENTER);
		title.setSize(framWidth,100);
		title.setLocation(0,30);
		title.setFont(new Font("����",Font.BOLD, 35));
		jFrame.add(title);
		
		
		extipLabel2.setFont(new Font("����",Font.PLAIN, 27));
		extipLabel2.setText(experimentTip);
		extipLabel2.setSize(framWidth-200,400);
		extipLabel2.setLocation(100,60);
		jFrame.add(extipLabel2);
		
		jFrame.setVisible(true);
		jFrame.repaint();
	}
	
	
	
	public void initButton() {
		
		
		JButton btn1= new JButton("P2�׶�ʵ��");
		JButton btn2 = new JButton("P1�׶�ʵ��");
		
		Font font = new Font("����",Font.BOLD, 25);
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
				// TODO �Զ����ɵķ������
				
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
		//��ʼ��һ���˵���
        JMenuBar menuBar = new JMenuBar();

        JMenuItem menu1 = new JMenu("���ڰ���");
        JMenuItem menu11 = new JMenuItem("����");
        JMenuItem menu12 = new JMenuItem("����");
       
        menu1.add(menu11);
        menu1.add(menu12);
       
        
        JMenuItem menu2 = new JMenu("ʵ������");
        
        JMenuItem menu21 = new JMenuItem("��Ϣʱ������");
        JMenuItem menu22 = new JMenuItem("block����");
        JMenuItem menu23 = new JMenuItem("ָ��������");
        JMenuItem menu24 = new JMenuItem("�л�������");
       
        menu2.add(menu21);
        menu2.add(menu22);
        menu2.add(menu23);
        menu2.add(menu24);
       
        menuBar.add(menu2);
        menuBar.add(menu1);                       
        
       
        menu11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				showHelp();
				
			}

			
		});
       
        menu12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				showAbout();
			}

			
		});
        
        //�޸ĵ�һ�׶εȴ�ʱ��
        menu21.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String oneTime  = (String) JOptionPane.showInputDialog(null,"�������һ�εȴ�ʱ��(��λ:ms ����)��\n","ʱ������",JOptionPane.PLAIN_MESSAGE,null,null,exService.getOneTime());  
				 if(oneTime == null){
                   return;
                }else if (oneTime.equals("") ){
                  JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
                  return;
                }else {
					exService.setOneTime(Integer.valueOf(oneTime));
					exService2.setOneTime(Integer.valueOf(oneTime));
				}
				
			}

			
		});
        
      //�޸�block
        menu22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String block  = (String) JOptionPane.showInputDialog(null,"������Block(����)��\n","Block����",JOptionPane.PLAIN_MESSAGE,null,null,exService.getBlock());  
				 if(block == null){
                   return;
                }else if (block.equals("") ){
                  JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
                  return;
                }else {
					exService.setBlock(Integer.valueOf(block));
					exService2.setBlock(Integer.valueOf(block));
				}
				
			}

			
		});
        
      
        
        // �޸���ʾ��
        menu23.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String strid  = (String) JOptionPane.showInputDialog(null,"������ָ����(ʹ��html�﷨)��\n","ָ��������",JOptionPane.PLAIN_MESSAGE,null,null,experimentTip);  
				 if(strid == null){
                    return;
                 }else if (strid.equals("") ){
                   JOptionPane.showMessageDialog(null,"������ָ����","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
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
				// TODO �Զ����ɵķ������
				
	        	try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
						
	        		
				
			}
		});
        this.setJMenuBar(menuBar);
	}
	private void showHelp() {
		// TODO �Զ����ɵķ������
		JOptionPane.showMessageDialog(null, "ʱ�䵥λΪms\n ���˻�ʵ�������� �л���Ӣ�����뷨 \nqwe��Ӧ789 asd��Ӧ456 zxc��Ӧ123\n����ʵ�������� ����ʹ��Ӣ�Ĵ������� ����ʹ�����ּ��� \n v2.01����:\n1�������ò���\n2���л�������ʽ", "����", JOptionPane.PLAIN_MESSAGE); 
		
	}
	private void showAbout() {
		// TODO �Զ����ɵķ������
		System.out.println("about");
		JOptionPane.showMessageDialog(null, "����JavaSwing jdk1.8\n���ߣ�niuini\n���䣺admin@niuini.com\n�汾��"+version+"\nԴ�룺https://github.com/bemlai/PsychologicalExperiment", "����", JOptionPane.PLAIN_MESSAGE); 
		
		
	}
	
	public void showDialog(){
		final JDialog dialog = new JDialog(this, "��ʾ", true);
		dialog.setTitle("ddd");
		dialog.setVisible(true);
		//new Begin();
	}
	public int GetScreenCount() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//���ͼ�λ���
		return ge.getScreenDevices().length;
	}
	
}
