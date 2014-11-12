package de.alosdev.android.devfestist14;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import de.alosdev.cloud.devfestist14.myApi.MyApi;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

  EditText editText;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    editText = (EditText) findViewById(R.id.edittext);
    textView = (TextView) findViewById(R.id.textview2);
    findViewById(R.id.button).setOnClickListener(this);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onClick(View v) {
    if (R.id.button == v.getId()) {

      new AsyncTask<String, Void, String>() {

        @Override
        protected String doInBackground(String... params) {
          try {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
            builder.setRootUrl("http://10.0.2.2:8080/_ah/api").setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
              @Override
              public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                abstractGoogleClientRequest.setDisableGZipContent(true);
              }
            });
            MyApi myApi = builder.build();
            return myApi.sayHi(params[0]).execute().getData();
          } catch (IOException e) {
            Log.e(MainActivity.class.getSimpleName(), "cannot contact service", e);
          } finally {

          }
          return null;
        }

        @Override
        protected void onPostExecute(String s) {
          textView.setText(s);
        }
      }.execute(editText.getText().toString());
    }
  }
}
