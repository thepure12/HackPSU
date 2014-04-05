package com.hackpsu.hack;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class HackPSU implements ApplicationListener
{
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Stage currentStage, homeScreen;

	@Override
	public void create()
	{
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		camera = new OrthographicCamera(w, h);
		camera.position.set(0, 0, 0);
		homeScreen = new HomeScreen();
		homeScreen.setCamera(camera);
		currentStage = homeScreen;
		Gdx.input.setInputProcessor(homeScreen);
	}

	@Override
	public void dispose()
	{

	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		currentStage.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
