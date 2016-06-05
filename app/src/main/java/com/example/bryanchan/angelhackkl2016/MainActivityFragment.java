package com.example.bryanchan.angelhackkl2016;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivityFragment extends Fragment
{
    private List<Person> person_list;
    private RecyclerView recList;

    public static MainActivityFragment newInstance(Bundle bundle)
    {
        final MainActivityFragment mainActivityFragment = new MainActivityFragment();

        if (bundle != null)
        {
            mainActivityFragment.setArguments(bundle);
        }

        return mainActivityFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        person_list = Person.initializeData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflateoperly
        final View rootview = inflater.inflate(R.layout.main_activity_fragment_layout, container, false);
        recList = (RecyclerView) rootview.findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        recList.setHasFixedSize(true);
        PersonAdapter adapter = new PersonAdapter(person_list);
        recList.setAdapter(adapter);
        final EditText search = (EditText) rootview.findViewById(R.id.search);
        search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if(search.getText().toString().toUpperCase().equals("PLUMBER")) {
                        person_list = new ArrayList<>();
                        person_list.add(new Person("John", "67475723445", "Plumber", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.plumber)));
                        person_list.add(new Person("Michael", "5465676578", "Plumber", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
                        PersonAdapter adapter = new PersonAdapter(person_list);
                        recList.swapAdapter(adapter, false);
                        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(rootview.getWindowToken(), 0);
                    }
                    else if(search.getText().toString().toUpperCase().equals("MECHANIC")){
                        person_list = new ArrayList<>();
                        person_list.add(new Person("Ali", "34665634365", "Mechanic", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
                        person_list.add(new Person("Tan", "45654535643", "Mechanic", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
                        person_list.add(new Person("Kevin", "12312323", "Mechanic", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
                        person_list.add(new Person("Wong", "453645654646", "Mechanic", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
                        PersonAdapter adapter = new PersonAdapter(person_list);
                        recList.swapAdapter(adapter, false);
                        Toast.makeText(getActivity(), search.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(rootview.getWindowToken(), 0);
                    }
                    else if(search.getText().toString().toUpperCase().equals("JOHN")){
                        person_list = new ArrayList<>();
                        person_list.add(new Person("John", "67475723445", "Plumber", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
                        PersonAdapter adapter = new PersonAdapter(person_list);
                        recList.swapAdapter(adapter, false);
                        Toast.makeText(getActivity(), search.getText().toString().toUpperCase(), Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(rootview.getWindowToken(), 0);
                    }
                    else{
                        Toast.makeText(getActivity(), "No result found...", Toast.LENGTH_SHORT).show();
                        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(rootview.getWindowToken(), 0);
                    }
                    return true;
                }
                return false;
            }
        });
        return rootview;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}