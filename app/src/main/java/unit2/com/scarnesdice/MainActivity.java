package unit2.com.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
The app works in such a way that if the user rolls for 'n' number of times
the computer also rolls for 'n' number of times
*/

public class MainActivity extends AppCompatActivity
{
    public int b=0,c=0,userScore=0,compScore=0,currentScore=0;

    private ImageView imageView;
    private TextView text;
    private  Button roll,hold,reset;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll =(Button)findViewById(R.id.button1);
        imageView = (ImageView)findViewById(R.id.image1);
        roll.setOnClickListener(changeImage);
        text = (TextView)findViewById(R.id.textView);
    }
    public void resetAll(View v)
    {
        userScore=0;compScore=0;
        text.setText("Your Score : 0 Computer Score : 0");
    }
    public void add(View v)
    {
        userScore+=currentScore;
        if(userScore>=100)
            text.setText("You Win!!!\nYour Score : "+userScore+" Computer Score : "+compScore+"\nYou Win!!!");
        else
            text.setText("Your Score : "+userScore+" Computer Score : "+compScore);
        currentScore=0;
        this.computerTurn();
    }
    public void computerTurn()
    {
        int a;
        do{

        Random r=new Random();
        a=1+r.nextInt(6);
        if(a==1)
        {
            imageView.setImageResource(R.drawable.dice1);
            currentScore=0;
            break;
        }
        if(a==2)
        {
            imageView.setImageResource(R.drawable.dice2);
            currentScore+=2;
            c++;
        }
        if(a==3)
        {
            imageView.setImageResource(R.drawable.dice3);
            currentScore+=3;
            c++;
        }
        if(a==4)
        {
            imageView.setImageResource(R.drawable.dice4);
            currentScore+=4;
            c++;
        }
        if(a==5)
        {
            imageView.setImageResource(R.drawable.dice5);
            currentScore+=5;
            c++;
        }
        if(a==6)
        {
            imageView.setImageResource(R.drawable.dice6);
            currentScore+=6;
            c++;
        }
        }while(b!=c);
        b=0;c=0;
        compScore+=currentScore;
        if(compScore>=100)
            text.setText("Your Score : "+userScore+" Computer Score : "+compScore+"\nComputer Wins!!!");
        else
            text.setText("Your Score : "+userScore+" Computer Score : "+compScore);
        currentScore=0;
    }
    View.OnClickListener changeImage = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Random r=new Random();
            int a=1+r.nextInt(7);
            if(a==1)
            {
                imageView.setImageResource(R.drawable.dice1);
                currentScore=0;
                text.setText("Your Score : "+userScore+" Computer Score : "+compScore);
                computerTurn();
            }
            if(a==2)
            {
                imageView.setImageResource(R.drawable.dice2);
                currentScore+=2;
                b++;
            }
            if(a==3)
            {
                imageView.setImageResource(R.drawable.dice3);
                currentScore+=3;
                b++;
            }
            if(a==4)
            {
                imageView.setImageResource(R.drawable.dice4);
                currentScore+=4;
                b++;
            }
            if(a==5)
            {
                imageView.setImageResource(R.drawable.dice5);
                currentScore+=5;
                b++;
            }
            if(a==6)
            {
                imageView.setImageResource(R.drawable.dice6);
                currentScore+=6;
                b++;
            }
        }
    };
}
