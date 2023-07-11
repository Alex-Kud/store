package com.practice.store.service.implimentations;

import com.practice.store.dao.BuyerDao;
import com.practice.store.dao.OrderDao;
import com.practice.store.dao.ProductDao;
import com.practice.store.dto.OrderDto;
import com.practice.store.entity.OrderEntity;
import com.practice.store.mapper.OrderMapper;
import com.practice.store.service.interfaces.IOrderService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrderService implements IOrderService {
    // Инициализация логера
    private static final Logger log = Logger.getLogger(String.valueOf(OrderService.class));
    static String[] HEADERs = { "Id", "Surname", "First name", "Last name", "Phone", "Address", "Title", "Length", "Width", "Height", "Weight", "Price", "Quantity", "Cost", "Date" };
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuyerDao buyerDao;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderEntity create(OrderDto request) {
        if(productDao.findById(request.getProductId()).isPresent() &&
                buyerDao.findById(request.getBuyerId()).isPresent()) {
            OrderEntity order = orderMapper.toEntity(request);
            order.setDate(LocalDate.now());
            log.log(Level.INFO, "Заказ успешно создан");
            return orderDao.save(order);
        }
        else {
            log.log(Level.SEVERE, "Ошибка при создании заказа");
            return null;
        }
    }

    @Override
    public ByteArrayResource export() throws IOException {
        String filename = "Report.xlsx";
        return export(filename);
    }

    private ByteArrayResource export(String filename) throws IOException {
        byte[] bytes = new byte[1024];
        try (Workbook workbook = generateExcel()) {
            FileOutputStream fos = new FileOutputStream(filename);
            workbook.write(fos);
            fos.write(bytes);
            fos.flush();
            fos.close();
        }

        return new ByteArrayResource(bytes);
    }

    private Workbook generateExcel() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Orders");

        List<OrderEntity> orders = orderDao.findAllByOrderByIdAsc();

        Row headerRow = sheet.createRow(0);

        for (int col = 0; col < HEADERs.length; col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(HEADERs[col]);
        }

        int rowIdx = 1;
        for (OrderEntity order : orders) {
            Row row = sheet.createRow(rowIdx++);

            row.createCell(0).setCellValue(order.getId());
            row.createCell(1).setCellValue(order.getBuyer().getSurname());
            row.createCell(2).setCellValue(order.getBuyer().getFirstname());
            row.createCell(3).setCellValue(order.getBuyer().getLastname());
            row.createCell(4).setCellValue(order.getBuyer().getPhone());
            row.createCell(5).setCellValue(order.getBuyer().getAddress());

            row.createCell(6).setCellValue(order.getProduct().getTitle());
            row.createCell(7).setCellValue(order.getProduct().getLength());
            row.createCell(8).setCellValue(order.getProduct().getWidth());
            row.createCell(9).setCellValue(order.getProduct().getHeight());
            row.createCell(10).setCellValue(order.getProduct().getWeight());
            row.createCell(11).setCellValue(order.getProduct().getPrice());

            row.createCell(12).setCellValue(order.getQuantity());
            row.createCell(13).setCellValue(order.getQuantity() * order.getProduct().getPrice());
            row.createCell(14).setCellValue(order.getDate().toString());
        }

        return workbook;
    }

    @Scheduled(fixedRate = 5000)
    public void generateOrder() {
        int buyerId = (int) (Math.random() * buyerDao.count()) + 1;
        int productId = (int) (Math.random() * productDao.count()) + 1;
        int quantity = (int) (Math.random() * 50);
        OrderDto newOrder = new OrderDto(buyerId, productId, quantity);
        if (create(newOrder) != null) {
            log.log(Level.INFO, "Заказ успешно создан автоматически");
        }
        else {
            log.log(Level.SEVERE, "Ошибка при автоматическом создании заказа");
        }
    }
}
