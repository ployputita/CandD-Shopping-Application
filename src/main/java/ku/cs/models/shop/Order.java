package ku.cs.models.shop;

public class Order {
    private String orderCode;
    private String shopName;
    private String name;
    private double price;
    private String username;
    private String nameProduct;
    private int remaining;
    private String status;
    private String trackingNumber;

    public Order(String orderCode, String shopName, String name,double price, String username,
                 String nameProduct, int remaining, String status, String trackingNumber) {
        this.orderCode = orderCode;
        this.shopName = shopName;
        this.name = name;
        this.price = price;
        this.username = username;
        this.nameProduct = nameProduct;
        this.remaining = remaining;
        this.status = status;
        this.trackingNumber = trackingNumber;
    }

//    public Order(String orderCode, String shopName, String name, String username,
//                 String nameProduct, String remaining, String status, String trackingNumber) {
//        this.orderCode = orderCode;
//        this.shopName = shopName;
//        this.name = name;
//        this.username = username;
//        this.nameProduct = nameProduct;
//        this.remaining = Integer.parseInt(remaining);
//        this.status = status;
//        this.trackingNumber = trackingNumber;
//    }

    public boolean isShopName(String shopName){
        return this.shopName.equals(shopName);
    }
    public boolean isTrackingNumber(String trackingNumber){
        return this.trackingNumber.equals(trackingNumber);
    }
    public boolean isOrderCode(String orderCode){
        return this.orderCode.equals(orderCode);
    }
    public double priceSum(double price, int remaining){
        return price*remaining;
    }


    //----------- GETTER ----------------
    public String getOrderCode() {
        return orderCode;
    }

    public String getShopName() {
        return shopName;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceString() {
        int priceInt = (int) getPrice();
        double priceDouble = getPrice();
        String price;
        if(priceDouble-priceInt != 0.0)
        {
            price = ""+ String.format("%.2f",priceDouble);
        }else{
            price = ""+ priceInt;
        }
        return price;
    }

    public String getUsername() {
        return username;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getRemaining() {
        return remaining;
    }

    public String getStatus() {
        return status;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    //------------- SETTER --------------------


    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    public String toCsv(){
        return orderCode +","+ shopName +","+ name +","+ price +","+ username +","+ nameProduct +","+ remaining +","+ status +","+ trackingNumber;
    }
}//end