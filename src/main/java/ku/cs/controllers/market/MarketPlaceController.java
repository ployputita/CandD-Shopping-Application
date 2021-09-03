package ku.cs.controllers.market;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import ku.cs.models.market.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarketPlaceController implements Initializable{

    @FXML private ChoiceBox<String> category;
    @FXML private ChoiceBox<String> sort;
    @FXML private Label categoryLabel;
    @FXML private GridPane grid;

    private List<Product> products = new ArrayList<>();

    private List<Product> getData(){
        List<Product> products = new ArrayList<>();
        Product product;

        for (int i = 0; i < 20; i++){
            product = new Product();
            product.setName("เสื้อแฟชั่นลายฮิต");
            product.setPrice(250);
            product.setImages("/images/marketpage/img_1.png");
            products.add(product);
        }
        return products;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sort.getItems().addAll("ราคาน้อยไปมาก", "ราคามากไปน้อย", "ความนิยม");
        category.getItems().addAll("เครื่องแต่งกาย", "เสื้อผ้าแฟชั่น");
        category.setOnAction(actionEvent -> categoryLabel.setText(category.getValue()));

        products.addAll(getData());
        int column  = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/ku/cs/marketpage/card.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                CardController cardController = fxmlLoader.getController();
                cardController.setData(products.get(i));

                if(column == 4){
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(9));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}