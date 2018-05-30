package com.example.navaneethreddy.towersofhanoi;

import android.view.ViewGroup;

public class Tower
{
    private Disk top;
    private ViewGroup theView;
    private int count;

    public Tower(ViewGroup theView)
    {
        this.theView = theView;
        this.theView.removeAllViews();
        this.top = null;
        this.count = 0;
    }

    /*
    currently does NOT check the Tower of Hanoi rules for placing a disk
    1. if the tower is empty, a push is allowed
    2. otherwise, if the disk at the top of the tower is larger than the
       disk I am trying to push it is a LEGAL move
    3. If the disk at the top of the tower is smaller than the disk I am
       trying to push, then it is an ILLEGAL move and should not be allowed
    HINT: Make this guy return true when a move was successfully made, and
          false otherwise.  This way you know whether to clear out the landing
          zone, or reset it to what it was before we tried to make this move.
     */
    public void push(Disk d)
    {
        if(this.top == null)
        {
            this.top = d;
        }
        else
        {
            d.setNextDisk(this.top);
            this.top = d;
        }
        this.count ++;
        //visually put this disk at the top of this view
        this.theView.addView(d.getTheView(), 0);
    }

    public Disk pop()
    {
        Disk diskToReturn = this.top;

        if(this.top != null)
        {
            this.top = this.top.getNextDisk();
            diskToReturn.setNextDisk(null);
            this.count--;
            this.theView.removeViewAt(0);
        }
        return diskToReturn;
    }
    public int getNumOfDisks()
    {
        return this.count;
    }

    public Disk peek()
    {
        return this.top;
    }

}