package com.example.bryanchan.angelhackkl2016;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    public View v;
    public class PersonViewHolder extends RecyclerView.ViewHolder {


        CardView cv;
        TextView personname;
        TextView personcontact;
        TextView persontitle;
        ImageView personImage;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            personname = (TextView) itemView.findViewById(R.id.card_Name);
            personcontact = (TextView) itemView.findViewById(R.id.card_contactNum);
            persontitle = (TextView) itemView.findViewById(R.id.card_title);
            personImage = (ImageView) itemView.findViewById(R.id.profile_image);
            v = itemView;
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View viewItem) {
                    Intent intent = new Intent(v.getContext(), PeopleProfile.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
    List<Person> person_list;

    PersonAdapter(List<Person> person_list){
        this.person_list = person_list;
    }
    @Override
    public int getItemCount() {
        return person_list.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_acitivty_fragment_cardview, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personname.setText(String.valueOf(person_list.get(i).name));
        personViewHolder.personcontact.setText(String.valueOf(person_list.get(i).contactnum));
        personViewHolder.persontitle.setText(String.valueOf(person_list.get(i).title));
        Log.e("TAG", ""+person_list.get(i).imagelink);
//        Picasso.with(v.getContext())
//                .load(person_list.get(i).imagelink)
//                .resize(96, 96).centerCrop()
//                .into(personViewHolder.personImage);
////        personViewHolder.personImage.setImageDrawable(String.valueOf(person_list.get(i).imagelink));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
