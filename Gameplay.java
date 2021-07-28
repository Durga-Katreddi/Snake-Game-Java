
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
//3.
public class Gameplay extends JPanel implements KeyListener, ActionListener {
    private int[] snakexlength = new int[750];
    private int[] snakeylength = new int[750];
//movement
private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
//snake head
private ImageIcon rightmouth;
    private ImageIcon leftmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
//timer class for moment of snake
private Timer timer;
    private int delay = 300;//speed of snake
    //snake body
private ImageIcon snakeimage;
    private int[] enemyxpos={25,50,75,100,125,150,175,200,
225,250,275,300,325,350,375,400,
425,450,475,500,525,550,575,600,
625,650,675,700,725,750,775,800,
825,850};
    private int[] enemyypos={75,100,125,150,175,200,
225,250,275,300,325,350,375,400,
425,450,475,500,525,550,575,600,
625};
    private ImageIcon enemyimage;
    private Random random = new Random();
    private int xpos=random.nextInt(34);
    private int ypos=random.nextInt(23);
    private int score=0;
    private int lengthofsnake=3;
    private int moves = 0;
//snake title on the panel
private ImageIcon titleImage;

//add default position of snake
public Gameplay(){
    addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(false);
//set the speed of snake
timer = new Timer(delay,this);
timer.start();
}
//6. draws each and everything on the panel
public void paint(Graphics g)
{
    //check if the game just started and set the initial snake position
if(moves==0)
    {
        snakexlength[2]=50;
snakexlength[1]=75;
snakexlength[0]=100;
snakeylength[2]=100;
snakeylength[1]=100;
snakeylength[0]=100;
}

//border,draw title image, border of playing area, bgcolor of playng area
g.setColor(Color.white);
g.drawRect(24,10,851,55);
titleImage = new ImageIcon("snaketitle.jpg");
titleImage.paintIcon(this,g,25,11);
//border of playing area, bgcolor of playng area
g.setColor(Color.white);
g.drawRect(24,74,851,577);
g.setColor(Color.black);
g.fillRect(25,75,850,575);
//draw scores(game end)
g.setColor(Color.WHITE);
g.setFont(new Font("arial", Font.PLAIN,14));
g.drawString("Scores: "+score,780,30);
//draw length(game end)
g.setColor(Color.WHITE);
g.setFont(new Font("arial", Font.PLAIN,14));
g.drawString("Length: "+lengthofsnake,780,50);

//draw snake
rightmouth = new ImageIcon("rightmouth.png");
rightmouth.paintIcon(this,g,snakexlength[0],snakeylength[0]);
for(int a=0;a<lengthofsnake;a++)
{
    //detect direction of snake and drawing head of snake based on direction
if(a==0 && right){
        rightmouth = new ImageIcon("rightmouth.png");
rightmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
}
    if(a==0 && left){
        leftmouth = new ImageIcon("leftmouth1.png");
leftmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
}
    if(a==0 && down){
        downmouth = new ImageIcon("downmouth.png");
downmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
}
    if(a==0 && up){
        upmouth = new ImageIcon("upmouth.png");
upmouth.paintIcon(this,g,snakexlength[a],snakeylength[a]);
}
    //draw body of the sanke
if(a!=0){
        snakeimage = new ImageIcon("snakeimage.png");
snakeimage.paintIcon(this,g,snakexlength[a],snakeylength[a]);
}
}

//detect if head and the tail are colliding with the pickup
enemyimage =  new ImageIcon("enemy.png");
    if((enemyxpos[xpos]==snakexlength[0])&&(enemyypos[ypos]==snakeylength[0]))
    {
        score++;
lengthofsnake++;
xpos=random.nextInt(34);
ypos=random.nextInt(23);
}
    enemyimage.paintIcon(this,g,enemyxpos[xpos],enemyypos[ypos]);
    for(int b=1;b<lengthofsnake;b++)
    {
        if (snakexlength[b]==snakexlength[0]&&snakeylength[b]==snakeylength[0])
        {
            right=false;
left=false;
up=false;
down=false;
g.setColor(Color.white);
g.setFont(new Font("arial",Font.BOLD,50));
g.drawString("Game Over",300,300);
g.setFont(new Font("arial",Font.BOLD,20));
g.drawString("Space to restart",350,340);
}
    }
    g.dispose();
}

 

//implement arrow keys using keylistener
//automatically called when the timer starts
@Override
public void actionPerformed(ActionEvent e) {
    timer.start();
    if(right)
    {
        for(int r =lengthofsnake-1;r>=0;r--)
        {
            snakeylength[r+1]=snakeylength[r];
}
        for(int r=lengthofsnake;r>=0;r--)
        {
            if(r==0){
                snakexlength[r]=snakexlength[r]+25;
}
            else{
                snakexlength[r]=snakexlength[r-1];
}
            //check if snake moving touches the border
            // it must come from other side
if(snakexlength[r]>850)
            {
                snakexlength[r]=25;
} 
        } 
        repaint();
} 
    //if left button is pressed
if(left)
    { 
        for(int r =lengthofsnake-1;r>=0;r--)
        { 
            snakeylength[r+1]=snakeylength[r];
} 
        for(int r=lengthofsnake;r>=0;r--)
        { 
            if(r==0){ 
                snakexlength[r]=snakexlength[r]-25;
} 
            else{ 
                snakexlength[r]=snakexlength[r-1];
} 
            //check if snake moving touches the border
            // it must come from other side
if(snakexlength[r]<25)
            { 
                snakexlength[r]=850;
} 
        } 
        repaint();
} 
    if(up)
    { 
        for(int r =lengthofsnake-1;r>=0;r--)
        { 
            snakexlength[r+1]=snakexlength[r];
} 
        for(int r=lengthofsnake;r>=0;r--)
        { 
            if(r==0){ 
                snakeylength[r]=snakeylength[r]-25;
} 
            else{ 
                snakeylength[r]=snakeylength[r-1];
} 
            //check if snake moving touches the border
            // it must come from other side
if(snakeylength[r]<75)
            { 
                snakeylength[r]=625;
} 
         
        repaint();
        }
    if(down)
    {
        for(int r =lengthofsnake-1;r>=0;r--)
        {
            snakexlength[r+1]=snakexlength[r];
}
        for(int r=lengthofsnake;r>=0;r--)
        {
            if(r==0){ 
                snakeylength[r]=snakeylength[r]+25;
} 
            else{ 
                snakeylength[r]=snakeylength[r-1];
} 
            //check if snake moving touches the border
            // it must come from other side
if(snakeylength[r]>625)
            { 
                snakeylength[r]=75;
} 
        } 
        repaint();
} 

} 



@Override
public void keyTyped(KeyEvent e) { 
} 
@Override
public void keyPressed(KeyEvent e) { 
    //to restart the game press space
if(e.getKeyCode()==KeyEvent.VK_SPACE)
    { 
        moves=0;
score=0;
lengthofsnake=3;
repaint();
} 
    if(e.getKeyCode()==KeyEvent.VK_RIGHT){ 
        moves++;
right=true;
//if its moving towards right, it should not move towards left
if(!left){ 
            right = true;
} 
        else{
            right=false;
left=true;
} 
        up=false;
down=false;
} 
    if(e.getKeyCode()==KeyEvent.VK_LEFT){ 
        moves++;
left=true;
//if its moving towards right, it should not move towards left
if(!right){ 
            left= true;
} 
        else{ 
            left=false;
right=true;
} 
        up=false;
down=false;
} 

   

        if(e.getKeyCode()==KeyEvent.VK_UP){ 
            moves++;
up=true;
//if its moving towards right, it should not move towards left
if(!down){ 
                up = true;
} 
            else{ 
                up=false;
down=true;
} 
            left=false;
right=false;
} 
        if(e.getKeyCode()==KeyEvent.VK_DOWN){ 
            moves++;
down=true;
//if its moving towards right, it should not move towards left
if(!up){ 
                down = true;
} 
            else{ 
                down=false;
up=true;
} 
            left=false;
right=false;
} 
    } 
    @Override
public void keyReleased(KeyEvent e) { 
    } 
} 



