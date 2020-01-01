/**
 * 
 */
package src.fr.univavignon.ceri.application.services;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import src.fr.univavignon.ceri.application.GuiController;
import src.fr.univavignon.ceri.application.config.Textures;
import src.fr.univavignon.ceri.application.models.Game;
import src.fr.univavignon.ceri.application.models.Map;
import src.fr.univavignon.ceri.application.models.entities.Entity;
import src.fr.univavignon.ceri.application.models.entities.EntityManager;
import src.fr.univavignon.ceri.application.models.items.Item;
import src.fr.univavignon.ceri.application.models.tiles.Tile;

/**
 * @author Yanis Labrak
 *
 */
public class Draw {
	
	/**
	 * Draw all the {@code Tile}'s on the {@code Gui}
	 */
	public static void drawTiles() {
		
		Pane overlay = new Pane();
        
		Double width = GuiController.canvasDimensions.getX();
		Double height = GuiController.canvasDimensions.getY();
		
		Double tileWidth = width / Game.mapSize;
		Double tileHeight = height / Game.mapSize;
		
		for (Tile[] xTiles : Map.matrix) {
			for (Tile tile : xTiles) {
				
				Point2D coordinates = tile.getCoordinates();
				
				Double xTilePos = tileWidth * coordinates.getX();
				Double yTilePos = tileHeight * coordinates.getY();
				
				if (tile.getActive()) {
					
					GuiController.gc.drawImage(
						new Image(Draw.class.getResourceAsStream(Textures.ACTIVE)),
						xTilePos,
						yTilePos,
						tileWidth,
						tileHeight
					);
					
				} else {
					
					GuiController.gc.drawImage(
						new Image(Draw.class.getResourceAsStream(tile.getTexture())),
						xTilePos,
						yTilePos,
						tileWidth,
						tileHeight
					);
				}
				
			}		
		}
		
	}
	
	/**
	 * Draw all the {@code Entities} on the {@code Gui}
	 */
	public static void drawEntities() {

		Double width = GuiController.canvasDimensions.getX();
		Double height = GuiController.canvasDimensions.getY();
		
		Double tileWidth = width / Game.mapSize;
		Double tileHeight = height / Game.mapSize;
		
		for (Entity entity : EntityManager.getEntities()) {
				
			Point2D coordinates = entity.getCoordinates();
			
			Double xTilePos = tileWidth * coordinates.getX();
			Double yTilePos = tileHeight * coordinates.getY();
			
			GuiController.gc.drawImage(
				new Image(Draw.class.getResourceAsStream(entity.getTexture())),
				xTilePos,
				yTilePos,
				tileWidth,
				tileHeight
			);
		}

	}

	/**
	 * Draw all the {@code Item}'s on the {@code Gui}
	 */
	public static void drawItems() {
        
		Double width = GuiController.canvasDimensions.getX();
		Double height = GuiController.canvasDimensions.getY();
		
		Double tileWidth = width / Game.mapSize;
		Double tileHeight = height / Game.mapSize;
		
		for (Tile[] xTiles : Map.matrix) {
			for (Tile tile : xTiles) {
				
				Point2D coordinates = tile.getCoordinates();
				
				Double xTilePos = tileWidth * coordinates.getX();
				Double yTilePos = tileHeight * coordinates.getY();
				
				Item item = tile.getContain();
				
				// Has object in It
				if (item != null && EntityManager.checkHasNoEntity(coordinates)) {
					
					String fileName = "../ressources/assets/textures/" + item.getClass().getSimpleName() + ".png";
					Image image = new Image(Draw.class.getResourceAsStream(fileName));
					
					GuiController.gc.drawImage(
						image,
						xTilePos,
						yTilePos,
						tileWidth,
						tileHeight
					);
					
//					System.out.println("Display => " + item.getClass().getSimpleName());
					
//					if (tile.getActive()) {
//						
//						GuiController.gc.drawImage(
//							new Image(Draw.class.getResourceAsStream(Textures.ACTIVE)),
//							xTilePos,
//							yTilePos,
//							tileWidth,
//							tileHeight
//						);
//						
//					} else {
//						
//						GuiController.gc.drawImage(
//							new Image(Draw.class.getResourceAsStream(tile.getTexture())),
//							xTilePos,
//							yTilePos,
//							tileWidth,
//							tileHeight
//						);
//					}
					
				}
				
			}		
		}
		
	}

}
