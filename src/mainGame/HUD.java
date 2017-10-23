package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * The main Heads Up Display of the game
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class HUD {

	public double health = 100;
	private double healthMax = 100;

	private double greenValue = 255;

	private int score = 00000000000;
	private int level = 0;
	String highScore = "";

	private boolean regen = false;
	private int timer = 60;
	private int healthBarWidth = 400;
	private int healthBarModifier = 2;
	private boolean doubleHealth = false;
	private String ability = "";
	private int abilityUses;

	private Color scoreColor = Color.white;

	private int extraLives = 0;

	public void tick() {
		health = Game.clamp(health, 0, health);

		greenValue = Game.clamp(greenValue, 0, 255);

		greenValue = health * healthBarModifier;

		score++;

		if (regen) {// regenerates health if that ability has been unlocked
			timer--;
			if (timer == 0 && health < 100) {
				health += 1;
				timer = 60;
			}
		}
	}

	public void render(Graphics g) {
		Font font = new Font("Amoebic", 1, 30);

		g.setColor(Color.GRAY);
		g.fillRect(15, 15, healthBarWidth, 64);
		g.setColor(new Color(75, (int) greenValue, 0));
		g.fillRect((int) 15, (int) 15, (int) health * 4, 64);
		g.setColor(scoreColor);
		g.drawRect(15, 15, healthBarWidth, 64);

		g.setFont(font);

		g.drawString("Score: " + score, 15, 115);
		g.drawString("Level: " + level, 15, 150);
		g.drawString("Extra Lives: " + extraLives, 15, 185);
		g.drawString("High Score: " + highScore, 2200, 35);


		if (ability.equals("freezeTime")) {
			g.drawString("Time Freezes: " + abilityUses, Game.WIDTH - 300, 64);
		} else if (ability.equals("clearScreen")) {
			g.drawString("Screen Clears: " + abilityUses, Game.WIDTH - 300, 64);
		} else if (ability.equals("levelSkip")) {
			g.drawString("Level Skips: " + abilityUses, Game.WIDTH - 300, 64);
		}
		
		if (highScore.equals("")) {
			//initialize high score
			highScore = this.GetHighScore();
			
		}
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public int getAbilityUses() {
		return this.abilityUses;
	}

	public void setAbilityUses(int abilityUses) {
		this.abilityUses = abilityUses;
	}

	public void updateScoreColor(Color color) {
		this.scoreColor = color;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setRegen() {
		regen = true;
	}

	public void resetRegen() {
		regen = false;
	}

	public void setExtraLives(int lives) {
		this.extraLives = lives;
	}

	public int getExtraLives() {
		return this.extraLives;
	}

	public void healthIncrease() {
		doubleHealth = true;
		healthMax = 200;
		this.health = healthMax;
		healthBarModifier = 1;
		healthBarWidth = 800;
	}

	public void resetHealth() {
		doubleHealth = false;
		healthMax = 100;
		this.health = healthMax;
		healthBarModifier = 2;
		healthBarWidth = 400;
	}

	public void restoreHealth() {
		this.health = healthMax;
	}
	public void CheckScore() {
		
		
		if (highScore.equals(""))
			return;
		
		
		if (score > Integer.parseInt(highScore.split(" ")[1])) {
			
			String name = JOptionPane.showInputDialog("You set a new highscore, what is your name?");
			highScore = name + " " + score;
			
			File scoreFile = new File("highscore.dat");
			if (!scoreFile.exists()) {
			
				try {
					scoreFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			FileWriter writeFile = null; 
			BufferedWriter writer = null;
			try {
				writeFile = new FileWriter(scoreFile);
				writer = new BufferedWriter(writeFile);
				writer.write(this.highScore);
			}
			catch (Exception e) {
				//errors
		
			}
			finally {
				try {
					if (writer !=null) {
						writer.close();
					}
				}
				catch (Exception e) {}
			
			}
			
		}
	}
	
	public String GetHighScore() {
		
		FileReader readFile = null;
		BufferedReader reader = null;
		try {
		
			readFile = new FileReader("highscore.dat");
			reader = new BufferedReader(readFile);
			return reader.readLine();
		}
		
		catch (Exception e) {
			return "Nobody: 0";
		}
		finally {
			try {
				if (reader != null)
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
