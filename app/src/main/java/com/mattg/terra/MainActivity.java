package com.mattg.terra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout
        RelativeLayout layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.GREEN);
        //Button
        Button button = new Button(this);
        button.setText("Push");
        button.setBackgroundColor(Color.RED);
        //Username input
        EditText username = new EditText(this);
        //Set IDs
        button.setId(1);
        username.setId(2);
        // sets button details
        // params: height and width
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        // Position button
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        // Position username
        usernameDetails.addRule(RelativeLayout.ABOVE, button.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50);

        Resources r = getResources();
        // convert DIP into pixels for set width
        int pix = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics()
        );
        username.setWidth(pix); // only takes pixel value

        //add widgets to layout (button is now child of layout
        layout.addView(button, buttonDetails);
        layout.addView(username, usernameDetails);
        //make layout this activities main display
        setContentView(layout);
    }
}
// start working on tutorial