package models;

import java.time.LocalDate;
import java.util.Scanner;
import controllers.Validation;

public class GiamGia {
    Scanner input = new Scanner(System.in);
    GiamGia[] DSGG;
    private String discountId;
    private String kindOfCustomer;
    private String productName;
    private String discountRate;
    private LocalDate startDate;
    private LocalDate endDate;

    public GiamGia() {
        discountId = null;
        kindOfCustomer = null;
        productName = null;
        discountRate = null;
        startDate = null;
        endDate = null;
    }

    public GiamGia(String discountId, String kindOfCustomer, String productName, String discountRate,
            LocalDate startDate, LocalDate endDate) {
        this.discountId = discountId;
        this.kindOfCustomer = kindOfCustomer;
        this.productName = productName;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDiscountId() {
        return this.discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getKindOfCustomer() {
        return this.kindOfCustomer;
    }

    public void setKindOfCustomer(String kindOfCustomer) {
        this.kindOfCustomer = kindOfCustomer;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public GiamGia discountId(String discountId) {
        setDiscountId(discountId);
        return this;
    }

    public GiamGia kindOfCustomer(String kindOfCustomer) {
        setKindOfCustomer(kindOfCustomer);
        return this;
    }

    public GiamGia productName(String productName) {
        setProductName(productName);
        return this;
    }

    public GiamGia discountRate(String discountRate) {
        setDiscountRate(discountRate);
        return this;
    }

    public GiamGia startDate(LocalDate startDate) {
        setStartDate(startDate);
        return this;
    }

    public GiamGia endDate(LocalDate endDate) {
        setEndDate(endDate);
        return this;
    }

    public void nhapDiscountId(GiamGia[] DSGG) {
        while (true) {
            System.out.println("Nhập ID giảm giá (gg_): ");
            discountId = input.nextLine();
            if (discountId.isEmpty() || !discountId.matches("^gg[0-9]+$") || discountId.length() > 6) {
                System.out.println("Nhập sai định dạng.");
            } else {
                int check = 0;
                for (GiamGia giamGia : DSGG) {
                    if (getDiscountId().equals(giamGia.getDiscountId())) {
                        check = 1;
                        break;
                    }
                }
                if (check == 1) {
                    System.out.println("\t\t\t\t\t\t\t\t +----MÃ GIẢM GIÁ BỊ TRÙNG----+");
                } else {
                    break;
                }
            }
        }
        setDiscountId(discountId);
    }

    public void nhapKindOfCustomer(GiamGia[] DSGG) {
        do {
            System.out.println("Nhập loại khách hàng: ");
            kindOfCustomer = input.nextLine();
            if (kindOfCustomer.isEmpty()) {
                System.out.println("Nhập sai định dạng.");
            }
            if (kindOfCustomer.length() > 20) {
                System.out.println("Nhập không quá 20 kí tự.");
            }
        } while (kindOfCustomer.isEmpty() || kindOfCustomer.length() > 20);
        setKindOfCustomer(kindOfCustomer);
    }

    public void nhapProductName(GiamGia[] DSGG) {
        do {
            System.out.println("Nhập tên sản phẩm: ");
            productName = input.nextLine();
            if (productName.isEmpty()) {
                System.out.println("Nhập sai định dạng.");
            }
            if (productName.length() > 10) {
                System.out.println("Nhập không quá 20 kí tự.");
            }
        } while (productName.isEmpty() || productName.length() > 20);
        setProductName(productName);
    }

    public void nhapDiscountRate(GiamGia[] DSGG) {
        do {
            System.out.println("Nhập % giảm giá: ");
            discountRate = input.nextLine();
            if (discountRate.isEmpty() || !discountRate.matches("^[0-9]{1,2}%$") || discountRate.length() > 3) {
                System.out.println("Nhập % giảm giá từ 0 - 99%.");
            }
        } while (discountRate.isEmpty() || !discountRate.matches("^[0-9]{1,2}%$") || discountRate.length() > 3);
        setDiscountRate(discountRate);
    }

    public void nhapStartDate(GiamGia[] DSGG) {
        System.out.println("Nhập ngày bắt đầu giảm giá (yyyy-MM-dd): ");
        input.nextLine();
        String StartDate;
        while (true) {
            StartDate = input.nextLine();
            if (StartDate.isEmpty()) {
                System.out.println("Nhập sai định dạng.");
            } else {
                if (Validation.isValidDate(StartDate)) {
                    setStartDate(LocalDate.parse(StartDate));
                    break;
                } else {
                    System.out.println("Ngày không hợp lệ. Nhập lại: ");
                }
            }
        }
    }

    public void nhapEndDate(GiamGia[] DSGG) {
        System.out.println("Nhập ngày kết thúc giảm giá (yyyy-MM-dd): ");
        String endDate;
        while (true) {
            endDate = input.nextLine();
            if (endDate.isEmpty()) {
                System.out.println("Nhập sai định dạng.");
            } else {
                if (Validation.isValidDate(endDate)) {
                    setEndDate(LocalDate.parse(endDate));
                    break;
                } else {
                    System.out.println("Ngày không hợp lệ. Nhập lại: ");
                }
            }
        }
    }
}
