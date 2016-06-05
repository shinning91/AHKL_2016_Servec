package com.example.bryanchan.angelhackkl2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private LinearLayout mNavDrawerEntriesRootView;
    private PercentRelativeLayout mFrameLayout_AccountView;
    private FrameLayout mFrameLayout_Home, mFrameLayout_GenerateInvoice, mFrameLayout_ScanInvoice,
            mFrameLayout_SavedContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialise();
    }

    private void initialise()
    {
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setUpIcons();

        mFrameLayout_AccountView = (PercentRelativeLayout) findViewById
                (R.id.navigation_drawer_account_view);

        mNavDrawerEntriesRootView = (LinearLayout)findViewById
                (R.id.navigation_drawer_linearLayout_entries_root_view);

        mFrameLayout_Home = (FrameLayout) findViewById
                (R.id.navigation_drawer_items_list_linearLayout_home);

        mFrameLayout_GenerateInvoice = (FrameLayout) findViewById
                (R.id.navigation_drawer_items_list_linearLayout_explore);

        mFrameLayout_ScanInvoice = (FrameLayout) findViewById
                (R.id.navigation_drawer_items_list_linearLayout_scaninvoice);

        mFrameLayout_SavedContact = (FrameLayout) findViewById
                (R.id.navigation_drawer_items_list_linearLayout_savedcontact);

        // Navigation Drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_activity_DrawerLayout);

        final ScrimInsetsFrameLayout mScrimInsetsFrameLayout = (ScrimInsetsFrameLayout)
                findViewById(R.id.main_activity_navigation_drawer_rootLayout);

        final ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.navigation_drawer_opened, R.string.navigation_drawer_closed) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                // Disables the burger/arrow animation by default
                super.onDrawerSlide(drawerView, 0);
            }
        };

        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        mActionBarDrawerToggle.syncState();

        final int possibleMinDrawerWidth =
                utilsdevice.getScreenWidth(this) -
                        UtilsMiscellaneous
                                .getThemeAttributeDimensionSize(this, android.R.attr.actionBarSize);

        final int maxDrawerWidth = getResources().getDimensionPixelSize(R.dimen.navigation_drawer_max_width);

        mScrimInsetsFrameLayout.getLayoutParams().width =
                Math.min(possibleMinDrawerWidth, maxDrawerWidth);

        // Nav Drawer item click listener
        mFrameLayout_AccountView.setOnClickListener(this);
        mFrameLayout_Home.setOnClickListener(this);
        mFrameLayout_GenerateInvoice.setOnClickListener(this);
        mFrameLayout_ScanInvoice.setOnClickListener(this);
        mFrameLayout_SavedContact.setOnClickListener(this);
//        mFrameLayout_HelpAndFeedback.setOnClickListener(this);
//        mFrameLayout_About.setOnClickListener(this);

        // Set the first item as selected for the first time
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(R.string.toolbar_title_home);
        }

        mFrameLayout_Home.setSelected(true);

        // Create the first fragment to be shown
        final Bundle bundle = new Bundle();
        bundle.putInt(ImageFragment.sARGUMENT_IMAGE_CODE, 0);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_activity_content_frame, MainActivityFragment.newInstance(bundle))
                .commit();
    }

    @Override
    public void onClick(View view)
    {
        if (view == mFrameLayout_AccountView)
        {
            mDrawerLayout.closeDrawer(GravityCompat.START);

            // SignUp/SignIn/Profile
//            startActivity(new Intent(view.getContext(), MyProfile.class));
            final Bundle bundle = new Bundle();
//            bundle.putInt(ImageFragment.sARGUMENT_IMAGE_CODE, 0);

            // Insert the fragment by replacing any existing fragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_activity_content_frame, MyProfile.newInstance(bundle))
                    .commit();
        }
        else
        {
            if (!view.isSelected())
            {
                onRowPressed((FrameLayout) view);

                if (view == mFrameLayout_Home)
                {
//                    if (getSupportActionBar() != null)
//                    {
//                        getSupportActionBar().setTitle(getString(R.string.toolbar_title_home));
//                    }

                    view.setSelected(true);

                    final Bundle bundle = new Bundle();
                    bundle.putInt(ImageFragment.sARGUMENT_IMAGE_CODE, 0);

                    // Insert the fragment by replacing any existing fragment
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_activity_content_frame, MainActivityFragment.newInstance(bundle))
                            .commit();
                }
                else if (view == mFrameLayout_GenerateInvoice)
                {
//                    if (getSupportActionBar() != null)
//                    {
//                        getSupportActionBar().setTitle("Generate Invoice");
//                    }

                    view.setSelected(true);

                    Intent molPayIntent = new Intent(this, InvoiceGenerator.class);
                    startActivity(molPayIntent);
                }
                else if (view == mFrameLayout_ScanInvoice)
                {
//                    if (getSupportActionBar() != null)
//                    {
//                        getSupportActionBar().setTitle("Generate Invoice");
//                    }

                    view.setSelected(true);

                    Intent scanInvoice = new Intent(this, InvoiceReceiver.class);
                    startActivity(scanInvoice);
                }
                else if (view == mFrameLayout_SavedContact)
                {
//                    if (getSupportActionBar() != null)
//                    {
//                        getSupportActionBar().setTitle("Generate Invoice");
//                    }

                    view.setSelected(true);

                    Intent savedcontact = new Intent(this, SavedContact.class);
                    startActivity(savedcontact);
                }
            }
            else
            {
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }
        }
    }

    /**
     * Set up the rows when any is pressed
     *
     * @param pressedRow is the pressed row in the drawer
     */
    private void onRowPressed(@NonNull final FrameLayout pressedRow)
    {
        if (pressedRow.getTag() != getResources().getString(R.string.tag_nav_drawer_special_entry))
        {
            for (int i = 0; i < mNavDrawerEntriesRootView.getChildCount(); i++)
            {
                final View currentView = mNavDrawerEntriesRootView.getChildAt(i);

                final boolean currentViewIsMainEntry = currentView.getTag() ==
                        getResources().getString(R.string.tag_nav_drawer_main_entry);

                if (currentViewIsMainEntry)
                {
                    currentView.setSelected(currentView == pressedRow);
                }
            }
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    /**
     * Sets a tint list to the icons
     *
     * Uses DrawableCompat to make it work before SKD 21
     */
    private void setUpIcons()
    {
        // Icons tint list
        final ImageView homeImageView =
                (ImageView) findViewById(R.id.navigation_drawer_items_list_icon_home);
        final Drawable homeDrawable = DrawableCompat.wrap(homeImageView.getDrawable());
        DrawableCompat.setTintList
                (
                        homeDrawable.mutate(),
                        ContextCompat.getColorStateList(this, R.color.nav_drawer_icon)
                );

        homeImageView.setImageDrawable(homeDrawable);

        final ImageView exploreImageView =
            (ImageView) findViewById(R.id.navigation_drawer_items_list_icon_explore);
        final Drawable exploreDrawable = DrawableCompat.wrap(exploreImageView.getDrawable());
        DrawableCompat.setTintList
                (
                        exploreDrawable.mutate(),
                        ContextCompat.getColorStateList(this, R.color.nav_drawer_icon)
                );

        exploreImageView.setImageDrawable(exploreDrawable);

        final ImageView scanImageView =
                (ImageView) findViewById(R.id.navigation_drawer_items_list_icon_scaninvoice);
        final Drawable scanDrawable = DrawableCompat.wrap(scanImageView.getDrawable());
        DrawableCompat.setTintList
                (
                        scanDrawable.mutate(),
                        ContextCompat.getColorStateList(this, R.color.nav_drawer_icon)
                );

        scanImageView.setImageDrawable(scanDrawable);

        final ImageView savedcontactImageView =
                (ImageView) findViewById(R.id.navigation_drawer_items_list_icon_savedcontact);
        final Drawable savedContactDrawable = DrawableCompat.wrap(savedcontactImageView.getDrawable());
        DrawableCompat.setTintList
                (
                        savedContactDrawable.mutate(),
                        ContextCompat.getColorStateList(this, R.color.nav_drawer_icon)
                );

        savedcontactImageView.setImageDrawable(savedContactDrawable);
    }

    public void goToMolPay(View view)
    {
        Intent molPayIntent = new Intent(MainActivity.this, InvoiceReceiver.class);
        startActivity(molPayIntent);
    }


}
