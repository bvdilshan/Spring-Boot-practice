# Why These Spring Boot Annotations Are Needed

This file explains **why** we use the following annotations in a Spring Boot REST API:

* `@RestController`
* Request mappings (`@GetMapping`, `@PostMapping`, etc.)
* `@RequestBody`
* `@PathVariable`

---

## 1. Why `@RestController`

### Problem without it

If you don’t use `@RestController`, Spring treats your class as a **normal Java class**.

* No HTTP requests reach it
* Methods are never called from the browser or Postman

### What it does

```java
@RestController
```

* Tells Spring: **this class handles HTTP requests**
* Automatically converts return values to **JSON / text**

### Internally

`@RestController = @Controller + @ResponseBody`

### Without it

```java
public class CustomerController {
}
```

❌ Not a REST API

### With it

```java
@RestController
public class CustomerController {
}
```

✅ REST API enabled

---

## 2. Why Request Mappings (`@GetMapping`, `@PostMapping`, etc.)

### Problem without them

Spring has **no idea** which URL or HTTP method should call your function.

### What they do

They map **HTTP method + URL → Java method**

Examples:

```java
@GetMapping("/customers")
```

→ Called when user sends:

```
GET /customers
```

```java
@PostMapping("/customers")
```

→ Called when user sends:

```
POST /customers
```

### Mapping types

* `@GetMapping` → Read data
* `@PostMapping` → Create data
* `@PutMapping` → Update data
* `@DeleteMapping` → Delete data

### Without mapping

```java
public String getCustomer() { }
```

❌ Never called

---

## 3. Why `@RequestBody`

### Problem without it

Spring **cannot read JSON data** sent from the client.

### Example request

```json
{
  "name": "Dilshan",
  "address": "Colombo"
}
```

### What `@RequestBody` does

```java
public String saveCustomer(@RequestBody CustomerRequestDto dto)
```

* Converts JSON → Java Object (DTO)
* Uses Jackson internally

### Without `@RequestBody`

```java
public String saveCustomer(CustomerRequestDto dto)
```

❌ `dto` will be `null`

### With `@RequestBody`

```java
public String saveCustomer(@RequestBody CustomerRequestDto dto)
```

✅ JSON → DTO works

---

## 4. Why `@PathVariable`

### Problem without it

Spring cannot extract values from the URL.

### Example URL

```
GET /customers/10
```

Here `10` is **dynamic data**.

### What `@PathVariable` does

```java
@GetMapping("/customers/{id}")
public String getCustomer(@PathVariable String id)
```

* Extracts `id` from URL
* Passes it to the method

### Without `@PathVariable`

```java
public String getCustomer(String id)
```

❌ `id` is `null`

### With `@PathVariable`

```java
public String getCustomer(@PathVariable String id)
```

✅ `id = 10`

---

## 5. Real-World Controller Example

```java
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @PostMapping
    public String save(@RequestBody CustomerRequestDto dto) {
        return "Saved";
    }

    @GetMapping("/{id}")
    public String get(@PathVariable String id) {
        return "Customer " + id;
    }
}
```

---

## 6. One-Line Summary

| Annotation        | Purpose                 |
| ----------------- | ----------------------- |
| `@RestController` | Marks class as REST API |
| `@GetMapping`     | Handle GET requests     |
| `@PostMapping`    | Handle POST requests    |
| `@RequestBody`    | JSON → Java object      |
| `@PathVariable`   | URL value → variable    |

---

## Final Truth (industry rule)

Without these annotations, **Spring Boot ≠ Backend API**.

With them, your app becomes a **real REST service** 🚀

---

Next topics you should learn:

* Service layer (`@Service`)
* Repository layer (`JpaRepository`)
* Validation (`@Valid`)
* Exception handling (`@ControllerAdvice`)
