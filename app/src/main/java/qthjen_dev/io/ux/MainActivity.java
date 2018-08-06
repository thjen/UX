package qthjen_dev.io.ux;

import android.animation.Animator;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button, button2, button3, startActivity, flip, bt6, bt7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        startActivity = findViewById(R.id.button4);
        flip = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        bt7 = findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // not use support v4
                //button.animate().alpha(0.2f).xBy(-100).yBy(100).setDuration(5000);
                // use support v4
                ViewCompat.animate(button).alpha(0.2f).xBy(-100).yBy(100).setDuration(5000);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.animate().alpha(0.5f).rotation(90f).scaleX(2).xBy(100).yBy(100).setDuration(5000)
                        .setStartDelay(10).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        Toast.makeText(MainActivity.this, "Started...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(MainActivity.this, "Ended...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        Toast.makeText(MainActivity.this, "Canceled...", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                        Toast.makeText(MainActivity.this, "Repeated...", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        final Animation animFadeout = new AnimationUtils().loadAnimation(this, R.anim.fade_out);
        animFadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Started...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "Ended...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Toast.makeText(MainActivity.this, "Repeated...", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3.startAnimation(animFadeout);
            }
        });

        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.left_in, R.anim.right_out);
                //overridePendingTransition(R.anim.right_in, R.anim.left_out);
            }
        });

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.flip_from_middle, R.anim.flip_to_middle);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.scale_down);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.right_in, R.anim.scale_down);
            }
        });
    }
}
