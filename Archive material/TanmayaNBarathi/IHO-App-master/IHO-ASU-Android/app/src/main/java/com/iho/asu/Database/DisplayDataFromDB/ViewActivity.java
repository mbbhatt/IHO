package com.iho.asu.Database.DisplayDataFromDB;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.iho.asu.Database.Columns;
import com.iho.asu.MainActivity;
import com.iho.asu.Pages.FieldNotes;
import com.iho.asu.Pages.NewsEvents;
import com.iho.asu.R;


public class ViewActivity extends Activity implements View.OnClickListener {
    private String link ="";
    private String eventLink="";
    private String email ="";

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_view);
        Intent i = getIntent();
        String typeOfView = i.getStringExtra("ViewNeeded");
        Fragment returnFragment = getTheTypeOfFragment(typeOfView,i);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.per_view, returnFragment);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        Intent i= new Intent(this,MainActivity.class );
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.customLecturerGalleryBackbutton:
                PerLecturerViewFragment fragment = new PerLecturerViewFragment();
                ft.replace(R.id.per_view, fragment);
                ft.commit();
                break;
            case R.id.customLecturerBackbutton:
                LecturerFragment lecturerFragment = new LecturerFragment();
                ft.replace(R.id.per_view,lecturerFragment);
                ft.commit();
                break;
            case R.id.customNewsBackbutton:
                NewsFragment newsFragment = new NewsFragment();
                ft.replace(R.id.per_view, newsFragment);
                ft.commit();
                break;
            case R.id.eventsLink:
            case R.id.newsLink:
            case R.id.lectureLink:
            case R.id.scienceLink:
            case R.id.travelLink:
                startActivity(intent);
                break;
            case R.id.registerEvent:
                uri = Uri.parse(eventLink);
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.viewGallery:
                LecturerGalleryFragment gFragment = new LecturerGalleryFragment(email);
                ft.replace(R.id.per_view, gFragment);
                ft.commit();
                break;
            case R.id.customEventsBackbutton:
                EventsFragment eFragment = new EventsFragment();
                ft.replace(R.id.per_view, eFragment);
                ft.commit();
                break;
            case R.id.customScienceBackbutton:
                ScienceFragment sFragment = new ScienceFragment();
                ft.replace(R.id.per_view, sFragment);
                ft.commit();
                break;
            case R.id.emailButton:
                Intent emailI = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",email,null));
                startActivity(Intent.createChooser(emailI, "Choose an Email Client:"));
                break;
            case R.id.customFNBackbutton:
                MainActivity.fragment = new FieldNotes();
                startActivity(i);
                break;
            case R.id.customNEBackButton:
                MainActivity.fragment = new NewsEvents();
                startActivity(i);
                break;
        }
    }

    private Fragment getTheTypeOfFragment(String type, Intent i){
        Fragment returnFragment = new Fragment();
        if(type.equalsIgnoreCase("Lecturer")){
            returnFragment = new PerLecturerViewFragment();
            link = i.getStringExtra(Columns.KEY_LECTURER_LINK.getColumnName());
            email = i.getStringExtra(Columns.KEY_LECTURER_EMAIL.getColumnName());
        } else if(type.equalsIgnoreCase("News")){
            returnFragment = new PerNewsViewFragment();
            link = i.getStringExtra(Columns.KEY_NEWS_LINK.getColumnName());
        } else if(type.equalsIgnoreCase("Events")){
            returnFragment = new PerEventsViewFragment();
            link = i.getStringExtra(Columns.KEY_EVENT_MAP.getColumnName());
            eventLink = i.getStringExtra(Columns.KEY_EVENT_REG.getColumnName());
        } else if(type.equalsIgnoreCase("Science")){
            returnFragment = new PerScienceViewFragment();
            link = i.getStringExtra(Columns.KEY_SCIENCE_LINK.getColumnName());
        }else if(type.equalsIgnoreCase("Travel")){
            returnFragment = new PerTravelViewFragment();
            link = i.getStringExtra(Columns.KEY_TRAVEL_LINK.getColumnName());
        }
        return returnFragment;
    }

    @Override
    public void onStart(){
        super.onStart();
    }




}