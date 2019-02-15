package ru.itpark.exchangecurrencywithsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OperationEntity {
    @Id
    @GeneratedValue
    private int id;
    // private int ownerId; -> id'шник пользователя, который добавил, надо записывать руками
    private String type;
    private String currency;
    private float centralBankRate;//Курс ЦБ
    private float operationRate;//цена покупки
    private float count;//количество
    private float amount;//сумма
    private String lastName;
    private String firstName;
    private String middleName;
    private int seriesDoc;
    private int numberDoc;
    private String content;
}
