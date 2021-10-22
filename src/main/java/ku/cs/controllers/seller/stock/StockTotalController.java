package ku.cs.controllers.seller.stock;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import ku.cs.controllers.ThemeController;
import ku.cs.models.shop.product.ProductList;
import ku.cs.models.shop.product.Product;
import ku.cs.models.user.LoginCustomer;
import ku.cs.services.ConditionFilterer;
import ku.cs.services.DataSource;
import ku.cs.services.ProductFileDataSource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StockTotalController implements Initializable {
    @FXML private VBox contactsLayout;
    @FXML private Circle imageProfileTitle;
    @FXML private Label usernameLabel;
    @FXML private AnchorPane parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ThemeController.setTheme(parent);

        DataSource<ProductList> dataSource;
        dataSource = new ProductFileDataSource();
        ProductList productList = dataSource.readData();

        Comparator<Product> productComparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getAddedTime().isBefore(o2.getAddedTime())) return 1;
                if (o2.getAddedTime().isBefore(o1.getAddedTime())) return -1;
                return 0;
            }
        };

        ConditionFilterer<Product> filterer = new ConditionFilterer<Product>() {
            @Override
            public boolean match(Product product) {
                return product.getShopName().equals(LoginCustomer.customer.getShopName());
            }
        };

        ArrayList<Product> products = productList.filter(filterer);

        for (int i = 0; i < products.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/ku/cs/sellerpage/stock/stock-total-list.fxml"));
            products.sort(productComparator);

            try {
                AnchorPane anchorPane = fxmlLoader.load();
                StockTotalListController stockTotalList = fxmlLoader.getController();
                stockTotalList.setData(products.get(i));
                contactsLayout.getChildren().add(anchorPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(LoginCustomer.customer.getImageFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imageProfileTitle.setFill(new ImagePattern(image));
        usernameLabel.setText(LoginCustomer.customer.getUsername());

    }

    @FXML
    public void handleLowStockButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("low-stock");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า low-stock ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }

    @FXML
    public void handleNewOrderButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("new-order");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า new-order ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }

    @FXML
    public void handleEditShopButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("edit-shop");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า edit-shop ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }

    @FXML
    public void handleShippedOrderButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("shipped-order");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า shipped-order ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }

    @FXML
    public void handleAddItemButton(ActionEvent actionEvent) {
        try {
            com.github.saacsos.FXRouter.goTo("add-item");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า add-item ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }

    @FXML
    void goToEditProfile(ActionEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("user-profile-edit");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า user-profile-edit ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void clickLogoBackToMarketPlace(MouseEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("market-place");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า market-place ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void logOut(ActionEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("login");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า login ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void goToOpenShop(ActionEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("market-place");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า market-place ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void handleCreatePromotionButton(ActionEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("create-promotion");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า create-promotion ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void handleAllPromotionCreateButton(ActionEvent event) {
        try {
            com.github.saacsos.FXRouter.goTo("all-promotion-create");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า all-promotion-create ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

}
