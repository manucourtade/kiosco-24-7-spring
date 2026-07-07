🇦🇷 Español
Kiosco 24/7 — API RESTful con Spring Boot
API RESTful para la gestión de un kiosco desarrollada con Spring Boot. El sistema permite administrar productos y categorías con relaciones entre entidades, y protege todos los endpoints con autenticación JWT — el usuario se registra, obtiene un token y lo usa en cada request para acceder a los recursos.
Arquitectura en capas (Controller, Service, Repository, Model, DTO) con validaciones de entrada, manejo global de excepciones, operaciones parciales con PATCH y documentación automática con Swagger. Persistencia con Spring Data JPA y MySQL, credenciales protegidas con variables de entorno y contraseñas encriptadas con BCrypt.
Tecnologías: Java 21 · Spring Boot · Spring Security · JWT · Spring Data JPA · Hibernate · MySQL · Lombok · Swagger · Maven

🇺🇸 English
Kiosk 24/7 — RESTful API with Spring Boot
RESTful API for kiosk management built with Spring Boot. The system handles product and category management with entity relationships, and secures all endpoints with JWT authentication — users register, receive a token, and include it in every request to access protected resources.
Layered architecture (Controller, Service, Repository, Model, DTO) with input validations, global exception handling, partial updates via PATCH, and automatic documentation with Swagger. Data persistence via Spring Data JPA and MySQL, environment variable credentials, and BCrypt password encryption.
Tech stack: Java 21 · Spring Boot · Spring Security · JWT · Spring Data JPA · Hibernate · MySQL · Lombok · Swagger · Maven
