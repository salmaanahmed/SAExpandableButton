package com.interconn.salmaanahmed.saexpandablebuttondemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.interconn.salmaanahmed.saexpandablebutton.ExpandableButton;

public class MainActivity extends AppCompatActivity {

    ExpandableButton expandableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableButton = findViewById(R.id.expandableButton);
        expandableButton.setCallbackListener(new ExpandableButton.ExpandableButtonListener() {
            @Override
            public void onViewExpanded() {
                Toast.makeText(MainActivity.this, "Button Expanded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onViewCollapsed() {
                Toast.makeText(MainActivity.this, "Button Collapsed", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.childView1);
    }

    public void childClicked(View view) {
        ((TextView) view).setText("Task Completed (Expandable Button color changed)");
        expandableButton.setBarColor(Color.parseColor("#297e55"));
    }
}
