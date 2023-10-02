package com.example.dicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[]images; //array das imagens

    int[] valid; //array para validar

    int counter = 0; //contador de vezes que se rodou o dado

    ImageView i1,i2,i3; //criar objs de ImageView vazios para guardar imagens

    ToggleButton tb1, tb2, tb3;//criar objs de ToggleButton vazios para guardar os botões

    TextView result;//obj vazio para guardar o resultado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializamos o array com 4 posições para não usar a posição 0
        //valid é o array que aparece na tela com as imagens
        valid = new int[4];

        /**
         * atribuimos pelo id das imagens aos objs vazios de imagens sendo assim eles
         * começam com dados já predefinidos
         */
        i1 = findViewById(R.id.imageView3);
        i2 = findViewById(R.id.imageView4);
        i3 = findViewById(R.id.imageView5);

        /**
         * atribuimos os objetos vazios de toggle button os toggleButtons pelo o id de cada
         * um
         */
        tb1 = findViewById(R.id.toggleButton);
        tb2 = findViewById(R.id.toggleButton2);
        tb3 = findViewById(R.id.toggleButton3);

        //atribuimos ao obj vazio result o textview para
        result = findViewById(R.id.Resultado);

        /**
         * é inicializado o array das imagens com as respetivas imagens em
         */
        images = new int[7];
        images[1] = R.drawable.d1;
        images[2] = R.drawable.d2;
        images[3] = R.drawable.d3;
        images[4] = R.drawable.d4;
        images[5] = R.drawable.d5;
        images[6] = R.drawable.d6;

        //Iniciar valores do array valid
        //updateImages(images[1],images[2],images[3]);
    }

    //método do botão
    public void play(View v){

        Random rn = new Random();//método random
        int img1, img2, img3;

        /**
         * é atribuido a cada int um valor random de 1 a 6
         */
        img1 = rn.nextInt(6)+1;
        img2 = rn.nextInt(6)+1;
        img3 = rn.nextInt(6)+1;

        //verifica se a imagens são iguais se forem o jogador ganha
        if(updateImages(images[img1], images[img2], images[img3])){
            result.setText("ganhou "+counter);
        }
    }


    /**
     *Este método dá update às imagens e verifica se o botão toggle está ativo ou não
     */
    public boolean updateImages(int t1, int t2, int t3){
        if(!tb1.isChecked()){//verifica o botão
            i1.setImageResource(t1);//ele dá update ao contentor da imagem para a guardar com outra imagem
            valid[1] = t1;//após trocar a imagem ele no valid dá update ao nr da imagem
        }if(!tb2.isChecked()){
            i2.setImageResource(t2);
            valid[2] = t2;
        }if(!tb3.isChecked()){
            i3.setImageResource(t3);
            valid[3] = t3;
        }
        counter++;

        return valid[1] == valid[2] && valid[2] == valid[3];
    }
}