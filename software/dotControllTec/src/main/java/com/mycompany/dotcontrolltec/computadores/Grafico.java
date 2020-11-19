/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec.computadores;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aluno
 */
public class Grafico {

    private String titulo;

    public Grafico(String titulo) {
        this.titulo = titulo;

//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setTitle(titulo);
//        setSize(950,700);
//        setLocationRelativeTo(null);
//        this.CriarGrafico();
//        setVisible(true);
    }

    public void CriarGrafico(DefaultPieDataset dados, JTabbedPane exibir) {
//        DefaultPieDataset dados = new DefaultPieDataset();
//        dados.setValue("em uso", 60);
//        dados.setValue("livre", 40);

        JFreeChart grafico = ChartFactory.createRingChart(titulo, dados, true, true, false);
        grafico.setTextAntiAlias(true);
//        PiePlot dado = (PiePlot) grafico.getPlot();
//        dado.setSectionPaint("em uso", Color.yellow);
//        dado.setSectionPaint("Livre", Color.GRAY);
        ChartPanel painel = new ChartPanel(grafico, true);

        exibir.add(this.titulo, painel);

    }

    public void GraficoLinha(DefaultCategoryDataset dados, JTabbedPane teste) {
        JFreeChart grafico = ChartFactory.createLineChart(titulo, titulo, titulo, dados, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel painel = new ChartPanel(grafico, true);

        teste.add(this.titulo, painel);
    }

    public ChartPanel GraficoLinha2(DefaultCategoryDataset dados, Integer largura, Integer altura) {
        JFreeChart grafico = ChartFactory.createLineChart(titulo, titulo, titulo, dados, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = grafico.getCategoryPlot();
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        plot.setBackgroundPaint(Color.BLACK);
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesShapesVisible(0, true);
        final DecimalFormat format = new DecimalFormat("#0.##");
        renderer.setSeriesItemLabelsVisible(0, true);


        ChartPanel painel = new ChartPanel(grafico);
        painel.setSize(largura, altura);
        return painel;
    }

    public ChartPanel CriarGrafico2(DefaultPieDataset dados, Integer altura, Integer largura) {
//        DefaultPieDataset dados = new DefaultPieDataset();
//        dados.setValue("em uso", 60);
//        dados.setValue("livre", 40);

        JFreeChart grafico = ChartFactory.createRingChart(titulo, dados, true, true, false);
        grafico.setTextAntiAlias(true);
//        PiePlot dado = (PiePlot) grafico.getPlot();
//        dado.setSectionPaint("em uso", Color.yellow);
//        dado.setSectionPaint("Livre", Color.GRAY);
        ChartPanel painel = new ChartPanel(grafico);
        painel.setSize(altura, largura);

        return painel;

    }
}
