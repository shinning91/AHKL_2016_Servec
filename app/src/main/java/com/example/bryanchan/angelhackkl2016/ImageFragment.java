package com.example.bryanchan.angelhackkl2016;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Fragment showing a solid background color
 */
public class ImageFragment extends Fragment
{
    public static final String sARGUMENT_IMAGE_CODE = "image";

    public static ImageFragment newInstance(Bundle bundle)
    {
        final ImageFragment imageFragment = new ImageFragment();

        if (bundle != null)
        {
            imageFragment.setArguments(bundle);
        }

        return imageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        // The last two arguments ensure LayoutParams are inflated properly
        final View view = inflater.inflate(R.layout.image_fragment, container, false);
        initialise(view);

        return view;
    }

    private void initialise(@NonNull final View view)
    {
//        switch (getArguments().getInt(sARGUMENT_IMAGE_CODE))
//        {
//            case 0:
//                view.findViewById(R.id.neo).setVisibility(View.VISIBLE);
//                view.findViewById(R.id.morpheo).setVisibility(View.GONE);
//                break;
//
//            case 1:
//                view.findViewById(R.id.neo).setVisibility(View.GONE);
//                view.findViewById(R.id.morpheo).setVisibility(View.VISIBLE);
//                break;
//
//        }
    }
}