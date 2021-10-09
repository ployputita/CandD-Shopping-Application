package ku.cs.models.user;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

public class Customer extends User{
    private String userID;
    private String name;
    private boolean isBlocked;
    private String shopName;
    private File imageFile;

    public Customer(String userID, String username, String password, LocalDateTime lastTimeLoggedIn, String name, boolean isBlocked, String shopName, String imageFilePath) {
        super(username, password, lastTimeLoggedIn);
        this.userID = userID;
        this.name = name;
        this.isBlocked = isBlocked;
        this.shopName = shopName;
        setImageFile(new File(imageFilePath));
    }

    public Customer(String username,String password,LocalDateTime lastTimeLoggedIn){
        super(username, password, lastTimeLoggedIn);
    }

    public String getUserID() {
        return userID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBlocked() {
        return isBlocked;
    }

    @Override
    public String getShopName() {
        return shopName;
    }

    @Override
    public String getIsUserBlockedToString(){
        if(isBlocked){
            return "ถูกจำกัด";
        }
        return "ปกติ";
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public void copyImageFile(){
        Path sourcePath = imageFile.toPath();
        String filename = this.userID + "_profileImage.jpg";
        Path targetPath = Paths.get("./src/main/resources/images/userProfileImage/"+filename);

        try {
            Files.copy(sourcePath,targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("copy ไฟล์ไม่ได้");
        }

        imageFile = new File(targetPath.toString());
        LoginCustomer.customer.setImageFile(imageFile);
    }

    @Override
    public String toCsv() {
        return "Customer," + userID + ","+ getUsername() + "," + getPassword() + "," + getLastTimeLoggedInToString() + ","
                + name + "," + isBlocked + "," + shopName + "," + imageFile;
    }
}
