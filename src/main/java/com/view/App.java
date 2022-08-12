package com.view;

import java.awt.EventQueue;

import javax.swing.*;

public class App {
    public static void main (String args[]){
        /*var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);*/
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Incio frame = new Incio();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
