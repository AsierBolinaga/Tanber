package abolinaga.tander;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import abolinaga.tander.custom.CustomActivity;

public class OptionsActivity extends CustomActivity
{
	private TextView textView;
	
	private Button buttonFindTanderFriend;
    private Button buttonViewTanderFriends;
	
    @Override
    protected void onCreate(Bundle _bdSavedInstanceState)
    {
        super.onCreate(_bdSavedInstanceState);
        setContentView(R.layout.options);

        textView = (TextView) findViewById(R.id.textViewUserName);

        Bundle reicieveUserName = getIntent().getExtras();

        textView.setText("Welcome " + reicieveUserName.getString("USER_NAME"));
        
        buttonFindTanderFriend = (Button) findViewById(R.id.buttonFindTanderFriend);
        buttonViewTanderFriends = (Button) findViewById(R.id.buttonViewTanderFriends);
        
        //Setting listeners to button
        buttonFindTanderFriend.setOnClickListener(this);
        buttonViewTanderFriends.setOnClickListener(this);
    }
    
    @Override
	public void onClick(View _v) 
	{
		if(_v == buttonFindTanderFriend)
        {
        	/* TODO: Friends Finder */
        }
		else if(_v == buttonViewTanderFriends)
		{
			startActivity(new Intent(OptionsActivity.this, TanderFriendsList.class));
		}
		else
		{
			/* Do Nothing */
		}
	}
}
