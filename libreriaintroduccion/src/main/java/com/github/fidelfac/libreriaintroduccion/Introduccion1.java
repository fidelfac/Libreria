package com.github.fidelfac.libreriaintroduccion;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Formato #1 del componente Introduccion
 *
 * @author ACER
 * @version 1.0
 */
public class Introduccion1 extends LinearLayout{
	private ImageView image;
	private TextView texto;
	private RelativeLayout layout;
	private AnimatorSet animator;


	private String text = "Texto prueba";
	private int cColor = Color.BLACK;
	private int cLogo = R.mipmap.ic_launcher;
	private int cFondo = Color.WHITE;
	private float cTamanio = 14;

	public enum tipoAnimacion{

	}

	public Introduccion1(Context context) {
		super(context);
		//si es modificado los datos en el xml o sea en modo edicion
		if (!isInEditMode()) {
			inicializar(context);
		}

	}

	public Introduccion1(Context context, AttributeSet attrs) {
		super(context, attrs);
		//si es modificado los datos en el xml o sea en modo edicion
//		if (!isInEditMode()){
			inicializar(context, attrs);



	}

	public Introduccion1(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		inicializar(context,attrs);
	}

	private void inicializar(Context context) {

		this.inflate(context, R.layout.splash, this);

		this.image = (ImageView) findViewById(R.id.imageView1);
		this.texto = (TextView) findViewById(R.id.textView1);
		this.layout = (RelativeLayout) findViewById(R.id.layout);
		this.animator = new AnimatorSet();

	}

	private void inicializar(Context context, AttributeSet attrs) {


		TypedArray atri = context.obtainStyledAttributes(attrs, R.styleable.IntroComponente);

		if (atri != null){
			cLogo = atri.getResourceId(R.styleable.IntroComponente_imagenlogo, cLogo);
			cFondo = atri.getResourceId(R.styleable.IntroComponente_fondo, cFondo);

//			text = atri.getString(R.styleable.IntroComponente_texto);
			cTamanio = atri.getDimension(R.styleable.IntroComponente_textotamanio, cTamanio);
			cColor = atri.getColor(R.styleable.IntroComponente_textocolor, cColor);
		}

		String s = atri.getString(R.styleable.IntroComponente_texto);
		if (s != null){
			text = s;
		}

		atri.recycle();

		this.inflate(context, R.layout.splash, this);

		this.image = (ImageView) findViewById(R.id.imageView1);
		this.image.setImageResource(cLogo);
		this.texto = (TextView) findViewById(R.id.textView1);
		this.texto.setText(text);
		this.texto.setTextSize(cTamanio);
		this.texto.setTextColor(cColor);
		this.layout = (RelativeLayout) findViewById(R.id.layout);
		this.layout.setBackgroundResource(cFondo);
		this.animator = new AnimatorSet();

	}

	/**
	 * Cambia el logo de la app
	 *
	 * @param logo nombre de la imagen del logo
	 */
	public void cambiarLogo(int logo){
		this.image.setImageResource(logo);
	}


	/**
	 * Cambia la imagen de fondo
	 *
	 * @param fondo nombre de la imagen que se va a mostrar de fondo
	 */
	public void cambiarImagenFondo(int fondo) {
		this.layout.setBackgroundResource(fondo);
	}

	/**
	 * Cambia el color de fondo
	 *
	 * @param color nombre del color de fondo
	 */
	public void cambiarColorFondo(int color) {
		this.layout.setBackgroundColor(color);
	}

	/**
	 * Muestra una animacion del logo
	 */
	public void animacion() {
		ValueAnimator fadeAnim = ObjectAnimator.ofFloat(this.image, "alpha", 1f, 0f);
		fadeAnim.setDuration(3000);
		fadeAnim.setRepeatCount(ValueAnimator.INFINITE);
		fadeAnim.setRepeatMode(ValueAnimator.REVERSE);
		
		animator.play(fadeAnim);
		animator.start();

	}



}
