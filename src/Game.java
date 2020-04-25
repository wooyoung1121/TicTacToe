

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import javax.swing.JButton;


public class Game extends JPanel {
	JButton newGame = new JButton("New Game"); 
	int[][]gameBoard = new int[3][3];
	int x;
	int y;
	int win = 0;
	boolean p1 = true;
	JLabel turn = new JLabel("P1's Turn");
	int p1wins = 0;
    int p2wins = 0;
    int pDraws = 0;
	
	public Game() {
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(null);
		turn.setBounds(925,75,100,100);
		add(turn);
		addMouseListener(new clickListener()); 
		add(newGame);
		newGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            reset();
	            repaint();
	         }          
	      });
		newGame.setBounds(550,100, 100, 50);
		
	}
	public int win(){
	    for(int i=0;i<gameBoard.length;i++){
	    	int a = gameBoard[i][0];
	    	int b = gameBoard[i][1];
	    	int c = gameBoard[i][2];
	    	if((a == b) && (b == c)){
	    		win = a;
	    		System.out.println(a);
	
	      }
	    }
	    for(int i=0;i<gameBoard.length;i++){
	    	int a = gameBoard[0][i];
	    	int b = gameBoard[1][i];
	    	int c = gameBoard[2][i];
	    	if((a == b) && (b == c)){
	    		win = a;
	      }
	    }
	    int a = gameBoard[0][0];
	    int b = gameBoard[1][1];
	    int c = gameBoard[2][2];
	    if((a == b) && (b == c)){
	        win = a;
	      }
	    a = gameBoard[2][0];
	    b = gameBoard[1][1];
	    c = gameBoard[0][2];
	    if((a == b) && (b == c)){
	    	win = a;  
	       }
	       return win;
	    }
	public int Draw(){
	    int draw = 1;
	    for(int i=0;i<gameBoard.length;i++){
	    	for(int j=0;j<gameBoard.length;j++){
	    		if(gameBoard[i][j] == 0){
	    			draw = 0;
	        }
	      }
	    }
	    switch(draw) {
	    case 0:
	    	System.out.println("No draw, game is left to be played.");
	    	break;
	    case 1:
	    	System.out.println("Game has ended in draw");
	    	break;
	    }
	    return draw;
	  }
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xLim = 500;
		int xDelta = 300;
		int yLim = 200;
		int yDelta = 250;
		g.drawLine(800, 200,800, 950); //vertical1
		g.drawLine(1100, 200, 1100, 950);  // vertical2
		g.drawLine(500, 450, 1400, 450);   //horizontal1
		g.drawLine(500, 700, 1400, 700);  //horizontal2
	    
		
		for(int x=0;x<gameBoard.length;x++){
		      for(int y=0;y<gameBoard.length;y++){
		    	  if(gameBoard[x][y]==1){   // 
		    		  g.setColor(Color.blue);
		    		  g.drawLine(xLim  +10 +xDelta*x, yLim + 10 + yDelta*y, xLim + 290 + xDelta*x, yLim + 240 + yDelta*y);
		    		  g.drawLine(xLim + 290 + xDelta*x,  yLim + 10 + yDelta*y,  xLim + 10 + xDelta*x ,  yLim + 240 + yDelta*y);
		    	  }else if(gameBoard[x][y]==2){   // 
		    		  g.setColor(Color.RED);
		    		  g.drawOval(xLim  + xDelta * x,yLim  + yDelta * y,290,240);
		    	  }
		        }
		      }

		if(win()== 1){
			  g.setColor(Color.blue);
		      g.drawString("P1 Wins!",925,100);
		    }else if(win()== 2){
		    	g.setColor(Color.red);
		    	g.drawString("P2 Wins!",925,100);
		    }else if(Draw() == 1){
		    	g.setColor(Color.black);
		    	g.drawString("Draw!",950,100);
		    }
	
		g.setColor(Color.black);
		g.drawString("P1: ",1250,50);
	    g.drawString("has " +  p1wins + " wins",1300,50);
	    g.drawString("P2: ",1250,100);
	    g.drawString("has " +  p2wins + " wins",1300,100);
	    g.drawString("Draws = ",1250,150);
	    g.drawString("" + pDraws + "" ,1300,150);
	    
	    
	    
	 /*   for (int i = 0; i<gameBoard.length; i++) {
            System.out.print(gameBoard[i][0]);
        }
        System.out.println("");
        for (int i = 0; i<gameBoard.length; i++) {
            System.out.print(gameBoard[i][1]);
        }
        System.out.println("");
        for (int i = 0; i<gameBoard.length; i++) {
            System.out.print(gameBoard[i][2]);
        }
        System.out.println("");*/
	    System.out.println(gameBoard[0][0]);
	    System.out.println(gameBoard[0][1]);
	    System.out.println(gameBoard[0][2]);
	}
	public void reset(){
	    for(int i=0;i<gameBoard.length;i++){
	    	for(int j=0;j<gameBoard.length;j++){
	    		gameBoard[i][j]=0;
	      }
	    }
	    win = 0;
	    p1 = true;
	  }
	public class clickListener implements MouseListener{
	    public void mouseEntered(MouseEvent event){}
	    public void mouseExited(MouseEvent event){}
	    public void mousePressed(MouseEvent event){}
	    public void mouseReleased(MouseEvent event){}
	    

	    public void mouseClicked(MouseEvent event){
	    	boolean hit = true;
	    	if(win()> 0){ 
	    		//nothing
	    	}else{
	    		int a = event.getX();
	    		int b = event.getY();
	    		if((a<500) || (b<200)){   
	    			repaint();
	    			hit = false;
	    		}else if((a>1400) || (b>950)){ 
	    			repaint();
	    			hit = false;
	    		}else{
	    			hit = true;
	    			if(a>500 && a<800){
	    				x=0;
	    			}else if(a>800 && a<1100){
	    				x=1;
	    			}else if(a>1100 && a<1400){
	    				x=2;
	    			}
	    		if(b>200 && b<450){
	    			y=0;
	    		}else if(b>450 && b<700){
	    			y=1;
	    		}else if(b>700 && b<950){
	    			y=2;
	    		}
	    		if(gameBoard[x][y]== 1 || gameBoard[x][y]==2){  
	    			repaint();
	    			hit = false;
	    		}else if (hit == true){
	    			if(p1 == true){ 
	    				gameBoard[x][y]= 1;
	    			}else if (p1 == false){ 
	    				gameBoard[x][y]=2;
	    			}
	    		}
	        }
	        if(win() == 1){
	        	p1wins++;
	        }else if(win() == 2){
	        	p2wins++; 
	        }else if(Draw() == 1){
	            pDraws++;
	        }else if (hit == true) {
	        	if(p1 == true){ 
	        		turn.setText("P2'S TURN");
	        		p1 = false;
	        	}else{
	        		turn.setText("P1'S TURN");
	        		p1=true;
	          }
	        }
	        repaint();
	      }
	    } 
	  }

	public static void main(String[] args) {
		JFrame frame = new JFrame("TicTacToeGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dMax = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setMaximumSize(dMax);

	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    Game Ttt = new Game();
	    frame.getContentPane().add(Ttt);
	    frame.pack();
	    frame.setVisible(true);  
	}

}
