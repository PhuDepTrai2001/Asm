package entity;

import annotation.Column;
import annotation.Entity;
import annotation.Id;
import helper.SQLDataTypes;

import java.util.Date;

@Entity(tableName = "foods")
public class Food {
    @Column(columnName = "id", columnType = SQLDataTypes.INTEGER)
    @Id(autoIncrement = true)
    private int id;
    @Column(columnName = "name", columnType = SQLDataTypes.VARCHAR255)
    private String name;
    @Column(columnName = "categoryId", columnType = SQLDataTypes.INTEGER)
    private int categoryId;
    @Column(columnName = "description", columnType = SQLDataTypes.VARCHAR255)
    private String description;
    @Column(columnName = "thumbnail", columnType = SQLDataTypes.VARCHAR255)
    private String thumbnail;
    @Column(columnName = "price", columnType = SQLDataTypes.DOUBLE)
    private Double price;
    @Column(columnName = "saleStartDate", columnType = SQLDataTypes.DATETIME)
    private java.util.Date saleStartDate;
    @Column(columnName = "updatedAt", columnType = SQLDataTypes.DATETIME)
    private java.util.Date updatedAt;
    @Column(columnName = "createdAt", columnType = SQLDataTypes.DATETIME)
    private java.util.Date createdAt;
    @Column(columnName = "status", columnType = SQLDataTypes.INTEGER)
    private int status;

    public String toStatus(int status) {
        switch (status) {
            case 0:
                return "Đã xóa";
            case 1:
                return "Đang Bán";
            case 2:
                return "Dừng bán";
            default:
                return "Không xác định";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public java.util.Date getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(java.util.Date saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public java.util.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean validate() {
        if (this.getName().trim().length() > 7 && this.getPrice() > 0) {
            return true;
        };
        return false;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", saleStartDate=" + saleStartDate +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", status=" + status +
                '}';
    }
}
