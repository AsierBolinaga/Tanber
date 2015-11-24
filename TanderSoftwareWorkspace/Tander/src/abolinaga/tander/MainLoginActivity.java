package abolinaga.tander;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import abolinaga.tander.custom.CustomActivity;

public class MainLoginActivity extends CustomActivity
{
    private EditText editTextLogingUserName;
    private EditText editTextLogingPassword;

    private Button buttonGoToRegister;
    private Button buttonLogin;
    
    @Override
    protected void onCreate(Bundle _bndSavedInstanceState) 
    {
        super.onCreate(_bndSavedInstanceState);
        setContentView(R.layout.login);
        
        editTextLogingUserName = (EditText) findViewById(R.id.username);
        editTextLogingPassword = (EditText) findViewById(R.id.password);
        
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonGoToRegister = (Button) findViewById(R.id.buttonGoToRegister);
        
        //Setting listeners to button
        buttonLogin.setOnClickListener(this);
        buttonGoToRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View _v) 
    {
        if(_v == buttonGoToRegister)
        {                    
			startActivity(new Intent(MainLoginActivity.this, RegisterActivity.class));
        }
        else if(_v == buttonLogin)
        {
        	loginUser();
        }
        else
        {
        	/* Do nothing */
        }
    }
    
    private void loginUser()
    {
    	final String strUsername = editTextLogingUserName.getText().toString().trim();       
    	String strPassword = editTextLogingPassword.getText().toString().trim();
    	
    	 class LoginUserClass extends AsyncTask<String,Void,String>
    	 {
    		ProgressDialog pdLoading;
			
    		@Override            
    		protected void onPreExecute() 
    		{                
    			super.onPreExecute();                
    			pdLoading = ProgressDialog.show(MainLoginActivity.this,"Please Wait",null,true,true);            
    		}
    		
    		@Override
    		protected void onPostExecute(String _strResult) 
    		{
    			super.onPostExecute(_strResult);
    			pdLoading.dismiss();
    			if(_strResult.equalsIgnoreCase("Invalid Username or Password"))
    			{      
    				Toast.makeText(MainLoginActivity.this,_strResult,Toast.LENGTH_LONG).show();  
    			}
    			else
    			{                    
    				Toast.makeText(MainLoginActivity.this,_strResult,Toast.LENGTH_LONG).show();
    			
    				Intent intent = new Intent(MainLoginActivity.this, OptionsActivity.class);                    
    				intent.putExtra("USER_NAME", strUsername);                    
    				startActivity(intent); 
    				finish();
    			}
    		}
			
			protected String doInBackground(String... _strParams) 
			{
				HashMap<String,String> hmData = new HashMap<String,String>();
				hmData.put("username",_strParams[0]);
				hmData.put("password",_strParams[1]);
				
				RequestHandler rh = new RequestHandler();
				
				String strResult = rh.sendPostRequest(Config.URL_LOGGIN_USER, hmData);
				
				return strResult;
			}
    		 
    	 }
    	 
    	 LoginUserClass luc = new LoginUserClass();
    	 luc.execute(strUsername,strPassword);
    }
}
