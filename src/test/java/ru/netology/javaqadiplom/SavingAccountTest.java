package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class SavingAccountTest {
    @Test //1
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

    @Test //2
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


    @Test //3
    public void shouldAddAboveThanMaxBalance1() {  //пополнение счёта больше чем максбаланс на 1 - граничное значение
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

    @Test //4
    public void shouldAddEqualMaxBalance() {  //пополнение счёта равное максбалансу - граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

//        account.add(8_000);
//        Assertions.assertEquals(10_000, account.getBalance());

        boolean actual = account.add(8_000);
        Assertions.assertTrue(actual);
    }

    @Test //5
    public void shouldAddLessMaxBalance() {  //пополнение счёта меньше максбаланса на 1  граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_999);
        Assertions.assertEquals(9_999, account.getBalance());

    }


    @Test //6
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

    @Test //7
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

    @Test // 8
    public void shouldPayEgualToInitialBalance() { // оплата равная начальному балансу
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);
        Assertions.assertEquals(2_000, account.getBalance());

////        boolean actual = account.pay(2_000);
////        Assertions.assertFalse(actual);
    }

    @Test //9
    public void shouldPayAboveThanMinBalance1() {  // оплата больше, чем минбаланс на 1 граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_001);
        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test // 10
    public void shouldPayThanBalanceEqualToBalance() { //оплата равная минбалансу граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);
        Assertions.assertEquals(1_000, account.getBalance());

    }

    @Test // 11
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


    @Test // 12
    public void shouldYearChange() { // расчёт процентов на остаток счета
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(300, account.yearChange());


    }

    @Test // 13
    public void shouldYearChange1() { //расчёт 1% граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                1
        );

        account.yearChange();
        Assertions.assertEquals(20, account.yearChange());
    }

    @Test // 14
    public void shouldYearChangeThenPersent0() { //расчёт 0% граничное значение
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test // 15
    public void shouldYearChangeThenNegativePercentage() { //расчёт отрицательный процент -1% граничное значение

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    8_000,
                    1_000,
                    10_000,
                    -1
            );
            ;
        });
    }


    @Test // 16
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

    @Test // 17
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

    @Test //18
    public void shouldSetMinBalance() { // текущий минбаланс
        SavingAccount account = new SavingAccount(
                6_000,
                5_000,
                10_000,
                7
        );
        int minBalance = account.minBalance;
        int expected = 5_000;
        int actual = account.minBalance;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 19
    public void shouldSetMaxBalance() { // текущий максбаланс
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                7
        );
        int maxBalance = account.maxBalance;
        int expected = 10_000;
        int actual = account.maxBalance;
        Assertions.assertEquals(expected, actual);
    }

    @Test // 20
    public void shouldNegativeRate() { // исключение отрицательная процентная ставка


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    8_000,
                    1_000,
                    10_000,
                    -7
            );
            ;
        });
    }

    @Test // 21
    public void shouldExceptionThenMixBalanceAboveMaxBalance() { // исключение минбаланс больше максбаланса

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    10_000,
                    18_000,
                    11_000,
                    10
            );
            ;
        });
    }

    @Test // 22
    public void shouldExceptionThenMaxBalanceLowMinBalance() { // исключение начальный баланс больше максимального

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    14_000,
                    1_000,
                    10_000,
                    10
            );
            ;
        });
    }

        @Test // 23
        public void shouldExceptionThenInitialBalanceLowMixBalance () { // исключение начальный баланс меньше минбаланса

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                SavingAccount account = new SavingAccount(
                        3_000,
                        10_000,
                        15_000,
                        10
                );
                ;
            });
        }
    }


