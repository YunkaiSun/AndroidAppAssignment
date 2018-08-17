package com.example.yunka.icecreamdiy;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int clickCounter = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find layout views
        TextView headerTextView = (TextView) findViewById(R.id.HeaderTextView);
        TextView descriptionTextView2 = (TextView) findViewById(R.id.DescriptionTextView2);
        TextView descriptionTextView = (TextView) findViewById(R.id.DescriptionTextView);
        TextView weOfferTextView = (TextView) findViewById(R.id.WeOfferTextView);
        TextView offer1TextView = (TextView) findViewById(R.id.Offer1TextView);
        TextView offer2TextView = (TextView) findViewById(R.id.Offer2TextView);
        TextView offer3TextView = (TextView) findViewById(R.id.Offer3TextView);
        TextView offer4TextView = (TextView) findViewById(R.id.Offer4TextView);
        TextView othersMasterpieceTextView = (TextView) findViewById(R.id.OthersMasterpieceTextView);
        TextView ourLocationTextView = (TextView) findViewById(R.id.OurLocationTextView);
        TextView busLocationTextView = (TextView) findViewById(R.id.BusLocationTextView);
        TextView ourContactTextView = (TextView) findViewById(R.id.OurContactTextView);
        TextView busEmailTextView = (TextView) findViewById(R.id.BusEmailTextView);
        TextView busPhoneTextView = (TextView) findViewById(R.id.BusPhoneTextView);
        TextView busWebsiteTextView = (TextView) findViewById(R.id.BusWebsiteTextView);
        final ImageView iceCreamImageView = (ImageView) findViewById(R.id.IceCreamImageView);
        LinearLayout toLeftClickableArea = (LinearLayout) findViewById(R.id.ToLeftClickableArea);
        LinearLayout toRightClickableArea = (LinearLayout) findViewById(R.id.ToRightClickableArea);
        Button toLeftBtn = (Button) findViewById(R.id.LeftBtn);
        Button toRightBtn = (Button) findViewById(R.id.RightBtn);

        Typeface creamyButterFont = Typeface.createFromAsset(getAssets(),"fonts/creamy_butter.ttf");
        Typeface headerFont = Typeface.createFromAsset(getAssets(),"fonts/Tolo.ttf");
        descriptionTextView.setTypeface(creamyButterFont);
        descriptionTextView2.setTypeface(creamyButterFont);
        headerTextView.setTypeface(headerFont);
        weOfferTextView.setTypeface(creamyButterFont);
        offer1TextView.setTypeface(creamyButterFont);
        offer2TextView.setTypeface(creamyButterFont);
        offer3TextView.setTypeface(creamyButterFont);
        offer4TextView.setTypeface(creamyButterFont);
        othersMasterpieceTextView.setTypeface(creamyButterFont);
        ourLocationTextView.setTypeface(creamyButterFont);
        ourContactTextView.setTypeface(creamyButterFont);

        iceCreamImageView.setImageResource(R.drawable.icecream1);

        //load google map when click address
        busLocationTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:37.410481, -122.059774");//CMU SV campus address
                Intent i = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                i.setPackage("com.google.android.apps.maps");
                try{
                    startActivity(Intent.createChooser(i, "loading maps..."));
                } catch(android.content.ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "There is no map clients installed. ", Toast.LENGTH_LONG).show();
                }
            }
        });

        //send email when click email
        busEmailTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"123JohnDoe@gmail.com"});
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//will return to this app if click "back" from email client
                try{
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "There is no email clients installed. ", Toast.LENGTH_LONG).show();
                }
            }
        });

        //call number when click phone
        busPhoneTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String phoneNo = "+11234567890";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNo, null));
                try{
                    startActivity(Intent.createChooser(i,"calling..."));
                } catch (android.content.ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this,"Calling cannot be performed on this device. ", Toast.LENGTH_LONG).show();
                }
            }
        });

        //load website when click website
        busWebsiteTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String website = "https://www.cmu.edu/iii/degrees/mssm/";
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
                try{
                    startActivity(Intent.createChooser(i, "loading website..."));
                } catch (android.content.ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this,"There is no browser clients installed. ", Toast.LENGTH_LONG).show();
                }
            }
        });

        toLeftClickableArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter--;
                //Toast.makeText(MainActivity.this, String.valueOf(clickCounter), Toast.LENGTH_SHORT).show();
                if (clickCounter%3 == 1){
                    iceCreamImageView.setImageResource(R.drawable.icecream1);
                }
                if (clickCounter%3 == 2){
                    iceCreamImageView.setImageResource(R.drawable.icecream2);
                }
                if (clickCounter%3 == 0){
                    iceCreamImageView.setImageResource(R.drawable.icecream3);
                }
            }
        });
        toLeftBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                clickCounter--;
                //Toast.makeText(MainActivity.this, String.valueOf(clickCounter), Toast.LENGTH_SHORT).show();
                if (clickCounter%3 == 1){
                    iceCreamImageView.setImageResource(R.drawable.icecream1);
                }
                if (clickCounter%3 == 2){
                    iceCreamImageView.setImageResource(R.drawable.icecream2);
                }
                if (clickCounter%3 == 0){
                    iceCreamImageView.setImageResource(R.drawable.icecream3);
                }
            }
        });

        toRightClickableArea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                clickCounter++;
                //Toast.makeText(MainActivity.this, String.valueOf(clickCounter), Toast.LENGTH_SHORT).show();
                if (clickCounter%3 == 1){
                    iceCreamImageView.setImageResource(R.drawable.icecream1);
                }
                if (clickCounter%3 == 2){
                    iceCreamImageView.setImageResource(R.drawable.icecream2);
                }
                if (clickCounter%3 == 0){
                    iceCreamImageView.setImageResource(R.drawable.icecream3);
                }
            }
        });
        toRightBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                clickCounter++;
                //Toast.makeText(MainActivity.this, String.valueOf(clickCounter), Toast.LENGTH_SHORT).show();
                if (clickCounter%3 == 1){
                    iceCreamImageView.setImageResource(R.drawable.icecream1);
                }
                if (clickCounter%3 == 2){
                    iceCreamImageView.setImageResource(R.drawable.icecream2);
                }
                if (clickCounter%3 == 0){
                    iceCreamImageView.setImageResource(R.drawable.icecream3);
                }
            }
        });




    }
}
