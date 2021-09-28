package ku.cs.controllers.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import ku.cs.models.admin.AdminUserReport;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminReportListController implements Initializable {
    @FXML
    private Circle profileImage;

    @FXML
    private Label username;

    @FXML
    private Label reportType;

    @FXML
    private Label moreDetailReport;

    @FXML
    private Label messageReport;

    @FXML
    private ComboBox<String> statusUserReport;

    public void setData(AdminUserReport user){
//        Image imgProfile = new Image(getClass().getResourceAsStream(user.getImgSrc()));
//        img.setImage(imgProfile);
        username.setText(user.getUsername());
        reportType.setText(user.getReportType());
        moreDetailReport.setText(user.getMoreDetailReport());
        messageReport.setText(user.getMessagetoReport());
        statusUserReport.setValue("รอตรวจสอบ");
        statusUserReport.getItems().addAll("อนุมัติ","ไม่อนุมัติ");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
