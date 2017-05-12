package graphs;

//commented until library can be added to gradle
//*
import java.awt.Color;
import java.awt.BasicStroke;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import javax.swing.*;

/**
 * The XYLineChart_AWT class is used to create the graph that is displayed after a simualtion has
 * been run. It takes into account the current energy consumption within a building/room created
 * an represents this data with relation to Light, Gas, Heating and Electricity.
 */

public class XYLineChart_AWT extends JFrame
{
    public XYLineChart_AWT(String applicationTitle, String chartTitle, ArrayList<Double> electricityUsage, ArrayList<Double> lightUsage, ArrayList<Double> heatingUsage, ArrayList<Double> gas)
    {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Time (Minutes)" ,
                "Energy Usage (KwH)" ,
                createDataset(lightUsage,heatingUsage,electricityUsage,gas) ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.BLUE );
        renderer.setSeriesPaint( 3 , Color.BLACK );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    public XYDataset createDataset(ArrayList<Double> lightUsage, ArrayList<Double> heatingUsage, ArrayList<Double> electricityUsage, ArrayList<Double> gas)
    {
        final XYSeries electricity = new XYSeries( "Electricity" );
        final XYSeries Gas = new XYSeries( "Gas" );
        final XYSeries light = new XYSeries( "Light" );
        final XYSeries heating = new XYSeries( "Heating" );
        for(int x =0;x<electricityUsage.size();x++)
        {
            electricity.add(x*5,electricityUsage.get(x));
            Gas.add(x*5, gas.get(x));
            light.add(x*5, lightUsage.get(x));
            heating.add(x*5, heatingUsage.get(x));

        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(electricity);
        dataset.addSeries(Gas);
        dataset.addSeries(light);
        dataset.addSeries(heating);
        return dataset;
    }
}
