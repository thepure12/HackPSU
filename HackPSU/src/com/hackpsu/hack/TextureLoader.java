package com.hackpsu.hack;
import java.util.HashMap;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureLoader
{
	private static TextureLoader textureLoader;
	private HashMap<String, Texture> textures;
	
	private TextureLoader()
	{
		textures = new HashMap<String, Texture>();
		loadTextures();
	}
	
	private void loadTextures()
	{
		textures.put("loginbg", new Texture(Gdx.files.internal("loginbg.png")));
		textures.put("loginbox", new Texture(Gdx.files.internal("loginbox.png")));
		textures.put("login", new Texture(Gdx.files.internal("login.png")));
	}

	public static TextureLoader getLoader()
	{
		if (textureLoader == null) textureLoader = new TextureLoader();
		return textureLoader;
	}
	
	public Texture getTexture(String str)
	{
		return textures.get(str);
	}
}
