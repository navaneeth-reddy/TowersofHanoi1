package com.example.navaneethreddy.towersofhanoi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Tower t1;
    private Tower t2;
    private Tower t3;
    private Disk d1;
    private Disk d2;
    private Disk d3;
    private Disk temp = null;
    private ViewGroup landingZone;

    TextView tv1 = (TextView)findViewById(R.id.disk1TV);
    TextView tv2 = (TextView)findViewById(R.id.disk2TV);
    TextView tv3 = (TextView)findViewById(R.id.disk3TV);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.landingZone = (ViewGroup)this.findViewById(R.id.landingZone);


        d1 = new Disk(1, (TextView) this.findViewById(R.id.disk1TV));
        d2 = new Disk(2, (TextView) this.findViewById(R.id.disk2TV));
        d3 = new Disk(3, (TextView) this.findViewById(R.id.disk3TV));

        t1 = new Tower((ViewGroup)this.findViewById(R.id.tower1Layout));
        t2 = new Tower((ViewGroup)this.findViewById(R.id.tower2Layout));
        t3 = new Tower((ViewGroup)this.findViewById(R.id.tower3Layout));

        //put the disks into t1
        t1.push(d3);
        t1.push(d2);
        t1.push(d1);

    }

    public void onResetButtonPressed(View V)
    {

        if(t2.peek()!=null) {
            t2.pop();
        }
        if (t2.peek()!= null){
                t2.pop();
        }
        if (t2.peek()!= null){
            t2.pop();
        }

        if(t3.peek()!=null) {
            t3.pop();
        }
        if (t3.peek()!= null){
            t3.pop();
        }
        if (t3.peek()!= null){
            t3.pop();
        }

        t1.push(d3);
        t1.push(d2);
        t1.push(d1);
    }

    public int getIntFromStr(String num)
    {
        int res = 0;
        int len = num.length();

        for (int i = 0; (i < len); i++)
        {
            if (num.charAt(i) != ' ' && num.charAt(i) != '=')
                res = res * 10 + (num.charAt(i) - '0');
        }
        return res;
    }

    public void tower1ButtonPressed(View v)
    {
        if(temp == null)
        {
            if(t1.peek() != null)
            {
                //pop top of tower 1 into temp
                this.temp = this.t1.pop();
                this.landingZone.addView(this.temp.getTheView());
            }
        }
        else
        {
            /*
            remove view from landing zone so it can POTENTIALLY be added
            to the tower.

            if the push is successful, set temp to null indicating the
            landing zone is empty, otherwise, put the view back in the
            landing zone so it is visually there, and don't set temp to
            null, since the move was not a legal move.
             */
            int top;
            if (this.t1.peek() != null) {
                top = this.t1.peek().getSize();
                TextView myView = (TextView) this.landingZone.getChildAt(0);

                String num = new String( myView.getText().toString());

                if (getIntFromStr(num) > top) {
                    System.out.print("Invalid Move from tower t1");
                    Toast.makeText(this, "Invalid Move from tower t1 ", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            this.landingZone.removeAllViews();
            this.t1.push(this.temp);
            this.temp = null;
        }
    }
    public void tower2ButtonPressed(View v)
    {
        if(temp == null)
        {
            if(t2.peek() != null)
            {
                //pop top of tower 1 into temp
                this.temp = this.t2.pop();
                this.landingZone.addView(this.temp.getTheView());
            }
        }
        else
        {

            int top;
            if (this.t2.peek() != null) {

                top = this.t2.peek().getSize();
                TextView myView = (TextView) this.landingZone.getChildAt(0);

                String num = new String( myView.getText().toString());

                if (getIntFromStr(num) > top) {
                    System.out.print("Invalid Move from tower t2");
                    Toast.makeText(this, "Invalid Move from tower t2", Toast.LENGTH_SHORT ).show();
                    return;
                }
            }

            this.landingZone.removeAllViews();
            this.t2.push(this.temp);
            this.temp = null;

        }
    }
    public void tower3ButtonPressed(View v)
    {
        if(temp == null)
        {
            if(t3.peek() != null)
            {
                //pop top of tower 1 into temp
                this.temp = this.t3.pop();
                this.landingZone.addView(this.temp.getTheView());
            }
        }
        else
        {

            int top;
            if (this.t3.peek() != null) {
                top = this.t3.peek().getSize();
                TextView myView = (TextView) this.landingZone.getChildAt(0);

                String num = new String( myView.getText().toString());

                if (getIntFromStr(num) > top) {
                    System.out.print("Invalid Move from tower t3");
                    Toast.makeText(this, "Invalid Move from tower t3", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            this.landingZone.removeAllViews();
            this.t3.push(this.temp);
            if ((t3.getNumOfDisks() == 3) && (t3.peek().getSize() == 1) )
            {
                Toast.makeText(this, "You Won!", Toast.LENGTH_SHORT ).show();
                Intent i = new Intent(this, WinnerActivity.class);
                startActivity(i);
            }
            this.temp = null;
        }
    }


}