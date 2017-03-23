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

public class XYLineChart_AWT extends JFrame
{
    public XYLineChart_AWT( String applicationTitle, String chartTitle, ArrayList<Double> elec, ArrayList<Double> gas)
    {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Time (24HR)" ,
                "Energy Usage (%)" ,
                createDataset(elec,gas) ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    public XYDataset createDataset(ArrayList<Double> elec, ArrayList<Double> gas)
    {
        final XYSeries electricity = new XYSeries( "Electricity" );
        final XYSeries Gas = new XYSeries( "Gas" );
        for(int x =0;x<elec.size();x++)
        {
            electricity.add(x*5,elec.get(x));
            Gas.add(x*5, gas.get(x));
        }
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(electricity);
        dataset.addSeries(Gas);
        return dataset;
    }
}
