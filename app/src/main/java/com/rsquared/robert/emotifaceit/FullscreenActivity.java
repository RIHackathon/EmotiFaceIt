package com.rsquared.robert.emotifaceit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity{
//    /**
//     * Whether or not the system UI should be auto-hidden after
//     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
//     */
//    private static final boolean AUTO_HIDE = true;
//
//    /**
//     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
//     * user interaction before hiding the system UI.
//     */
//    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
//    private Camera mCamera = null;
//    private CameraView mCameraView = null;
//    /**
//     * Some older devices needs a small delay between UI widget updates
//     * and a change of the status and navigation bar.
//     */
//    private static final int UI_ANIMATION_DELAY = 300;
//    private final Handler mHideHandler = new Handler();
//    private View mContentView;
//    private final Runnable mHidePart2Runnable = new Runnable() {
//        @SuppressLint("InlinedApi")
//        @Override
//        public void run() {
//            // Delayed removal of status and navigation bar
//
//            // Note that some of these constants are new as of API 16 (Jelly Bean)
//            // and API 19 (KitKat). It is safe to use them, as they are inlined
//            // at compile-time and do nothing on earlier devices.
//            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
//                    | View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//        }
//    };
//    private View mControlsView;
//    private final Runnable mShowPart2Runnable = new Runnable() {
//        @Override
//        public void run() {
//            // Delayed display of UI elements
//            ActionBar actionBar = getSupportActionBar();
//            if (actionBar != null) {
//                actionBar.show();
//            }
//            mControlsView.setVisibility(View.VISIBLE);
//        }
//    };
//    private boolean mVisible;
//    private final Runnable mHideRunnable = new Runnable() {
//        @Override
//        public void run() {
//            hide();
//        }
//    };
//    /**
//     * Touch listener to use for in-layout UI controls to delay hiding the
//     * system UI. This is to prevent the jarring behavior of controls going away
//     * while interacting with activity UI.
//     */
//    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
//        @Override
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            if (AUTO_HIDE) {
//                delayedHide(AUTO_HIDE_DELAY_MILLIS);
//            }
//            return false;
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_fullscreen);
//
//
//        try{
//            mCamera = Camera.open();//you can use open(int) to use different cameras
//        } catch (Exception e){
//            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
//        }
//
//        if(mCamera != null) {
//            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
//            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
//            camera_view.addView(mCameraView);//add the SurfaceView to the layout
//        }
//
//        //btn to close the application
//        ImageButton imgClose = (ImageButton)findViewById(R.id.imgClose);
//        imgClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.exit(0);
//            }
//        });
//
////        mControlsView = findViewById(R.id.fullscreen_content_controls);
////        mContentView = findViewById(R.id.fullscreen_content);
//
//
//        // Set up the user interaction to manually show or hide the system UI.
////        mContentView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                toggle();
////            }
////        });
////    }
//
//        // Upon interacting with UI controls, delay any scheduled hide()
//        // operations to prevent the jarring behavior of controls going away
//        // while interacting with the UI.
////        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
////    }
//
////    @Override
////    protected void onPostCreate(Bundle savedInstanceState) {
////        super.onPostCreate(savedInstanceState);
////
////        // Trigger the initial hide() shortly after the activity has been
////        // created, to briefly hint to the user that UI controls
////        // are available.
////        delayedHide(100);
//    }
//
//    private void toggle() {
//        if (mVisible) {
//            hide();
//        } else {
//            show();
//        }
//    }
//
//    private void hide() {
//        // Hide UI first
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }
//        mControlsView.setVisibility(View.GONE);
//        mVisible = false;
//
//        // Schedule a runnable to remove the status and navigation bar after a delay
//        mHideHandler.removeCallbacks(mShowPart2Runnable);
//        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
//    }
//
//    @SuppressLint("InlinedApi")
//    private void show() {
//        // Show the system bar
//        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        mVisible = true;
//
//        // Schedule a runnable to display UI elements after a delay
//        mHideHandler.removeCallbacks(mHidePart2Runnable);
//        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
//    }
//
//    /**
//     * Schedules a call to hide() in [delay] milliseconds, canceling any
//     * previously scheduled calls.
//     */
//    private void delayedHide(int delayMillis) {
//        mHideHandler.removeCallbacks(mHideRunnable);
//        mHideHandler.postDelayed(mHideRunnable, delayMillis);
//    }
//
//
//
////    public class CameraView extends SurfaceView implements SurfaceHolder.Callback {
////
////        public CameraView(Context context, Camera camera) {
////            super(context);
////        }
////
////        @Override
////        public void surfaceCreated(SurfaceHolder surfaceHolder) {
////
////        }
////
////        @Override
////        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
////
////        }
////
////        @Override
////        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
////
////        }
////
////        private SurfaceHolder mHolder;
////        private Camera mCamera;
////
////        public FullscreenActivity(Context context, Camera camera) {
////            super(context);
////
////            mCamera = camera;
////            mCamera.setDisplayOrientation(90);
////            //get the holder and set this class as the callback, so we can get camera data here
////            mHolder = getHolder();
////            mHolder.addCallback(this);
////            mHolder.setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
////        }
////
////        @Override
////        public void surfaceCreated(SurfaceHolder surfaceHolder) {
////            try {
////                //when the surface is created, we can set the camera to draw images in this surfaceholder
////                mCamera.setPreviewDisplay(surfaceHolder);
////                mCamera.startPreview();
////            } catch (IOException e) {
////                Log.d("ERROR", "Camera error on surfaceCreated " + e.getMessage());
////            }
////        }
////
////        @Override
////        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
////            //before changing the application orientation, you need to stop the preview, rotate and then start it again
////            if (mHolder.getSurface() == null)//check if the surface is ready to receive camera data
////                return;
////
////            try {
////                mCamera.stopPreview();
////            } catch (Exception e) {
////                //this will happen when you are trying the camera if it's not running
////            }
////
////            //now, recreate the camera preview
////            try {
////                mCamera.setPreviewDisplay(mHolder);
////                mCamera.startPreview();
////            } catch (IOException e) {
////                Log.d("ERROR", "Camera error on surfaceChanged " + e.getMessage());
////            }
////        }
////
////        @Override
////        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
////            //our app has only one screen, so we'll destroy the camera in the surface
////            //if you are unsing with more screens, please move this code your activity
////            mCamera.stopPreview();
////            mCamera.release();
////        }
////
////        private Camera mCamera = null;
////        private CameraView mCameraView = null;
////
////        protected void onCreate(Bundle savedInstanceState) {
////            super.onCreate(savedInstanceState);
////            setContentView(R.layout.activity_fullscreen);
////
////            try {
////                mCamera = Camera.open();//you can use open(int) to use different cameras
////            } catch (Exception e) {
////                Log.d("ERROR", "Failed to get camera: " + e.getMessage());
////            }
////
////            if (mCamera != null) {
////                mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
////                FrameLayout camera_view = (FrameLayout) findViewById(R.id.camera_view);
////                camera_view.addView(mCameraView);//add the SurfaceView to the layout
////            }
////
////            //btn to close the application
////            ImageButton imgClose = (ImageButton) findViewById(R.id.imgClose);
////            imgClose.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    System.exit(0);
////                }
////            });
////        }
////    }

    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 100;
    public static final String ALLOW_KEY = "ALLOWED";
    public static final String CAMERA_PREF = "camera_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (getFromPref(this, ALLOW_KEY)) {
                showSettingsAlert();
            } else if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CAMERA)

                    != PackageManager.PERMISSION_GRANTED) {

                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.CAMERA)) {
                    showAlert();
                } else {
                    // No explanation needed, we can request the permission.
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CAMERA},
                            MY_PERMISSIONS_REQUEST_CAMERA);
                }
            }
        } else {
            openCamera();
        }

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

    private void showAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ALLOW",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ActivityCompat.requestPermissions(MainActivity.this,
                                new String[]{Manifest.permission.CAMERA},
                                MY_PERMISSIONS_REQUEST_CAMERA);
                    }
                });
        alertDialog.show();
    }

    private void showSettingsAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startInstalledAppDetailsActivity(MainActivity.this);
                    }
                });

        alertDialog.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                for (int i = 0, len = permissions.length; i < len; i++) {
                    String permission = permissions[i];

                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        boolean
                                showRationale =
                                ActivityCompat.shouldShowRequestPermissionRationale(
                                        this, permission);

                        if (showRationale) {
                            showAlert();
                        } else if (!showRationale) {
                            // user denied flagging NEVER ASK AGAIN
                            // you can either enable some fall back,
                            // disable features of your app
                            // or open another dialog explaining
                            // again the permission and directing to
                            // the app setting
                            saveToPreferences(MainActivity.this, ALLOW_KEY, true);
                        }
                    }
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

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

    private void openCamera() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
}
}
