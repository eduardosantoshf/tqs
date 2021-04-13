# Lab 4: Multi-layer application testing (with Spring Boot)

## Questions

### a) Identify a couple of examples on the use of AssertJ expressive methods chaining.

We can identify the use of AssertJ expressive methods chaining on the following examples:

* On _EmployeeRepositoryTest.java_, inside the _givenSetOfEmployees_whenFindAll_thenReturnAllEmployees()_ method:
```java
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```

* On _EmployeeRestControllerIT.java_, inside the _whenValidInput_thenCreateEmployee()_ method:
```java
assertThat(found).extracting(Employee::getName).containsOnly("bob");
```

### b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).

We can identify an example in which this happens on _EmployeeController_WithMockServiceIT.java_, inside the _whenPostEmployee_thenCreateEmployee()_ method:
```java
when( service.save(Mockito.any()) ).thenReturn( alex);
```

### c) What is the difference between standard @Mock and @MockBean?

#### @Mock

This anotation is an abbreviation of the Mockito.mock() method, which allows us to create a mock object of a class/interface.
We should only use the @Mock annotation in a test class, and to use it, the Mockito annotations must be enabled.

#### @MockBean

This annotation is used to add mock objects to the Spring application context. The mock will replace any bean of the same type that already exists in the application context. A new bean is added if no bean of the same type is defined. 
This annotation is useful in integration tests where a particular bean needs to be mocked.

### d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

This file has the specifications (properties) to connect to a database that can be used during tests.