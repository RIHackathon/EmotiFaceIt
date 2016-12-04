package com.rsquared.robert.emotifaceit;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.graphics.Camera;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.hardware.camera2.CameraCaptureSession;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.R.attr.bitmap;


public class FullscreenActivity extends AppCompatActivity implements SurfaceHolder.Callback{


    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;


    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    private static final String ALLOW_KEY = "ALLOWED";
    private static final String CAMERA_PREF = "camera_pref";
    private static final int REQUEST_TAKE_PHOTO = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Camera mCamera = null;
    private CameraView mCameraView = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();

//                Intent intent = new Intent("android.intent.action.ANDROIDCAMERAAPI");
//                startActivity(intent);
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (getFromPref(this, ALLOW_KEY)) {
//                showSettingsAlert();
            } else if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA)

                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.CAMERA)) {
//                    showAlert();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST_CAMERA);
                }
            }
        } else {
           // openCamera();
        }

        createListView();
        surfaceView = (SurfaceView)findViewById(R.id.camera_view);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        rawCallback = new Camera.PictureCallback() {
            public void onPictureTaken(byte[] data, Camera camera) {
/*                Log.d("Log", "onPictureTaken - raw");
                savePicture(data);

                Intent intent = new Intent("android.intent.action.EMOTIWAREHOUSE");
                startActivity(intent);*/
            }
        };


        //initiateCamera();
    }

    private String getFilePath(){
        // path to /data/data/yourapp/app_data/imageDir
        File directory = getDir("imageDir", Context.MODE_PRIVATE);

        String mypath = directory.getAbsolutePath();

        return mypath;
    }


    private void savePicture(byte[] data) {
        // path to /data/data/yourapp/app_data/imageDir
        Bitmap bmBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        File directory = getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath = new File(directory, FILE_NAME + countImagesStored() + FILE_EXTENSION);

        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bmBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static final String FILE_NAME = "memoji";
    private static final String FILE_EXTENSION = ".png";

    private int countImagesStored() {
        int count = 0;
        boolean hasImage = true;
        try {
            while(hasImage) {
                File file = new File(getFilePath(), FILE_NAME + count + FILE_EXTENSION);
                if(!file.exists()){
                    hasImage = false;
                }else {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

//    private void initiateCamera() {
//
//        try{
//            mCamera = Camera.open(1);//you can use open(int) to use different cameras
//        } catch (Exception e){
//            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
//        }
//
//        if(mCamera != null) {
////            Button button = (Button) findViewById(R.id.button3);
//            mCameraView = new CameraView(this.getBaseContext(), mCamera);//create a SurfaceView to show camera data
//            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
//            camera_view.addView(mCameraView);//add the SurfaceView to the layout
//            camera_view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mCamera.startPreview();;
//                }
//            });
//        }
//    }

    private void createListView() {
//        final ListView listView = (ListView) findViewById(R.id.emoti_list_view);
        //Resources res = getResources();
        //Drawable drawable = res.getDrawable(R.drawable.smile);

        ListView simpleList;
        ArrayList<Item> mimojis =new ArrayList<>();

        simpleList = (ListView) findViewById(R.id.emoti_list_view);
        mimojis.add(new Item("Smile",R.drawable.smile));
        mimojis.add(new Item("Sleepy",R.drawable.sleepy));
        mimojis.add(new Item("Dizzy",R.drawable.dizzy));
        mimojis.add(new Item("Smirk",R.drawable.smirk));
        mimojis.add(new Item("Angry",R.drawable.angry));
        mimojis.add(new Item("Drooling",R.drawable.drooling));
        mimojis.add(new Item("Crying",R.drawable.crying_face));
        mimojis.add(new Item("Contemplative",R.drawable.contemplative));
        mimojis.add(new Item("Hearts",R.drawable.smiling_face_with_hearts));
        mimojis.add(new Item("Zipper mouth",R.drawable.zipper_mouth));
        mimojis.add(new Item("Rolling eyes",R.drawable.rolling_eyes));

        ListViewAdapter myAdapter=new ListViewAdapter(this,R.layout.test_listview,mimojis);
        simpleList.setAdapter(myAdapter);

        Drawable myIcon = getResources().getDrawable( R.drawable.smile);


//        ArrayAdapter<Drawable> stringArrayAdapter = new ArrayAdapter<Drawable>(this, android.R.layout.simple_list_item_1);
        simpleList.setAdapter(myAdapter);
//        showAlert();
//        myAdapter.add(myIcon);
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView imageView = (ImageView) view;
                imageView.setImageAlpha(100);

            }
        };
        simpleList.setOnItemClickListener(onItemClickListener);
    }

    public static void saveToPreferences(Context context, String key, Boolean allowed) {
        SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putBoolean(key, allowed);
        prefsEditor.commit();
    }

    public static Boolean getFromPref(Context context, String key) {
        SharedPreferences myPrefs = context.getSharedPreferences(CAMERA_PREF,
                Context.MODE_PRIVATE);
        return (myPrefs.getBoolean(key, false));
    }

//    private void showAlert() {
//        AlertDialog alertDialog = new AlertDialog.Builder(FullscreenActivity.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage("App needs to access the Camera.");
//
//        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        finish();
//                    }
//                });
//
//        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW",
//                new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        ActivityCompat.requestPermissions(FullscreenActivity.this,
//                                new String[]{Manifest.permission.CAMERA},
//                                MY_PERMISSIONS_REQUEST_CAMERA);
//                    }
//                });
//        alertDialog.show();
//    }

//    private void showSettingsAlert() {
//        AlertDialog alertDialog = new AlertDialog.Builder(FullscreenActivity.this).create();
//        alertDialog.setTitle("Alert");
//        alertDialog.setMessage("App needs to access the Camera.");
//
//        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
//                new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        //finish();
//                    }
//                });

//        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
//                new DialogInterface.OnClickListener() {
//
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        startInstalledAppDetailsActivity(FullscreenActivity.this);
//                    }
//                });
//
//        alertDialog.show();
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_CAMERA: {
//                for (int i = 0, len = permissions.length; i < len; i++) {
//                    String permission = permissions[i];
//
//                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
//                        boolean
//                                showRationale =
//                                ActivityCompat.shouldShowRequestPermissionRationale(
//                                        this, permission);
//
//                        if (showRationale) {
//                            showAlert();
//                        } else if (!showRationale) {
//                            // user denied flagging NEVER ASK AGAIN
//                            // you can either enable some fall back,
//                            // disable features of your app
//                            // or open another dialog explaining
//                            // again the permission and directing to
//                            // the app setting
//                            saveToPreferences(FullscreenActivity.this, ALLOW_KEY, true);
//                        }
//                    }
//                }
//            }

            // other 'case' lines to check for other
            // permissions this app might request
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public static void startInstalledAppDetailsActivity(final Activity context) {
        if (context == null) {
            return;
        }

        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(i);
    }

//    private void openCamera() {
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        startActivityForResult(intent,  REQUEST_TAKE_PHOTO);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
////            mImageVie.setImageBitmap(imageBitmap);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte[] bytes = stream.toByteArray();
//
//            Intent intent = new Intent("android.intent.action.EMOTIWAREHOUSE");
//            intent.putExtra("bitmapbytes",bytes);
//            startActivity(intent);
//        }
//
//    }

    Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {
        public void onShutter() {
            //			 Log.d(TAG, "onShutter'd");
        }
    };

    Camera.PictureCallback rawCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            savePicture(data);

            //			 Log.d(TAG, "onPictureTaken - raw");
        }
    };

    Camera.PictureCallback jpegCallback = new Camera.PictureCallback() {
        public void onPictureTaken(byte[] data, Camera camera) {
            savePicture(data);
            Intent intent = new Intent("android.intent.action.EMOTIWAREHOUSE");
            startActivity(intent);

/*            new SaveImageTask().execute(data);
            resetCam();
            Log.d(TAG, "onPictureTaken - jpeg");*/
        }
    };

    private void captureImage() {
        // TODO Auto-generated method stub
        camera.takePicture(shutterCallback, rawCallback, jpegCallback);
    }

    private void start_camera()
    {
        try{
            camera = Camera.open(1);
        }catch(RuntimeException e){
            Log.e("start", "init_camera: " + e);
            return;
        }
        Camera.Parameters param;
        param = camera.getParameters();
        //modify parameter
        param.setPreviewFrameRate(20);
        param.setPreviewSize(176, 144);
        camera.setParameters(param);
        camera.setDisplayOrientation(90);

        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
            //camera.takePicture(shutter, raw, jpeg)
        } catch (Exception e) {
            Log.e("eror", "init_camera: " + e);
            return;
        }
    }

    private void stop_camera()
    {
        camera.stopPreview();
        camera.release();
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        // TODO Auto-generated method stub
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        start_camera();

    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

}

