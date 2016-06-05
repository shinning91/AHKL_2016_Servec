package com.example.bryanchan.angelhackkl2016;

import android.media.Image;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * Fragment showing a solid background color
 */
public class MyProfile extends Fragment {
    public static MyProfile newInstance(Bundle bundle) {
        final MyProfile profilefragment = new MyProfile();

        if (bundle != null) {
            profilefragment.setArguments(bundle);
        }

        return profilefragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated properly
        final View view = inflater.inflate(R.layout.my_profile_layout, container, false);
        initialise(view);

        return view;
    }

    private void initialise(final View view) {
//        ImageView profile_img = (ImageView)view.findViewById(R.id.profile_image);
//        Picasso.with(getActivity())
//                .load(Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture))
//                .resize(96, 96).centerCrop()
//                .into(profile_img);
    }

    public void goToPeopleProfile(View view) {
        Intent molPayIntent = new Intent(getActivity(), PeopleProfile.class);
        startActivity(molPayIntent);
    }
}
