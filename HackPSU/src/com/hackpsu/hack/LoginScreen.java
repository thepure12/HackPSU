package com.hackpsu.hack;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class LoginScreen extends Table
{
	private float width, height;
	private TextureLoader textureLoader;
	private Sprite background;
	private BitmapFont font;
	private TextArea user, pass;
	private TextFieldStyle loginTextStyle;
	private Label userLabel, passLabel;
	private ImageButton login;
	private ImageButtonStyle loginStyle;
	
	public LoginScreen(float width, float height)
	{
		this.width = width;
		this.height = height;
		this.textureLoader = TextureLoader.getLoader();
		this.font = new BitmapFont();
		this.font.setScale(2);
		setLoginStyle();
		setBackground();
		createLabels();
		createComponents();
		addComponents();
	}
	
	public void setLoginStyle()
	{
		Sprite sprite = new Sprite(textureLoader.getTexture("loginbox"));
		SpriteDrawable draw = new SpriteDrawable(sprite);
		loginTextStyle = new TextFieldStyle();
		loginTextStyle.fontColor = Color.BLACK;
		loginTextStyle.background = draw;
		loginTextStyle.font = font;
		sprite = new Sprite(textureLoader.getTexture("login"));
		sprite.setSize(width * .2f, width * .05f);
		draw = new SpriteDrawable(sprite);
		loginStyle = new ImageButtonStyle(draw, draw, draw, draw, draw, draw);
	}
	
	private void setBackground()
	{
		background = new Sprite(textureLoader.getTexture("loginbg"));
		background.setSize(width, height);
	}
	
	public Sprite getBackgroundSprite()
	{
		return background;
	}

	private void createLabels()
	{
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = font;
		labelStyle.fontColor = Color.BLACK;
		userLabel = new Label("Username", labelStyle);
		passLabel = new Label("Password", labelStyle);
	}
	
	private void createComponents()
	{
		user = new TextArea("", loginTextStyle);
		pass = new TextArea("", loginTextStyle);
		pass.setPasswordCharacter('*');
		pass.setPasswordMode(true);
		login = new ImageButton(loginStyle);
		login.sizeBy(width * .2f, .2f * width);
	}
	
	private void addComponents()
	{
		add(userLabel);
		row().padBottom(10);
		add(user).size(.75f * width, .15f * width);
		row().padBottom(10);
		add(passLabel);
		row().padBottom(10);
		add(pass).size(.75f * width, .15f * width);
		row().padBottom(10);
		add(login);
	}
}
