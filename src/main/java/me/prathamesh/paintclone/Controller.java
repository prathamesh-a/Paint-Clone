package me.prathamesh.paintclone;

import javafx.css.converter.PaintConverter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ColorPicker color;
    @FXML
    private TextField bsize;
    @FXML
    private Canvas canvas;
    boolean toolSelected;
    boolean isEraser;
    GraphicsContext brushTool;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        brushTool = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(bsize.getText());
            double x = e.getX() - size/2;
            double y = e.getY() - size/2;

            if (toolSelected && !bsize.getText().isEmpty()){
                brushTool.setFill(color.getValue());
                brushTool.fillRoundRect(x, y, size, size, size, size);
            }
            else if(isEraser){
                color.setValue(Color.WHITE);
                brushTool.setFill(color.getValue());
                brushTool.fillRoundRect(x, y, size, size, size, size);
            }
        });
    }

    @FXML
    public void toolSelected(ActionEvent e){
        toolSelected = true;
    }
    @FXML
    public void isEraser(ActionEvent e){
        System.out.println("eraser selected");
        isEraser = true;
        toolSelected = false;
    }
}