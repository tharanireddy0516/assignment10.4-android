package com.example.tharani.actionbartabs;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener   {
    /*onCreate is the first method in the life cycle of an activity
    * savedInstance passes data to super class,data is pull to store state of application
    * setContentView is used to set layout for the activity
    *  R is a resource and it is auto generate file
    * activity_main assign an integer value
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //here we are creating object for the action bar
        /*A primary toolbar within the activity that may display the activity title, application-level navigation affordances, and other interactive items.
        The app bar, also known as the action bar, is one of the most important design elements in your app's activities
         because it provides a visual structure and interactive elements that are familiar to us*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        //The mipmap folders are for placing your app/launcher icons
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);
        /*in action bar contains navigation mode that means for information about how to use the action bar, including how to add action items, navigation modes*/

        actionBar.addTab(actionBar.newTab().setText("AUDIO").setIcon(R.mipmap.ic_launcher)
                .setTabListener(this));
        //here we are adding tab in the action bar for AUDIO,VIDEO
        //this gives reference
        actionBar.addTab(actionBar.newTab().setText("VIDEO").setIcon(R.mipmap.ic_launcher)
                .setTabListener(this));

    }
    /*onTabSelected is t notify the viewPage
    * FragmentTransaction  is allowed to be added to the back stack.
    *By using Toast we can display the toast notification by calling show() method*/
    @Override
    public void onTabSelected (ActionBar.Tab tab, FragmentTransaction ft){
        //here we are applying condition for selecting the tab
        int currentTab=tab.getPosition();//getsPosition
        Toast.makeText(this, "Current Tab " + currentTab, Toast.LENGTH_SHORT).show();
        switch (currentTab) {//using Switch case
            /*Switch is a multi branch statement,dispatch execution to different parts of code*/
            case 0:
                setContentView(R.layout.tab_one);//for tab_one
                break;//terminates
            case 1:
                setContentView(R.layout.tab_two);//for tab_two
                break;//terminates
        }
    }
    @Override
    public void onTabUnselected (ActionBar.Tab tab, FragmentTransaction ft){
        /*Toast messages are a quick way of telling the user something.
         They are short pop-up messages that show for a second or two and then fade away. Here's a basic Toast.
         It pops up near the bottom of the screen.*/
        Toast.makeText(this, tab.getText()+ " is unSelected", Toast.LENGTH_LONG).show();
        //Toast.LENGTH_LONG Means display in long period of time that is 3 to 5 seconds
    }

    @Override
    public void onTabReselected (ActionBar.Tab tab, FragmentTransaction ft){
       // FragmentTransaction  is allowed to be added to the back stack.
        Toast.makeText(this, tab.getText()+ " is Selected", Toast.LENGTH_LONG).show();

        //Toast.LENGTH_LONG Means display in long period of time that is 3 to 5 seconds

    }
}
