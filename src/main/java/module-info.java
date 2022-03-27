module me.prathamesh.paintclone {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.prathamesh.paintclone to javafx.fxml;
    exports me.prathamesh.paintclone;
}