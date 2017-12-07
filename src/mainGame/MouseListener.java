package mainGame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import mainGame.Game.STATE;

/**
 * Handles all mouse input
 * 
 * @author Brandon Loehle 5/30/16
 *
 */

public class MouseListener extends MouseAdapter {

	private Game game;
	private Handler handler;
	private HUD hud;
	private Spawn1to10 spawner;
	private Spawn10to20 spawner2;
	private UpgradeScreen upgradeScreen;
	private Upgrades upgrades;
	private Player player;
	private String upgradeText;

	public MouseListener(Game game, Handler handler, HUD hud, Spawn1to10 spawner, Spawn10to20 spawner2,
			UpgradeScreen upgradeScreen, Player player, Upgrades upgrades) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
		this.spawner = spawner;
		this.spawner2 = spawner2;
		this.upgradeScreen = upgradeScreen;
		this.player = player;
		this.upgrades = upgrades;
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		AudioPlayer.getSound("menu_sound").play((float)1, (float)100);

		if (game.gameState == STATE.GameOver) {
			handler.object.clear();
			upgrades.resetUpgrades();
			hud.health = 100;
			hud.setScore(0);
			hud.setLevel(1);
			spawner.restart();
			spawner.addLevels();
			spawner2.restart();
			spawner2.addLevels();
			Spawn1to10.LEVEL_SET = 1;
			game.gameState = STATE.Menu;
		}

		else if (game.gameState == STATE.Game) {

		}

		else if (game.gameState == STATE.Upgrade) {
			if (mouseOver(mx, my, 100, 300, 1721, 174)) {
				upgradeText = upgradeScreen.getPath(1);

				upgrades.activateUpgrade(upgradeText);

				upgradeScreen.removeUpgradeOption(1);

				game.gameState = STATE.Game;
			} else if (mouseOver(mx, my, 100, 300 + (60 + Game.HEIGHT / 6), 1721, 174)) {
				upgradeText = upgradeScreen.getPath(2);

				upgrades.activateUpgrade(upgradeText);

				upgradeScreen.removeUpgradeOption(2);

				game.gameState = STATE.Game;
			} else if (mouseOver(mx, my, 100, 300 + 2 * (60 + Game.HEIGHT / 6), 1721, 174)) {
				upgradeText = upgradeScreen.getPath(3);

				upgrades.activateUpgrade(upgradeText);

				upgradeScreen.removeUpgradeOption(3);

				game.gameState = STATE.Game;
			}

		}

		else if (game.gameState == STATE.Menu) {

			game.gameState = STATE.Select; 

			//play button location based on percent of screen size
			int playHeight = (int)((Game.HEIGHT)*(0.3));
			int playWidth = (int)((Game.WIDTH)*(0.09));
			int playX = (int)((Game.HEIGHT)*(0.2));
			int playY = (int)((Game.WIDTH)*(0.1));
			

			//help button location based on percent of screen size
			int helpHeight = (int)((Game.HEIGHT)*(0.3));
			int helpWidth = (int)((Game.WIDTH)*(0.1));
			int helpX = (int)((Game.HEIGHT)*(0.2));
			int helpY = (int)((Game.WIDTH)*(0.2));

			//credits button location based on percent of screen size
			int creditsHeight = (int)((Game.HEIGHT)*(0.3));
			int creditsWidth = (int)((Game.WIDTH)*(0.1));
			int creditsX = (int)((Game.HEIGHT)*(0.2));
			int creditsY = (int)((Game.WIDTH)*(0.32));

			//quit button location based on percent of screen size
			int quitHeight = (int)((Game.HEIGHT)*(0.3));
			int quitWidth = (int)((Game.WIDTH)*(0.1));
			int quitX = (int)((Game.HEIGHT)*(0.2));
			int quitY = (int)((Game.WIDTH)*(0.43));

			// Waves Button
			/*if (mouseOver(mx, my, playX, playY, playHeight, playWidth)) {
				handler.object.clear();
				game.gameState = STATE.Game;
				handler.addObject(player);
				// handler.addPickup(new PickupHealth(100, 100, ID.PickupHealth,
				// "images/PickupHealth.png", handler));
			}

			// Help Button
			else if (mouseOver(mx, my, helpX, helpY, helpHeight, helpWidth)) {
				game.gameState = STATE.Help;
			}

			// Credits
			else if (mouseOver(mx, my, creditsX, creditsY, creditsHeight, creditsWidth)) {
				JOptionPane.showMessageDialog(game,
						"Made by Brandon Loehle for his "
								+ "final project in AP Computer Science senior year, 2015 - 2016."
								+ "\n\nThis game is grossly unfinished with minor bugs. However,"
								+ " it is 100% playable, enjoy!");
			}

			// Quit Button
			else if (mouseOver(mx, my, quitX, quitY, quitHeight, quitWidth)) {
				System.exit(1);
			}
		}

		// Back Button for Help screen
		else if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 850, 300, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
			 */
		}
		else if (game.gameState == STATE.Select) {

			game.gameState = STATE.Select;


			//normal
			//play button location based on percent of screen size
			int playHeight = (int)((Game.HEIGHT)*(0.3));
			int playWidth = (int)((Game.WIDTH)*(0.09));
			int playX = (int)((Game.HEIGHT)*(0.2));
			int playY = (int)((Game.WIDTH)*(0.1));

			//hard
			//help button location based on percent of screen size
			int helpHeight = (int)((Game.HEIGHT)*(0.3));
			int helpWidth = (int)((Game.WIDTH)*(0.1));
			int helpX = (int)((Game.HEIGHT)*(0.2));
			int helpY = (int)((Game.WIDTH)*(0.2));

			//credits button location based on percent of screen size
			//int creditsHeight = (int)((Game.HEIGHT)*(0.9));
			//int creditsWidth = (int)((Game.WIDTH)*(0.1));
			//int creditsX = (int)((Game.HEIGHT)*(0.4));
			//int creditsY = (int)((Game.WIDTH)*(0.32));

			//back
			//quit button location based on percent of screen size
			int quitHeight = (int)((Game.HEIGHT)*(0.3));
			int quitWidth = (int)((Game.WIDTH)*(0.1));
			int quitX = (int)((Game.HEIGHT)*(0.2));
			int quitY = (int)((Game.WIDTH)*(0.43));

			// normal Button
			if (mouseOver(mx, my, playX, playY, playHeight, playWidth)) {
				handler.object.clear();
				game.gameState = STATE.Game;
				handler.addObject(player);
				// handler.addPickup(new PickupHealth(100, 100, ID.PickupHealth,
				// "images/PickupHealth.png", handler));
				game.diff = 0;
			}

			// hard Button
			else if (mouseOver(mx, my, helpX, helpY, helpHeight, helpWidth)) {
				handler.object.clear();
				game.gameState = STATE.Game;
				handler.addObject(player);
				
				game.diff = 1;
			}

			// Credits
			//else if (mouseOver(mx, my, creditsX, creditsY, creditsHeight, creditsWidth)) {
				//JOptionPane.showMessageDialog(game,
					//	"Made by Brandon Loehle for his "
						//		+ "final project in AP Computer Science senior year, 2015 - 2016."
							//	+ "\n\nThis game is grossly unfinished with minor bugs. However,"
								//+ " it is 100% playable, enjoy!");
			//}

			// Quit Button
			else if (mouseOver(mx, my, quitX, quitY, quitHeight, quitWidth)) {
				
					game.gameState = STATE.Menu;
					return;
				
			}
		}

		// Back Button for Help screen
		else if (game.gameState == STATE.Help) {
			if (mouseOver(mx, my, 850, 300, 200, 64)) {
				game.gameState = STATE.Menu;
				return;
			}
			 
		}

	}

	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Helper method to detect is the mouse is over a "button" drawn via Graphics
	 * 
	 * @param mx
	 *            mouse x position
	 * @param my
	 *            mouse y position
	 * @param x
	 *            button x position
	 * @param y
	 *            button y position
	 * @param width
	 *            button width
	 * @param height
	 *            button height
	 * @return boolean, true if the mouse is contained within the button
	 */
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width) {
			if (my > y && my < y + height) {
				return true;
			} else
				return false;
		} else
			return false;
	}
}
