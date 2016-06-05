package com.example.bryanchan.angelhackkl2016;

import android.net.Uri;

import java.util.ArrayList;

class Person {
    String name;
    String contactnum;
    String title;
    Uri imagelink;

    Person(String name, String contactnum, String title, Uri imagelink) {
        this.name = name;
        this.contactnum = contactnum;
        this.title = title;
        this.imagelink = imagelink;
    }

    private static ArrayList<Person> person_list;

    // This method creates an ArrayList that has three Person objects
    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.
    public static ArrayList<Person> initializeData() {
        person_list = new ArrayList<>();
        person_list.add(new Person("Bryan", "01234567890", "Designer", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
        person_list.add(new Person("Sean", "77785786", "Mechanic", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.plumber)));
        person_list.add(new Person("Marcus", "37273243467", "Freelance Writer", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
        person_list.add(new Person("Jessica", "287267876784", "Photographer", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));
        person_list.add(new Person("William", "345546456", "Manager", Uri.parse("android.resource://com.example.bryanchan.angelhackkl2016/" + R.drawable.profile_picture)));

        return person_list;
    }

}