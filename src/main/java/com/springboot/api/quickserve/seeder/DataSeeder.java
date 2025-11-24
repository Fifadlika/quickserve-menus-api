package com.springboot.api.quickserve.seeder;



import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springboot.api.quickserve.model.entity.CategoryEntity;
import com.springboot.api.quickserve.model.entity.MenuEntity;
import com.springboot.api.quickserve.repository.CategoryRepository;
import com.springboot.api.quickserve.repository.MenuRepository;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final MenuRepository menuRepository;

    public DataSeeder(CategoryRepository categoryRepository, MenuRepository menuRepository) {
        this.categoryRepository = categoryRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Clear existing data
        menuRepository.deleteAll();
        categoryRepository.deleteAll();

        // Seed Categories
        CategoryEntity makananUtama = categoryRepository.save(new CategoryEntity("Makanan Utama"));
        CategoryEntity minuman = categoryRepository.save(new CategoryEntity("Minuman"));
        CategoryEntity snack = categoryRepository.save(new CategoryEntity("Snack"));
        CategoryEntity dessert = categoryRepository.save(new CategoryEntity("Dessert"));

        // Seed Menu Items - Makanan Utama
        menuRepository.save(new MenuEntity("Nasi Goreng Spesial", new BigDecimal("25000.00"), true, makananUtama));
        menuRepository.save(new MenuEntity("Mie Goreng", new BigDecimal("20000.00"), true, makananUtama));
        menuRepository.save(new MenuEntity("Nasi Ayam Geprek", new BigDecimal("22000.00"), true, makananUtama));
        menuRepository.save(new MenuEntity("Soto Ayam", new BigDecimal("18000.00"), true, makananUtama));
        menuRepository.save(new MenuEntity("Bakso Spesial", new BigDecimal("23000.00"), false, makananUtama));

        // Seed Menu Items - Minuman
        menuRepository.save(new MenuEntity("Es Teh Manis", new BigDecimal("5000.00"), true, minuman));
        menuRepository.save(new MenuEntity("Es Jeruk", new BigDecimal("8000.00"), true, minuman));
        menuRepository.save(new MenuEntity("Jus Alpukat", new BigDecimal("15000.00"), true, minuman));
        menuRepository.save(new MenuEntity("Kopi Susu", new BigDecimal("12000.00"), true, minuman));
        menuRepository.save(new MenuEntity("Thai Tea", new BigDecimal("10000.00"), true, minuman));

        // Seed Menu Items - Snack
        menuRepository.save(new MenuEntity("Pisang Goreng", new BigDecimal("10000.00"), true, snack));
        menuRepository.save(new MenuEntity("Tahu Crispy", new BigDecimal("12000.00"), true, snack));
        menuRepository.save(new MenuEntity("Kentang Goreng", new BigDecimal("15000.00"), true, snack));
        menuRepository.save(new MenuEntity("Onion Rings", new BigDecimal("13000.00"), false, snack));

        // Seed Menu Items - Dessert
        menuRepository.save(new MenuEntity("Es Krim Vanilla", new BigDecimal("12000.00"), true, dessert));
        menuRepository.save(new MenuEntity("Puding Coklat", new BigDecimal("10000.00"), true, dessert));
        menuRepository.save(new MenuEntity("Pancake", new BigDecimal("18000.00"), true, dessert));

        System.out.println("✅ Database seeded successfully!");
        System.out.println("📊 Total Categories: " + categoryRepository.count());
        System.out.println("📊 Total Menu Items: " + menuRepository.count());
    }
}