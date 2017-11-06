package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import mainGame.Game.STATE;

/**
 * The main menu
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class Menu {

	private Game game;
	private Handler handler;
	private HUD hud;
	private BufferedImage img;
	private int timer;
	private Random r;
	private ArrayList<Color> colorPick = new ArrayList<Color>();
	private int colorIndex;
	private Spawn1to10 spawner;

	public Menu(Game game, Handler handler, HUD hud, Spawn1to10 spawner) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.spawner = spawner;
		timer = 10;
		r = new Random();
		addColors();

		img = null;
		try {
			img = ImageIO.read(new File("images/background.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		//handler.addObject(new MenuFireworks((r.nextInt(Game.WIDTH) - 25), 500, 50, 50, 0, -2,
				//colorPick.get(r.nextInt(6)), ID.Firework, this.handler));
	}

	public void addColors() {
		colorPick.add(Color.blue);
		colorPick.add(Color.white);
		colorPick.add(Color.green);
		colorPick.add(Color.red);
		colorPick.add(Color.cyan);
		colorPick.add(Color.magenta);
		colorPick.add(Color.yellow);
	}

	public void tick() {
		timer--;
		if (timer <= 0) {
			handler.object.clear();
			colorIndex = r.nextInt(6);
			//handler.addObject(new MenuFireworks((r.nextInt(Game.WIDTH) - 25), 1080, 100, 100, 0, -4,
					//colorPick.get(colorIndex), ID.Firework, this.handler));
			timer = 300;
		}
		handler.tick();
	}

	public void render(Graphics g) {

		//title location (should be centered)
		int wavesHeight = (int)((Game.HEIGHT)*(0.1));
		int wavesWidth = (int)((Game.WIDTH)*(0.4));

		//play button location based on percent of screen size
		int playHeight = (int)((Game.HEIGHT)*(0.9));
		int playWidth = (int)((Game.WIDTH)*(0.1));
		int playX = (int)((Game.HEIGHT)*(0.4));
		int playY = (int)((Game.WIDTH)*(0.1));
		int playTextX = (int)((Game.HEIGHT)*(0.77));
		int playTextY = (int)((Game.WIDTH)*(0.17));

		//help button location based on percent of screen size
		int helpHeight = (int)((Game.HEIGHT)*(0.9));
		int helpWidth = (int)((Game.WIDTH)*(0.1));
		int helpX = (int)((Game.HEIGHT)*(0.4));
		int helpY = (int)((Game.WIDTH)*(0.21));
		int helpTextX = (int)((Game.HEIGHT)*(0.77));
		int helpTextY = (int)((Game.WIDTH)*(0.27));

		//credits button location based on percent of screen size
		int creditsHeight = (int)((Game.HEIGHT)*(0.9));
		int creditsWidth = (int)((Game.WIDTH)*(0.1));
		int creditsX = (int)((Game.HEIGHT)*(0.4));
		int creditsY = (int)((Game.WIDTH)*(0.32));
		int creditsTextX = (int)((Game.HEIGHT)*(0.73));
		int creditsTextY = (int)((Game.WIDTH)*(0.38));

		//quit button location based on percent of screen size
		int quitHeight = (int)((Game.HEIGHT)*(0.9));
		int quitWidth = (int)((Game.WIDTH)*(0.1));
		int quitX = (int)((Game.HEIGHT)*(0.4));
		int quitY = (int)((Game.WIDTH)*(0.43));
		int quitTextX = (int)((Game.HEIGHT)*(0.77));
		int quitTextY = (int)((Game.WIDTH)*(0.49));


		if (game.gameState == STATE.Menu) {
			g.drawImage(img, 0, 0, Game.WIDTH, Game.HEIGHT, null);
			handler.render(g);
			Font font = new Font("Amoebic", 1, 100);
			Font font2 = new Font("Amoebic", 1, 60);

			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Waves", wavesWidth, wavesHeight);

			g.setColor(Color.white);
			g.drawRect(playX, playY, playHeight, playWidth);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Play", playTextX, playTextY);

			g.setColor(Color.white);
			g.drawRect(helpX, helpY, helpHeight, helpWidth);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Help", helpTextX, helpTextY);

			g.setColor(Color.white);
			g.drawRect(creditsX, creditsY, creditsHeight, creditsWidth);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Credits", creditsTextX, creditsTextY);

			g.setColor(Color.white);
			g.drawRect(quitX, quitY, quitHeight, quitWidth);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Quit", quitTextX, quitTextY);

			/**

			 g.setFont(font);
			 g.setColor(Color.white);
			 g.drawString("Game Modes", 1140, 100);

			 g.setColor(Color.white);
			 g.drawRect(1440, 135, 400, 400);
			 g.setFont(font2);
			 g.setColor(Color.white);
			 g.drawString("Bosses", 1550, 215);

			 g.setColor(Color.white);
			 g.drawRect(990, 585, 400, 400);
			 g.setFont(font2);
			 g.setColor(Color.white);
			 g.drawString("Attack", 1095, 665);

			 g.setColor(Color.white);
			 g.drawRect(1440, 585, 400, 400);
			 g.setFont(font2);
			 g.setColor(Color.white);
			 g.drawString("Hunger", 1550, 665);

			 **/

		} else if (game.gameState == STATE.Help) {// if the user clicks on "help"
			Font font = new Font("impact", 1, 50);
			Font font2 = new Font("impact", 1, 30);

			g.setFont(font);
			g.setColor(Color.white);
			g.drawString("Help", 900, 70);

			g.setFont(font2);
			g.drawString("Waves: Simply use WASD to avoid enemies. Once you avoid" + " \n"
					+ "them long enough, a new batch will spawn in! Defeat each boss to win!", 40, 200);

			g.setFont(font2);
			g.setColor(Color.white);
			g.drawRect(850, 300, 200, 64);
			g.drawString("Back", 920, 340);
		}

	}

}
