package isgw.isgw.Graphs;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.Random;

import isgw.isgw.R;


/**
 * Created by vishal on 1/20/17.
 */

public class Realtime extends android.support.v4.app.Fragment {

    private static final String TAG = "Realtime";
    private final Handler mHandler = new Handler();
    private Runnable t1;
    private LineGraphSeries<DataPoint> series1;
    private double lastXVal=5;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rView = inflater.inflate(R.layout.fragment_realtime, container, false);
        GraphView gView = (GraphView) rView.findViewById(R.id.graph);
        series1 = new LineGraphSeries<>();
        series1.setDrawDataPoints(true);
        series1.setDrawBackground(true);
        gView.addSeries(series1);
        gView.setTitle("Unit Consumption");
        gView.getViewport().setXAxisBoundsManual(true);
        gView.getViewport().setMinX(0);
        gView.getViewport().setMaxX(30);
        gView.getGridLabelRenderer().setLabelVerticalWidth(100);
        return rView;
    }


    @Override
    public void onResume() {
        super.onResume();
        t1 = new Runnable() {
            @Override
            public void run() {
                lastXVal++;
                double t=getRand();
                Log.d(TAG, "run: rand"+getRand());
                series1.appendData(new DataPoint(lastXVal,t),true,30);
                mHandler.postDelayed(this, 500);
            }
        };

        mHandler.postDelayed(t1, 1000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mHandler.removeCallbacks(t1);
    }


    /**
     * TODO:
     * This function retrieves data form server
     * use this to get data and implement callback inside this func.
     */
//    private void retrieveData() {
//
//    }

    //// TODO: 1/20/17 to be removed
    private double lastRandVal=2d;
    Random r=new Random();
    private double getRand() {
        return lastRandVal=(lastRandVal+r.nextDouble()*0.7-0.25);
    }




}
