package com.hackpsu.hack;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureLoader
{
	private static TextureLoader textureLoader;
	private HashMap<String, Texture> textures;
	
	private TextureLoader()
	{
		textures = new HashMap<String, Texture>();
		loadHomeScreenTextures();
	}
	
	private void loadHomeScreenTextures()
	{
		Texture t = new Texture(Gdx.files.internal("assets/loginbg.png"));
	}

	public static TextureLoader getTextureLoader()
	{
		if (textureLoader == null) textureLoader = new TextureLoader();
		return textureLoader;
	}
}
