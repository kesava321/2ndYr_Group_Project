package graphs;

import java.awt.Color;
import java.awt.BasicStroke;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.ui.RefineryUtilities;

class XYLineChart_AWT extends ApplicationFrame
{
    public XYLineChart_AWT( String applicationTitle, String chartTitle )
    {
        super(applicationTitle);
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                chartTitle ,
                "Time (24HR)" ,
                "Energy Usage (%)" ,
                createDataset() ,
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot( );
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


    private XYDataset createDataset( )
    {
        final XYSeries electricity = new XYSeries( "Electricity" );
        electricity.add( 06.00 , 10.0 );
        electricity.add( 09.00 , 60.0 );
        electricity.add( 12.00 , 50.0 );
        electricity.add( 15.00 , 40.0 );
        electricity.add( 18.00 , 70.0 );
        electricity.add( 21.00 , 100.0 );
        electricity.add( 24.00 , 60.0 );
        final XYSeries gas = new XYSeries( "Gas" );
        gas.add( 06.00 , 40.0 );
        gas.add( 09.00 , 50.0 );
        gas.add( 12.00 , 70.0 );
        gas.add( 15.00 , 30.0 );
        gas.add( 18.00 , 60.0 );
        gas.add( 21.00 , 90.0 );
        gas.add( 24.00 , 40.0 );
        final XYSeries water = new XYSeries( "Water" );
        water.add( 06.00 , 20.0 );
        water.add( 09.00 , 50.0 );
        water.add( 12.00 , 40.0 );
        water.add( 15.00 , 40.0 );
        water.add( 18.00 , 50.0 );
        water.add( 21.00 , 40.0 );
        water.add( 24.00 , 20.0 );
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( electricity );
        dataset.addSeries( gas );
        dataset.addSeries( water );
        return dataset;
    }

    public static void main( String[ ] args )
    {
        XYLineChart_AWT chart = new XYLineChart_AWT("Energy Usage Statistics", "Current Energy Consumption Within Building");
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}