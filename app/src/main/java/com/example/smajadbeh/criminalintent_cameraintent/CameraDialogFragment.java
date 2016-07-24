package com.example.smajadbeh.criminalintent_cameraintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.util.UUID;

/**
 * Created by smajadbeh on 7/20/2016.
 */
public class CameraDialogFragment extends DialogFragment {

    private File myPhotoFile;

    public static CameraDialogFragment newInstance(File mPhotoFile){
        Bundle args = new Bundle();
        args.putSerializable("SS", mPhotoFile);

        CameraDialogFragment fragment = new CameraDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myPhotoFile = (File) getArguments().getSerializable("SS");

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.cam_layout, null);





        if(myPhotoFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(myPhotoFile.getAbsolutePath());

            ImageView myImage = (ImageView) v.findViewById(R.id.imageView1);

            myImage.setImageBitmap(myBitmap);

        }



        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }

}
