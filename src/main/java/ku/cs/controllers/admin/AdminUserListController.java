package ku.cs.controllers.admin;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import ku.cs.models.admin.AdminUser;
import ku.cs.models.user.Customer;
import ku.cs.models.user.User;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class AdminUserListController implements Initializable {
    @FXML
    private Circle profileImage;

    @FXML
    private Label username;

    @FXML
    private Label name;

    @FXML
    private Label shopname;

    @FXML
    private Label lastlogin;

    @FXML
    private Label userBlocked;

    public void setData(User user) throws IOException{
        BufferedImage bufferedImage = ImageIO.read(((Customer)user).getImageFile());
        Image image = SwingFXUtils.toFXImage(bufferedImage,null);
        profileImage.setFill(new ImagePattern(image));
        name.setText(user.getName());
        username.setText(user.getUsername());
        shopname.setText(user.getShopName());
        lastlogin.setText(user.getLastTimeLoggedInToString());
        userBlocked.setText(user.getIsUserBlockedToString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}

