

---

```markdown
# ⚙️ ForgeBase – Gear Calculation Engine

Spring Boot application that computes Spur and Helical gear parameters using mechanical formulas. Ideal for showcasing engineering + backend development skills.

> ⚠️ This project is for educational purposes only and not meant for manufacturing-grade outputs.

---

## 🚀 Features

- 📐 Spur & Helical Gear Calculations
- 🧠 Mechanical logic implemented in service layer
- 🔗 REST API with Spring Boot
- 🗃️ Data persistence with Spring Data JPA
- ✅ Input validation using `javax.validation` annotations
- 🔍 Separate DTOs for clean structure and security
- 📊 Rounded outputs using `BigDecimal.setScale(...)`
- 🔄 Full CRUD (Create, Read, Delete) supported

---

## 📁 Project Structure

```

forgebase/
├── Controller/
│   ├── SpurGearController.java
│   └── HelicalGearController.java
├── Service/
│   ├── SpurGearService.java
│   └── HelicalGearService.java
├── Model/
│   ├── SpurGearModel.java
│   ├── HelicalGearModel.java
│   ├── SpurGearInputDTO.java
│   └── HelicalGearInputDTO.java
├── Calculations/
│   ├── SpurGearCalculations.java
│   └── HelicalGearCalculations.java
├── Repository/
│   ├── SpurGearRepository.java
│   └── HelicalGearRepository.java
└── ForgebaseApplication.java

```

---

## 🧪 API Endpoints

### Spur Gear

```

POST   /api/spurgears/calculations
GET    /api/spurgears/calculations/all
GET    /api/spurgears/calculations/{id}
DELETE /api/spurgears/calculations/{id}
DELETE /api/spurgears/calculations/all

```

### Helical Gear

```

POST   /api/helicalgears/calculations
GET    /api/helicalgears/calculations/all
GET    /api/helicalgears/calculations/{id}
DELETE /api/helicalgears/calculations/{id}
DELETE /api/helicalgears/calculations/all

````

---

## 📸 Screenshots

### Spur Gear

- ![Spur POST](screenshots/spur_post.png)
- ![Spur GET](screenshots/spur_get.png)

### Helical Gear

- ![Helical POST](screenshots/helical_post.png)
- ![Helical GET](screenshots/helical_get.png)

---

## 📥 Sample Inputs

### Spur Gear Input

```json
{
  "createdAt": "2025-07-08T16:00:00.000+00:00",
  "pressureAngleOfGear": 20,
  "module": 2.5,
  "teethOnPinion": 18,
  "teethOnGear": 36,
  "addendaOnPinion": 1,
  "addendaOnGear": 1
}
````

### Helical Gear Input

```json
{
  "createdAt": "2025-07-08T17:00:00.000+00:00",
  "module": 3.0,
  "teethOnPinion": 20,
  "teethOnGear": 40,
  "pressureAngle": 20,
  "helixAngle": 15,
  "addendaOnPinion": 1,
  "addendaOnGear": 1
}
```

---

## 🔧 Run Locally

```bash
git clone https://github.com/HemanthKumarThiruvengadam/ForgeBase.git
cd ForgeBase
mvn clean install
./mvnw spring-boot:run
```

---

## 🧠 Tech Stack

* Java 21
* Spring Boot 3.5
* Spring Data JPA
* Maven
* MySQL
* Postman
* IntelliJ IDEA
* Lombok

---

## 👨‍💻 Author

**Hemanth Kumar T**
Mechanical Engineer | Backend Developer
📫 [LinkedIn](https://www.linkedin.com/in/hemanth-kumar-thiruvengadam/)
💻 [GitHub](https://github.com/HemanthKumarThiruvengadam)

---

## 📜 License

MIT License – Free to use and modify

```

---


