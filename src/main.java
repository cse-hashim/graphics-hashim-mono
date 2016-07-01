import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class main extends JFrame {

	private JPanel contentPane;
	Pan panel=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("keypressed");
				if(panel!=null){
					if(e.getKeyCode()==KeyEvent.VK_LEFT){
//						System.out.println("vk_left");
						panel.moveLeft();
					}
					if(e.getKeyCode()==KeyEvent.VK_RIGHT){
						panel.moveRight();
					}
					if(e.getKeyCode()==KeyEvent.VK_UP){
						panel.moveUp();
					}
					if(e.getKeyCode()==KeyEvent.VK_DOWN){
						panel.moveDown();
					}
					if(e.getKeyCode()==KeyEvent.VK_A){
						panel.rotateLeft();
					}
					if(e.getKeyCode()==KeyEvent.VK_D){
						panel.rotateRight();
					}
				}
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				repaint();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 panel = new Pan();
		panel.setBounds(5, 5, 424, 245);
		contentPane.add(panel);
	}

}
