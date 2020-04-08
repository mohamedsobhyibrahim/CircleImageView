package com.circleimageview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickCancel;

public class MainActivity extends AppCompatActivity {

    private ImageView addImageView;
    private ImageView profileImage;
    private String imageUrl;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addImageView = findViewById(R.id.add_photo_imageView);
        profileImage = findViewById(R.id.profile_image);

        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickImageDialog.build(new PickSetup())
                        .setOnPickResult(r -> {
                            imageUri = r.getUri();
                            Picasso.get().load(imageUri).into(profileImage);

                        }).setOnPickCancel(new IPickCancel() {
                    @Override
                    public void onCancelClick() {
                        //TODO: do what you have to if user clicked cancel
                    }
                }).show(getSupportFragmentManager());
            }
        });
    }

}
