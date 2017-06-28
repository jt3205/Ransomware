package Project6_Ransomware;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import java.util.*;

public class Graphic extends JFrame {
	Function func = new Function();
	String path = "C:\\Users\\박형진\\Desktop\\Test";
	
	Container contentPane = getContentPane();
	JButton bt_attack = new JButton("공격");
	JButton bt_recover = new JButton("복구");
	MouseListen mouseL = new MouseListen();
	{
		bt_attack.setSize(120,40);
		bt_recover.setSize(120,40);
		
		bt_attack.setLocation(40,30);
		bt_recover.setLocation(40,110);
		
		bt_attack.addMouseListener(mouseL);
		bt_recover.addMouseListener(mouseL);
		
		bt_recover.setEnabled(false);
	}
	JPanel panel = new JPanel();
	
	Graphic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,230);
		setTitle("랜섬 웨어");
		setResizable(false);
		panel.setLayout(null);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

		
		panel.setBackground(Color.white);
		setContentPane(panel);

		DefaultMetalTheme z = new DefaultMetalTheme() {
			// inactive title color
			public ColorUIResource getWindowTitleInactiveBackground() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}

			// active title color
			public ColorUIResource getWindowTitleBackground() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}

			// start ActiveBumps
			public ColorUIResource getPrimaryControlHighlight() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}

			public ColorUIResource getPrimaryControlDarkShadow() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}

			public ColorUIResource getPrimaryControl() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}
			// end ActiveBumps

			// start inActiveBumps
			public ColorUIResource getControlHighlight() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}

			public ColorUIResource getControlDarkShadow() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}

			public ColorUIResource getControl() {
				return new ColorUIResource(java.awt.Color.CYAN);
			}
			// end inActiveBumps

		};

		MetalLookAndFeel.setCurrentTheme(z);

		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		SwingUtilities.updateComponentTreeUI(this);
		
		panel.add(bt_attack);
		panel.add(bt_recover);

		setVisible(true);
	}
	
	class MouseListen implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(e.getComponent() == bt_attack){
				bt_attack.setEnabled(false);
				bt_recover.setEnabled(true);
				func.attack(path);
				
			}
			else if(e.getComponent() == bt_recover){
				bt_attack.setEnabled(true);
				bt_recover.setEnabled(false);
				func.recover(path);
			}
		}
		
	}
}
