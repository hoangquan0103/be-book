package com.oop.btlon1;

import com.oop.btlon1.entity.product.Book;
import com.oop.btlon1.entity.product.Category;
import com.oop.btlon1.entity.user.Role;
import com.oop.btlon1.entity.user.User;
import com.oop.btlon1.repo.product.BookRepo;
import com.oop.btlon1.service.mail.EmailSender;
import com.oop.btlon1.repo.user.UserRepo;
import com.oop.btlon1.service.product.BookService;
import com.oop.btlon1.service.product.CategoryService;
import com.oop.btlon1.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Btlon1Application {

    @Autowired
    CategoryService categoryService;
    @Autowired
    RoleService roleService;
    @Autowired
    BookRepo bookRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    EmailSender emailSender;
    public static void main(String[] args) {
        SpringApplication.run(Btlon1Application.class, args);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(BookService service) {
        return args -> {
            int checkRole = roleService.getAll().size();
            if(checkRole == 0){
                roleService.saveRole(new Role("ROLE_USER"));
                roleService.saveRole(new Role("ROLE_ADMIN"));
            }

            int checkUser = userRepo.findAll().size();
            if(checkUser == 0){
                Role role = roleService.findByName("ROLE_ADMIN");
                List<Role> roles = new ArrayList<>();
                roles.add(role);
                User user = new User();
                user.setEmail("quank71nsl@gmail.com");
                user.setPassword("$2a$10$2cqVlUAoAYt4Ay7YbO8uceZph2VYMBGVDYMAIoqlkrr.iBiGKP7/W");
                user.setRoles(roles);
                userRepo.save(user);
            }

            int checkBook = categoryService.getAll().size();
            if(checkBook == 0) {
//                List<Category> list = new ArrayList<>();
                categoryService.save(new Category("VĂN HỌC", LocalDateTime.now()));
                categoryService.save(new Category("KINH TẾ", LocalDateTime.now()));
                categoryService.save(new Category("TÂM LÝ - KỸ NĂNG SỐNG", LocalDateTime.now()));
                categoryService.save(new Category("NUÔI DẠY CON", LocalDateTime.now()));
                categoryService.save(new Category("SÁCH THIẾU NHI", LocalDateTime.now()));
                categoryService.save(new Category("TIỂU SỬ - HỒI KẾT", LocalDateTime.now()));
                categoryService.save(new Category("GIÁO KHOA - THAM KHẢO", LocalDateTime.now()));
                categoryService.save(new Category("SÁCH HỌC NGOẠI NGỮ", LocalDateTime.now()));

                System.out.println(categoryService.getAll().size());
                Set<Category> categories = new HashSet<>(categoryService.getAll());
                Thread.sleep(1000);

            }
        };
    }
}
