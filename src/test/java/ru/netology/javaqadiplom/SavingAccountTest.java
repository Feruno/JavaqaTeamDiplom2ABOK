package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class SavingAccountTest {
    @Test
    public void shouldAddLessThanMaxBalance() { //пополнение счёта меньше чем максбаланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddAboveThanMaxBalance() {  //пополнение счёта больше чем максбаланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(11_000);
        Assertions.assertEquals(2_000, account.getBalance());

        boolean actual = account.add(11_000);
        Assertions.assertFalse(actual);
    }


    @Test
    public void shouldAddAboveThanMaxBalance1() {  //пополнение счёта больше чем максбаланс на 1 граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());

        boolean actual = account.add(8_001);
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldAddEqualMaxBalance() {  //пополнение счёта равное максбалансу  граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);
        boolean actual = account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());


        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldAddLessMaxBalance() {  //пополнение счёта меньше максбаланса на 1  граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_999);
        Assertions.assertEquals(9_999, account.getBalance());

//        boolean actual = account.add(7_999);
//        Assertions.assertTrue(actual);
    }



    @Test
    public void shouldPayLowThanMixBalance() {  //оплата с остатком меньше, чем минбаланс
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(7_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayWithinMinBalance() { //оплата в пределах минбаланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(350);

        Assertions.assertEquals(1_650, account.getBalance());
    }

    @Test
    public void shouldPayWithinInitialBalance() { // оплата в пределах начального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );
//
//        account.pay(2_000);
//        Assertions.assertEquals(2_000, account.getBalance());

        boolean actual = account.pay(2_000);
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldPayAboveThanMinBalance1() {  // оплата больше, чем минбаланс на 1 граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

//        account.pay(1_001);
//        Assertions.assertEquals(2_000, account.getBalance());

        boolean actual = account.pay(1_001);
        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldPayThanBalanceEqualToBalance() { //оплата равная минбалансу граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

//        account.pay(1_000);
//        Assertions.assertEquals(1_000, account.getBalance());

        boolean actual = account.pay(1_000);
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldPayLessThanMaxBalance1() { // оплата меньше, чем минбаланс на 1 граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

//        account.pay(999);
//        Assertions.assertEquals(1_001, account.getBalance());

        boolean actual = account.pay(999);
        Assertions.assertTrue(actual);
    }


    @Test
    public void shouldYearChange() { // расчёт процентов на остаток счета
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );


        account.yearChange();
        Assertions.assertEquals(300, account.getBalance());


//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            account.getBalance();
//        });
    }
    @Test
    public void shouldYearChange1() { //расчёт 1% граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        account.yearChange();
        Assertions.assertEquals(20, account.getBalance());
    }

    @Test
    public void shouldPayTrue() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                7
        );

        boolean actual = account.pay(999);
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldPayFalse() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                7
        );

        boolean actual = account.pay(1_001);
        Assertions.assertFalse(actual);
    }
}

