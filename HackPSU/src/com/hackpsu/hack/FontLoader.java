package com.hackpsu.hack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FontLoader
{
	private static FontLoader fontLoader;
	private BitmapFont font;
	private int device = 0;
	private String folder[] = {"res/", ""};
	
	private FontLoader()
	{
		if (Gdx.app.getType() ==  ApplicationType.Android) device = 1;
		if (Gdx.app.getType() == ApplicationType.iOS) device = 1;
		loadFont();
	}
	
	private void loadFont()
	{
		font = new BitmapFont(Gdx.files.internal(folder[device] + "font.fnt"));
		font.setColor(Color.BLACK);
		font.setScale(1.1f);
	}

	public BitmapFont getFont()
	{
		return font;
	}
	
	public static FontLoader getFontLoader()
	{
		if (fontLoader == null) fontLoader = new FontLoader();
		return fontLoader;
	}
}
