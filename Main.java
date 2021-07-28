
import javax.swing.*;
import java.awt.*;

//ref: awais mirza
//https://www.youtube.com/watch?v=_SqnzvJuKiA&list=PLz5rnvLVJX5WPzzaJucyHujFCZNhVOivR&t=0s
public class Main {
	public static void main(String[] args) {
        //1.JFrame is the window in which our game runs
				JFrame obj = new JFrame();
				//4. create object of gsameplay
				Gameplay gameplay = new Gameplay();
				//2.set properties of Jframe
				obj.setBounds(10,10,905,700);
				obj.setBackground(Color.darkGray);
				obj.setResizable(false);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//5. add properties of game play
				obj.add(gameplay);
}
}
