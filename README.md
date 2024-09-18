# online-banking-platform
# Banking Accountability Application

## Overview

The **Banking Accountability Application** is a simple banking system that allows users to perform essential banking operations. The application is built using the **Spring Boot** framework and **Spring Initializer** to structure and initialize the project. **MySQL** is used as the database to store and manage account data following an RDBMS model. 

The application is structured following the **MVC (Model-View-Controller) architecture**, which helps in the separation of concerns and ensures maintainability and scalability of the code.

We have used **Postman** to test and verify the API endpoints during development.

## Features

The application supports the following features:
- **Create a new user (Account)**: Register a new user with an account in the system.
- **Find account by ID**: Retrieve account details by the account ID.
- **Deposit money into an account**: Add funds to an existing account.
- **Withdraw money from an account**: Withdraw money from an existing account.
- **Send money**: Transfer funds from one account to another.
- **Delete account**: Permanently remove an account from the system.
- **Get all account user information**: Retrieve details for all users and their accounts.
- **Filter accounts by balance**: Retrieve accounts that meet a certain balance criterion.

## Technologies Used

- **Spring Boot**: For building the backend and handling REST APIs.
- **Spring Initializer**: To quickly set up the project structure and dependencies.
- **MySQL**: For persisting account and user information in a relational database.
- **Spring Data JPA**: To interact with the MySQL database using JPA (Java Persistence API) for database operations.
- **Lombok**: For reducing boilerplate code such as getters, setters, and constructors.
- **Postman**: For testing and verifying the API endpoints during development.
- **MVC Architecture**: To keep the application clean, modular, and scalable.

## Project Structure

The application follows the **MVC (Model-View-Controller)** architecture:
- **Model**: Represents the application's data structure. This is where the `Account` and `User` entities are defined.
- **Controller**: Handles incoming requests, processes the business logic, and returns the response. The `AccountController` is responsible for managing user requests like creating, deleting, or updating accounts.
- **Service**: Contains the core business logic. The `AccountService` handles the CRUD operations such as creating new accounts, transferring money, and filtering accounts based on balance.
- **Repository**: Interacts with the database to store and retrieve account information. The `AccountRepository` extends `JpaRepository`, making CRUD operations easy.

## Key Operations (CRUD)

The application allows for the following **CRUD** operations on the account entity:

1. **Create**: Register a new user or create a new account.
2. **Read**: 
   - Find an account by its ID.
   - Retrieve all account users' information.
   - Filter accounts based on balance.
3. **Update**: 
   - Deposit money into an account.
   - Withdraw money from an account.
   - Transfer money between accounts.
4. **Delete**: Permanently delete an account.

### Example Endpoints

1. **Create Account**  
   `/REST-API/accounts/newUser`
   ![Create Account Endpoint](https://example.com/path-to-screenshot.png)
   
2. **Find Account by ID**  
   `/REST-API/accounts/findBy/{id}`
   ![Find Account Endpoint](https://example.com/path-to-screenshot.png)
   
3. **Deposit Money**  
   `/REST-API/accounts/Self-Deposit/{id}`
   ![Deposit Money Endpoint](https://example.com/path-to-screenshot.png)
   
4. **Withdraw Money**  
   `/REST-API/accounts/Withdraw/{id}`
   ![Withdraw Money Endpoint](https://example.com/path-to-screenshot.png)
   
5. **Send Money**  
   `/REST-API/accounts/{id}/moneyTransfer`
   ![Send Money Endpoint](https://example.com/path-to-screenshot.png)
   
6. **Delete Account**  
   `/REST-API/accounts/Delete-Account/{id}`
   ![Delete Account Endpoint](https://example.com/path-to-screenshot.png)
   
7. **Get All Accounts**  
   `/REST-API/accounts/All-User-Info`
   ![Get All Accounts Endpoint](https://example.com/path-to-screenshot.png)
   
8. **Filter Accounts by Balance**  
   `/REST-API/accounts/ListOfAccountGreater/{amount}`
   ![Filter Accounts Endpoint](https://drive.google.com/file/d/1gZusWiqqpSnH97VDUHevPmR5xo0HT_uy/view?usp=sharing)

## Database

**MySQL** is used to persist the data. The following tables are defined:

- **Accounts**: Stores account details such as account ID, balance, and user information.
  
Example of database schema:

```sql
CREATE TABLE accounts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255),
    balance DOUBLE,
    ...
);
