///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author user
// */
//import java.awt.*;
//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.sound.sampled.DataLine;
//import javax.swing.*;
//import java.awt.event.*;
//import java.text.DecimalFormat;
//import sun.audio.*;
//import java.io.*;
//import java.util.Timer;
//
//public class RyanImagePanelExample{//Ignore this line. Named for package clarity
//
///**
// * This program is a GUI version of MonsterTester.java. It features music, background colours, message dialogs, png files and gif files.
// * @author Ryan Trudeau. Student ID 0296506.
// *
// */
//public class MonsterGUI extends JFrame{
//
//	private ImageIcon zomb;
//	private ImageIcon charz;
//	private ImageIcon crona;
//	private JLabel label0, label1, label2, label3, labelLast, heroName;
//	private JTextField name;
//	private JTextArea output;
//	private JButton attack0, attack1, attack2, attack3, attackLast, enterName;
//	private JPanel heroPanel, monstersPanel, monster0, monster1, monster2, monster3, boss, out;
//	private Monster[] monsters;
//	private Hero hero;
//	private int afflictionTurnCount;
//	private boolean musicOn;
//	private Clip clip;
//
//	
//	Font myFont = new Font("Times New Roman", Font.BOLD | Font.ITALIC ,20);
//	/**
//	 * This no argument constructor creates the monster GUI
//	 */
//	MonsterGUI(){
//	musicOn = true;
//	//hero creation
//	heroPanel = new JPanel();
//	heroName = new JLabel("What is your hero's name?");
//	name = new JTextField(15);
//	enterName = new JButton("Start!");
//	enterName.addActionListener(new NameListener());
//	
//	heroPanel.add(heroName);
//	heroPanel.add(name);
//	heroPanel.add(enterName);
//
//	monsters = new Monster[5];
//	makeMonsters();
//	monstersPanel.setVisible(false);
//	monstersPanel.setPreferredSize(new Dimension(600,150));
//	
//	boss = new JPanel();
//	boss.setLayout(new BorderLayout());
//		
//	crona= new ImageIcon(getClass().getResource("crona.png"));
//	monsters[4] = new DemonSwordsmanCrona();
//	labelLast = new JLabel(crona);
//	attackLast = new JButton("Attack!");
//	attackLast.addActionListener(new BossListener());
//	attackLast.setEnabled(false);
//	boss.add(labelLast, BorderLayout.CENTER);
//	boss.add(attackLast, BorderLayout.SOUTH);
//	boss.setPreferredSize(new Dimension(400, 300));
//	boss.setVisible(false);
//	
//	out = new JPanel();
//	output = new JTextArea(10,50);
//	out.add(new JScrollPane(output));
//	out.setVisible(false);
//	
//	
//	Container contentPane = getContentPane();
//	contentPane.setLayout(new FlowLayout());
//	contentPane.setBackground(Color.DARK_GRAY);
//	add(heroPanel);
//	add(boss);
//	add(monstersPanel);
//	add(out);
//	}
//	
//	/**
//	 * This is the main method which runs the GUI
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//			MonsterGUI q2 = new MonsterGUI();
//			q2.setSize(500,250);
//			q2.setVisible(true);
//			q2.setTitle("Monster GUI");
//	}
//
////listeners
///**
// * This listener checks for when the user hits the go button, it shows the pre-game message and sets up the game.
// */
//public class NameListener implements ActionListener{
//	public void actionPerformed(ActionEvent n){
//		hero = new Hero(name.getText());
//		JOptionPane.showMessageDialog(null, hero.getName() + " you have a battle ahead of you!  You \n can choose which monster to attack!  Be \n warned though, if you attack a monster \n and the monster survives it will strike back!\n  Defeat all the monsters to win the game.");
//		setSize(800,800);
//		output.append(hero.toString() + "\n");
//		heroPanel.setVisible(false);
//		boss.setVisible(true);
//		monstersPanel.setVisible(true);
//		out.setVisible(true);
//		
//	}
//}
//
////audio stuff
///**
// * This listener simulates the battle when the hero attacks a monster. 
// */
//public class AttackListener implements ActionListener{
//	public void actionPerformed(ActionEvent event){
//		try{
//		if(event.getSource() == attack0){
//			heroAttacks(0);
//			afflictionTurnCount = afflictionTurnCount + 1;
//			if(afflictionTurnCount == 5){
//			hero.processAfflictions();
//			afflictionTurnCount = 0;
//			}
//			output.append(hero.toString() + "\n");
//			if(monsters[0].isDead()){
//				monster0.setVisible(false);
//			}
//			if(monsters[0].isDead() && monsters[1].isDead() && monsters[2].isDead() && monsters[3].isDead()){
//				attackLast.setEnabled(true);
//				monstersPanel.setVisible(false);
//				playMusic();
//				reachCrona();
//				
//			}
//		}
//		if(event.getSource() == attack1){
//			heroAttacks(1);
//			afflictionTurnCount = afflictionTurnCount + 1;
//			if(afflictionTurnCount == 5){
//			hero.processAfflictions();
//			afflictionTurnCount = 0;
//			}
//			output.append(hero.toString() + "\n");
//			if(monsters[1].isDead()){
//				monster1.setVisible(false);
//			}
//			if(monsters[0].isDead() && monsters[1].isDead() && monsters[2].isDead() && monsters[3].isDead()){
//				attackLast.setEnabled(true);
//				monstersPanel.setVisible(false);
//				playMusic();
//				reachCrona();
//			}
//		}
//		if(event.getSource() == attack2){
//			heroAttacks(2);
//			afflictionTurnCount = afflictionTurnCount + 1;
//			if(afflictionTurnCount == 5){
//			hero.processAfflictions();
//			afflictionTurnCount = 0;
//			}
//			output.append(hero.toString() + "\n");
//			if(monsters[2].isDead()){
//				monster2.setVisible(false);
//			}
//			if(monsters[0].isDead() && monsters[1].isDead() && monsters[2].isDead() && monsters[3].isDead()){
//				attackLast.setEnabled(true);
//				monstersPanel.setVisible(false);
//				playMusic();
//				reachCrona();
//			}
//		}
//		if(event.getSource() == attack3){
//			heroAttacks(3);
//			afflictionTurnCount = afflictionTurnCount + 1;
//			if(afflictionTurnCount == 5){
//			hero.processAfflictions();
//			afflictionTurnCount = 0;
//			}
//			output.append(hero.toString() + "\n");
//			if(monsters[3].isDead()){
//				monster3.setVisible(false);
//			}
//			if(monsters[0].isDead() && monsters[1].isDead() && monsters[2].isDead() && monsters[3].isDead()){
//				attackLast.setEnabled(true);
//				monstersPanel.setVisible(false);
//				playMusic();
//				reachCrona();
//			}//end if
//		}//end if
//		}//end try
//		catch(ArrayIndexOutOfBoundsException e){
//			output.append("The hero can only take so much!" + "\n");
//		}
//	}
//}
//
///**
// * This listener simulates the battle with Crona, including game ending conditions.
// */
//public class BossListener implements ActionListener{
//	public void actionPerformed(ActionEvent doom){
//		
//		try{	
//			heroAttacks(4);
//			afflictionTurnCount = afflictionTurnCount + 1;
//			if(afflictionTurnCount == 5){
//			hero.processAfflictions();
//			afflictionTurnCount = 0;
//			}
//			output.append(hero.toString() + "\n");
//			if(monsters[4].isDead()){
//				clip.stop();
//				JOptionPane.showMessageDialog(null, "Congratulations! You defeated all the monsters!");
//			}
//			if(hero.isDead()){
//				clip.stop();
//				JOptionPane.showMessageDialog(null, "Crona has slain you!  Dust yourself off \n and try the game again!");
//			}
//		}//end try
//		catch(ArrayIndexOutOfBoundsException e){
//			output.append("The hero can only take so much!" + "\n");
//		}
//	}
//}
///**
// * This method makes the monsters, it is just here to make code nicer above.
// */
//public void makeMonsters(){
//	//images
//	zomb = new ImageIcon(getClass().getResource("zombie.gif"));
//	charz = new ImageIcon(getClass().getResource("charizard.gif"));
//	
//	monster0 = new JPanel();
//	monster0.setLayout(new BorderLayout());
//	if((int)(Math.random() * 2) == 0){
//	label0 = new JLabel(zomb);
//	monsters[0] = new Zombie();
//	}
//	else{
//	label0 = new JLabel(charz);
//	monsters[0] = new Charizard();
//	}
//	
//	attack0 = new JButton("Attack!");
//	attack0.addActionListener(new AttackListener());
//	
//	monster0.add(label0, BorderLayout.CENTER);
//	monster0.add(attack0, BorderLayout.SOUTH);
//	
//	//next monster
//	
//	monster1 = new JPanel();
//	monster1.setLayout(new BorderLayout());
//	if((int)(Math.random() * 2) == 0){
//	label1 = new JLabel(zomb);
//	monsters[1] = new Zombie();
//	}
//	else{
//	label1 = new JLabel(charz);
//	monsters[1] = new Charizard();
//	}
//	
//	attack1 = new JButton("Attack!");
//	attack1.addActionListener(new AttackListener());
//	
//	monster1.add(label1, BorderLayout.CENTER);
//	monster1.add(attack1, BorderLayout.SOUTH);
//	
//	//next monster
//	monster2 = new JPanel();
//	monster2.setLayout(new BorderLayout());
//	if((int)(Math.random() * 2) == 0){
//	label2 = new JLabel(zomb);
//	monsters[2] = new Zombie();
//	}
//	else{
//	label2 = new JLabel(charz);
//	monsters[2] = new Charizard();
//	}
//	
//	attack2 = new JButton("Attack!");
//	attack2.addActionListener(new AttackListener());
//	
//	monster2.add(label2, BorderLayout.CENTER);
//	monster2.add(attack2, BorderLayout.SOUTH);
//	
//	//last non boss monster
//	monster3 = new JPanel();
//	monster3.setLayout(new BorderLayout());
//	if((int)(Math.random() * 2) == 0){
//	label3 = new JLabel(zomb);
//	monsters[3] = new Zombie();
//	}
//	else{
//	label3 = new JLabel(charz);
//	monsters[3] = new Charizard();
//	}
//	
//	attack3 = new JButton("Attack!");
//	attack3.addActionListener(new AttackListener());
//	
//	monster3.add(label3, BorderLayout.CENTER);
//	monster3.add(attack3, BorderLayout.SOUTH);
//	
//	monstersPanel = new JPanel();
//	monstersPanel.setLayout(new GridLayout(1,4));
//	
//	monstersPanel.add(monster0);
//	monstersPanel.add(monster1);
//	monstersPanel.add(monster2);
//	monstersPanel.add(monster3);
//}
//
///**
// * This method controls the parameters of the hero and monsters as a result of battle.
// * @param i is the index of the monster array for which monster the hero is attacking
// */
//public void heroAttacks(int i){
//	int damage = hero.dealDamage();//hero deals out damage
//	monsters[i].takeDamage(damage);
//	output.append("You did " + damage + " damage: " + monsters[i] + "\n");
//		
//		if(monsters[i].isDead()){ //if you killed the monster
//			output.append("Monster " + i + " is dead.");
//		}
//		
//		else{ //if you didn't kill the monster...
//			damage = monsters[i].dealDamage();
//			hero.takeDamage(damage);
//			output.append(monsters[i] + " strikes back, dealing " + damage + " damage." + "\n");
//			String affliction = monsters[i].afflict();
//			hero.becomeAfflicted(affliction);					
//			if(affliction.length() > 0){
//				output.append("Affliction!!! You got " + affliction + "\n");
//			}
//		}//end else
//	}
//
///**
// * This method plays the dramatic music for the fight with Crona
// */
//public void playMusic(){
//	while(musicOn){
//		try {
//		    File yourFile;
//		    yourFile = new File("src/question1/DeathWaltz.wav");
//		    AudioInputStream stream;
//		    AudioFormat format;
//		    DataLine.Info info;
//
//		    stream = AudioSystem.getAudioInputStream(yourFile);
//		    format = stream.getFormat();
//		    info = new DataLine.Info(Clip.class, format);
//		    clip = (Clip) AudioSystem.getLine(info);
//		    clip.open(stream);
//		    clip.start();
//		}
//		catch (Exception e) {
//			System.out.println("Music exception");
//		}
//	musicOn = false;
//	}
//}
//
///**
// * This method creates the break message introducing Crona to battle.
// */
//public void reachCrona(){
//	JOptionPane.showMessageDialog(null, "You've defeated all the monsters leading \n to the demon swordsman Crona!  Crona \n is swift, and his black blood strengthens \n him.  Prepare to fight!.");
//}
//
//}//end program  
//}
