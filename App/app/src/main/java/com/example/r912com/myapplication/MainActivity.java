package com.example.r912com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity {

    private final BT_comm bl = new BT_comm();
    private OutputStreamWriter out;
    /*
    Button emergency = (Button)findViewById(R.id.e_stop);
    Button stop = (Button) findViewById(R.id.stop);
    Button resume = (Button) findViewById(R.id.resume);
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btn = (Button) findViewById(R.id.button);
            Button A = (Button) findViewById(R.id.main_a);


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                bl.enableBT();
                if (!bl.connectToNXTs())
                    Toast.makeText(MainActivity.this, "FAIL", Toast.LENGTH_SHORT).show();

                    try {
                        out =new OutputStreamWriter(bl.socket_nxt1.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        });

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                try {
                    out.write(0);
                    out.flush();
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               // emergency.setVisibility(View.VISIBLE);
               // stop.setVisibility(View.VISIBLE);
              //  resume.setVisibility(View.VISIBLE);

            }
        });
        ((Button) findViewById(R.id.main_b)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                try {
                    out.write(1);
                    out.flush();
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               // emergency.setVisibility(View.VISIBLE);
               // stop.setVisibility(View.VISIBLE);
              //  resume.setVisibility(View.VISIBLE);
            }
        });
        ((Button) findViewById(R.id.stop)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                try {
                    out.write(2);
                    out.flush();
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.e_stop)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                try {
                    out.write(3);
                    out.flush();
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.resume)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                try {
                    out.write(4);
                    out.flush();
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
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
}
