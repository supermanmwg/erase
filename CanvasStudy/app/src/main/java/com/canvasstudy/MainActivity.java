package com.canvasstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.canvasstudy.customviews.DrawBoard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawBoard drawBoard = (DrawBoard) findViewById(R.id.drawboard);

        findViewById(R.id.change_style_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    drawBoard.setPaint(0);
            }
        });

        findViewById(R.id.change_style_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawBoard.setPaint(1);
            }
        });
    }
}
