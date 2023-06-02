package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;
    @FXML
    private Circle c1 = new Circle();
    @FXML
    private Circle c2 = new Circle();
    @FXML
    private Circle c3 = new Circle();
    @FXML
    private Circle c4 = new Circle();
    @FXML
    private Circle c5 = new Circle();
    @FXML
    private Circle c6 = new Circle();

    @FXML
    private Polyline p1 = new Polyline();

    @FXML
    private Label erreur1 = new Label();
    @FXML
    private Label erreur2 = new Label();

    @FXML
    private TextField comp1;
    @FXML
    private TextField comp2;
    @FXML
    private TextField comp3;
    @FXML
    private TextField comp4;
    @FXML
    private TextField comp5;
    @FXML
    private TextField comp6;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }


    @FXML
    public void vider(){
        comp1.setText("");
        comp2.setText("");
        comp3.setText("");
        comp4.setText("");
        comp5.setText("");
        comp6.setText("");

        c1.setRadius(0);
        c2.setRadius(0);
        c3.setRadius(0);
        c4.setRadius(0);
        c5.setRadius(0);
        c6.setRadius(0);

        p1.getPoints().setAll(new Double[]{});
    }
    @FXML
    public void tracer(){
        if (!comp1.getText().isEmpty()
                && !comp2.getText().isEmpty()
                && !comp3.getText().isEmpty()
                && !comp4.getText().isEmpty()
                && !comp5.getText().isEmpty()
                && !comp6.getText().isEmpty()){

            int n1 = Integer.parseInt(comp1.getText());
            int n2 = Integer.parseInt(comp2.getText());
            int n3 = Integer.parseInt(comp3.getText());
            int n4 = Integer.parseInt(comp4.getText());
            int n5 = Integer.parseInt(comp5.getText());
            int n6 = Integer.parseInt(comp6.getText());

            if (    0<=n1 && n1<=20
                    && 0<=n2 && n2<=20
                    && 0<=n3 && n3<=20
                    && 0<=n4 && n4<=20
                    && 0<=n5 && n5<=20
                    && 0<=n6 && n6<=20){
                erreur1.setText("");
                erreur2.setText("");

                c1.setCenterX(getXRadarChart(n1,1));
                c1.setCenterY(getYRadarChart(n1,1));
                c1.setRadius(5);

                c2.setCenterX(getXRadarChart(n2,2));
                c2.setCenterY(getYRadarChart(n2,2));
                c2.setRadius(5);

                c3.setCenterX(getXRadarChart(n3,3));
                c3.setCenterY(getYRadarChart(n3,3));
                c3.setRadius(5);

                c4.setCenterX(getXRadarChart(n4,4));
                c4.setCenterY(getYRadarChart(n4,4));
                c4.setRadius(5);

                c5.setCenterX(getXRadarChart(n5,5));
                c5.setCenterY(getYRadarChart(n5,5));
                c5.setRadius(5);

                c6.setCenterX(getXRadarChart(n6,6));
                c6.setCenterY(getYRadarChart(n6,6));
                c6.setRadius(5);

                p1.getPoints().setAll(new Double[] {
                        c1.getCenterX(),c1.getCenterY(),
                        c2.getCenterX(),c2.getCenterY(),
                        c3.getCenterX(),c3.getCenterY(),
                        c4.getCenterX(),c4.getCenterY(),
                        c5.getCenterX(),c5.getCenterY(),
                        c6.getCenterX(),c6.getCenterY(),
                        c1.getCenterX(),c1.getCenterY(),
                });
            }
            else {
                vider();
                erreur1.setText("Erreur de saisie :");
                erreur2.setText("Les valeurs doivent être entre 0 et 20");
            }


        }
        else{
            vider();
            erreur1.setText("Erreur de saisie :");
            erreur2.setText("Toutes les valeurs doivent être rentrée");
        }



    }

}
