package com.example.user.torch;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.app.Activity;
import android.graphics.*;
import android.support.v7.app.*;
import android.os.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.security.*;

public class MainActivity extends Activity {

    Button button;
    Button button2;

    Camera camera;
    Parameters parameters;
    boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!status)
                {
                    camera = Camera.open();
                    parameters = camera.getParameters();
                    parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();
                    status=true;
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Sorry!!! Your Device Will Not Support it.",Toast.LENGTH_SHORT).show();

                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status)
                {
                    camera.stopPreview();
                    camera.release();
                    status=false;
                }



            }
        });



    }

}
