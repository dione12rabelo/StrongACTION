/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
/**
 *
 * @author dione
 */
@ManagedBean
@SessionScoped
public class GraficosHome {

    /**
     * Creates a new instance of GraficosHome
     */
    private LineChartModel animatedModel1;
    private BarChartModel animatedModel2;
    private LineChartModel animatedModel3;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
    
      public LineChartModel getAnimatedModel3() {
        return animatedModel3;
    }
 
    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Relacionamento com Doador");
        animatedModel1.setAnimate(true);
        animatedModel1.setLegendPosition("se");
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Tele Cobrança");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        animatedModel3 = initLinearMode3();
        animatedModel3.setTitle("Captação");
        animatedModel3.setAnimate(true);
        animatedModel3.setLegendPosition("se");
        Axis yAxis3 = animatedModel3.getAxis(AxisType.Y);
        yAxis3.setMin(0);
        yAxis3.setMax(10);
        

    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
            ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2015", 120);
        boys.set("2016", 100);
        boys.set("2017", 44);
        boys.set("2018", 150);
        boys.set("2019", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2015", 52);
        girls.set("2016", 60);
        girls.set("2017", 110);
        girls.set("2018", 135);
        girls.set("2019", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
    private LineChartModel initLinearMode3() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
 
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
    
}
