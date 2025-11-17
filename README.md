# 🚕 Cab Booking System (Java, Spring MVC, Hibernate)

A simple **Cab Booking System** implemented using:

- Spring MVC
- Hibernate (with JPA annotations)
- JDBC (via Hibernate + DataSource)
- JSP, HTML, CSS

The application allows users to:

1. Enter **pick-up** and **drop** locations.
2. Find a **nearby available driver**.
3. See an **estimated time of arrival (ETA)**.
4. Confirm the ride and persist the booking.

---

## 🏗 Architecture

- **Presentation Layer**: Spring MVC Controllers + JSP Views  
- **Service Layer**: `BookingService` for business logic  
- **Persistence Layer**: Generic DAO + Hibernate repositories  
- **Database**: Any relational DB (default configuration assumes MySQL)

Package structure:

```text
com.mobinyousefi.cabbooking
├─ config        # Spring & Hibernate configuration
├─ controller    # Web layer (Spring MVC)
├─ dto           # Request/response models used by controllers
├─ exception     # Custom exceptions
├─ model         # JPA entities (User, Driver, Ride, enums)
├─ repository    # Generic DAO + specific repositories
├─ service       # Business services
└─ util          # Helper utilities (ETA calculation)
```

---

## ⚙️ Prerequisites

- JDK 17+
- Maven 3.8+
- MySQL (or change JDBC URL to your DB)
- Apache Tomcat 9+ (or any compatible servlet container)

---

## 🔧 Configuration

### 1. Database

Create a database:

```sql
CREATE DATABASE cab_booking_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

Update `src/main/resources/application.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/cab_booking_db?useSSL=false&serverTimezone=UTC
db.username=root
db.password=your_password
db.driver=com.mysql.cj.jdbc.Driver
hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
hibernate.show_sql=true
hibernate.format_sql=true
hibernate.hbm2ddl.auto=update
```

---

## ▶️ Running the Project

1. **Build the WAR:**

```bash
mvn clean package
```

2. **Deploy to Tomcat:**

Copy `target/cab-booking-system.war` to:

```text
<TOMCAT_HOME>/webapps/
```

3. **Start Tomcat** and open in your browser:

```text
http://localhost:8080/cab-booking-system/
```

You should see the **home page** with the cab booking form.

---

## 🚗 Sample Flow

1. Go to **Home Page** (`/`).
2. Enter:
   - Pick-up area
   - Drop area
   - Cab type (e.g. MINI, SEDAN, SUV)
3. Submit the form.
4. The app selects a **nearest available driver** (simplified logic).
5. It shows **driver details + ETA**.
6. Click **Confirm Ride** to finalize the booking.
7. You are redirected to a **booking success** page.

---

## 🧱 Technologies

- **Backend**: Java 17, Spring MVC, Hibernate
- **Frontend**: JSP, JSTL, HTML5, CSS3
- **Database**: MySQL
- **Build**: Maven
- **Logging**: SLF4J + Log4j

---

## 🧪 Possible Extensions

- User authentication (login / registration)
- Driver registration & admin dashboard
- Pricing estimation based on distance and surge
- Integration with a real maps / routing API
- REST API layer for mobile apps

---

## 👨‍💻 Author

**Mobin Yousefi**  
GitHub: [github.com/mobinyousefi-cs](https://github.com/mobinyousefi-cs)

License: **MIT**
