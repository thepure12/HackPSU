package com.hackpsu.hack;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Display extends Stage
{	
	private Table table;
	private float width, height;
	private TextureLoader textureLoader;
	
	
	public Display(float width, float height)
	{
		this.width = width;
		this.height = height;
		setTable(new LoginScreen(width, height));
	}
	
	public void setTable(Table table)
	{
		this.table = table;
		addActor(table);
	}
	
	public void render()
	{
		act(Gdx.graphics.getDeltaTime());
		draw();
	}

	public Sprite getBackground()
	{
		if (table instanceof LoginScreen)
		{
			return ((LoginScreen) table).getBackgroundSprite();
		}
		return null;
	}
}