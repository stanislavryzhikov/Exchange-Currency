package ru.itpark.exchangecurrencywithsecurity.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.exchangecurrencywithsecurity.entity.OperationEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class OperationRepositoryTest {

    @Autowired
    private OperationRepository repository;

    @Autowired
    private TestEntityManager em; //

    @Test
    public void findAll() {

        em.persist(new OperationEntity(0, "Тестовая продажа","USD", 65.55f, 67.44f,1,100,"Рыжикова", "Ангелина", "Викторовна", 6543, 123456, "Тестовая операция"));

        var actual = repository.findAll().size();

        assertEquals(1, actual);
    }

    @Autowired
    private OperationRepository repository1;

    @Autowired
    private TestEntityManager em1;
    @Test
    public void findById() {

        em1.persist(new OperationEntity(0, "Тестовая продажа 1","USD", 65.55f, 67.44f,1,100,"Рыжикова", "Ангелина", "Викторовна", 6543, 123456, "Тестовая операция"));
        em1.persist(new OperationEntity(0, "Тестовая продажа 2","USD", 65.55f, 67.44f,1,100,"Рыжикова", "Ангелина", "Викторовна", 6543, 123456, "Тестовая операция"));
        em1.persist(new OperationEntity(0, "Тестовая продажа 3","USD", 65.55f, 67.44f,1,100,"Рыжикова", "Ангелина", "Викторовна", 6543, 123456, "Тестовая операция"));

        var actual = repository1.findById(1).toString();

        assertEquals("Optional[OperationEntity(id=1, type=Тестовая продажа 1, currency=USD, centralBankRate=65.55, operationRate=67.44, count=1.0, amount=100.0, lastName=Рыжикова, firstName=Ангелина, middleName=Викторовна, seriesDoc=6543, numberDoc=123456, content=Тестовая операция)]", actual);
    }
}