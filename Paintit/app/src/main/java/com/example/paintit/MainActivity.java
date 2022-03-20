package com.example.paintit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {

    int defaultColor;

    SignatureView signatureView;
    ImageButton imgEraser;
    ImageButton imgColor;
    ImageButton imgSave;
    SeekBar seekBar;
    TextView penSize;

    private static String filename;
    File path=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/My Paintings");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signatureView =findViewById(R.id.signature_view);
        imgColor=findViewById(R.id.btcolor);
        imgEraser=findViewById(R.id.btErase);
        imgSave=findViewById(R.id.btsave);

        seekBar=findViewById(R.id.penSize);
        penSize=findViewById(R.id.penSizeTextview);

        askPermission();

        SimpleDateFormat format= new SimpleDateFormat("yyyyMMdd_hhMMss", Locale.getDefault());
        String date = format.format(new Date());
        filename = path +"/"+date+".png";

        if(!path.exists()){

            path.mkdirs();

        }

        defaultColor = ContextCompat.getColor(MainActivity.this,R.color.black);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                penSize.setText(i+"dp");
                signatureView.setPenSize(i);
                seekBar.setMax(50);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        imgColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColors();
            }
        });
        imgEraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signatureView.clearCanvas();
            }
        });

        imgSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!signatureView.isBitmapEmpty()){

                    try {
                        saveImage();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Could not save", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void saveImage() throws IOException {

        File file=new File(filename);
        Bitmap bitmap = signatureView.getSignatureBitmap();
        ByteArrayOutputStream bais =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,bais);
        byte[] bitMapDate = bais.toByteArray();

        FileOutputStream fios =new FileOutputStream(file);
        fios.write(bitMapDate);
        fios.flush();
        fios.close();

        Toast.makeText(this,"Image Save",Toast.LENGTH_LONG);
    }

    private void openColors() {
        AmbilWarnaDialog colorDialog= new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                Toast.makeText(MainActivity.this,"Something Went Wrong",Toast.LENGTH_SHORT);
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor=color;
                signatureView.setPenColor(color);
            }
        });
        colorDialog.show();
    }

    private void askPermission() {
        Dexter.withContext(this)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Toast.makeText(MainActivity.this,"Thank You",Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }
}