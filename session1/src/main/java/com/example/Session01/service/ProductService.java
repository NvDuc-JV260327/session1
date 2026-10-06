package com.example.Session01.service;

import com.example.Session01.model.entity.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service // Đánh dấu để Spring quản lý (IoC Container)
public class ProductService {
    private List<Product> products = new ArrayList<>();

    // Constructor: Tạo dữ liệu giả khi khởi động
    public ProductService() {
        products.add(new Product(1, "Laptop Dell", 1500.0));
        products.add(new Product(2, "iPhone 15", 1200.0));
        products.add(new Product(3, "Chuột Logitech", 25.0));
    }

    // 1. Lấy tất cả danh sách
    public List<Product> getAllProducts() {
        return products;
    }

    // 2. Thêm mới
    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    // 3. Cập nhật
    public Product updateProduct(int id, Product newInfo) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newInfo.getName());
                p.setPrice(newInfo.getPrice());
                return p;
            }
        }
        return null; // Hoặc ném Exception nếu không tìm thấy
    }

    // 4. Xóa
    public boolean deleteProduct(int id) {
        // removeIf trả về true nếu xóa được phần tử
        return products.removeIf(p -> p.getId() == id);
    }
}