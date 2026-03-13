# Task Manager

Пет-проект для изучения Spring Boot.\
REST API для управления задачами. :)

## Стек
- Java 17
- Spring Boot
- Spring Data JPA
- Database: H2 (dev) / PostgreSQL (prod)
- Lombok

## Как запустить

1. **Клонировать:**
   ```bash
   git clone https://github.com/username/TaskManager.git
   cd TaskManager
   ```

2. **Настроить БД:**
   В `src/main/resources/application.properties` проверить подключение.
   По умолчанию стоит H2:
   ```properties
   spring.datasource.url=jdbc:h2:mem:taskdb
   spring.h2.console.enabled=true
   ```

3. **Запустить:**
   ```bash
   mvn spring-boot:run
   ```
   Приложение доступно по адресу: `http://localhost:8080`

## API Endpoints

| Метод    | URL           | Описание              |
|----------|---------------|-----------------------|
| `POST`   | `/tasks`      | Создать задачу        |
| `GET`    | `/tasks`      | Список всех задач     |
| `GET`    | `/tasks/{id}` | Получить задачу по ID |
| `PUT`    | `/tasks/{id}` | Обновить задачу       |
| `DELETE` | `/tasks/{id}` | Удалить задачу        |

## Примеры запросов

**Создать задачу:**
```bash
http post :8080/tasks @task.json
```

**Получить все задачи:**
```bash
http :8080/tasks
```
